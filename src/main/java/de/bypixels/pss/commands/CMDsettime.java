package de.bypixels.pss.commands;
// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /

import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CMDsettime implements CommandExecutor{

    public CMDsettime(PSS plugin) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("settime")){
            if (sender instanceof Player){
                Player p = (Player)sender;
                if (p.hasPermission("pss.settime")){
                    if (args.length == 1){
                        if (args[0].equalsIgnoreCase("day")){

                            setTimeDay(p);

                        }else if (args[0].equalsIgnoreCase("night")){

                            setTimeNight(p);
                        }
                    }else if (args.length == 2){

                        Player target = Bukkit.getPlayer(args[1]);

                        if (args[0].equalsIgnoreCase("day")){

                 setTimeDay(Objects.requireNonNull(target));

                        }else if (args[0].equalsIgnoreCase("night")){

                          setTimeNight(Objects.requireNonNull(target));
                        }


                    }else{
                        String msg = PSS.prefix + Messages.cfg.getString("arguments");
                        /* 46 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
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
        return false;
    }




    public void setTimeNight(Player p){
        p.setPlayerTime(16000, true);
        p.setPlayerWeather(WeatherType.CLEAR);
        String msg = PSS.prefix + Messages.cfg.getString("Time_Night");
        /* 46 */
        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    public void setTimeDay(Player p){
        p.setPlayerTime(6000, true);
        p.setPlayerWeather(WeatherType.CLEAR);
        String msg = PSS.prefix + Messages.cfg.getString("Time_Night");
        /* 46 */
        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
}
