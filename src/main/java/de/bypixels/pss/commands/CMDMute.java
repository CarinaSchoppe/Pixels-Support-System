/*    */ package de.bypixels.pss.commands;
/*    */ 
/*    */

import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ public class CMDMute
/*    */   implements CommandExecutor
/*    */ {
    /*    */
/*    */   public CMDMute(PSS plugin)
/*    */   {
/* 21 */     /*    */
        /*    */   }
/*    */
public static final File file = new File("plugins/Pixels-Support-System/mutes.yml");
public static final FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

public static void setmutes(){
    try {
        cfg.save(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
/* 24 */   public static final ArrayList<Player> muted = new ArrayList();
/*    */   
/*    */   public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args)
/*    */   {
/* 28 */     if (command.getName().equalsIgnoreCase("mute")) {
        if (Settings.cfg.getBoolean("mute")) {
/* 29 */       if ((sender instanceof Player)) {
/* 30 */         Player p = (Player)sender;
/* 31 */
/* 32 */           if (p.hasPermission("pss.mute")) {
/* 33 */             if (args.length == 1) {
/* 34 */               Player mute = Bukkit.getPlayer(args[0]);
/* 35 */               if (mute != null) {
/* 36 */                 if (!muted.contains(mute)) {
    cfg.set(mute.getName(), true);
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                /* 37 */                      String msg1 = PSS.prefix+ Objects.requireNonNull(Messages.cfg.getString("mute1")).replace("%player%", mute.getName());
/* 38 */                     String msg2 = PSS.prefix+ Messages.cfg.getString("mute2");
/* 39 */                   Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/* 40 */                   mute.sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
/* 41 */                   muted.add(mute);
/*    */                 } else {
/* 43 */                     String msg = PSS.prefix+ Messages.cfg.getString("mute5");
/* 44 */                   Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */                 }
/*    */               } else {
/* 47 */                    String msg = PSS.prefix+ Messages.cfg.getString("notserver");
/* 48 */                 Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */               }
/*    */             } else {
/* 51 */                   String msg = PSS.prefix+ Messages.cfg.getString("mute3");
/* 52 */               Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */             }
/*    */           } else {
/* 55 */
                    String msg = PSS.prefix + Messages.cfg.getString("permissions");
                    /* 56 */
                    Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */           }
/*    */         }else{
    if (args.length == 1){
        if (Bukkit.getPlayer(args[0]) != null) {
            Player mute = Bukkit.getPlayer(args[0]);
            /* 35 */
            if (mute != null) {
                /* 36 */
                if (!muted.contains(mute)) {
                    /* 37 */
                    String msg1 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("mute1")).replace("%player%", mute.getName());
                    /* 38 */
                    String msg2 = PSS.prefix + Messages.cfg.getString("mute2");
                    /* 39 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                    /* 40 */
                    mute.sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
                    /* 41 */
                    muted.add(mute);
                    try {
                        cfg.set(mute.getName(), true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    /*    */
                } else {
                    /* 43 */
                    String msg = PSS.prefix + Messages.cfg.getString("mute5");
                    /* 44 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /*    */
                }
                /*    */
            } else {
                /* 47 */
                String msg = PSS.prefix + Messages.cfg.getString("notserver");
                /* 48 */
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                /*    */
            }
        }else{
            String msg = PSS.prefix+ Messages.cfg.getString("online");
            /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        }
            }else{
        String msg = PSS.prefix+ Messages.cfg.getString("arguments");
        /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
    }

/*    */       }
/*    */
/*    */     }
/*    */     
/* 66 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDMute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */