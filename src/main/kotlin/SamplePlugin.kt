package kr.heartpattern.kotlinpluginsample

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin(){
    override fun onEnable() {
        logger.info("Plugin enabled")
    }

    override fun onDisable(){
        logger.info("Plugin disabled")
    }

    override fun getCommand(name: String?): PluginCommand {
            return super.getCommand(name)
    }
}

class command: JavaPlugin(), CommandExecutor{
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        return super.onCommand(sender, command, label, args)
    }
}