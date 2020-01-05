package com.example.bracuusisloginsequenceclone.interfaces

import com.example.bracuusisloginsequenceclone.LoginModel

/**
 * Interface for abstracting connection between ViewModel and activity
 * **/

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: LoginModel?)
    fun onFailure(message: String)
}