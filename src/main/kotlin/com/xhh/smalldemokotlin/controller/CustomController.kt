package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.domain.Custom
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomController {
    
    @GetMapping("/index")
    fun index() {
        val custom = Custom(id = 1, name = "xhh", age = 18)
    }
}