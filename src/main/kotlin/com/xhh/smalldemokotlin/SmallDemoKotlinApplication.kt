package com.xhh.smalldemokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
class SmallDemoKotlinApplication

fun main(args: Array<String>) {
    runApplication<SmallDemoKotlinApplication>(*args)
}
