package com.example.educacionitmvpexample.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.educacionitmvpexample.R
import com.example.educacionitmvpexample.model.LoginRepositoryImp
import com.example.educacionitmvpexample.model.data.UserResponse
import com.example.educacionitmvpexample.networkfake.UserApiImp
import com.example.educacionitmvpexample.presenter.LoginPresenter
import com.example.educacionitmvpexample.presenter.LoginPresenterImp

class MainActivity : AppCompatActivity(), MainActivityView {

    private lateinit var etUser: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createPresenter()

        setupUI()

    }

    private fun createPresenter() {
        presenter = LoginPresenterImp(this, LoginRepositoryImp(UserApiImp()))
    }

    private fun setupUI() {
        etUser = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)

        btnLogin.setOnClickListener {
            //entrada a la arquitectura
            //recibe el evento y se comunica con el presenter para continuar con el proceso logico.
            // hide the keyboard
            presenter.doLogin(etUser.text.toString(),etPassword.text.toString()
            )
        }
    }


    //metodos que realiza la vista cuando son invocados por el presenter.

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        //progressBar.visibility = View.INVISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun enableLoginButton() {
        btnLogin.isEnabled = true
    }

    override fun disableLoginButton() {
        btnLogin.isEnabled = false
    }

    override fun goToNextScreen(user: UserResponse) {
        Toast.makeText(this, "Bienvenido ${user.firstName}", Toast.LENGTH_LONG).show()
        //Mostrar siguiente pantalla
    }
}