package br.com.andreguedes.login

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Andre on 14/12/17.
 */
@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    @Mock lateinit var view: LoginContract.LoginView

    lateinit var presenter: LoginContract.LoginPresenter


    @Before
    fun setUp() {
        presenter = LoginPresenter(view, LoginService())
    }

    @Test
    fun shouldShowMessageIfEmailAndPasswordAreEmpty() {
        `when`(view.getEmail()).thenReturn("")
        `when`(view.getPassword()).thenReturn("")

        presenter.onLoginClicked()

        verify(view).showMessage(R.string.msg_fields_are_invalid)
    }

    @Test
    fun shouldShowMessageIfEmailAndPasswordAreValid() {
        `when`(view.getEmail()).thenReturn("teste@gmail.com")
        `when`(view.getPassword()).thenReturn("teste123")

        presenter.onLoginClicked()

        verify(view).changeTextUserStatus(R.string.txt_status_logged)
    }

}