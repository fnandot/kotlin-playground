package com.fnandot.users.domain

import com.fnandot.users.domain.model.AggregateRoot
import com.fnandot.users.domain.model.DomainEventIdentifier
import com.fnandot.users.domain.model.Identifier
import java.util.UUID

data class User(
    override val id: UserIdentifier,
    val name: String,
    val surname: String,
    val age: Int,
    val email: String,
) : AggregateRoot(id) {
    companion object {
        fun register(name: String, surname: String, age: Int, email: String): User =
            User(UserIdentifier.generate(), name, surname, age, email)
                .apply {
                    recordThat(
                        UserRegistered(
                            DomainEventIdentifier.generate(),
                            Clock.now(),
                            id,
                            name,
                            surname,
                            age,
                            email
                        )
                    )
                }
    }
}

data class UserIdentifier(override val value: String) : Identifier {
    companion object {
        fun generate() = UserIdentifier(UUID.randomUUID().toString())
    }
}
