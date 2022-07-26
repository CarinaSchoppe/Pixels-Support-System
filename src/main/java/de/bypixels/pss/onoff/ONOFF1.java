package de.bypixels.pss.onoff;


import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Iterator;
import java.util.Objects;


/*     */ public class ONOFF1 implements org.bukkit.event.Listener
        /*     */ {

    /*     */
    /*     */
    public ONOFF1(PSS plugin)
    /*     */ {
        /*  22 */
        /*     */
        /*  25 */
        /*     */
        /*     */
    }

    /*     */
    /*     */
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onnotuse(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("bPlayers")) {
            if (p.hasPermission("pss.gui")) {
                e.setCancelled(true);
                p.updateInventory();
                if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.WHITE_STAINED_GLASS_PANE)) {
                    e.setCancelled(true);
                    p.updateInventory();
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick(InventoryClickEvent event)
        /*     */ {
        try {
            /*  30 */
            if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  32 */
                    event.setCancelled(true);
                    /*  33 */                    /* 124 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {

                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGamemode On"))
                            /*     */ {
                            /*  35 */
                            event.setCancelled(true);
                            /*  36 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /*  38 */
                            event.getWhoClicked().setGameMode(org.bukkit.GameMode.CREATIVE);
                            /*  39 */
                            player.updateInventory();
                            /*     */
                            /*  41 */
                            String msg = PSS.prefix + Messages.cfg.getString("gamemode1");
                            /*     */
                            /*  43 */
                            Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /*  45 */
                            return;
                            /*     */
                        }
                        /*  47 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGamemode Off"))
                            /*     */ {
                            /*  49 */
                            event.setCancelled(true);
                            /*  50 */
                            Player player = (Player) event.getWhoClicked();
                            /*     */
                            /*  52 */
                            player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                            /*  53 */
                            player.updateInventory();
                            /*  54 */
                            String msg = PSS.prefix + Messages.cfg.getString("gamemode2");
                            /*  55 */
                            Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /*  57 */
                            /*     */
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

    /*     */
    /*     */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick2(InventoryClickEvent event)
    /*     */ {
        try {
            /*  65 */
            if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  67 */
                    event.setCancelled(true);
                    Player player = (Player)event.getWhoClicked();

                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1,1);
                    /*  68 */                    /* 124 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {

                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFly On"))
                            /*     */ {
                            /*  70 */
                            event.setCancelled(true);
                            /*  71 */

                            /*  72 */
                            ((Player) event.getWhoClicked()).setAllowFlight(true);
                            /*  73 */
                            ((Player) event.getWhoClicked()).setFlying(true);
                            /*  74 */
                            player.updateInventory();
                            /*  75 */
                            String msg = PSS.prefix + Messages.cfg.getString("fly1");
                            /*  76 */
                            Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*  77 */
                            return;
                            /*     */
                        }
                        /*  79 */
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cFly Off"))
                            /*     */ {
                            /*  81 */
                            event.setCancelled(true);
                            /*  82 */

                            /*  83 */
                            ((Player) event.getWhoClicked()).setAllowFlight(false);
                            /*  84 */
                            ((Player) event.getWhoClicked()).setFlying(false);
                            /*  85 */
                            player.updateInventory();
                            /*  86 */
                            String msg = PSS.prefix + Messages.cfg.getString("fly2");
                            /*  87 */
                            Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*  88 */
                            /*     */
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

    /*     */
    /*     */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick3(InventoryClickEvent event)
    /*     */ {
        /*  96 */
        try {
            if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /*  98 */
                    event.setCancelled(true);
                    /*     */
                    /* 100 */                    /* 124 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {

                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVanish On"))
                            /*     */ {
                            /* 102 */
                            Iterator localIterator = Bukkit.getServer().getOnlinePlayers().iterator();
                            /* 103 */
                            if (localIterator.hasNext())
                                /*     */ {
                                /* 105 */
                                Player players = (Player) localIterator.next();
                                /*     */
                                /* 107 */
                                event.setCancelled(true);
                                /* 108 */
                                Player player = (Player) event.getWhoClicked();
                                /*     */
                                /* 110 */

                                /*     */
                                /* 112 */
                                PSS.hide.add(player);
                                /*     */
                                /* 114 */
                                player.showPlayer(PSS.getPlugin(), players);
                                /* 115 */
                                players.showPlayer(PSS.getPlugin(),player);
                                /* 116 */
                                ((Player) event.getWhoClicked()).hidePlayer(PSS.getPlugin(), players);
                                /* 117 */
                                player.updateInventory();
                                /* 118 */
                                String msg = PSS.prefix + Messages.cfg.getString("vanish1");
                                /* 119 */
                                Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                            }
                            /*     */
                            /*     */
                            /*     */
                        } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVanish Off"))
                            /*     */ {
                            /* 126 */
                            Iterator localIterator = Bukkit.getServer().getOnlinePlayers().iterator();
                            /* 127 */
                            if (localIterator.hasNext())
                                /*     */ {
                                /* 129 */
                                Player players = (Player) localIterator.next();
                                /* 130 */
                                event.setCancelled(true);
                                /* 131 */
                                Player player = (Player) event.getWhoClicked();
                                /* 132 */
                                player.updateInventory();
                                /* 133 */
                                players.showPlayer(PSS.getPlugin(), player);
                                /* 134 */
                                String msg = PSS.prefix + Messages.cfg.getString("vanish2");
                                /* 135 */
                                Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                                /*     */
                                /* 137 */

                                /* 138 */
                                player.showPlayer(PSS.getPlugin(), players);
                                /* 139 */
                                players.showPlayer(PSS.getPlugin(), player);
                                /*     */
                                /* 141 */
                                /*     */
                            }
                            /*     */
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


    /*     */
    /*     */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick9(InventoryClickEvent event)
    /*     */ {
        try {
            /* 172 */
            if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /* 174 */
                    event.setCancelled(true);
                    /* 175 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHeal Yourself"))
                            /*     */ {
                            /* 177 */
                            Player player = (Player) event.getWhoClicked();
                            /* 178 */
                            player.updateInventory();
                            /* 179 */
                            String msg = PSS.prefix + Messages.cfg.getString("heal1");
                            /* 180 */
                            Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                            /*     */
                            /* 182 */
                            player.setHealth(20.0D);
                            /*     */
                            /* 184 */
                            player.setFoodLevel(20);
                            /* 185 */
                            event.setCancelled(true);
                            /*     */
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

    /*     */
    /*     */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*     */ public void onClick10(InventoryClickEvent event)
    /*     */ {
        try {
            /* 193 */
            if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
                /*     */ {
                if (event.getWhoClicked().hasPermission("pss.gui")) {
                    /* 195 */
                    event.setCancelled(true);
                    /* 196 */
                    if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHeal All"))
                            /*     */ {
                            /* 198 */
                            Player player = (Player) event.getWhoClicked();
                            /* 199 */
                            Iterator localIterator = Bukkit.getOnlinePlayers().iterator();
                            /* 200 */
                            if (localIterator.hasNext())
                                /*     */ {
                                /* 202 */
                                Player all = (Player) localIterator.next();
                                /* 203 */
                                all.setHealth(20.0D);
                                /* 204 */
                                player.updateInventory();
                                /* 205 */
                                String msg1 = PSS.prefix + Objects.requireNonNull(Messages.cfg.getString("heal2")).replace("%player%", player.getName());
                                /* 206 */
                                String msg3 = PSS.prefix + Messages.cfg.getString("heal3");
                                /* 207 */
                                Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg3));
                                /* 208 */
                                Objects.requireNonNull(all.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg1));
                                /*     */
                                /* 210 */
                                event.setCancelled(true);
                                /* 211 */
                                /*     */
                            }
                            /*     */
                        }
                    }
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


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\OnOff\ONOFF1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */