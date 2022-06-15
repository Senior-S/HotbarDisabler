package com.seniors.hotbardisabler.hotbardisabler.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Hotbar implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(cmd.getName().equalsIgnoreCase("hotbar")){
                if(args.length != 1){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[&cHotbarDisabler&a] &7/hotbar <enable/disable>"));
                    return true;
                }

                switch (args[0].toLowerCase()){
                    case "enable":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.setFlySpeed(0.1F);
                        PacketContainer resetHotbar = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.GAME_STATE_CHANGE);
                        resetHotbar.getGameStateIDs().write(0, 3);
                        resetHotbar.getFloat().write(0, 0F);
                        try{
                            ProtocolLibrary.getProtocolManager().sendServerPacket(player, resetHotbar);
                        } catch (InvocationTargetException e){
                            throw  new RuntimeException("Exception:", e);
                        }
                        break;
                    case "disable":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.setFlySpeed(0F);
                        PacketContainer hideHotbar = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.GAME_STATE_CHANGE);
                        hideHotbar.getGameStateIDs().write(0, 3);
                        hideHotbar.getFloat().write(0, 3F);
                        try{
                            ProtocolLibrary.getProtocolManager().sendServerPacket(player, hideHotbar);
                        } catch (InvocationTargetException e){
                            throw  new RuntimeException("Exception:", e);
                        }
                        break;
                }
            }
        }
        return true;
    }
}
