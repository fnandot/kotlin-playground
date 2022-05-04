package com.fnandot.users.application

interface QueryHandler<T : Query, R> {
    fun handle(query: T): R
}

