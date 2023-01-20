package com.example.educacionitmvpexample.model

import com.example.educacionitmvpexample.model.data.User
import com.example.educacionitmvpexample.model.data.UserResponse

interface LoginRepository {
    fun login(user: User, responseSuccess: (UserResponse) -> Unit, responseError: (String)->Unit)
}