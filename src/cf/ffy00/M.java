/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */

package cf.ffy00;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class M extends JavaPlugin implements Listener{
  PluginDescriptionFile pl;
  
  @Override
  public void onEnable(){
    this.pl = getDescription();
    Bukkit.getConsoleSender().sendMessage("§bAtivando " + this.pl.getName() + " v" + this.pl.getVersion() + " por FFY00!");
    getServer().getPluginManager().registerEvents(this, this);
  }
  
  @Override
  public void onDisable(){
    Bukkit.getConsoleSender().sendMessage("§bDesativando " + this.pl.getName() + " v" + this.pl.getVersion() + " por FFY00!");
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void dano(EntityDamageEvent e){
    if ((e.getCause() == EntityDamageEvent.DamageCause.VOID) && ((e.getEntity() instanceof Player))){
      e.setCancelled(true);
      Player p = (Player)e.getEntity();
      p.teleport(p.getWorld().getSpawnLocation());
    }
  }
}
