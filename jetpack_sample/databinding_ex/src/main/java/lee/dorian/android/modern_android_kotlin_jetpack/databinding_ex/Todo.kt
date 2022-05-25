package lee.dorian.android.modern_android_kotlin_jetpack.databinding_ex

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @ColumnInfo(name = "title") var title: String
) {

    @PrimaryKey(autoGenerate = true) var id: Int = 0

}
