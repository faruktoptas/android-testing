package me.toptas.unittest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = LoginPresenter(this, LoginRepositoryImpl())
        btnLogin.setOnClickListener {
            presenter.login("user", "pass")
        }
    }

    override fun onLoginSuccess() {
        Log.i("test", "Login success")
    }

    override fun onLoginFail(e: Throwable) {
        Log.i("test", "Login fail")

    }
}
