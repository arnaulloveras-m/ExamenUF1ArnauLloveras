package com.example.examenuf1arnaulloveras.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.examenuf1arnaulloveras.model.Alumns
import com.example.examenuf1arnaulloveras.repositori.Repositori

class GroupViewModel : ViewModel(){

    var alumns: LiveData<List<Alumns>>? = null

    fun getAlumnsByGradeApproved(context: Context): LiveData<List<Alumns>>? {

        alumns = Repositori.getAlumnsByGradeApproved(context)

        return alumns
    }

    fun getAlumnsByGradeSuspend(context: Context): LiveData<List<Alumns>>? {

        alumns = Repositori.getAlumnsByGradeSuspend(context)

        return alumns
    }

    fun getAlumnByName(context: Context, nombre: String) : LiveData<List<Alumns>>? {
        alumns = Repositori.getAlumnByName(context, nombre)
        return alumns
    }

    fun getAllAlumns(context: Context) : LiveData<List<Alumns>>? {
        alumns = Repositori.getAllAlumns(context)
        return alumns
    }
}