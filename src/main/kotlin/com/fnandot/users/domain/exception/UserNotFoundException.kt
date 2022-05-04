package com.fnandot.users.domain.exception

import com.fnandot.users.domain.UserIdentifier

data class UserNotFoundException(val userId: UserIdentifier) : Exception() {
    override val message: String = "User with id <${userId.value}> not found"
}
