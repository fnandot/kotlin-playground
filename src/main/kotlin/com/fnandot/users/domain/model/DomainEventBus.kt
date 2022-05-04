package com.fnandot.users.domain.model

interface DomainEventBus {
    fun handle(event: DomainEvent)
}
