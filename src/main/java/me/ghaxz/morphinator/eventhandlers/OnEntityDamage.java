package me.ghaxz.morphinator.eventhandlers;

import me.ghaxz.morphinator.Morphinator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import java.util.Map.Entry;

public class OnEntityDamage implements Listener {

    @EventHandler
    public void OnEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        if(event.getDamager() instanceof Player) {
            Player player = (Player) damager;
            LivingEntity entity = (LivingEntity) event.getEntity();

            if(Morphinator.getInstance().getMorphedPlayers().containsKey(player)) {
                if(Morphinator.getInstance().getMorphedPlayers().get(player).equals(entity)) {
                    event.setCancelled(true);
                    return;
                }
            }

            if(Morphinator.getInstance().getMorphedPlayers().containsValue((LivingEntity) event.getEntity())) {
                for(Entry<Player, LivingEntity> entry : Morphinator.getInstance().getMorphedPlayers().entrySet()) {
                    if(entry.getValue().equals(entity)) {
                        Player morphedPlayer = entry.getKey();

                        morphedPlayer.setInvisible(false);
                        morphedPlayer.setCollidable(true);
                        entity.setCollidable(true);
                        entity.setAI(true);

                        Morphinator.getInstance().getMorphedPlayers().remove(morphedPlayer);
                    }
                }
            }
        }

        if(damager instanceof Creeper && Morphinator.getInstance().getMorphedPlayers().containsValue(damager)) {
            event.setCancelled(true);
        }
    }
}
