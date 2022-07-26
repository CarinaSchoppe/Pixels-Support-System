package de.bypixels.pss.commands;

// Project: PSS 
// Package: de.bypixels.pss.commands 
// Made by PixelsDE 
// Date: 05.02.2018 
// Copyright PixelsDE 

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

import java.io.IOException;
import java.util.Objects;

public class CMDsetcmd implements CommandExecutor {

    /*    */
    /*    */
    public CMDsetcmd(PSS plugin)
    /*    */ {
        /* 19 */
        /*    */
        /*    */
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setcmd")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("pss.setcmd")) {

                    if (args.length == 2) {
                        String command = args[0];
                        if (command.equalsIgnoreCase("lag") ||command.equalsIgnoreCase("clearlag") || command.equalsIgnoreCase("config") || command.equalsIgnoreCase("deathmessage") || command.equalsIgnoreCase("godmode") || command.equalsIgnoreCase("vanish") || command.equalsIgnoreCase("mute") ||command.equalsIgnoreCase("unmute") || command.equalsIgnoreCase("show") ||  command.equalsIgnoreCase("invsee") || command.equalsIgnoreCase("joinmessage") || command.equalsIgnoreCase("msg") ||command.equalsIgnoreCase("player") || command.equalsIgnoreCase("ping") || command.equalsIgnoreCase("info") ||command.equalsIgnoreCase("heal") || command.equalsIgnoreCase("socialspy") ||  command.equalsIgnoreCase("gm") || command.equalsIgnoreCase("fly") || command.equalsIgnoreCase("crash") || command.equalsIgnoreCase("chest") || command.equalsIgnoreCase("chat") || command.equalsIgnoreCase("build") ||command.equalsIgnoreCase("gui") || command.equalsIgnoreCase("pvp")) {
                            if (args[1].equalsIgnoreCase("true")) {

                                String msg1 = saveSettings(args, command);
                                /*    */
                                /* 56 */
                                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                            } else if (args[1].equalsIgnoreCase("false")) {
                                Settings.cfg.set(command, false);
                                String msg1 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("setcmd")).replace("%command%", command).replace("%what%", args[1]);
                                /*    */
                                /* 56 */
                                try {
                                    Settings.cfg.save(Settings.file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                            }
                        }
                    } else {
                        String msg1 = PSS.prefix + Messages.cfg.getString("arguments");
                        /*    */
                        /* 56 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    }
                } else {
                    /* 54 */
                    String msg = PSS.prefix + Messages.cfg.getString("permissions");
                    /* 55 */
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            } else {

                if (args.length == 2) {

                    String command = args[0];
                    if (command.equalsIgnoreCase("lag") ||command.equalsIgnoreCase("clearlag") || command.equalsIgnoreCase("deathmessage") || command.equalsIgnoreCase("godmode") || command.equalsIgnoreCase("vanish") || command.equalsIgnoreCase("mute") ||command.equalsIgnoreCase("unmute") || command.equalsIgnoreCase("show") ||  command.equalsIgnoreCase("invsee") || command.equalsIgnoreCase("joinmessage") || command.equalsIgnoreCase("msg") ||command.equalsIgnoreCase("player") || command.equalsIgnoreCase("ping") || command.equalsIgnoreCase("info") ||command.equalsIgnoreCase("heal") || command.equalsIgnoreCase("socialspy") ||  command.equalsIgnoreCase("gm") || command.equalsIgnoreCase("fly") || command.equalsIgnoreCase("crash") || command.equalsIgnoreCase("chest") || command.equalsIgnoreCase("chat") || command.equalsIgnoreCase("build") ||command.equalsIgnoreCase("gui")) {
                        if (args[1].equalsIgnoreCase("true")) {
                            var msg1 = saveSettings(args, command);
                            /* 56 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        } else if (args[1].equalsIgnoreCase("false")) {
                            Settings.cfg.set(command, false);
                            String msg1 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("setcmd")).replace("%command%", command).replace("%what%", args[1]);
                            /*    */
                            try {
                                Settings.cfg.save(Settings.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            /* 56 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        }
                    }
                } else {
                    String msg1 = PSS.prefix + Messages.cfg.getString("arguments");
                    /*    */
                    /* 56 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                }
            }
        }
        return false;
    }

    private String saveSettings(String[] args, String command) {
        Settings.cfg.set(command, true);
        String msg1 = PSS.prefix + Messages.cfg.getString("setcmd").replace("%command%", command).replace("%what%", args[1]);
        try {
            Settings.cfg.save(Settings.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg1;
    }
}
