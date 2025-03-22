package com.xhh.smalldemokotlin.domain

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long?,
    @Column(name = "username")
    var username: String?,
    @Column(name = "password")
    var password: String?,
    @Column(name = "email")
    var email: String?,
    @Column(name = "status")
    var status: Int?
) : BaseTimeEntity() {

    constructor() : this(null, null, null, null, null)
    
    

}