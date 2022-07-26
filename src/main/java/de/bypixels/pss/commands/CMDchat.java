/*    */
package de.bypixels.pss.commands;
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
/*    */ public class CMDchat implements CommandExecutor
        /*    */ {

    /*    */
    /*    */
    public CMDchat(PSS plugin)
    /*    */ {
        /* 19 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    @SuppressWarnings("deprecation")
    public boolean onCommand(@NotNull CommandSender cs, @NotNull Command cmd, @NotNull String label, String[] args)
    /*    */ {
        /* 24 */   if (Settings.cfg.getBoolean("chat"))
            /*    */ {
        if ((cs instanceof Player)) {
            /* 25 */
            Player p = (Player) cs;
            /* 26 */

                /* 28 */
                if (cmd.getName().equalsIgnoreCase("chat")) {
                    /* 29 */
                    if (p.hasPermission("pss.chat")) {
                        /* 30 */
                        for (int i = 0; i < 50; i++)
                            /* 31 */
                            Bukkit.broadcastMessage("");
                        /*    */
                        Player localPlayer1;
                        /* 33 */
                        for (Iterator localIterator = Bukkit.getOnlinePlayers().iterator(); localIterator.hasNext(); localPlayer1 = (Player) localIterator.next()) {
                        }
                        /*    */
                        /*    */
                        /*    */
                        /*    */
                        /* 38 */
                        String msg = PSS.prefix + Messages.cfg.getString("chatclear");
                        /* 39 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    } else {
                        /* 41 */
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 42 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                }
                /*    */
            }else{
            String msg = PSS.prefix + Messages.cfg.getString("player");
            /* 48 */
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        }
            /*    */
        }  /* 47 */ /*    */
        /* 50 */
        return true;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDchat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */