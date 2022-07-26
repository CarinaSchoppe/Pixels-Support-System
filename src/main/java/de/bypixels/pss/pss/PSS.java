/*     */
package de.bypixels.pss.pss;
/*     */
/*     */

import de.bypixels.pss.CMDevents.EVENTJoin;
import de.bypixels.pss.CMDevents.EVENTPlayers;
import de.bypixels.pss.CMDevents.EVENTchat;
import de.bypixels.pss.CMDevents.EVENTdeath;
import de.bypixels.pss.commands.*;
import de.bypixels.pss.CMDevents.EVENTVanish;
import de.bypixels.pss.gui.StartGUI;
import de.bypixels.pss.onoff.ONOFF2;
import de.bypixels.pss.util.Autoupdater;
import de.bypixels.pss.util.Lag;
import de.bypixels.pss.util.Messages;
import de.bypixels.pss.util.Settings;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/*     */
/*     */ public class PSS extends org.bukkit.plugin.java.JavaPlugin implements Listener
        /*     */ {
    /*     */   public static PSS plugin;
    /*     */
    public static String prefix = Settings.cfg.getString("Prefix");

    /*  29 */   public static final ArrayList<Player> hide = new ArrayList();

    /*  31 */   public static boolean wartung = false;

    /*     */
    public static PSS getPlugin()
    /*     */ {
        /*  88 */
        return plugin;
        /*     */
    }

    /*     */
    /*     */
    public void onEnable() {
        /*  38 */
        plugin = this;


        EVENTPlayers.setCfg();
        Settings.setSettings();
        Messages.setMessages();
        CMDMute.setmutes();
        CMDchest.setbackpack();
        wartung = Settings.cfg.getBoolean("workmode");

        ONOFF2.pvp = Settings.cfg.getBoolean("pvp");

        init();


        new Autoupdater(this).checkUpdate("41971");

        Bukkit.getConsoleSender().sendMessage("§a-> §7[§6PSS§7] §aPixels-Support-System has been enabled!");

    }

    /*     */
    public void init() {
        /*     */
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
        /*  44 */
        PluginManager pm = Bukkit.getPluginManager();
        /*     */
        /*  46 */
        Objects.requireNonNull(getCommand("gui")).setExecutor(new StartGUI(this));
        /*  47 */
        Objects.requireNonNull(getCommand("mute")).setExecutor(new CMDMute(this));
        /*  48 */
        Objects.requireNonNull(getCommand("unmute")).setExecutor(new CMDunmute(this));
        /*  49 */
        Objects.requireNonNull(getCommand("joinmessage")).setExecutor(new CMDJoinMessage(this));
        /*  50 */
        Objects.requireNonNull(getCommand("pss")).setExecutor(new CMDInfo(this));

        Objects.requireNonNull(getCommand("setcmd")).setExecutor(new CMDsetcmd(this));
        /*  51 */
        /*  52 */
        Objects.requireNonNull(getCommand("chest")).setExecutor(new CMDchest(this));
        /*  53 */
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new CMDInvsee(this));

        Objects.requireNonNull(getCommand("config")).setExecutor(new CMDreload(this));
        /*  54 */
        Objects.requireNonNull(getCommand("show")).setExecutor(new CMDshow(this));
        /*  55 */
        Objects.requireNonNull(getCommand("hide")).setExecutor(new CMDshow(this));
        /*  56 */
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new CMDVanish(this));

        Objects.requireNonNull(getCommand("pvp")).setExecutor(new CMDpvp(this));
        /*  57 */
        Objects.requireNonNull(getCommand("lag")).setExecutor(new CMDlag(this));

        Objects.requireNonNull(getCommand("clearlag")).setExecutor(new CMDclearlag(this));

        Objects.requireNonNull(getCommand("maintenance")).setExecutor(new CMDMaintenanceMode(this));
        /*  58 */
        Objects.requireNonNull(getCommand("gm")).setExecutor(new CMDgm(this));
        /*  59 */
        Objects.requireNonNull(getCommand("fly")).setExecutor(new CMDfly(this));
        /*  60 */
        Objects.requireNonNull(getCommand("chat")).setExecutor(new CMDchat(this));
        /*  61 */
        Objects.requireNonNull(getCommand("heal")).setExecutor(new CMDHeal(this));
        /*  62 */
        Objects.requireNonNull(getCommand("build")).setExecutor(new CMDBuild(this));
        /*  63 */
        Objects.requireNonNull(getCommand("godmode")).setExecutor(new CMDgodmode(this));
        /*  64 */
        Objects.requireNonNull(getCommand("players")).setExecutor(new CMDPlayers(this));
        /*     */
        Objects.requireNonNull(getCommand("deathmessage")).setExecutor(new CMDdeathmessage(this));
