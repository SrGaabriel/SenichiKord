package me.hechfx.project

import dev.kord.core.Kord
import me.hechfx.project.command.handler.CommandHandler
import me.hechfx.project.command.handler.CommandManager
import me.hechfx.project.command.handler.CommandService
import me.hechfx.project.util.locale.SenichiConfig

class Senichi(private val config: SenichiConfig) {
    lateinit var client: Kord

    val commandManager: CommandManager = CommandManager()
    val commandHandler: CommandHandler = CommandHandler(this)

    suspend fun start() {
        client = Kord(config.token)

        CommandService(commandManager).registerCommands()
        commandHandler.startListening()

        client.login()
    }
}