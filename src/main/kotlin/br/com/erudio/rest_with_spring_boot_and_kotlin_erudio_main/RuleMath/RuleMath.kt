package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.RuleMath

object RuleMath {
    fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(',', '.')
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false;
        val number = strNumber.replace(',', '.')
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}