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
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
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
/*    */ public class CMDshow implements CommandExecutor
/*    */ {
    /*    */
/*    */   public CMDshow(PSS plugin)
/*    */   {
/* 19 */     /*    */
        /*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCommand(@NotNull CommandSender commandSender, Command command, @NotNull String s, String[] strings)
/*    */   {
/*    */   Object msg;
/* 26 */     if (command.getName().equalsIgnoreCase("show")) {
/* 27 */       if ((commandSender instanceof Player)) {
/* 28 */         Player p = (Player)commandSender;
/* 29 */         if ((Settings.cfg.getBoolean("show")) &&
/* 30 */           (p.hasPermission("pss.show"))) {
/* 31 */           for (Player all : Bukkit.getOnlinePlayers()) {
/* 32 */             all.showPlayer(PSS.getPlugin(), p);
/* 33 */             p.showPlayer(PSS.getPlugin(),all);
/*    */           }
/*    */           
/*    */ 
/* 37 */            msg = PSS.prefix+ Messages.cfg.getString("showall1");
/*    */           
/* 39 */           Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', (String)msg));
/*    */         }
/*    */       }
/*    */     }
/* 43 */     else if (command.getName().equalsIgnoreCase("hide")) {
/* 44 */       if ((commandSender instanceof Player)) {
/* 45 */         if (Settings.cfg.getBoolean("show")) {
/* 46 */           Player p = (Player)commandSender;
/* 47 */           if (p.hasPermission("pss.players")) {
/* 48 */             for (msg = Bukkit.getOnlinePlayers().iterator(); ((Iterator)msg).hasNext();) { Player all = (Player)((Iterator)msg).next();
/* 49 */               all.hidePlayer(PSS.getPlugin(),p);
/* 50 */               p.hidePlayer(PSS.getPlugin(),all);
/*    */             }
/*    */             
/*    */ 
/* 54 */               String msg1 = PSS.prefix+ Messages.cfg.getString("showall2");
/*    */             
/* 56 */             Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/*    */           } else {
/* 58 */
                    String msg1 = PSS.prefix + Messages.cfg.getString("permissions");
                    /* 59 */
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/*    */           }
/*    */         }
/*    */       } else {
/* 63 */           String msg1 = PSS.prefix+ Messages.cfg.getString("player");
/* 64 */         Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
/*    */       }
/*    */     }
/*    */     
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDshow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */