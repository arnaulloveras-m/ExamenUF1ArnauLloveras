package com.example.examenuf1arnaulloveras.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.examenuf1arnaulloveras.R
import com.example.examenuf1arnaulloveras.databases.AlumnsDatabase
import com.example.examenuf1arnaulloveras.databinding.FragmentInsertBinding
import com.example.examenuf1arnaulloveras.model.Alumns
import com.example.examenuf1arnaulloveras.viewModel.InsertViewModel

class InsertFragment : Fragment() {
    private lateinit var binding: FragmentInsertBinding
    private lateinit var alumnsViewModel: InsertViewModel
    var alumnsDatabase: AlumnsDatabase?= null

    var alumns: LiveData<List<Alumns>>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert, container, false
        )

        alumnsViewModel = ViewModelProvider(this).get(InsertViewModel::class.java)

        binding.buttonAdd.setOnClickListener {

            val name = binding.editTextName.text.toString()
            val group = binding.editTextGroup.text.toString()
            val grade = binding.editTextGrade.text.toString().toInt()

            alumnsViewModel.newAlumns(requireContext(), name, group, grade)
        }
        return binding.root
    }

}