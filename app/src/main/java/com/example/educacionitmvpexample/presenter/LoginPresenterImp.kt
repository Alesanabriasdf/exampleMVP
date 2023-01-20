package com.example.educacionitmvpexample.presenter

import com.example.educacionitmvpexample.model.LoginRepository
import com.example.educacionitmvpexample.model.data.User
import com.example.educacionitmvpexample.view.MainActivityView

class LoginPresenterImp (private val view: MainActivityView, private val model: LoginRepository) : LoginPresenter {

    override fun doLogin(email: String, password: String) {

        //inicio comunicacion con vista

        view.showLoading()
        view.disableLoginButton()
        //fin comunicacion con vista

        //------------------------------------------------------------

        // comunicacion con el model

        val user = User(email,password)
        if (dataIsCorrect(user)){
            model.login(user,{
                // recibe un ok (200) del model y se da vuelta y
                // se comunica con la vista y le dice que hacer
                view.hideLoading()
                view.goToNextScreen(it)
            },
                {
                    //model respondio 400 y se comunica con la vista
                    onDoLoginError("password o email incorrectos")
                }
            )
        } else {
            //aca hay un fallo en el ingreso de datos desde la vista
            // al no poder comunicarse con el model por falta de datos
            // y se comunica con la vista
            onDoLoginError("no puede haber campos vacios")
        }
    }

    private fun onDoLoginError(errorMessage: String) {
        //aca invocamos los metodos de la interfaz de la vista
        view.showError(errorMessage)
        view.enableLoginButton()
        view.hideLoading()
    }

    private fun dataIsCorrect(user: User): Boolean {
        //el presenter en si mismo hace un checkeo de la info que recibe de la vista
        //y en base a eso decide comunicarse con el model o la vista nuevamente

        if(user.email.trim().length>2 && user.password.trim().length >2){
            return true
        } else {
            return false
        }
    }
}