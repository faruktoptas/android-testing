package me.toptas.unittest

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception

class UserListTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val repo = Mockito.mock(UserListRepo::class.java)
    val vm = UserListViewModel(repo)

    @Test
    fun testUserList() {
        Mockito.`when`(repo.getUsers())
            .thenReturn(listOf(User("user")))

        vm.getList()

        assert(vm.listLive.value?.size == 1)
    }

    @Test
    fun testEmptyUserList() {
        Mockito.`when`(repo.getUsers())
            .thenReturn(listOf())

        vm.getList()

        assert(vm.listLive.value?.size == 0)
        assert(vm.showEmptyLive.observedValue() == true)

    }

    @Test
    fun testUserListFail() {
        Mockito.`when`(repo.getUsers())
            .then {
                throw Exception("Fail")
            }

        vm.getList()

        assert(vm.errorLive.value != null)
    }
}

fun <T> LiveData<T>.observedValue(): T? {
    observeForever { }
    return value
}