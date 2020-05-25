package com.example.restinoapp.ui.auth

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.restinoapp.R
import com.example.restinoapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var viewModel: AuthViewModel
    private lateinit var binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        binding.lifecycleOwner=this

        (activity as AppCompatActivity).supportActionBar?.hide()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel

        binding.btnSubmitLogin.setOnClickListener {





        }


        binding.homeButtonLogin.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            )
        }
        binding.signupButtonLogin.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            )
        }


    }

}
