package com.helicoptera.android.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.helicoptera.android.R
import com.helicoptera.android.databinding.FragmentLoginBinding
import com.helicoptera.android.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private var binding: FragmentRegistrationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_registration, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = view.findNavController()
        binding?.apply {
            content.setOnClickListener {
                navController.navigate(R.id.action_registrationFragment_to_contentFragment)
            }
            login.setOnClickListener {
                navController.navigate(R.id.action_registrationFragment_to_loginFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}