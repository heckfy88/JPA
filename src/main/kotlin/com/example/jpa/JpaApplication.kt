package com.example.jpa

import com.example.jpa.entities.OutpatientDepartment
import com.example.jpa.entities.Patient
import com.example.jpa.entities.PatientPersonalDocuments
import com.example.jpa.repository.PatientRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate

@SpringBootApplication
class JpaApplication(private val patientRepository: PatientRepository): CommandLineRunner {
    override fun run(vararg args: String?) {

        // Create

        val patient1: Patient = Patient(
            name = "Джо Джо Джамбалайа",
            email = "joejoe@joejoe.joejoe",
            birthDate = LocalDate.of(1999, 10, 10),
            personalDocuments = PatientPersonalDocuments(
                passport = "0000 000000",
                snils = "777-777-777 53"
            ),
            outpatientDepartment = mutableListOf(
                OutpatientDepartment(
                    street = "1st st."
                ),
                OutpatientDepartment(
                    street = "10st st."
                ),
                OutpatientDepartment(
                    street = "100st st."
                ),
            )
        )
        val patient2: Patient = Patient(
            name = "Джо2 Джо2 Джамбалайа2",
            email = "joe2joe2@joejoe.joejoe",
            birthDate = LocalDate.of(19992, 12, 12),
            personalDocuments = PatientPersonalDocuments(
                passport = "2222 222222",
                snils = "222-222-222 53"
            ),
            outpatientDepartment = mutableListOf(
                OutpatientDepartment(
                    street = "2st st."
                ),
                OutpatientDepartment(
                    street = "20st st."
                ),
                OutpatientDepartment(
                    street = "200st st."
                ),
            )
        )

        val patient3: Patient = Patient(
            name = "Джо3 Джо23 Джамбалайа23333",
            email = "joe33333332joe2@joejoe.joejoe",
            birthDate = LocalDate.of(19992, 12, 12),
            personalDocuments = PatientPersonalDocuments(
                passport = "2223333332 222222",
                snils = "222-22333333332-222 53"
            ),
            outpatientDepartment = mutableListOf(
                OutpatientDepartment(
                    street = "3st st."
                ),
                OutpatientDepartment(
                    street = "30st st."
                ),
                OutpatientDepartment(
                    street = "300st st."
                ),
            )
        )

        val patient4: Patient = Patient(
            name = "Джо2 Джо2 Джамбалайа2",
            email = "joe2joe312312312@joejoe.joejoe",
            birthDate = LocalDate.of(19992, 12, 12),
            personalDocuments = PatientPersonalDocuments(
                passport = "2444444444222 222222",
                snils = "2444444444422-222-222 53"
            ),
            outpatientDepartment = mutableListOf(
                OutpatientDepartment(
                    street = "4st st."
                ),
                OutpatientDepartment(
                    street = "40st st."
                ),
                OutpatientDepartment(
                    street = "400st st."
                ),
            )
        )

        patientRepository.saveAll(
            listOf(
                patient1,
                patient2,
                patient3,
                patient4
            )
        )

        // Read

        var patientListOutput = patientRepository.findAll()


        for (i in patientListOutput) {
            println("There's a patient: $i")
        }

        val patient1Output = patientRepository.findById(1)
        println("Patient Uno: $patient1Output")

        patientRepository.deleteById(1)
        patient4.birthDate = LocalDate.of(200,2,10)
        patientRepository.save(patient4)
        patientRepository.findAll()
        println("Must be 3 guys and one has a changed email, right?")
        for (i in patientRepository.findAll()) {
            println("There's a patient: $i")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<JpaApplication>(*args)
}
