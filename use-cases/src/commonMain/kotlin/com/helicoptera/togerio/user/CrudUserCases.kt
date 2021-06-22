package com.helicoptera.togerio.user

import com.helicoptera.togerio.data.model.User


interface CrudUserCases {

    fun createUser(user: User)

    fun deleteUserById(id: Int)
}