package com.fnandot.users.domain.model

abstract class AggregateRoot(open val id: Identifier) {

    private val events: MutableList<DomainEvent> = mutableListOf()

    fun recordThat(event: DomainEvent) = events.add(event)

    fun fetchDomainEvents(): List<DomainEvent> = events.toList().also { events.clear() }
}

interface Identifier {
    val value: String
}
