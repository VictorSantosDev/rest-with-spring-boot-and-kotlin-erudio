package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.services


import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.data.vo.v1.PersonVO
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.data.vo.v2.PersonVO as PersonVOV2
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.exceptions.ResourceNotFoundException
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.mapper.DozerMapper
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.mapper.custom.PersonMapper
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.model.Person
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO>
    {
        logger.info("Finding all people!")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO
    {
        logger.info("Finding one person")
        var person = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID!") }

        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO) : PersonVO {
        logger.info("Create one person with name ${person.firstName}!")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun createV2(person: PersonVOV2) : PersonVOV2 {
        logger.info("Create one person with name ${person.firstName}!")
        var entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(entity))
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Update one person with name ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Delete one person with name ${id}!")
        val entity = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID!") }

        repository.delete(entity)
    }
}