package me.hechfx.project.event

import dev.kord.core.Kord
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on

class ReadyEvent(val client: Kord) {
    init {
        client.on<ReadyEvent> {
            println("${client.getSelf().tag} initialized")
        }
    }
}