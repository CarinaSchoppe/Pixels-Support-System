/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Collections;
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
/*    */
/*    */

/*    */
/*    */ public class EVENTCrash implements Listener
        /*    */ {

    /*    */
    /*    */
    public EVENTCrash(PSS plugin)
    /*    */ {
        /* 28 */
        /*    */
        /*    */
    }

    /*    */    @EventHandler
    public void onNotUse(InventoryClickEvent e) {
        updateInventory(e);
    }

    @SuppressWarnings("deprecation")
    public static void updateInventory(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("bPlayers")) {
            if (p.hasPermission("pss.gui")) {
                e.setCancelled(true);

                if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.WHITE_STAINED_GLASS_PANE)) {
                    e.setCancelled(true);
                    p.updateInventory();
                }
            }
        }
    }

    /*    */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*    */ public void onClick(InventoryClickEvent event)
    /*    */ {
        /* 34 */
        if (Objects.requireNonNull(event.getView().getTitle()).equals("§bServer"))
            /*    */ {
            /* 36 */if (event.getWhoClicked().hasPermission("pss.gui")){
            event.setCancelled(true);
            /* 37 */
            if (Objects.requireNonNull(event.getCurrentItem()).getItemMeta().getDisplayName().equalsIgnoreCase("§cCrash all Players!"))
                /*    */ {
                /* 39 */
                for (Player all : Bukkit.getOnlinePlayers()) {
                    /* 43 */
                    if (!all.equals(event.getWhoClicked())) {
                        all.setHealth(99999999999999999.0D);
                        /* 44 */
                        String msg = PSS.prefix + Messages.cfg.getString("crash3");
                        /* 45 */
                        Player p = (Player) event.getWhoClicked();
                        /* 46 */
                        Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                        /* 47 */
                        return;
                        /*    */
                    }
                    /*   [ */
                }
            }

            /*   } */}
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTCrash.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */