package com.example.bracuusisloginsequenceclone.utils

import android.content.Context
import android.widget.Toast

/**
 * Custom extension function over Context to reduce boilerplate of Toast messages
 * @param message as a String
 * @return null
 * **/
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}