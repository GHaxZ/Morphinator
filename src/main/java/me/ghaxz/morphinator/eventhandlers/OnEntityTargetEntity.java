package me.ghaxz.morphinator.eventhandlers;

import me.ghaxz.morphinator.Morphinator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class OnEntityTargetEntity implements Listener {
    @EventHandler
    public void OnEntityTargetEntity(EntityTargetLivingEntityEvent event) {
        if(event.getTarget() instanceof Player && Morphinator.getInstance().getMorphedPlayers().containsKey((Player) event.getTarget())) {
            event.setCancelled(true);
        }
    }
}
