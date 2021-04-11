package me.hechfx.project.api

import me.hechfx.project.util.CommandCategory

abstract class TextCommand(val options: Options) {

    abstract suspend fun run(context: CommandContext)

    abstract class Options(val labels: List<String>) {
        abstract var description: String
        abstract var category: CommandCategory
        open var onlyDev: Boolean = false
        open var debugMode: Boolean = false
    }
}