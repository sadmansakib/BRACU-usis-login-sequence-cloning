package com.example.bracuusisloginsequenceclone.network

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Retrofit interface for API end point.
 * @param(j_username,j_password) generates an URLEncoded String to pass as an input
 * @FormUrlEncoded annotation generates a "Content-Type:application/x-www-form-urlencoded" header.
 * @FormUrlEncoded annotation expects at least one field value and that's why student email address
 * and student password ar passed as @Field values.
 * **/

interface ApiInterface {
    @FormUrlEncoded
    @POST("j_spring_security_check")
    suspend fun initiateLoginTest(
        @Field(value = "j_username", encoded = false) username: String,
        @Field(value = "j_password", encoded = false) password: String
    ): Response<Unit>

}
