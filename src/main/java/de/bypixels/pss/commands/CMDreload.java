package de.bypixels.pss.commands;

// Project: PSS 
// Package: de.bypixels.pss.commands 
// Made by PixelsDE 
// Date: 07.02.2018 
// Copyright PixelsDE 


import de.bypixels.pss.CMDevents.EVENTPlayers;
import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CMDreload implements CommandExecutor{


    /*    */
    /*    */
    public CMDreload(PSS plugin)
    /*    */ {
        /* 17 */
        /*    */
        /*    */
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("config")){
            if (Settings.cfg.getBoolean("config")){
                if (sender instanceof Player){
                    Player p = (Player)sender;
                    if (p.hasPermission("pss.config")){

                        yamlSaving();
                        String msg1;
                        /* 59 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        Bukkit.getServer().reload();
                    }else{
                        String msg1 = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 59 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    }
                }else{

                    yamlSaving();
                    /* 59 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    Bukkit.getServer().reload();
                }
            }
        }
        return false;
    }

    private void yamlSaving() {
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(Settings.file);
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(Messages.file);
        YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(CMDchest.file);
        YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(CMDMute.file);
        YamlConfiguration cfg4 = YamlConfiguration.loadConfiguration(EVENTPlayers.file);


        try {
            cfg.load(Settings.file);
            cfg1.load(Messages.file);
            cfg2.load(CMDMute.file);
            cfg3.load(CMDchest.file);
            cfg4.load(EVENTPlayers.file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        String msg1 = PSS.prefix + Messages.cfg.getString("config");
    }
}
