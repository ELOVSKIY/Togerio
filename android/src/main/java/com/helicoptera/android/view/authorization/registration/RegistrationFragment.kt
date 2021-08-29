package com.helicoptera.android.view.authorization.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.helicoptera.android.R
import com.helicoptera.android.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private var binding: FragmentRegistrationBinding? = null
    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_registration, container, false)
        registrationViewModel =
            ViewModelProvider(this).get(RegistrationViewModel::class.java)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = view.findNavController()
        binding?.apply {
            viewModel = registrationViewModel
            login.setOnClickListener {
                navController.navigate(R.id.action_registrationFragment_to_loginFragment)
            }
        }
        registrationViewModel.apply {
            navigateToContent.observe(viewLifecycleOwner) { activeEvent ->
                if (activeEvent) {
                    onNavigateToContent()
                    navController.navigate(R.id.action_registrationFragment_to_contentFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}