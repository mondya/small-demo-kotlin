package com.xhh.smalldemokotlin.domain

import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {
    
    @CreatedDate
    //@Column(name = "date_created", nullable = false, updatable = false)
    @Column(name = "date_created")
    var dateCreated: LocalDateTime = LocalDateTime.now()
    
    @LastModifiedDate
    //@Column(name = "last_updated", nullable = false)
    @Column(name = "last_updated")
    var lastUpdated: LocalDateTime = LocalDateTime.now()
}
