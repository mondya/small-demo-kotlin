package com.xhh.smalldemokotlin.module

data class ResultVO(
    var status: Int?,
    var message: String?,
    var result: MutableMap<String, Any?> = mutableMapOf()
) {

    constructor() : this(null, null, mutableMapOf())

    fun success(result: MutableMap<String, Any?>): ResultVO {
        val resultVO = ResultVO()
        resultVO.status = 1
        resultVO.message = "success"
        resultVO.result = result
        return resultVO
    }
    
    fun success(): ResultVO {
        val resultVO = ResultVO()
        resultVO.status = 1
        resultVO.message = "success"
        return resultVO
    }

    fun fail(message: String?): ResultVO {
        val resultVO = ResultVO()
        resultVO.status = 0
        resultVO.message = message
        return resultVO
    }
}
