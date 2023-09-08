package me.ghaxz.morphinator.eventhandlers;

import me.ghaxz.morphinator.Morphinator;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class OnEntityExplode implements Listener {
    @EventHandler
    public void OnEntityExplode(EntityExplodeEvent event) {
        LivingEntity entity = (LivingEntity) event.getEntity();

        if(Morphinator.getInstance().getMorphedPlayers().containsValue(entity)) {
            event.setCancelled(true);
        }
    }
}
