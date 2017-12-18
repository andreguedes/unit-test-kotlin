package br.com.andreguedes.login.util

import java.util.regex.Pattern

object StringUtils {

    fun isEmailValid(email: String): Boolean {
        var isValid = false
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)

        if (matcher.matches()) {
            isValid = true
        }
        return isValid
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 3
    }

    fun applyMask(sentence: String?, mask: String): String {
        if (sentence == null || sentence.trim { it <= ' ' }.isEmpty()) {
            return ""
        }

        val newValue = unmask(sentence)
        val cMask = mask.toCharArray()
        val maskedNewValue = CharArray(cMask.size)

        var i = 0
        var j = 0
        while (i < maskedNewValue.size) {
            val mask_char = cMask[i]

            val hasNewValue = newValue.length > j
            if (hasNewValue && mask_char == '#') {
                maskedNewValue[i] = newValue[j++]
            } else if (hasNewValue) {
                maskedNewValue[i] = mask_char
            } else {
                maskedNewValue[i] = ' '
            }
            i++
        }
        return String(maskedNewValue).trim { it <= ' ' }
    }

    fun unmask(s: String): String {
        return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
                .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
                .replace("[)]".toRegex(), "").replace(" ".toRegex(), "")
                .replace(",".toRegex(), "")
    }

}