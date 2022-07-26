package de.bypixels.pss.commands;

// Project: PSS 
// Package: de.bypixels.pss.commands 
// Made by PixelsDE 
// Date: 06.02.2018 
// Copyright PixelsDE 

import de.bypixels.pss.onoff.ONOFF2;
import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CMDpvp implements CommandExecutor{

    /*    */
    /*    */
    public CMDpvp(PSS plugin)
    /*    */ {
        /* 17 */
        //
        /*    */
        /*    */
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("pvp")){
            if (Settings.cfg.getBoolean("cmdpvp")){
                if (sender instanceof Player){
                    Player p = (Player)sender;
                    if (p.hasPermission("pss.pvp")) {
                        if (ONOFF2.pvp) {
                            ONOFF2.pvp = false;
                            String msg = PSS.prefix + Messages.cfg.getString("pvp2");
                            /* 153 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        } else {
                            String msg = PSS.prefix + Messages.cfg.getString("pvp1");
                            /* 153 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            ONOFF2.pvp = true;
                        }
                    }
                }else{
                    if (ONOFF2.pvp) {
                        ONOFF2.pvp = false;
                        String msg = PSS.prefix + Messages.cfg.getString("pvp2");
                        /* 153 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    } else {
                        String msg = PSS.prefix + Messages.cfg.getString("pvp1");
                        /* 153 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        ONOFF2.pvp = true;
                    }
                }
            }
        }



        return false;
    }
}
