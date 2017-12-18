package br.com.andreguedes.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    lateinit var presenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this, LoginService())

        btnLogin.setOnClickListener {
            presenter.onLoginClicked()
        }
    }

    override fun getEmail(): String = edtEmail.text.toString()

    override fun getPassword(): String = edtPassword.text.toString()

    override fun showMessage(resId: Int) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
    }

    override fun changeTextUserStatus(resId: Int) {
        txtStatus.text = getString(resId)
    }

}