package com.example.jpa.repository

import com.example.jpa.entities.Patient
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository: CrudRepository<Patient, Long> {
}