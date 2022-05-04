package com.fnandot.users.infrastructure.event

import com.fnandot.users.domain.model.DomainEvent
import com.fnandot.users.domain.model.DomainEventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MemoryDomainEventBus : DomainEventBus {

    private val logger: Logger = LoggerFactory.getLogger(MemoryDomainEventBus::class.java)

    override fun handle(event: DomainEvent) {
        logger.info("Received event: $event")
    }
}
