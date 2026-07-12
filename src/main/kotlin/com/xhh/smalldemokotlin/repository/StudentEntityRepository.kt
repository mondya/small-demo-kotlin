package com.xhh.smalldemokotlin.repository

import com.xhh.smalldemokotlin.domain.StudentEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentEntityRepository : JpaRepository<StudentEntity, Long> {
    fun findAllByStatus(status: Int): List<StudentEntity>

    fun findAllByStatus(status: Int, pageable: Pageable): Page<StudentEntity>

    fun findAllByNameContainingIgnoreCase(name: String): List<StudentEntity>

    fun findAllByNameContainingIgnoreCase(name: String, pageable: Pageable): Page<StudentEntity>
}
