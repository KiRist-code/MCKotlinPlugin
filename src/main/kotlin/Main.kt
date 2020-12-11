package kr.heartpattern.kotlinpluginsample

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import java.sql.Time
import java.time.*


open class Main: JavaPlugin(), Listener, CommandExecutor{
    private sealed class MainCommand

    override fun onEnable() {
        logger.info("Plugin enabled")
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getScheduler().runTaskTimer(this, runTimer(), 20*3, 20*10)
    }

    override fun onDisable(){
        logger.info("Plugin disabled")
    }

    public fun runTimer() : Runnable {
        var r : Runnable = Runnable {
            Bukkit.broadcastMessage("/ is command start" + Time.from(Instant.now()))
        }
        return r;
    }
}


