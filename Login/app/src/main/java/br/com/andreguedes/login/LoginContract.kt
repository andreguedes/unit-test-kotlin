package br.com.andreguedes.login

interface LoginContract {

    interface LoginView {
        fun getEmail(): String
        fun getPassword(): String
        fun showMessage(resId: Int)
        fun changeTextUserStatus(resId: Int)
    }

    interface LoginPresenter {
        fun onLoginClicked()
    }

}