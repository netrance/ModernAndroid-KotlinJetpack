package lee.dorian.android.modern_android_kotlin_jetpack.room_ex

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

        db = Room.databaseBuilder(this, AppDatabase::class.java, "todo-db").apply {
            allowMainThreadQueries()
        }.build()

        views = Views().apply {
            val todoList = db.todoDao().getAll()
            todoText.text = todoList.toString()
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

    val btnAddClickListener = View.OnClickListener {
        db.todoDao().insert(Todo(views.todoEdit.text.toString()))
        views.todoText.text = db.todoDao().getAll().toString()
    }

}