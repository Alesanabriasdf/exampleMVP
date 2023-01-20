package com.example.educacionitmvpexample.view

import com.example.educacionitmvpexample.model.data.UserResponse

interface MainActivityView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun enableLoginButton()
    fun disableLoginButton()
    fun goToNextScreen(user: UserResponse)
}