package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue = "World") name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name!")
    }
}