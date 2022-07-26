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
/*    */ public class CMDInvsee implements CommandExecutor
        /*    */ {

    /*    */
    /*    */
    public CMDInvsee(PSS plugin)
    /*    */ {
        /* 19 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args)
    /*    */ {
        /* 24 */
        if (cmd.getName().equalsIgnoreCase("invsee")) {
            /* 25 */
            if (Settings.cfg.getBoolean("invsee")) {
                if ((sender instanceof Player)) {
                    /* 26 */
                    Player p = (Player) sender;
                    /* 27 */

                    /* 28 */
                    Player target = Bukkit.getPlayer(args[0]);
                    /* 29 */
                    if (p.hasPermission("pss.invsee")) {
                        /* 30 */
                        if (args.length == 1) {
                            /* 31 */
                            if (target != null) {
                                /* 32 */
                                if (p != target)
                                    /*    */ {
                                    /*    */
                                    /* 35 */
                                    Objects.requireNonNull(p.getPlayer()).openInventory(target.getInventory());
                                    /*    */
                                }
                                /*    */
                                else {
                                    /* 38 */
                                    String msg = PSS.prefix + Messages.cfg.getString("invsee2");
                                    /* 39 */
                                    Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /*    */
                                }
                                /*    */
                            } else {
                                /* 42 */
                                String msg4 = PSS.prefix + Messages.cfg.getString("online");
                                /* 43 */
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                                /*    */
                            }
                            /*    */
                        }
                        /*    */
                        else
                            /*    */ {
                            /* 48 */
                            String msg = PSS.prefix + Messages.cfg.getString("invsee1");
                            /* 49 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*    */
                        }
                        /*    */
                    }
                    /*    */
                    else
                        /*    */ {
                        /* 54 */
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 55 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                    /*    */
                }else {
                    String msg = PSS.prefix + Messages.cfg.getString("player");
                    /* 63 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
                /*    */
            }
            /*    */
        }
        /*    */ /* 62 */ /*    */
        /*    */

        /* 66 */
        return false;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDInvsee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */