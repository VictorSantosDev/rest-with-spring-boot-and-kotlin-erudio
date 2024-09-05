package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.controller

import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.data.vo.v1.PersonVO
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.data.vo.v2.PersonVO as PersonVOV2
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.services.PersonService
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.util.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/person/v1")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    fun findAll(): List<PersonVO>
    {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    fun findById(@PathVariable(value="id") id: Long): PersonVO
    {
        return service.findById(id)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML]
    )
    fun create(@RequestBody person: PersonVO): PersonVO
    {
        return service.create(person);
    }

    @PostMapping(value = ["/v2"],
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML]
    )
    fun createV2(@RequestBody person: PersonVOV2): PersonVOV2
    {
        return service.createV2(person);
    }

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML]
    )
    fun update(@RequestBody person: PersonVO): PersonVO
    {
        return service.update(person);
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
    fun delete(@PathVariable(value="id") id: Long) : ResponseEntity<*>
    {
        service.delete(id)

        return ResponseEntity.noContent().build<Any>()
    }
}