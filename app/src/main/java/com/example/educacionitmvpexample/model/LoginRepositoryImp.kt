package com.example.educacionitmvpexample.model

import com.example.educacionitmvpexample.model.data.User
import com.example.educacionitmvpexample.model.data.UserResponse
import com.example.educacionitmvpexample.networkfake.UserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoginRepositoryImp(private val userApi: UserApi): LoginRepository {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun login(
        user: User,
        responseSuccess: (UserResponse) -> Unit,
        responseError: (String) -> Unit
    ) {
        compositeDisposable.add(userApi
            .login(user)
            .delay(3000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { responseSuccess.invoke(it) },
                { responseError.invoke(it.message!!) }
            )
        )
    }
}