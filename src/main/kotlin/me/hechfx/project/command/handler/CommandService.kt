package me.hechfx.project.command.handler

import dev.kord.core.Kord
import me.hechfx.project.command.handler.CommandManager
import me.hechfx.project.command.vanilla.info.BotInfoCommand
import me.hechfx.project.command.vanilla.misc.DiscrimCommand
import me.hechfx.project.command.vanilla.misc.PingCommand
import me.hechfx.project.command.vanilla.util.InviteCommand

class CommandService(val commandManager: CommandManager) {

    fun registerCommands() {
        commandManager.add(BotInfoCommand())
        commandManager.add(DiscrimCommand())
        commandManager.add(PingCommand())
        commandManager.add(InviteCommand())
    }
}