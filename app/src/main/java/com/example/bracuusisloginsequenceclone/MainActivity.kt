package com.example.bracuusisloginsequenceclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bracuusisloginsequenceclone.databinding.ActivityMainBinding
import com.example.bracuusisloginsequenceclone.interfaces.AuthListener
import com.example.bracuusisloginsequenceclone.utils.toast
import com.example.bracuusisloginsequenceclone.viewmodel.MainActivityViewModel

/**
 * The activity that that holds UI elements.
 * This class also implements AuthListener that interacts with ViewModel UI triggers.
 * Uses DataBindingUtil to handover UI responsibilities to ViewModel
 * **/

class MainActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("login started")
    }

    override fun onSuccess(user: LoginModel?) {
    }

    override fun onFailure(message: String) {
//        toast(message)
    }
}
