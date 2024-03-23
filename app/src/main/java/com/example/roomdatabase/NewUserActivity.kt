package com.example.roomdatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.database.AppDatabase
import com.example.roomdatabase.database.dao.UserDao
import com.example.roomdatabase.database.model.User
import com.example.roomdatabase.databinding.ActivityNewUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewUserBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao : UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityNewUserBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)

        //criar instancias

        this.database = AppDatabase.getInstance(this)

        this.userDao=this.database.userDao()


    }

    override fun onStart() {
        super.onStart()

        this.binding.btnSave.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch{

                val result = saveUser(
                    binding.edtFirstName.text.toString(),
                    binding.edtLastName.text.toString(),)

                withContext(Dispatchers.Main){

                    Toast.makeText(

                        this@NewUserActivity,
                        if(result)"User saved" else "Error Trying to save user",
                        Toast.LENGTH_LONG).show()

                    if(result)
                        finish()

                }

            }


        }


    }

//suspend . vamos usar ela dentro de uma coroutines
    private suspend fun saveUser(firstName:String ,lastName:String):Boolean{

    if(firstName.isBlank() || firstName.isEmpty())
        return false

    if(lastName.isBlank() || lastName.isEmpty())
        return false

    this.userDao.insert(User(firstName, lastName))

    return true

    }
}