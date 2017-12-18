package br.com.andreguedes.calculadorakotlin

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

/**
 * Created by andreguedes on 04/12/17.
 */
@RunWith(MockitoJUnitRunner::class)
class CalculatorPresenterTest {

    @Mock private
    lateinit var view: CalculatorContract.CalculatorView

    private lateinit var presenter: CalculatorContract.CalculatorPresenter

    @Before
    fun setUp() {
        presenter = CalculatorPresenter(view)
    }

    @Test
    fun shouldReturnCorrectSum() {
        `when`(view.getNumber1()).thenReturn(1.0)
        `when`(view.getNumber2()).thenReturn(5.2)

        presenter.doSum()

        verify(view).setResult(6.2)
    }

}