package com.fnandot.users.domain

import java.time.LocalDateTime

object Clock {
    fun now(): LocalDateTime = LocalDateTime.now()
}
