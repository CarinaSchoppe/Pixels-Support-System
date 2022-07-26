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
/*    */ public class CMDHeal implements org.bukkit.command.CommandExecutor
        /*    */ {

    /*    */
    /*    */
    public CMDHeal(PSS plugin)
    /*    */ {
        /* 17 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args)
    /*    */ {
        /* 22 */
        if (command.getName().equalsIgnoreCase("heal")) {
            /* 23 */        if (Settings.cfg.getBoolean("heal")) {
            if ((sender instanceof Player)) {
                /* 24 */
                Player p = (Player) sender;
                /* 25 */

                    /* 27 */
                    if (p.hasPermission("pss.heal")) {
                        /* 28 */
                        if (args.length == 0) {
                            /* 29 */
                            Objects.requireNonNull(p.getPlayer()).setHealth(20.0D);
                            /* 30 */
                            p.getPlayer().setFoodLevel(20);
                            String msg = PSS.prefix + Messages.cfg.getString("heal1");
                            /* 32 */
                            p.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*    */
                        }
                        /* 34 */
                        else if (args.length == 1) {
                            /*    */
                            /* 36 */
                            if (args[0].equalsIgnoreCase("all"))
                                /*    */ {
                                /* 38 */
                                String msg3 = PSS.prefix + Messages.cfg.getString("heal3");
                                /* 39 */
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg3));
                                /* 40 */

                                /*    */
                                /*    */
                                /* 43 */
                                for (Player allp : Bukkit.getServer().getOnlinePlayers()) {
                                    /* 44 */
                                    String msg4 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal2")).replace("%player%", p.getName());
                                    /* 45 */
                                    allp.sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                                    /* 46 */
                                    allp.setSaturation(20.0F);
                                    /* 47 */
                                    allp.setHealth(20.0D);
                                    /*    */
                                }
                                /*    */
                            }
                            /*    */
                            /*    */
                            /*    */
                            /*    */
                            /* 54 */
                            Player target = Bukkit.getPlayer(args[0]);
                            /* 55 */
                            if (target != null)
                                /*    */ {
                                /* 57 */
                                Objects.requireNonNull(target.getPlayer()).setHealth(20.0D);
                                /* 58 */
                                target.getPlayer().setFoodLevel(20);
                                /* 59 */
                                String msg = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal2")).replace("%player%", p.getName());
                                /* 60 */
                                String msg2 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal4")).replace("%player%", target.getName());
                                /* 61 */
                                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
                                /* 62 */
                                target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*    */
                                /*    */
                                /*    */
                                /*    */
                                /*    */
                                /*    */
                            }
                            /* 69 */
                            else {
                            /*    */
                            /* 72 */
                            if (!args[0].equalsIgnoreCase("all")) {
                                /* 73 */
                                String msg4 = PSS.prefix + Messages.cfg.getString("online");
                                /* 74 */
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                                /*    */
                            }
                            /*    */
                        }
                            /*    */
                        }
                        /*    */
                    }
                    /*    */
                    else {
                        /* 80 */
                        String msg = PSS.prefix + Messages.cfg.getString("permissions");
                        /* 81 */
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                    }
                    /*    */
                }else{
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("all"))
                        /*    */ {
                        /* 38 */
                        String msg3 = PSS.prefix + Messages.cfg.getString("heal3");
                        /* 39 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg3));
                        /* 40 */
                        String str1 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal2")).replace("%player%", "Console");
                        /*    */
                        /*    */
                        /* 43 */
                        for (Player allp : Bukkit.getServer().getOnlinePlayers()) {
                            /* 44 */
                            String msg4 = PSS.prefix + Messages.cfg.getString("heal2");
                            /* 45 */
                            allp.sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                            /* 46 */
                            allp.setSaturation(20.0F);
                            /* 47 */
                            allp.setHealth(20.0D);
                            /*    */
                        }
                        /*    */
                    }
                    /*    */
                    /*    */
                    /*    */
                    /*    */
                    /* 54 */
                    Player target = Bukkit.getPlayer(args[0]);
                    /* 55 */
                    if (target != null)
                        /*    */ {
                        /* 57 */
                        Objects.requireNonNull(target.getPlayer()).setHealth(20.0D);
                        /* 58 */
                        target.getPlayer().setFoodLevel(20);
                        /* 59 */
                        String msg = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal2")).replace("%player%", "CONSOLE");
                        /* 60 */
                        String msg2 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal4")).replace("%player%", target.getName());
                        /* 61 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
                        /* 62 */
                        target.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /*    */
                        /*    */
                        /*    */
                        /*    */
                        /*    */
                        /*    */
                    }
                    /* 69 */
                    else {
                    /*    */
                    /* 72 */
                    if (!args[0].equalsIgnoreCase("all")) {
                        /* 73 */
                        String msg4 = PSS.prefix + Messages.cfg.getString("online");
                        /* 74 */
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                        /*    */
                    }
                    /*    */
                }
                    /*    */
                }else{
                    String msg4 = PSS.prefix + Messages.cfg.getString("arguments");
                    /* 74 */
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg4));
                }
            }
                /*    */
            }  /* 8
/* 36 */
            /*    */
        }
        /*    */
        /*    */
        /*    */
        /*    */
        /*    */
        /* 94 */
        return true;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDHeal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */