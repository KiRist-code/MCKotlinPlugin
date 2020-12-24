package kr.heartpattern.kotlinpluginsample

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.World
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
import org.bukkit.util.noise.SimplexOctaveGenerator
import java.sql.Time
import java.time.Instant
import kotlin.random.Random
import org.bukkit.inventory.ShapedRecipe

class MainCommand:Main(), Listener, CommandExecutor{
    @EventHandler
    public fun joinEvent(event: PlayerJoinEvent){
        event.player.sendMessage("Hello user! Welcome to my Server")
        var players = Bukkit.getOnlinePlayers()
        for(p in players) {
            event.player.sendMessage(p.name)
            p.allowFlight = true

            val right = p.effectivePermissions
            for(r in right){
                p.sendMessage(r.permission)
            }
            if(p.hasPermission("minecraft.command.me")) {
                p.sendMessage("U dont have permission!!")
            }
        }

        var p = event.player
        var inventar = p.inventory
        var stack = ItemStack(Material.IRON_SWORD,5)
        stack.addEnchantment(Enchantment.FIRE_ASPECT, 1)
        var metadata = stack.itemMeta
        metadata?.setDisplayName("Fire sword")
        stack.itemMeta = metadata
        inventar.addItem(stack)
        if(inventar.contains(stack)){
            p.sendMessage("Your first supply has been arrived!")
        }


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
                    "day" -> {
                        if(!setDay) {
                            setDay = true
                            sender.sendMessage("Days activated")
                        }
                        else {
                            setDay = false
                            sender.sendMessage("Days off")
                        }
                    }
                }
            }
        }
        return true
    }

}
