package me.hechfx.project.command.vanilla.misc

import dev.kord.core.behavior.edit
import me.hechfx.project.api.TextCommand
import me.hechfx.project.api.CommandContext
import me.hechfx.project.util.CommandCategory

class PingCommand() : TextCommand(Options) {
    companion object Options: TextCommand.Options("ping", "latency", "latencia") {
        override var category = CommandCategory.MISCELLANEOUS
        override var description = "Ping pong!"
        override val onlyDev = false
        override val debugMode = false
    }

    override suspend fun run(context: CommandContext) {
        val time = System.currentTimeMillis()
        val message = context.textChannel.createMessage("\uD83D\uDD39 • ${context.author.mention} API: `${context.client.gateway.averagePing}` | Gateway: `...`")

        message.edit {
            this.content = "\uD83D\uDD39 • ${context.author.mention} API: `${context.client.gateway.averagePing}` | Gateway: `${System.currentTimeMillis() - time}ms`"
        }
    }
}