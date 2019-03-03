package me.toptas.unittest

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = UserListViewModel(UserListRepoImpl())
        vm.getList()

        vm.listLive.observe(this, Observer {
            it?.apply {
                // Set adapter for user list
            }
        })

        vm.errorLive.observe(this, Observer {
            it?.apply {
                // show error message
            }
        })

        vm.showEmptyLive.observe(this, Observer {
            // show empty user list view
        })

    }

}
