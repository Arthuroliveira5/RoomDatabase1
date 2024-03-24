package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.database.AppDatabase
import com.example.roomdatabase.database.dao.UserDao
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)

        this.userDao = this.database.userDao()

    }

    override fun onStart() {
        super.onStart()

        loadTotalUsers()

        this.binding.btnNewUser.setOnClickListener {

            openNewUserActivity()

        }

    }

    private fun openNewUserActivity() {
        startActivity(Intent(this, NewUserActivity::class.java))
    }
//Nao podemos acessar o banco de dados na main tread porque vai travar a UI
    //a SOLUCAO É COLOCAR A PALAVRA SERAPARADA SUSPEND NA FUNCAO QUERY DA CLASSE DAO
    private fun loadTotalUsers() {

        this.binding.tvInfoTotalUsers.text = "Carregando..."

        CoroutineScope(Dispatchers.IO).launch {

            val total = userDao.getTotalItems()

            withContext(Dispatchers.Main) {

                binding.tvInfoTotalUsers.text = "Total de usuários: $total"

            }

        }

    }
}