//
        Objects.requireNonNull(getCommand("msg")).setExecutor(new CMDmsg(this));

        Objects.requireNonNull(getCommand("ping")).setExecutor(new CMDPing(this));


        Objects.requireNonNull(getCommand("socialspy")).setExecutor(new CMDsocialspy(this));

        Objects.requireNonNull(getCommand("settime")).setExecutor(new CMDsettime(this));
        /*  66 */

        pm.registerEvents(new de.bypixels.pss.CMDevents.EVENTInvClose(this), this);
        /*  67 */
        pm.registerEvents(new EVENTPlayers(this), this);
        /*  68 */
        /*  69 */
        pm.registerEvents(new de.bypixels.pss.events.InvClick2(this), this);
        /*  70 */
        pm.registerEvents(new de.bypixels.pss.events.InvClick3(this), this);
        /*  71 */
        pm.registerEvents(new de.bypixels.pss.events.InvClickBack1(this), this);
        /*  72 */
        pm.registerEvents(new de.bypixels.pss.events.InvClickBack2(this), this);
        /*  73 */
        pm.registerEvents(new de.bypixels.pss.events.InvClickWork(this), this);
        /*  74 */
        pm.registerEvents(new EVENTdeath(this), this);

        pm.registerEvents(new EVENTJoin(this), this);
        /*  75 */
        pm.registerEvents(new de.bypixels.pss.onoff.ONOFF1(this), this);
        /*  76 */
        pm.registerEvents(new de.bypixels.pss.onoff.ONOFF2(this), this);
        /*  77 */
        pm.registerEvents(new de.bypixels.pss.onoff.ONOFF3(this), this);
        /*  78 */
        pm.registerEvents(new de.bypixels.pss.CMDevents.EVENTCrash(this), this);
        /*  79 */
        pm.registerEvents(new EVENTchat(this), this);
        /*  80 */
        pm.registerEvents(new EVENTVanish(this), this);
        /*  81 */
        pm.registerEvents(new de.bypixels.pss.CMDevents.EVENTBreak(this), this);
        /*  82 */
        pm.registerEvents(new CMDgodmode(this), this);
        /*  83 */
        pm.registerEvents(this, this);


        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(Settings.file);
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(Messages.file);
        YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(CMDchest.file);
        YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(CMDMute.file);
        YamlConfiguration cfg4 = YamlConfiguration.loadConfiguration(EVENTPlayers.file);

        try {
            cfg.load(Settings.file);
            cfg1.load(Messages.file);
            cfg2.load(CMDMute.file);
            cfg3.load(CMDchest.file);
            cfg4.load(EVENTPlayers.file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        prefix = Settings.cfg.getString("Prefix");
    }
    /*     */

    /*     */
    /*     */
    public void onDisable() {
    /*  92 */
        Bukkit.getConsoleSender().sendMessage("§c-> §7[§6PSS§7] §cPixels-Support-System has been disabled!");
        /*     */


    }
    /*     */

}


/* Location:              C:\Users\Daniel\Downloads\PSS.jar!\PSS\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */