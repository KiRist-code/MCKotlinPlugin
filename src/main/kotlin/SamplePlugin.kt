package kr.heartpattern.kotlinpluginsample

import com.sun.tools.jdi.Packet
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin


open class Main: JavaPlugin(), Listener, CommandExecutor{
    private sealed class MainCommand

    override fun onEnable() {
        logger.info("Plugin enabled")
    }

    override fun onDisable(){
        logger.info("Plugin disabled")
    }
    
}
