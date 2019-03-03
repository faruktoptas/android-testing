package me.toptas.unittest

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.anyVararg
import com.nhaarman.mockitokotlin2.eq
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class LoginPresenterTest {

    lateinit var presenter: LoginPresenter
    lateinit var view: LoginView
    lateinit var repo: LoginRepository

    @Before
    fun setup() {
        view = Mockito.mock(LoginView::class.java)
        repo = Mockito.mock(LoginRepository::class.java)


        presenter = LoginPresenter(view, repo)
    }

    @Test
    fun loginSuccessTest() {
        Mockito.`when`(repo.login(eq("user"), eq("pass"), any()))
            .then {
                (it.getArgument(2) as LoginCallback).success(Login("123"))
            }

        presenter.login("user", "pass")

        Mockito.verify(view).onLoginSuccess()
    }

    @Test
    fun loginFailTest() {
        Mockito.`when`(repo.login(any(), any(), any()))
            .then {
                (it.getArgument(2) as LoginCallback).fail(Exception(""))
            }

        presenter.login("user", "")

        Mockito.verify(view).onLoginFail(anyVararg())
    }


}