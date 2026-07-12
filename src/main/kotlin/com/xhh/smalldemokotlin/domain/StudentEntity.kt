package com.xhh.smalldemokotlin.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "student")
class StudentEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id", nullable = false)
    var id: Long? = null,

    @field:Column(name = "name")
    var name: String? = null,

    @field:Column(name = "status")
    var status: Int? = null
) : BaseTimeEntity()
