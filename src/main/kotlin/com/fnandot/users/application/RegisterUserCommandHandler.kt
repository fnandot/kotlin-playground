package com.fnandot.users.application

import com.fnandot.users.domain.User
import com.fnandot.users.domain.UserRepository
import com.fnandot.users.domain.model.DomainEventBus
import org.springframework.stereotype.Service

@Service
class RegisterUserCommandHandler(
    private val repository: UserRepository,
    private val domainEventBus: DomainEventBus,
) : CommandHandler<RegisterUserCommand> {
    override fun handle(command: RegisterUserCommand): Unit = User
        .register(command.name, command.surname, command.age, command.email)
        .also { repository.save(it) }
        .also { it.fetchDomainEvents().map(domainEventBus::handle) }
        .let { }
}
