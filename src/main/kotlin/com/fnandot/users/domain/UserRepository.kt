package com.fnandot.users.domain

interface UserRepository {
    fun find(id: UserIdentifier): User?
    fun save(user: User)
}
