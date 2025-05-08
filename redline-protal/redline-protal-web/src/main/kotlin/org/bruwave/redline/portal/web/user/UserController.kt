package org.bruwave.redline.portal.web.user

import org.bruwave.redline.portal.web.api.UserApi
import org.bruwave.redline.portal.web.model.BasicUserVO
import org.bruwave.redline.usecase.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) : UserApi {

    override fun listUsers(): ResponseEntity<List<BasicUserVO>> {
        val users = userService.listUsers()
        val userVOS = users.map { user ->
            BasicUserVO(
                user.id,
                user.name,
                user.nick,
                user.createdAt.toEpochMilli()
            )
        }
        return ResponseEntity.ok(userVOS)
    }
}