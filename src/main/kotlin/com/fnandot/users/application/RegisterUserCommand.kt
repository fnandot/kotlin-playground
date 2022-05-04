package com.fnandot.users.application

data class RegisterUserCommand(
    val name: String,
    val surname: String,
    val age: Int,
    val email: String
) : Command
