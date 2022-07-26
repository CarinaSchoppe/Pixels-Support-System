package de.bypixels.pss.commands;
// Made by PixelsDE 
// Project: PSS
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 02.02.2018
// Package: de.bypixels.pss.commands
// Created by: Daniel

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


public class CMDdeathmessage implements CommandExecutor {
    public static boolean deathmessage = true;

    /*    */
    /*    */
    public CMDdeathmessage(PSS plugin)
    /*    */ {
        /* 17 */
        /*    */
        /*    */
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("deathmessage")) {
            if (Settings.cfg.getBoolean("deathmessage")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("pss.deathmessage")) {


                        if (deathmessage) {
                            deathmessage = false;
                            String msg = PSS.prefix + Messages.cfg.getString("deathmessage1");
                            /* 39 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        } else {
                            if (!deathmessage) {
                                deathmessage = true;
                                String msg = PSS.prefix + Messages.cfg.getString("deathmessage2");
                                /* 39 */
                                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            }
                        }
                    } else {
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 66 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                } else {


                    if (deathmessage) {
                        deathmessage = false;
                        String msg = PSS.prefix + Messages.cfg.getString("deathmessage1");
                        /* 39 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    } else {
                        if (!deathmessage) {
                            deathmessage = true;
                            String msg = PSS.prefix + Messages.cfg.getString("deathmessage2");
                            /* 39 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }
                    }

                }
            }

        }


        return false;
    }

}
