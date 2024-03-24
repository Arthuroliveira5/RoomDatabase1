package com.example.roomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.database.model.User


@Dao
//A dao é responsavel por colocar ou tirar dados de nosso banco de dados
interface UserDao {

    @Insert
    //Vamos usar coroutines entao usamos o suspend
    suspend fun insert(user: User)





    @Query("SELECT COUNT(uid) FROM user")
    suspend fun getTotalItems(): Long



}
