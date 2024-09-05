package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.data.vo.v2

import java.util.Date


data class PersonVO (

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDay: Date? = null
)