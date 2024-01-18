package com.example.examenuf1arnaulloveras.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenuf1arnaulloveras.databinding.RecycleviewBinding
import com.example.examenuf1arnaulloveras.model.Alumns

class AlumnsAdapter (private val alumnsList:List<Alumns>) : RecyclerView.Adapter<AlumnsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnsViewHolder {
        val layoutInflater = RecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlumnsViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = alumnsList.size

    override fun onBindViewHolder(holder: AlumnsViewHolder, position: Int) {
        val item = alumnsList[position]
        holder.render(item)

    }

}

class AlumnsViewHolder(private var binding: RecycleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(alumns: Alumns){
        binding.textViewName.text = alumns.name
        binding.textViewGroup.text = alumns.group
        binding.textViewGrade.text = alumns.grade.toString()
    }
}