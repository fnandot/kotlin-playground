package com.fnandot.users.infrastructure.api.controller

import com.fnandot.users.application.GetUserQuery
import com.fnandot.users.application.GetUserQueryHandler
import com.fnandot.users.application.RegisterUserCommand
import com.fnandot.users.application.RegisterUserCommandHandler
import com.fnandot.users.domain.exception.UserNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val registerUserCommandHandler: RegisterUserCommandHandler,
    private val getUserQueryHandler: GetUserQueryHandler,
) {

    @PostMapping(consumes = ["application/json"])
    fun create(@RequestBody command: RegisterUserCommand) =
        registerUserCommandHandler
            .runCatching { handle(command) }
            .onSuccess { ResponseEntity.accepted() }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") userId: String) =
        getUserQueryHandler
            .runCatching { handle(GetUserQuery(userId)) }
            .onFailure {
                when (it) {
                    is UserNotFoundException -> ResponseEntity.notFound()
                    else -> ResponseEntity.badRequest()
                }
            }
            .onSuccess { ResponseEntity.ok(it) }
}
