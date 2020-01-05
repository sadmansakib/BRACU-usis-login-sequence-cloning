package com.example.bracuusisloginsequenceclone.exception

import java.io.IOException

/**
 * Custom exception class for handling API related Exception
 * @param {exception} as String and passes it down to IOException
 * **/

class APIExceptions(e: String) : IOException(e)