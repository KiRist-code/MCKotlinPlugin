package kr.heartpattern.kotlinpluginsample

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class MainCommand:Main(), Listener, CommandExecutor{
    @EventHandler
    public fun joinEvent(event: PlayerJoinEvent){
        event.player.sendMessage("Hello user! Welcome to my Server")
    }

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender is Player) {
            if (command != null) {
                when (command.name) {
                    "hello" -> {
                        sender.sendMessage("Hello " + sender.name + "!")
                    }
                    "help" -> {
                        sender.sendMessage("sry, there is no help... so can u wait?")
                    }
                }
            }
        }
        return true
    }

}
