package com.example.bracuusisloginsequenceclone.network

import android.content.Context
import android.content.SharedPreferences

/*A custom cookie helper class*/
class CookiesHelper {

    /*Companion object block creates a static instance of these methods*/

    companion object {

        /**
         * getCookies method fetches cookies from shared preference
         * @param {context} Application Context
         * @return {HashSet<String>} HashSet of strings from SharedPreference
         * **/

        fun getCookies(context: Context?): HashSet<String> {
            val mcpPreferences: SharedPreferences = getSKSharedPreferences(context)
            return mcpPreferences.getStringSet(
                "cookies",
                HashSet()
            ) as HashSet<String>
        }

        /**
         * getCookies method fetches cookies from shared preference
         * @param {context} Application Context
         * @return {SharedPreferences} returns an instance of SharedPreferences
         * **/

        private fun getSKSharedPreferences(context: Context?): SharedPreferences {
            return context!!.getSharedPreferences("CookiesPreference", Context.MODE_PRIVATE)
        }

        /**
         * getCookies method fetches cookies from shared preference
         * @param {context,cookies} gets context and cookies as parameter
         * @return {SharedPreferences} Saves the cookie values in SharedPreferences
         * **/

        fun setCookies(context: Context?, cookies: HashSet<String>) {
            val mcpPreferences: SharedPreferences = getSKSharedPreferences(context)
            val editor = mcpPreferences.edit()
            return editor.putStringSet("cookies", cookies).apply()
        }

    }
}