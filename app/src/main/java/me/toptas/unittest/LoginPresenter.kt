package me.toptas.unittest


class LoginPresenter(private val view: LoginView, private val repository: LoginRepository) {

    fun login(user: String, pass: String) {
        repository.login(user, pass, object : LoginCallback {
            override fun success(login: Login) {
                view.onLoginSuccess()
            }

            override fun fail(error: Throwable) {
                view.onLoginFail(error)
            }
        })
    }
}

interface LoginView {
    fun onLoginSuccess()
    fun onLoginFail(e: Throwable)
}