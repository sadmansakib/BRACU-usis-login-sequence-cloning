package com.example.bracuusisloginsequenceclone.repositories

import com.example.bracuusisloginsequenceclone.Application
import retrofit2.Response

/**Repository class for Keeping Business Logic.**/

class AuthRepository {

    /**
     * @param email as String value which is the Student email address
     * @param password as String value which is the Student login password
     * @return A raw HTTP response from the API endpoint
     **/

    suspend fun studentLogin(email: String, password: String): Response<Unit> {
        return Application.createInstance().initiateLoginTest(email, password)
    }
}