package br.com.andreguedes.login

class LoginService {

    fun login(email: String, password: String): Boolean {
        return email.equals("teste@gmail.com") && password.equals("teste123")
    }

}