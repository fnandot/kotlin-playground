package com.fnandot.users.application

import com.fnandot.users.domain.User
import com.fnandot.users.domain.UserIdentifier
import com.fnandot.users.domain.UserRepository
import com.fnandot.users.domain.exception.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class GetUserQueryHandler(
    private val repository: UserRepository,
) : QueryHandler<GetUserQuery, User> {
    override fun handle(query: GetUserQuery): User = UserIdentifier(query.id)
        .let {
            repository.find(it) ?: throw UserNotFoundException(it)
        }
}
