package me.toptas.unittest

import com.nhaarman.mockitokotlin2.anyVararg
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class LoginPresenterTest {

    lateinit var presenter: LoginPresenter
    lateinit var view: LoginView

    @Before
    fun setup() {
        view = Mockito.mock(LoginView::class.java)
        presenter = LoginPresenter(view)
    }

    @Test
    fun loginSuccessTest() {
        presenter.login("user", "pass")

        Mockito.verify(view).onLoginSuccess()
    }

    @Test
    fun loginFailTest() {
        presenter.login("user", "")

        Mockito.verify(view).onLoginFail(anyVararg())
    }


}