/*    */ package de.bypixels.pss.events;
/*    */ 
/*    */ import de.bypixels.pss.pss.PSS;
/*    */ import org.bukkit.Material;
/*    */
/*    */ import org.bukkit.Sound;
import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;
/*    */
/*    */

/*    */
/*    */ public class InvClickBack2 implements org.bukkit.event.Listener
/*    */ {
    /*    */
/*    */   public InvClickBack2(PSS plugin)
/*    */   {
/* 18 */     /*    */
        /*    */   }
/*    */   
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void onClick(InventoryClickEvent event)
/*    */   {
/* 24 */     if (event.getView().getTitle().equalsIgnoreCase("§bPlayers"))
/*    */     {
    if (event.getWhoClicked().hasPermission("pss.gui")){
/* 26 */       event.setCancelled(true);   if (Objects.requireNonNull(event.getCurrentItem()).hasItemMeta()) {
/* 27 */       if (event.getCurrentItem().getType().equals(Material.IRON_DOOR)) {
/* 28 */         if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBack"))
/*    */         {
/* 30 */           event.setCancelled(true);
/* 31 */           event.getWhoClicked().closeInventory();
/* 32 */           Player player = (Player)event.getWhoClicked();
/* 33 */           ((Player)event.getWhoClicked()).performCommand("gui");


                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1,1);
/*    */         }
/*    */         else
/*    */         {
/* 37 */           event.setCancelled(true);
/* 38 */           Player player = (Player)event.getWhoClicked();
/* 39 */           ((Player)event.getWhoClicked()).performCommand("gui");
/*    */         }
/*    */       }
/*    */     }}
/*    */   }}
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\de.bypixels.de.bypixels.pss.pss.Events\InvClickBack2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */