package com.fnandot.users.domain.model

import java.time.LocalDateTime
import java.util.UUID

interface DomainEvent {
    val identifier: DomainEventIdentifier
    val occurredOn: LocalDateTime
}

data class DomainEventIdentifier(override val value: String) : Identifier {
    companion object {
        fun generate() = DomainEventIdentifier(UUID.randomUUID().toString())
    }
}
