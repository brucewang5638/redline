package org.bruwave.redline.usecase.user.impl

import org.bruwave.redline.usecase.user.BasicUserTO
import org.bruwave.redline.usecase.user.UserService
import org.bruwave.redline.usecase.user.UserTO
import org.bruwave.redline.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
) : UserService {
    override fun createUser(user: UserTO): UserTO {
        TODO("Not yet implemented")
    }

    override fun updateUser(userTO: UserTO): UserTO {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userTO: UserTO): UserTO {
        TODO("Not yet implemented")
    }

    override fun getUser(id: Long): UserTO {
        val user =
            userRepository
                .findById(id)
                .orElseThrow { RuntimeException("User with id $id not found") }

        return UserTO(
            id = user.id,
            name = user.name,
            nick = user.nick,
            sex = user.sex.name,
            age = user.age,
            roles = user.roles.map { it.name },
            enabled = user.enabled,
            locked = user.locked,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
        )
    }

    override fun getUser(name: String): UserTO {
        TODO("Not yet implemented")
    }

    override fun listUsers(): List<BasicUserTO> =
        userRepository.findAll().map {
            BasicUserTO(
                id = it.id,
                name = it.name,
                nick = it.nick,
                sex = it.sex.name,
                age = it.age,
                roles = it.roles.map { it.name },
                enabled = it.enabled,
                locked = it.locked,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
            )
        }
}
