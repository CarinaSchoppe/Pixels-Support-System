/*    */ package de.bypixels.pss.commands;
/*    */ 
/*    */ import de.bypixels.pss.pss.PSS;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
import java.util.Objects;
/*    */ import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */
/*    */
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/*    */
/*    */ 
/*    */ public class CMDchest
/*    */   implements CommandExecutor
/*    */ {
    /*    */
/*    */   public CMDchest(PSS plugin)
/*    */   {
/* 26 */     /*    */
        /*    */   }
/*    */   
/* 29 */   public static final File file = new File( "plugins/Pixels-Support-System/backpack.yml");
/* 30 */   public static final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*    */
public static void setbackpack(){
    try {
        cfg.save(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
/*    */   public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args)
/*    */   {
/* 34 */     if (command.getName().equalsIgnoreCase("chest")) {
/* 35 */       if (((sender instanceof Player)) && 
/* 36 */         (Settings.cfg.getBoolean("chest"))) {
/* 37 */         Player p = (Player)sender;
/* 38 */         if (p.hasPermission("pss.chest")) {
/* 39 */          String msg = PSS.prefix+ Messages.cfg.getString("chest1");
/* 40 */           Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/*    */           
/* 42 */           p.getPlayer().openInventory(loadChest(p));
/* 43 */           return true;
/*    */         }
/* 45 */         String msg = PSS.prefix+ Messages.cfg.getString("permissions");
/* 46 */         Objects.requireNonNull(p.getPlayer()).sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/* 47 */         return true;
/*    */       }
/*    */       
/* 50 */           String msg = PSS.prefix+ Messages.cfg.getString("player");
/* 51 */       Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public static void saveChest(Player p, Inventory inv)
/*    */   {
/* 60 */     for (int i = 0; i < 54; i++)
/*    */     {
/* 62 */       ItemStack item = inv.getItem(i);
/* 63 */       cfg.set("Backpack." + p.getUniqueId() + "." + i, item);
/*    */       try
/*    */       {
/* 66 */         cfg.save(file);
/*    */       }
/*    */       catch (IOException e)
/*    */       {
/* 70 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static Inventory loadChest(Player p)
/*    */   {
/* 77 */     Inventory inv = Bukkit.createInventory(null, 54, "§bBackpack");
/* 78 */     for (int i = 0; i < 54; i++)
/*    */     {
/* 80 */       ItemStack item = cfg.getItemStack("Backpack." + p.getUniqueId() + "." + i);
/* 81 */       inv.setItem(i, item);
/*    */     }
/* 83 */     return inv;
/*    */   }
/*    */ }


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\Commands\CMDchest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */