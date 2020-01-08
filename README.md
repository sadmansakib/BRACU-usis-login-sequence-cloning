# BRACU usis login sequence cloning

This is a mock application(WIP) that tries to replicate the login sequence used in BRACU mobile application using modern android application development libraries following MVVM architecture.

## What's Working

1. Authentication with from to j_spring_security_check? endpoint serves it's purpose.
2. Able to maintain USIS session management using cookies persistently.
3. gets proper response from backend. It's now possible to recreate the app from scratch.

## TODO

~~1. j_spring_security_check? shows 302 response code with a redirection location. Automatic redirection of OKHTTP tends to avoid 302 and redirects to another end point causing an exception error. Next task would be manually invoking redirection to proper address given by j_spring_security_check?~~

2. Automate the request sequence so that manual user interference is not needed  

## Libraries used
1. [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
2. [Jetpack Architectural Components](https://developer.android.com/jetpack) - A suite of libraries, tools, and guidance to help developers write high-quality apps easier
3. [Databinding Library](https://developer.android.com/topic/libraries/data-binding) - A support library that allows to bind UI components in layouts



## License
[MIT](https://choosealicense.com/licenses/mit/)
