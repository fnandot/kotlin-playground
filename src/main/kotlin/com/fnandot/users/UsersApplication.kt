package com.fnandot.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsersApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<UsersApplication>(*args)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<UsersApplication>(*args)
}
