package de.bypixels.pss.commands;

// Project: PSS 
// Package: de.bypixels.pss.commands 
// Made by PixelsDE 
// Date: 03.02.2018 
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

import java.util.Objects;

public class CMDmsg implements CommandExecutor {
    /*    */
    public static String message = "";
    public static String message1 = "";

    /*    */
    /*    */
    public CMDmsg(PSS plugin)
    /*    */ {
        /* 21 */
        /*    */
        /*    */
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("msg")) {
            if (Settings.cfg.getBoolean("msg")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("pss.msg")) {
                        if (args.length >= 2) {

                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                for (int i = 1; i < args.length; i++) {
                                    message = message + args[i] + " ";
                                }
                                String msg = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("msg1")).replace("%target%", target.getName()).replace("%message%", message);
                                /* 56 */
                                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                String msg1 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("msg2")).replace("%player%", p.getName()).replace("%message%", message);
                                /* 56 */
                                Objects.requireNonNull(target.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));

                                for (Player spy : Bukkit.getOnlinePlayers()) {
                                    String msg2 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("msg3")).replace("%player%", p.getName()).replace("%message%", message).replace("%otherplayer%", target.getName());
                                    if (CMDsocialspy.inspy.contains(spy)) {
                                        for (int i = 1; i < args.length; i++) {
                                            message1 = message1 + args[i] + " ";
                                        }
                                        Objects.requireNonNull(spy.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
                                    }
                                }

                                message = "";
                                message1 = "";

                            } else {
                                String msg = PSS.prefix + Messages.cfg.getString("notserver");
                                /* 56 */
                                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            }

                        }
                    } else {
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 56 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                } else {
                    String msg = PSS.prefix + Messages.cfg.getString("player");
                    /* 60 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }

            }
        }
        return false;
    }
}

