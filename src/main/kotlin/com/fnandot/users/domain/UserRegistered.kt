package com.fnandot.users.domain

import com.fnandot.users.domain.model.DomainEvent
import com.fnandot.users.domain.model.DomainEventIdentifier
import java.time.LocalDateTime

data class UserRegistered(
    override val identifier: DomainEventIdentifier,
    override val occurredOn: LocalDateTime,
    val userIdentifier: UserIdentifier,
    val name: String,
    val surname: String,
    val age: Int,
    val email: String,
) : DomainEvent
