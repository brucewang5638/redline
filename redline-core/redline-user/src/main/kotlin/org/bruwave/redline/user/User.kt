package org.bruwave.redline.user

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(val name: String) {
    @Id
    val id: Long = 0

    var sex: String? = null

    var age: Int
}

