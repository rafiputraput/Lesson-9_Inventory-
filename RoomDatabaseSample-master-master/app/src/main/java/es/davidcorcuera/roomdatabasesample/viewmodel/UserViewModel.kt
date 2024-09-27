package es.davidcorcuera.roomdatabasesample.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import es.davidcorcuera.roomdatabasesample.model.User
import es.davidcorcuera.roomdatabasesample.model.UserDao
import es.davidcorcuera.roomdatabasesample.model.UserDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val database: UserDao = UserDatabase.getInstance(application).userDao()

    val mAllUsers = database.getAllUsers()

    fun insertUser(user: User){
        viewModelScope.launch {
            database.insertUser(user)
            Toast.makeText(getApplication(),"Added ${user.name} ${user.lastName}", Toast.LENGTH_LONG).show()
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            database.deleteUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch {
            database.updateUser(user)
        }
    }

    fun getAllUsers(): LiveData<List<User>>{
        return mAllUsers
    }

    fun deleteAllUsers(){
        viewModelScope.launch {
            database.deleteAllUsers()
        }
    }

    fun getUserByName(name: String): LiveData<List<User>>{
        return database.getUserByName(name)
    }

    fun getUsersByAge(age: Int): LiveData<List<User>>{
        return database.getUsersByAge(age)
    }

    fun getAllUserOrderedByAge(): LiveData<List<User>>{
        return database.getAllUserOrderedByAge()
    }

}