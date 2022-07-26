/*    */ package de.bypixels.pss.CMDevents;
/*    */ 
/*    */ import de.bypixels.pss.commands.CMDVanish;
/*    */ import de.bypixels.pss.pss.PSS;
/*    */
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EVENTVanish
/*    */   implements Listener
/*    */ {
    /*    */
/*    */   public EVENTVanish(PSS plugin)
/*    */   {
/* 21 */     /*    */
        /*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent event) {
/* 26 */     Player p = event.getPlayer();
/* 27 */     for (Player players : Bukkit.getOnlinePlayers()) {
/* 28 */       if (CMDVanish.vanishList.contains(players))
/*    */       {
/* 30 */
/* 31 */         p.hidePlayer(PSS.getPlugin(),players);
/*    */       }
/*    */       else
/*    */       {
/* 35 */
/* 36 */         p.showPlayer(PSS.getPlugin(),players);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\de.bypixels.de.bypixels.pss.pss.Events\EVENTVanish.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */