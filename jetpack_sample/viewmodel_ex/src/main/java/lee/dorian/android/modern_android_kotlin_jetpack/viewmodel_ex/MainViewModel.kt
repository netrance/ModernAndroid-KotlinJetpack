package lee.dorian.android.modern_android_kotlin_jetpack.viewmodel_ex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // 이전 샘플의 MainActivity 클래스 안에 정의했던 아래 객체를 MainViewModel로 옮김
    // 그리고 이를 private 키워드로 은닉하여 MainActivity는 이를 알 필요가 없게 만든다.
    // 그 대신 getAllTodos(), insert(todo) 메소드를 노출하여
    // 이들을 통해서만 데이터베이스 조작 가능하게 한다.
    // 이로써 MainActivity는 UI에 집중 가능해진다.
    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "todo-db").apply {
        allowMainThreadQueries()
    }.build()

    fun getAllTodos(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    // MainActivity 클래스에 구현했던 DB 제어 코드는 MainViewModel 클래스로 옮긴다.
    fun insert(todo: Todo) {
        db.todoDao().insert(todo)
    }
}