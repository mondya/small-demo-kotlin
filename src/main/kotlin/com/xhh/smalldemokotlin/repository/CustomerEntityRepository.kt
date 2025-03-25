package com.xhh.smalldemokotlin.repository

import com.xhh.smalldemokotlin.domain.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerEntityRepository : JpaRepository<CustomerEntity, Long> {

    fun findFirstById(id: Long): CustomerEntity?
    
    fun findAllByStatus(status: Int): List<CustomerEntity>?
}