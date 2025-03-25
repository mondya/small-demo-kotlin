package com.xhh.smalldemokotlin.module

data class ResultVO(
    val status: Int,
    val message: String,
    val result: MutableMap<String, Any?> = mutableMapOf()
)
