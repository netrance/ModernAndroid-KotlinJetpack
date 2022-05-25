package lee.dorian.android.modern_android_kotlin_jetpack.databinding_ex

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    // 리턴 타입을 라이브 데이터로 지정하고 observer 등록하면, 자료 삽입/갱신/삭제시 observer 자동 실행
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)

}