/*     */
package de.bypixels.pss.onoff;
/*     */

import de.bypixels.pss.CMDevents.EVENTCrash;
import de.bypixels.pss.commands.CMDMute;
import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

/*     */ public class ONOFF3 implements org.bukkit.event.Listener
        /*     */ {
    /*     */
    /*     */
    public ONOFF3(PSS plugin)
    /*     */ {
        /*  21 */
        /*     */
        /*     */
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick1(InventoryClickEvent event)
    /*     */ {
        try {
            if (event.getView().getTitle().equalsIgnoreCase("§bServer"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  29 */
                    event.setCancelled(true);
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
                        /*  30 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMute-All Off"))
                            /*     */ {
                            /*  32 */
                            event.setCancelled(true);
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /*  36 */
                       for (Player all : Bukkit.getOnlinePlayers()){
                           if (!all.equals(player)){
                               CMDMute.muted.remove(all);
                               CMDMute.cfg.set(all.getName(), false);
                               CMDMute.cfg.save(CMDMute.file);
                               String msg = PSS.prefix + Messages.cfg.getString("mute6");
                               /*  44 */
                           Objects.requireNonNull(all.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                           }
                       }

                                player.updateInventory();
                                /*     */
                                /*  43 */
                                String msg = PSS.prefix + Messages.cfg.getString("mute8");
                                /*  44 */
                                Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*  45 */
                        }
                        /*     */
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick2(InventoryClickEvent event)
    /*     */ {
        if (event.getView().getTitle().equalsIgnoreCase("§bServer"))
            /*     */ {
            /*  56 */
            if (event.getWhoClicked().hasPermission("pss.gui")) {
                try {
                    event.setCancelled(true);
                    /*  57 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMute-All ON"))
                            /*     */ {
                            /*  59 */
                            event.setCancelled(true);
                            /*     */
                            /*  61 */
                            Player player = (Player) event.getWhoClicked();

                                /*     */ for (Player all : Bukkit.getOnlinePlayers()){
                                    if (!all.equals(player)){
                                        CMDMute.muted.add(all);
                                        String msg = PSS.prefix + Messages.cfg.getString("mute2");

                                        CMDMute.cfg.set(all.getName(), true);
                                        CMDMute.cfg.save(CMDMute.file);
                                        all.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));

                                    }
                            }
                                /*  66 */
                                player.updateInventory();
                                /*     */
                                /*  70 *//*  43 */
                                /*  72 */  /*  43 */
                                String msg2 = PSS.prefix + Messages.cfg.getString("mute7");
                                /*  73 */
                                Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg2));
                                /*  74 */
                            /*     */
                            /*     */
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*     */
            }
        }
        /*     */
    }
    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick4(InventoryClickEvent event)
    /*     */ {
        /* 110 */
        if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
            /*     */ {
            /* 112 */
            if (event.getWhoClicked().hasPermission("pss.gui")) {
                try {
                    event.setCancelled(true);
                    /* 113 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTP-All to you"))
                            /*     */ {
                            /* 115 */
                            event.setCancelled(true);
                            /*     */
                            /* 117 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                     for (Player all : Bukkit.getOnlinePlayers()){
                         if (!all.equals(player))
                         all.teleport(player);
                     }
                            /* 120 */

                                /*     */
                                /* 122 */

                                /* 123 */
                                player.updateInventory();
                                /* 124 */       /*  43 */
                                String msg = PSS.prefix + Messages.cfg.getString("tp1");
                                /* 125 */
                                Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));


                                /* 128 */
                            /*     */

                            /*     */
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*     */
            }
            /*     */
        }
        /*     */
    }


    @EventHandler
    public void onnotuse(InventoryClickEvent e) {
        EVENTCrash.updateInventory(e);
    }

    /*     */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick5(InventoryClickEvent event)
    /*     */ {
        try {
            /*     */
            Player player;
            /* 138 */
            if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                Player p = (Player)event.getWhoClicked();



                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1,1);
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /* 140 */
                    event.setCancelled(true);
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
                        /* 141 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cKill-All Online Players")){
                            /*     */ {
                            /* 143 */
                            event.setCancelled(true);
                            /*     */
                            /* 145 */

                            /*     */
                            /* 147 */
                            p.updateInventory();
                            /* 148 */
                            for (Player all : Bukkit.getOnlinePlayers())
                                /*     */ {
                                /* 150 */if (!all.equals(p)){
                                p.updateInventory();
                                /* 151 */
                                all.setHealth(0.0D);
                                /* 152 */
                                all.damage(100.0D);

                                    String msg = PSS.prefix + Messages.cfg.getString("Kill_All");
                                    /* 125 */
                                    Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            }}
                            /*     */
                        }
                        /*     */
                    }}
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*     */
    }
    /*     */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\OnOff\ONOFF3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */