package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.repository

import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>