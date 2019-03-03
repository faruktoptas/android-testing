package me.toptas.unittest

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class UserListViewModel(private val repo: UserListRepo) : ViewModel() {

    val listLive = MutableLiveData<List<User>>()
    val errorLive = MutableLiveData<Throwable>()
    val showEmptyLive: LiveData<Boolean> = Transformations.map(listLive) {
        it.isEmpty()
    }

    fun getList() {
        try {
            val users = repo.getUsers()
            listLive.postValue(users)
        } catch (e: Exception) {
            errorLive.postValue(e)
        }

    }
}