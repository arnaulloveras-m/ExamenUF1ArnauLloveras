package com.example.examenuf1arnaulloveras.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumns")
class Alumns (

    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "group")
    var group: String,
    @ColumnInfo(name = "grade")
    var grade: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}