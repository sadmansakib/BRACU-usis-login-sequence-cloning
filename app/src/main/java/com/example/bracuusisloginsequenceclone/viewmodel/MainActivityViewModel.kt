package com.example.bracuusisloginsequenceclone.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bracuusisloginsequenceclone.exception.APIExceptions
import com.example.bracuusisloginsequenceclone.interfaces.AuthListener
import com.example.bracuusisloginsequenceclone.repositories.AuthRepository
import kotlinx.coroutines.launch

/**
 * ViewModel class that handles interaction between UI and Business logic
 * @constructor application class instance
 * @return an instance of ViewModel
 * **/

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    //Initialization of parameters that are bound to UI editTexts
    var studentEmail: String? = null
    var studentPassword: String? = null


    var authListener: AuthListener? = null

    /**
     * Function responsible for triggering the interaction. This is bound with button
     * using dataBinding library
     * **/

    fun initiateLogin(view: View) {
        authListener?.onStarted()
        if (studentEmail.isNullOrEmpty() || studentPassword.isNullOrEmpty()) {
            authListener?.onFailure("login failed")
            return
        }

        // Coroutine block to initiate asynchronous function.
        viewModelScope.launch {
            try {
                val response = AuthRepository().studentLogin(studentEmail!!, studentPassword!!)
                Log.d("response", response.raw().toString())
            } catch (e: APIExceptions) {
                authListener?.onFailure(e.message!!)
            }

        }

    }
}