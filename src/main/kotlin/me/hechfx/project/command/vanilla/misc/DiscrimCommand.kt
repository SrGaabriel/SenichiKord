package me.hechfx.project.command.vanilla.misc

import me.hechfx.project.api.TextCommand
import me.hechfx.project.api.CommandContext
import me.hechfx.project.util.CommandCategory

class DiscrimCommand: TextCommand(Options) {
    companion object Options: TextCommand.Options(listOf("discrim, discriminator")) {
        override var category = CommandCategory.MISCELLANEOUS
        override var description = "???"
        override var debugMode = true
    }

    override suspend fun run(context: CommandContext) {

    }
}