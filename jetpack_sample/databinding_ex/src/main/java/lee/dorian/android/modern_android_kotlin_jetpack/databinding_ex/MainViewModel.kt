package lee.dorian.android.modern_android_kotlin_jetpack.databinding_ex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "todo-db").apply {
        allowMainThreadQueries()
    }.build()

    // 할 일 입력하는 EditText 뷰의 text 속성과 연결하여 데이터 바인딩 구현
    var todo = MutableLiveData<String>()

    // 할 일 리스트 보여주는 TextView 뷰의 text 속성과 연결하여 데이터 바인딩 구현
    var todoList = db.todoDao().getAll()

    // MainActivity 대신 activity_main.xml 파일의 Button 뷰의 onClick 속성의 람다 함수에서 호출
    fun insert() {
        val todoToSave = Todo(todo.value ?: "")
        db.todoDao().insert(todoToSave)
    }
}