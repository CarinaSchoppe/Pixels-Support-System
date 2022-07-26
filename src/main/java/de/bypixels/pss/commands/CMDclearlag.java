package de.bypixels.pss.commands;
// Made by PixelsDE
// Project: PingLag
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 31.01.2018
// Package: de.bypixels.pinglag.commands
// Created by: Daniel


import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CMDclearlag implements CommandExecutor {

    /*    */
    /*    */   public CMDclearlag(PSS plugin)
    /*    */   {
        /* 19 */
        /*    */   }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clearlag")) {
            if (Settings.cfg.getBoolean("clearlag")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("pss.clearlag")) {
                        for (Entity entity : Objects.requireNonNull(Bukkit.getWorld(p.getWorld().toString())).getEntities()) {
                            if (entity instanceof Item || entity instanceof Animals || entity instanceof Monster) {
                                entity.remove();

                            }
                        }
                        String msg1 = PSS.prefix + Messages.cfg.getString("clearlag");
                        /* 59 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    } else {
                        String msg1 = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 59 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    }
                } else {
                    if (args.length == 1) {
                        if (args[0] != null) {
                            if (Bukkit.getWorld(args[0]) != null) {
                                String worldname = args[0];
                                for (Entity entity : Objects.requireNonNull(Bukkit.getWorld(worldname)).getEntities()) {
                                    if (entity instanceof Item || entity instanceof Animals || entity instanceof Monster) {
                                        entity.remove();

                                    }
                                }

                                String msg1 = PSS.prefix + Messages.cfg.getString("clearlag");
                                /* 59 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                            } else {

                                String msg1 = PSS.prefix + Messages.cfg.getString("worldname2");
                                /* 59 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                            }

                        } else {
                            String msg1 = PSS.prefix + Messages.cfg.getString("worldname1");
                            /* 59 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        }
                    } else {
                        String msg1 = PSS.prefix + Messages.cfg.getString("worldname1");
                        /* 59 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    }
                }
            }
        }
        return false;
    }

}
