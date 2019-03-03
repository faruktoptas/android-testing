package me.toptas.unittest


class UserListRepoImpl : UserListRepo {

    override fun getUsers(): List<User> {
        return listOf(User("user1"), User("user2"))

    }

}

interface UserListRepo {
    fun getUsers(): List<User>
}