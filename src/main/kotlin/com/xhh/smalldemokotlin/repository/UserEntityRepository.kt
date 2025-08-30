package com.xhh.smalldemokotlin.repository

import com.xhh.smalldemokotlin.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository :JpaRepository<UserEntity, Long> {
    
    fun findFirstById(studentId: Long): UserEntity?
    
    fun findAllByStatus(status: Int): List<UserEntity>?
}