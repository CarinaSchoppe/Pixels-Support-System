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

import java.io.IOException;
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
/*    */ public class CMDMaintenanceMode
        /*    */ implements CommandExecutor
        /*    */ {

    /*    */
    /*    */
    public CMDMaintenanceMode(PSS plugin)
    /*    */ {
        /* 20 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(@NotNull CommandSender commandSender, Command command, @NotNull String label, String[] args)
    /*    */ {
        /* 25 */
        if (command.getName().equalsIgnoreCase("maintenance")) {
            /* 26 */
            if (Settings.cfg.getBoolean("maintenance")) {
                if ((commandSender instanceof Player)) {
                    /* 27 */
                    Player p = (Player) commandSender;
                    /* 28 */

                    /* 29 */
                    if (p.hasPermission("pss.maintenance")) {
                        /* 30 */
                        if (!Settings.cfg.getBoolean("workmode")) {
                            /* 31 */
                            Settings.cfg.set("workmode", true);
                            PSS.wartung = true;
                            try {
                                Settings.cfg.save(Settings.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            /* 32 */
                            String msg = PSS.prefix + Messages.cfg.getString("maintenance1");
                            /* 33 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 34 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 35 */
                        } else if (Settings.cfg.getBoolean("workmode")) {
                            /* 36 */
                            String msg = PSS.prefix + Messages.cfg.getString("maintenance2");
                            /* 37 */
                            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 38 */
                            Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /* 39 */
                            Settings.cfg.set("workmode", false);
                            PSS.wartung = false;
                            try {
                                Settings.cfg.save(Settings.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            /*    */
                        }
                        /*    */
                    } else {
                        /* 42 */
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 43 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                } else if (!PSS.wartung) {
                    /* 47 */
                    String msg = PSS.prefix + Messages.cfg.getString("maintenance1");
                    /* 48 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 49 */
                    PSS.wartung = true;
                    Settings.cfg.set("workmode", true);
                    try {
                        Settings.cfg.save(Settings.file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    /* 50 */
                } else if (PSS.wartung) {
                    /* 51 */
                    String msg = PSS.prefix + Messages.cfg.getString("maintenance2");
                    /* 52 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    /* 53 */
                    PSS.wartung = false;
                    Settings.cfg.set("workmode", false);
                    /*    */          try {
                        Settings.cfg.save(Settings.file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                /* 46 */


                /*    */
            }
            /*    */
            /* 57 */

            /*    */
        }
        return false;
    }}
    /*    */



/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDMaintenanceMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */