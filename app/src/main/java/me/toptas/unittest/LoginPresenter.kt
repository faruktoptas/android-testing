package me.toptas.unittest


class LoginPresenter(private val view: LoginView) {

    fun login(user: String, pass: String) {
        val repository = LoginRepositoryImpl()
        val result = repository.login(user, pass)

        if (result.success != null) {
            view.onLoginSuccess()
        }

        result.error?.apply {
            view.onLoginFail(this)
        }


    }
}

interface LoginView {
    fun onLoginSuccess()
    fun onLoginFail(e: Throwable)
}