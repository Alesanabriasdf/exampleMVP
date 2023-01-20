package com.example.educacionitmvpexample.networkfake

import com.example.educacionitmvpexample.model.data.User
import com.example.educacionitmvpexample.model.data.UserResponse
import io.reactivex.Single

interface UserApi {

    fun login(user: User): Single<UserResponse>

    fun loginError(): Single<UserResponse>

}