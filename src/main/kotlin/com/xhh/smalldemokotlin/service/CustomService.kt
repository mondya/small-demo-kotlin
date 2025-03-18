package com.xhh.smalldemokotlin.service

import com.xhh.smalldemokotlin.domain.CustomerEntity
import org.springframework.stereotype.Service

@Service
class CustomService {

    fun findAll(): MutableList<CustomerEntity> {
        return mutableListOf()
    }
}