package me.toptas.unittest

import org.junit.Test

class LoginManagerTest {

    @Test
    fun loginSuccessTest() {
        val manager = LoginManager()
        val result = manager.login("user", "pass")

        assert(result)
    }

    @Test
    fun loginFailTest(){
        val manager = LoginManager()
        val result = manager.login("user", "passs")

        assert(!result)
    }
}