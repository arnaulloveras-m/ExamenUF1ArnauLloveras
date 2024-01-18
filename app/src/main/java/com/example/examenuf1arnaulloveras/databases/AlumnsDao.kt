package com.example.examenuf1arnaulloveras.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenuf1arnaulloveras.model.Alumns

@Dao
interface AlumnsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumn(alumns: Alumns)

    @Query("SELECT * FROM Alumns WHERE grade >= 5")
    fun getAlumnsByGradeApproved(): LiveData<List<Alumns>>

    @Query("SELECT * FROM Alumns WHERE grade < 5")
    fun getAlumnsByGradeSuspend(): LiveData<List<Alumns>>

    @Query("SELECT * FROM Alumns WHERE name =:nombre")
    fun getAlumnByName(nombre:String): LiveData<List<Alumns>>

    @Query("SELECT * FROM Alumns ORDER BY grade")
    fun getAllAlumns(): LiveData<List<Alumns>>
}