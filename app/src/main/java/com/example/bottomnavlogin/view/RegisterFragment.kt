package com.example.bottomnavlogin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bottomnavlogin.databinding.FragmentRegisterBinding
import com.example.bottomnavlogin.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRegisterBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() = with(binding) {
        btnRegister.setOnClickListener {
            viewModel.register(email = "email", username = "username", password = "password")
            findNavController().navigate(RegisterFragmentDirections.goToHomeGraph())
        }
        tvAlreadyHaveAnAccount.setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.goToDestinationLogin())
        }
    }
}