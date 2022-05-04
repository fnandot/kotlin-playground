package com.fnandot.users.application

interface CommandHandler<T : Command> {
    fun handle(command: T)
}

