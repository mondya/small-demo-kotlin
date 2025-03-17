package com.xhh.smalldemokotlin.domain

import java.util.Date

open class BaseTimeEntity(
    val dateCreated: Date,
    val lastUpdated: Date
)
