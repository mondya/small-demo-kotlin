package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.domain.CustomerEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomController {

    @GetMapping("/index")
    fun index() {
        val customerEntity = CustomerEntity(null, "cus", 10, 1)
    }
}