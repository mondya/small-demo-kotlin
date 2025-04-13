package com.xhh.smalldemokotlin.repository

import com.xhh.smalldemokotlin.domain.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CustomerEntityRepository : JpaRepository<CustomerEntity, Long> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.id = ?1")
    fun findFirstById(id: Long): CustomerEntity?
    
    @Query("SELECT c FROM CustomerEntity  c WHERE c.status = ?1")
    fun findAllByStatus(status: Int): List<CustomerEntity>?
}