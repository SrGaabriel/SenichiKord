package me.hechfx.project.command.handler

import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import me.hechfx.project.Senichi
import me.hechfx.project.api.CommandContext
import me.hechfx.project.util.constant.Constants

class CommandHandler(private val senichi: Senichi) {

    fun startListening() = senichi.client.on<MessageCreateEvent> {
        if (this.message.author?.isBot == true) return@on

        val prefix = Constants.getConfig().prefix

        if (!this.message.content.startsWith(prefix)) return@on

        val args = this.message.content.substring(prefix.length, this.message.content.length).trim().split(Regex("/ +/"))

        val context = CommandContext(
            senichi.client,
            this.message,
            args.drop(1),
            this.message.author!!,
            this.message.channel
        )

        val command = senichi.commandManager[args[0]] ?:
            return@on

        if (command.options.debugMode && message.author?.id?.asString != Constants.OWNER_ID)
            return@on context.reply("Este comando está em manutenção!")

        if (command.options.onlyDev && message.author?.id?.asString != Constants.OWNER_ID)
            return@on context.reply("Este pode ser usado apenas por desenvolvedores!")

        command.run(context)
    }
}