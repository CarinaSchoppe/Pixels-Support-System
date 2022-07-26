package de.bypixels.pss.CMDevents;
// Made by PixelsDE 
// Project: PSS
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 02.02.2018
// Package: de.bypixels.pss.CMDevents
// Created by: Daniel

import de.bypixels.pss.commands.CMDdeathmessage;
import de.bypixels.pss.pss.PSS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EVENTdeath implements Listener{
    /*    */
    /*    */   public EVENTdeath(PSS plugin)
    /*    */   {
        /* 28 */     /*    */
        /*    */   }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        if (!CMDdeathmessage.deathmessage){
            e.deathMessage(null);
        }else{
            if (CMDdeathmessage.deathmessage){

            }
        }
    }


}
