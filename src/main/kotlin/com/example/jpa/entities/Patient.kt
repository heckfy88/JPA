package com.example.jpa.entities

import org.hibernate.annotations.NaturalId
import java.time.LocalDate
import javax.persistence.*

@Entity
class Patient(

    @Id
    @GeneratedValue
    var id: Long = 0,

    @Column(name = "name", length = 127)
    var name: String,

    @NaturalId
    @Column(nullable = false, unique = true)
    var email: String,

    var birthDate: LocalDate,

    @OneToOne(cascade = [CascadeType.ALL])
    var personalDocuments: PatientPersonalDocuments,

    @OneToMany(cascade = [CascadeType.ALL])
    var outpatientDepartment: MutableList<OutpatientDepartment>,

    ) {
    override fun toString(): String {
        return "Student(" +
                " id=$id," +
                " name='$name'," +
                " email='$email'," +
                " birthDate=$birthDate)" +
                " snils=''${personalDocuments.snils}" +
                " passport='${personalDocuments.passport}"
    }
}