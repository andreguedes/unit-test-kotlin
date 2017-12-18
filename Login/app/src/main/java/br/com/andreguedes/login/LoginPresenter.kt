package br.com.andreguedes.login

import br.com.andreguedes.login.util.StringUtils

class LoginPresenter(val view: LoginContract.LoginView, val loginService: LoginService) : LoginContract.LoginPresenter {

    override fun onLoginClicked() {
        val email = view.getEmail()
        val password = view.getPassword()

        if (email.isEmpty() && password.isEmpty()) {
            view.showMessage(R.string.msg_fields_are_invalid)
            return
        }

        if (email.isEmpty() || !StringUtils.isEmailValid(email)) {
            view.showMessage(R.string.msg_invalid_email)
            return
        }

        if (password.isEmpty() || !StringUtils.isPasswordValid(password)) {
            view.showMessage(R.string.msg_invalid_password)
            return
        }

        val status = loginService.login(email, password)
        if (status) {
            view.changeTextUserStatus(R.string.txt_status_logged)
            return
        }
        view.showMessage(R.string.msg_user_not_found)
    }

}