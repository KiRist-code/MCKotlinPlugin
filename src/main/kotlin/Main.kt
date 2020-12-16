package kr.heartpattern.kotlinpluginsample

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.sql.Time
import java.time.Instant



open class Main: JavaPlugin(), Listener, CommandExecutor{
    private sealed class MainCommand

    var setDay = true

    override fun onEnable() {
        logger.info("Plugin enabled")
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getScheduler().runTaskTimer(this, runTimer(), 20*3, 20*10)
        Bukkit.getScheduler().runTaskTimer(this, setDay(), 20*3, 20*30)
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

    public fun setDay() : Runnable {
        var r : Runnable = Runnable {
            if(setDay){
                val worlds = Bukkit.getWorlds()
                for(world in worlds){
                    if(world.time > 13000) {
                        world.time = 0
                    }
                }
            }
        }
        return r;
    }



}

