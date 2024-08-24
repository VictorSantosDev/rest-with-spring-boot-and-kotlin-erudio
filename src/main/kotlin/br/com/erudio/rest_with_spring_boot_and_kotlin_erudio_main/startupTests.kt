package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Startup

fun main(args: Array<String>) {
	runApplication<Startup>(*args)
}
