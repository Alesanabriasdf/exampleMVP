package com.example.educacionitmvpexample.networkfake

import com.example.educacionitmvpexample.model.data.User
import com.example.educacionitmvpexample.model.data.UserResponse
import io.reactivex.Single

class UserApiImp : UserApi {

    override fun login(user: User): Single<UserResponse> = Single.just(UserResponse("Jose", "Argento"))

    override fun loginError(): Single<UserResponse> = Single.error(Throwable("Datos incorrectos"))

}