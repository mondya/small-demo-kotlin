package com.xhh.smalldemokotlin.service

import com.xhh.smalldemokotlin.domain.CustomEntity
import org.springframework.stereotype.Service

@Service
class CustomService {

    fun findAll(): MutableList<CustomEntity> {
        return mutableListOf()
    }
}