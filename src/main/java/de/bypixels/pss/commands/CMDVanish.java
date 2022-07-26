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

import java.util.ArrayList;
import java.util.List;
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
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class CMDVanish
        /*    */ implements CommandExecutor
        /*    */ {
    /*    */
    /* 29 */   public static final List<Player> vanishList = new ArrayList();
    /*    */


    /*    */
    /*    */
    public CMDVanish(PSS plugin)
    /*    */ {
        /* 26 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args)
    /*    */ {
        /* 36 */
        if (cmd.getName().equalsIgnoreCase("vanish")) {
            /* 37 */     if (Settings.cfg.getBoolean("vanish")) {
            if ((sender instanceof Player)) {
                /* 38 */
                Player player = (Player) sender;
                /* 39 */

                    /* 40 */
                    if (player.hasPermission("pss.hide")) {
                        /* 41 */


                        if (args.length == 0) {
                            /* 42 */
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                /* 44 */
                                if (!PSS.hide.contains(player)) {
                                    /* 45 */
                                    PSS.hide.add(player);
                                    /* 46 */
                                    String msg = PSS.prefix + Messages.cfg.getString("vanish1");
                                    /* 47 */
                                    Objects.requireNonNull(player.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /* 48 */
                                    vanishList.add(player);
                                    /* 49 */
                                    players.hidePlayer(PSS.getPlugin(),player);
                                    /* 50 */
                                    player.showPlayer(PSS.getPlugin(),players);
                                    /* 51 */

                                    /*    */
                                    /* 53 */

                                    /*    */
                                    /*    */
                                    /* 56 */
                                    /*    */
                                } else {


                                    /*    */
                                    /* 59 */
                                    PSS.hide.remove(player);
                                    /* 60 */
                                    players.showPlayer(PSS.getPlugin(),player);
                                    /* 61 */
                                    String msg = PSS.prefix + Messages.cfg.getString("vanish2");
                                    /* 62 */
                                    Objects.requireNonNull(player.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    /*    */

                                    player.showPlayer(PSS.getPlugin(),players);
                                    /* 67 */
                                    players.showPlayer(PSS.getPlugin(),player);
                                    /* 68 */
                                    PSS.hide.remove(player);
                                    /* 69 */

                                }
                                return false;
                            }
                        } else if (args.length == 1) {

                            Player target = Bukkit.getPlayer(args[1]);
                            for (Player all : Bukkit.getOnlinePlayers()) {

                                if (PSS.hide.contains(target)) {
                                    PSS.hide.remove(target);

                                    String msg = PSS.prefix + Messages.cfg.getString("hide4").replace("%player%", target.getName());
                                    /* 76 */
                                    player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    String msg1 = PSS.prefix + Messages.cfg.getString("vanish2");
                                    /* 62 */
                                    target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                    all.showPlayer(PSS.getPlugin(),target);
                                } else if (!PSS.hide.contains(target)) {
                                    PSS.hide.add(target);
                                    String msg = Settings.cfg.getString("Prefix") + Messages.cfg.getString("hide3").replace("%player%", target.getName());
                                    /* 76 */
                                    String msg1 = Settings.cfg.getString("Prefix")+ Messages.cfg.getString("vanish1");
                                    /* 62 */
                                    target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                    player.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                    all.hidePlayer(PSS.getPlugin(),target);
                                }
                            }
                        }
                    } else {
                        /* 75 */
                        String msg =Settings.cfg.getString("Prefix") + Messages.cfg.getString("permissions");
                        /* 76 */
                        Objects.requireNonNull(player.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                }else{
                if (args.length == 1) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[1]);
                        for (Player all : Bukkit.getOnlinePlayers()) {

                            if (PSS.hide.contains(target)) {
                                PSS.hide.remove(target);

                                String msg = Settings.cfg.getString("Prefix") + Messages.cfg.getString("hide4").replace("%player%", target.getName());
                                /* 76 */
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                String msg1 = Settings.cfg.getString("Prefix")+ Messages.cfg.getString("vanish2");
                                /* 62 */
                                target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                all.showPlayer(PSS.getPlugin(),target);
                            } else if (!PSS.hide.contains(target)) {
                                PSS.hide.add(target);
                                String msg = Settings.cfg.getString("Prefix") + Messages.cfg.getString("hide3").replace("%player%", target.getName());
                                /* 76 */
                                String msg1 = Settings.cfg.getString("Prefix") + Messages.cfg.getString("vanish1");
                                /* 62 */
                                target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                all.hidePlayer(PSS.getPlugin(),target);
                            }
                        }
                    }else{
                        String msg =Settings.cfg.getString("Prefix")+ Messages.cfg.getString("online");
                        /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                }else{
                    String msg =Settings.cfg.getString("Prefix")+ Messages.cfg.getString("arguments");
                    /* 48 */                 Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                }
            }
                /*    */
            }
            /*    */
            /*    */
        }
        /*    */
        /*    */
        /*    */
        /* 88 */
        return false;
        /*    */
    }
    /*    */
}
