/*    */
package de.bypixels.pss.CMDevents;
/*    */
/*    */

import de.bypixels.pss.commands.CMDchest;
import de.bypixels.pss.pss.PSS;
import de.bypixels.pss.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

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
/*    */ public class EVENTInvClose
        /*    */ implements Listener
        /*    */ {

    /*    */
    /*    */
    public EVENTInvClose(PSS plugin)
    /*    */ {
        /* 20 */
        /*    */
        /*    */
    }

    /*    */
    /*    */
    @SuppressWarnings("deprecation")
    @EventHandler
    /*    */ public void onClose(InventoryCloseEvent event)
    /*    */ {
        /* 26 */
        if ((event.getPlayer() instanceof Player))
            /*    */ {
            /* 28 */
            Player p = (Player) event.getPlayer();
            /* 29 */
            if (event.getView().getTitle().equalsIgnoreCase("§bBackpack"))
                /*    */ {
                /* 31 */
                String msg = PSS.prefix +Messages.cfg.getString("chest2");
                /* 32 */
                CMDchest.saveChest(p, event.getInventory());
                /* 33 */
                Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                /* 34 */
                /*    */
            }
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTInvClose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */