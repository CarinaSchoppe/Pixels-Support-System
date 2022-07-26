/*    */ package de.bypixels.pss.commands;
/*    */ 
/*    */ import de.bypixels.pss.pss.PSS;
/*    */ import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */
/*    */
/*    */ import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/*    */
/*    */ public class CMDInfo
/*    */   implements CommandExecutor
/*    */ {

    /*    */
    /*    */
    public CMDInfo(PSS plugin)
    /*    */ {
        /* 20 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args)
    /*    */ {
        /* 25 */
        if (command.getName().equalsIgnoreCase("pss")) {
            if (Settings.cfg.getBoolean("info")) {
                /* 26 */
                if ((sender instanceof Player)) {
                    /* 27 */
                    Player p = (Player) sender;
                    /* 28 */
                    /* 29 */
                    if (p.hasPermission("pss.info")) {
                        /* 30 */
                        String msg = PSS.prefix + Messages.cfg.getString("info");
                        /* 31 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 32 */
                        return true;
                        /*    */
                    }
                    /* 34 */
                    String msg = PSS.prefix + Messages.cfg.getString("permissions");
                    /* 35 */
                    Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 36 */
                    /*    */
                }else {
                    String msg = PSS.prefix + Messages.cfg.getString("info");
                    /* 31 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 32 */
                }
                return true;
                /*    */
            }
            /*    */
            /*    */
        }

        /* 44 */
        return false;
        /*    */
    }
}

/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */