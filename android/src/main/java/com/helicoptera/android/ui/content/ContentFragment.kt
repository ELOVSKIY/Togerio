package com.helicoptera.android.ui.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.helicoptera.android.R
import com.helicoptera.android.databinding.FragmentContentBinding
import com.helicoptera.android.databinding.FragmentLoginBinding

class ContentFragment : Fragment() {

    private var binding: FragmentContentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_content, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO check connection of navcontroller and bottom navigation
        val navController = view.findNavController()
        binding?.apply {
            bottomNavigation.setupWithNavController(navController)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}