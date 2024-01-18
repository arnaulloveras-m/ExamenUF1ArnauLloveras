package com.example.examenuf1arnaulloveras.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.examenuf1arnaulloveras.model.Alumns
import com.example.examenuf1arnaulloveras.repositori.Repositori

class InsertViewModel : ViewModel(){

    var alumns: LiveData<List<Alumns>>? = null

    //Insert alumns
    fun newAlumns(context: Context, name: String, group: String, grade: Int) {

        var alumnsVM = Alumns(name, group, grade)
        Repositori.insertAlumn(context, alumnsVM)
    }
}