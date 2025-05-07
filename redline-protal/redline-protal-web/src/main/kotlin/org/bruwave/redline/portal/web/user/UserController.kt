package org.bruwave.redline.portal.web.user

import org.bruwave.redline.portal.web.api.UserApi
import org.bruwave.redline.portal.web.model.BasicUserVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class UserController : UserApi {

    override fun listUsers(): ResponseEntity<List<BasicUserVO>> {
        val users = listOf(BasicUserVO(0, "test", "测试用户", Instant.now().toEpochMilli()))
        return ResponseEntity.ok(users)
    }
}