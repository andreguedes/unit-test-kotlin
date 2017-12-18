package br.com.andreguedes.calculadorakotlin

/**
 * Created by andreguedes on 08/12/17.
 */
enum class Operation {

        SUM {
            fun apply(firstValue: Double, secondValue: Double): Double {
                return firstValue + secondValue
            }
        }

}