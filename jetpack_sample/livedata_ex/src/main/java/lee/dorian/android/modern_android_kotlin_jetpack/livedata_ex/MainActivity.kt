package lee.dorian.android.modern_android_kotlin_jetpack.livedata_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    private lateinit var views: Views

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        views = Views()
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "todo-db").apply {
            allowMainThreadQueries()
        }.build()

        // getAll() 함수가 리턴하는 라이브 데이터 관찰
        // Todo 테이블에 할 일 추가 → 아래 observer 실행
        db.todoDao().getAll().observe(this) { todoList ->
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
        db.todoDao().insert(Todo(views.todoEdit.text.toString()))
    }

}