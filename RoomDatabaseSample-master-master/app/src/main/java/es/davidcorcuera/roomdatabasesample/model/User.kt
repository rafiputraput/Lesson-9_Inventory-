package es.davidcorcuera.roomdatabasesample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "first_name")
    val name: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val age: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
