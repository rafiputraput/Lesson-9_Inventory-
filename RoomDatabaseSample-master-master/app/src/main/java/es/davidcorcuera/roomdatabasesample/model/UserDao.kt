package es.davidcorcuera.roomdatabasesample.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(vararg user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM users WHERE first_name = :name")
    fun getUserByName(name: String): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE age = :age")
    fun getUsersByAge(age: Int): LiveData<List<User>>

    @Query("SELECT * FROM users ORDER BY age ASC")
    fun getAllUserOrderedByAge(): LiveData<List<User>>

}