package com.helicoptera.android.view.content

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.helicoptera.android.R
import com.helicoptera.android.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_content)

        val navController = findNavController(R.id.navHost)
        binding.apply {
            bottomNavigation.setupWithNavController(navController)
        }
    }
}