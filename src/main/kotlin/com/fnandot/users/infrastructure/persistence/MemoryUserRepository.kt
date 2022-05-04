package com.fnandot.users.infrastructure.persistence

import com.fnandot.users.domain.User
import com.fnandot.users.domain.UserIdentifier
import com.fnandot.users.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class MemoryUserRepository : UserRepository {

    private val users: MutableMap<UserIdentifier, User> = mutableMapOf()

    override fun find(id: UserIdentifier): User? = users
        .filter { it.key == id }
        .values
        .firstOrNull()

    override fun save(user: User) = users.set(user.id, user)
}
