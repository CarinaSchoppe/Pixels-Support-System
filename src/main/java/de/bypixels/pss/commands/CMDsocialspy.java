package de.bypixels.pss.commands;

// Project: PSS 
// Package: de.bypixels.pss.commands 
// Made by PixelsDE 
// Date: 04.02.2018 
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

import java.util.ArrayList;
import java.util.Objects;

public class CMDsocialspy implements CommandExecutor{


    public CMDsocialspy (PSS plugin) {
    }
    public static final ArrayList<Player> inspy = new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("socialspy")){
            if (Settings.cfg.getBoolean("socialspy")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                if (p.hasPermission("pss.socialspy")) {
                    if (inspy.contains(p)) {



                        inspy.remove(p);
                        String msg = PSS.prefix + Messages.cfg.getString("socialspy2");
                        /* 56 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));


                    } else if (!inspy.contains(p)) {


                        String msg = PSS.prefix + Messages.cfg.getString("socialspy1");
                        /* 56 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        inspy.add(p);
                    }
                }else{
                    String msg = PSS.prefix + Messages.cfg.getString("permissions");
                    /* 56 */
                    Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
                }else{
                String msg = PSS.prefix + Messages.cfg.getString("player");
                /* 60 */
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            }
        }
        return false;
    }
}
