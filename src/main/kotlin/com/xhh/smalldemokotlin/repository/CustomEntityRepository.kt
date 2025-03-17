package com.xhh.smalldemokotlin.repository

import com.xhh.smalldemokotlin.domain.CustomEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomEntityRepository : JpaRepository<CustomEntity, Long> {

    fun findFirstById(id: Long): MutableList<CustomEntity>
}