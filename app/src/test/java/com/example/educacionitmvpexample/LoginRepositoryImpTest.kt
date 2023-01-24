package com.example.educacionitmvpexample

import com.example.educacionitmvpexample.model.LoginRepositoryImp
import com.example.educacionitmvpexample.model.data.User
import com.example.educacionitmvpexample.model.data.UserResponse
import com.example.educacionitmvpexample.networkfake.UserApi
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoginRepositoryImpTest {

    private lateinit var loginRepositoryImp: LoginRepositoryImp
    private var user = User ("alesanabria@gmail.com", "231465879")

    @Mock
    lateinit var userApi: UserApi

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler{ Schedulers.trampoline() }
        loginRepositoryImp = LoginRepositoryImp(userApi)
    }

    @Test
    fun verifyUserIsReal(){
        Mockito.`when`(userApi.login(user)).thenReturn(Single.just(UserResponse("ale","sanabria")))

        loginRepositoryImp.login(user,{},{})

        Mockito.verify(userApi).login(user)
    }
}