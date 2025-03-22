package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.domain.UserEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/login")
class LoginController {
    
    @PostMapping
    fun login(@RequestParam(name =  "username") userName: String, @RequestParam(name = "password") password: String): String {
        
        UserEntity()
        return "success"
    }
}