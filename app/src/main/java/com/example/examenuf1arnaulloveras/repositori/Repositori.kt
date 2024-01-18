package com.example.examenuf1arnaulloveras.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.examenuf1arnaulloveras.databases.AlumnsDatabase
import com.example.examenuf1arnaulloveras.model.Alumns
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repositori {

    companion object {
        var alumnsDatabase: AlumnsDatabase? = null

        var alumns: LiveData<List<Alumns>>? = null

        fun initializeDB(context: Context): AlumnsDatabase {
            return AlumnsDatabase.getDatabase(context)
        }

        //Insert alumn
        fun insertAlumn(context: Context, alumns: Alumns) {

            alumnsDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                alumnsDatabase!!.alumnsDao().addAlumn(alumns)
            }
        }

        //SQL alumns by gradeApproved

        fun getAlumnsByGradeApproved(context: Context): LiveData<List<Alumns>>? {

            alumnsDatabase = initializeDB(context)

            alumns = alumnsDatabase!!.alumnsDao().getAlumnsByGradeApproved()

            return alumns
        }

        //SQL alumns by gradeSuspend

        fun getAlumnsByGradeSuspend(context: Context): LiveData<List<Alumns>>? {
            alumnsDatabase = initializeDB(context)

            alumns = alumnsDatabase!!.alumnsDao().getAlumnsByGradeSuspend()

            return alumns
        }

        //SQL alumn by name

        fun getAlumnByName(context: Context, nombre: String): LiveData<List<Alumns>>? {

            alumnsDatabase = initializeDB(context)

            alumns = alumnsDatabase!!.alumnsDao().getAlumnByName(nombre)

            return alumns
        }

        //All Alumns
        fun getAllAlumns(context: Context): LiveData<List<Alumns>>?  {
            alumnsDatabase = initializeDB(context)

            alumns = alumnsDatabase!!.alumnsDao().getAllAlumns()

            return alumns
        }
    }
}