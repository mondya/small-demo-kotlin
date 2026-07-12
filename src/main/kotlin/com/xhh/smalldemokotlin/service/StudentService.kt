package com.xhh.smalldemokotlin.service

import com.xhh.smalldemokotlin.domain.StudentEntity
import com.xhh.smalldemokotlin.repository.StudentEntityRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentEntityRepository: StudentEntityRepository
) {
    fun findById(id: Long): StudentEntity? {
        return studentEntityRepository.findById(id).orElse(null)
    }

    fun findAllByStatus(status: Int): List<StudentEntity> {
        return studentEntityRepository.findAllByStatus(status)
    }

    fun listByPage(page: Int, size: Int, status: Int = 1): Page<StudentEntity> {
        require(page >= 0) { "page must be greater than or equal to 0" }
        require(size > 0) { "size must be greater than 0" }

        return studentEntityRepository.findAllByStatus(status, PageRequest.of(page, size))
    }

    fun findByName(name: String): List<StudentEntity> {
        return studentEntityRepository.findAllByNameContainingIgnoreCase(name.trim())
    }

    fun findByName(name: String, page: Int, size: Int): Page<StudentEntity> {
        require(page >= 0) { "page must be greater than or equal to 0" }
        require(size > 0) { "size must be greater than 0" }

        return studentEntityRepository.findAllByNameContainingIgnoreCase(
            name.trim(),
            PageRequest.of(page, size)
        )
    }
}
