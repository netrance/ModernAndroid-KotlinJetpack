package lee.dorian.android.modern_android_kotlin_jetpack.viewmodel_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var views: Views

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        views = Views()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // getAllTodos() 함수가 리턴하는 라이브 데이터 관찰
        // Todo 테이블에 할 일 추가 → 아래 observer 실행
        viewModel.getAllTodos().observe(this) { todoList ->
            views.todoText.text = todoList.toString()
        }
    }

    inner class Views(
        val todoEdit: AppCompatEditText = findViewById(R.id.todoEdit),
        val addTodoButton: AppCompatButton = findViewById(R.id.addTodoButton),
        val todoText: AppCompatTextView = findViewById(R.id.todoText)
    ) {
        init {
            addTodoButton.setOnClickListener(btnAddClickListener)
        }
    }

    // '할 일 추가' 버튼 클릭 → Todo 테이블에 할 일 추가
    val btnAddClickListener = View.OnClickListener {
        viewModel.insert(Todo(views.todoEdit.text.toString()))
    }

}