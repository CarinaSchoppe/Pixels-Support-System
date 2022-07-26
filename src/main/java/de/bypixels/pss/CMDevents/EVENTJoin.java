/*    */ package de.bypixels.pss.CMDevents;
/*    */ 
/*    */ import de.bypixels.pss.commands.CMDJoinMessage;
/*    */
import de.bypixels.pss.pss.PSS;
/*    */
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ 
/*    */ public class EVENTJoin
/*    */   implements Listener
/*    */ {
    /*    */
/*    */   public EVENTJoin(PSS plugin)
/*    */   {
/* 20 */     /*    */
        /*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent event)
/*    */   {
/* 26 */     Player p = event.getPlayer();
/* 27 */     if (!CMDJoinMessage.joinp.contains(CMDJoinMessage.MSG))
/*    */     {
/* 29 */       event.joinMessage(null);
/*    */       
/* 31 */
        /*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void onJoin(PlayerQuitEvent event)
/*    */   {
/* 40 */     Player p = event.getPlayer();
/* 41 */     if (!CMDJoinMessage.joinp.contains(CMDJoinMessage.MSG))
/*    */     {
/* 43 */       event.quitMessage(null);
/*    */       
/* 45 */
        /*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\CMDEvents\EVENTJoin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */