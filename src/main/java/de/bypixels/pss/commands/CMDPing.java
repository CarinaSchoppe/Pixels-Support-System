package de.bypixels.pss.commands;

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

public class CMDPing implements CommandExecutor {


    public CMDPing(PSS plugin) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("ping")) {
            if (Settings.cfg.getBoolean("ping")) {
            if (sender instanceof Player) {

                    Player p = (Player) sender;
                    if (p.hasPermission("pss.ping")) {

                        if (args.length == 0){
                            //Wenn er sich selbst meint!

                            String msg = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("ping1")).replace("%ping%", Integer.toString(getPing(p)));
                            /* 56 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));

                        }else if (args.length == 1){
                            Player target = Bukkit.getPlayer(args[0]);
                            String msg = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("ping2")).replace("%ping%", Integer.toString(getPing(Objects.requireNonNull(target)))).replace("%player%", target.getName());
                            /* 56 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }else{
                            String msg = PSS.prefix + Messages.cfg.getString("arguments");
                            /* 56 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        }
                    }else{
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 56 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                if (args.length == 1){
                    if (Bukkit.getPlayer(args[0]) != null){
                        Player target = Bukkit.getPlayer(args[0]);
                        String msg = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("ping2")).replace("%ping%", Integer.toString(getPing(Objects.requireNonNull(target)))).replace("%player%", target.getName());
                        /* 56 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }else{
                        String msg = PSS.prefix+ Messages.cfg.getString("online");
                        /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                    String msg = PSS.prefix+ Messages.cfg.getString("arguments");
                    /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }

            }
            }
        }


        return false;
    }


    public int getPing(Player p) {
        return p.getPing();
    }
}