package com.example.examenuf1arnaulloveras.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenuf1arnaulloveras.R
import com.example.examenuf1arnaulloveras.databinding.FragmentGroupBinding
import com.example.examenuf1arnaulloveras.databinding.FragmentInsertBinding
import com.example.examenuf1arnaulloveras.databinding.RecycleviewBinding
import com.example.examenuf1arnaulloveras.viewModel.GroupViewModel
import com.example.examenuf1arnaulloveras.viewModel.InsertViewModel

class GroupFragment : Fragment() {

    private lateinit var binding: FragmentGroupBinding
    private lateinit var alumnsViewModel: GroupViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var dadesRecycler: RecycleviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_group, container, false
        )

        alumnsViewModel = ViewModelProvider(this).get(GroupViewModel::class.java)

        recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity)

        val switch = binding.switchCompat

        alumnsViewModel.getAllAlumns(requireContext())
        alumnsViewModel.alumns?.observe(viewLifecycleOwner) { llistaAlumns ->
            binding.recyclerView.adapter = AlumnsAdapter(llistaAlumns)
        }

        switch.setOnClickListener {
            if (switch.isChecked) {
                alumnsViewModel.getAlumnsByGradeApproved(requireContext())

                alumnsViewModel.alumns?.observe(viewLifecycleOwner) { llistaAlumns ->
                    binding.recyclerView.adapter = AlumnsAdapter(llistaAlumns)
                }
            } else {
                alumnsViewModel.getAlumnsByGradeSuspend(requireContext())

                alumnsViewModel.alumns?.observe(viewLifecycleOwner) { llistaAlumns ->
                    binding.recyclerView.adapter = AlumnsAdapter(llistaAlumns)
                }
            }
        }

        binding.recyclerView.setOnClickListener {

            println("Hola")
            val name = dadesRecycler.textViewName.text.toString()
            alumnsViewModel.getAlumnByName(requireContext(), name)?.observe(viewLifecycleOwner,
                Observer { alumnLlistat ->
                    Toast.makeText(
                        requireContext(),
                        "Nom: ${alumnLlistat[0].name.toString()}, Grup: ${alumnLlistat[0].group.toString()}, Grade: ${
                            alumnLlistat[0].grade.toString().toInt()
                        }",
                        Toast.LENGTH_SHORT
                    ).show()
                })
        }
            return binding.root
        }
    }
