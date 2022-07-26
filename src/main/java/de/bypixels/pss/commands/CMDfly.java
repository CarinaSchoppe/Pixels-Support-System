/*    */ package de.bypixels.pss.commands;
/*    */ 
/*    */ import de.bypixels.pss.pss.PSS;
/*    */ import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */
/*    */ import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/*    */
/*    */ public class CMDfly implements CommandExecutor
/*    */ {
    /*    */
/*    */   public CMDfly(PSS plugin)
/*    */   {
/* 19 */     /*    */
        /*    */   }
/*    */   
/*    */   public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args)
/*    */   {
/* 24 */     if (command.getName().equalsIgnoreCase("fly")) {
        if (Settings.cfg.getBoolean("fly")) {


            //hE
/* 25 */       if ((sender instanceof Player))
/*    */       {
/* 27 */         Player p = (Player)sender;
/*    */         
/* 29 */
/* 30 */           if (p.hasPermission("pss.fly"))
/*    */           {
/*    */ 
/* 33 */             if (args.length == 0) {
/* 34 */               if (!p.getAllowFlight()) {
/* 35 */             String msg = PSS.prefix+ Messages.cfg.getString("fly1");
/* 36 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/* 37 */                 p.setAllowFlight(true);
/* 38 */               } else if (p.getAllowFlight()) {
/* 39 */         String msg = PSS.prefix+ Messages.cfg.getString("fly2");
/* 40 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/* 41 */                 Objects.requireNonNull(p.getPlayer()).setAllowFlight(false);
/*    */               }
/* 43 */             } else if (args.length == 1)
/*    */             {
/* 45 */               Player target = Bukkit.getServer().getPlayer(args[0]);
/* 46 */               if (target != null) {
/* 47 */                 if (!target.getAllowFlight()) {
/* 48 */           String msg = PSS.prefix+ Messages.cfg.getString("fly1");
/* 49 */                   target.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/* 50 */                   target.setAllowFlight(true);
/* 51 */                      String msg1 = PSS.prefix+ Messages.cfg.getString("fly3");
/* 52 */                   p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/* 53 */                 } else if (target.getAllowFlight()) {
/* 54 */                     String msg = PSS.prefix+ Messages.cfg.getString("fly2");
/* 55 */                   target.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/* 56 */                   Objects.requireNonNull(target.getPlayer()).setAllowFlight(false);
/* 57 */                     String msg1 = PSS.prefix+ Messages.cfg.getString("fly4");
/* 58 */                   p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/*    */                 }
/*    */               }
/*    */               else {
/* 62 */         String msg = PSS.prefix+ Messages.cfg.getString("online");
/* 63 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */               }
/*    */             }
/*    */           } else {
/* 67 */                String msg = PSS.prefix+ Messages.cfg.getString("permissions");
/* 68 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */           }
/*    */           
/*    */         }else{
if (args.length == 1){
                Player target = Bukkit.getServer().getPlayer(args[0]);
                /* 46 */               if (target != null) {
                    /* 47 */                 if (!target.getAllowFlight()) {
                        /* 48 */           String msg = PSS.prefix+ Messages.cfg.getString("fly1");
                        /* 49 */                   target.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 50 */                   target.setAllowFlight(true);
                        /* 51 */                      String msg1 = PSS.prefix+ Messages.cfg.getString("fly3");
                        /* 52 */                          Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        /* 53 */                 } else if (target.getAllowFlight()) {
                        /* 54 */                     String msg = PSS.prefix+ Messages.cfg.getString("fly2");
                        /* 55 */                   target.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 56 */                   Objects.requireNonNull(target.getPlayer()).setAllowFlight(false);
                        /* 57 */                     String msg1 = PSS.prefix+ Messages.cfg.getString("fly4");
                        /* 58 */                          Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                        /*    */                 }
                    /*    */               }
                /*    */               else {
                    /* 62 */         String msg = PSS.prefix+ Messages.cfg.getString("online");
                    /* 63 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /*    */               }


            }else{
    /*     */  String msg4 = PSS.prefix + Messages.cfg.getString("aguments");
    /* 74 */
    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));}
            }

/*    */       }
/*    */
/*    */     }
/*    */     
/*    */ 
/* 81 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDfly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */