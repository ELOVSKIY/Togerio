package com.helicoptera.togerio.user

import com.helicoptera.togerio.data.entity.User


interface CrudUserCases {

    fun createUser(user: User)

    fun deleteUserById(id: Int)
}