package com.example.bracuusisloginsequenceclone

data class LoginModel(
    val authorityList: List<String>,
    val msg: String,
    val name: String,
    val old_id_no: String,
    val status: String,
    val systemUserId: Int
)