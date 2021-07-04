package com.helicoptera.togerio.user

import com.helicoptera.togerio.data.entity.UserEntity


interface CrudUserCases {

    fun createUser(userEntity: UserEntity)

    fun deleteUserById(id: Int)
}