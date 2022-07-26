package de.bypixels.pss.commands;
// Made by PixelsDE
// Project: Template
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 31.01.2018
// Package: de.bypixels.projectname.commands
// Created by: Daniel

import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Lag;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.Objects;

public class CMDlag implements CommandExecutor {
    /*    */
    /*    */   public CMDlag(PSS plugin)
    /*    */   {
        /* 19 */
        /*    */   }
    @Override
    public boolean onCommand(final @NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("lag")) {
            if (Settings.cfg.getBoolean("lag")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("pss.lag")) {

                        double tps = Lag.getTPS();
                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                        if (tps > 20) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.DARK_GREEN + "TPS: " + decimalFormat.format(tps)));
                            return true;
                        }
                        if (tps > 19) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.GREEN + "TPS: " + decimalFormat.format(tps)));
                            return true;
                        }
                        if (tps > 14) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.YELLOW + "TPS: " + decimalFormat.format(tps)));
                            return true;
                        }
                        if (tps > 9) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.RED + "TPS: " + decimalFormat.format(tps)));
                            return true;
                        }
                        if (tps < 9) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.DARK_RED + "TPS: " + decimalFormat.format(tps)));
                            return true;
                        }


                    } else {
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 56 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                } else {
                    double tps = Lag.getTPS();
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    if (tps > 20) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.DARK_GREEN + "TPS: " + decimalFormat.format(tps)));
                        return true;
                    }
                    if (tps > 19) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.GREEN + "TPS: " + decimalFormat.format(tps)));
                        return true;
                    }
                    if (tps > 14) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.YELLOW + "TPS: " + decimalFormat.format(tps)));
                        return true;
                    }
                    if (tps > 9) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix + ChatColor.RED + "TPS: " + decimalFormat.format(tps)));
                        return true;
                    }
                    if (tps < 9) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', PSS.prefix) + ChatColor.DARK_RED + "TPS: " + decimalFormat.format(tps));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
