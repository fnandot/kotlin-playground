package com.fnandot.users.infrastructure.api.serialization

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fnandot.users.domain.UserRegistered
import org.springframework.boot.jackson.JsonComponent
import java.io.IOException

@JsonComponent
class UserRegisteredSerializer {
    class UserRegisteredJsonSerializer : JsonSerializer<UserRegistered>() {
        @Throws(IOException::class, JsonProcessingException::class)
        override fun serialize(
            userRegistered: UserRegistered,
            jsonGenerator: JsonGenerator,
            serializerProvider: SerializerProvider,
        ) {
            jsonGenerator.writeStartObject()
            jsonGenerator.writeObjectField("data", userRegistered)
            jsonGenerator.writeEndObject()
        }
    }

    class UserRegisteredJsonDeserializer : JsonDeserializer<UserRegistered>() {
        @Throws(IOException::class, JsonProcessingException::class)
        override fun deserialize(
            jsonParser: JsonParser,
            deserializationContext: DeserializationContext,
        ): UserRegistered {
            TODO("To be implemented")
        }
    }
}
