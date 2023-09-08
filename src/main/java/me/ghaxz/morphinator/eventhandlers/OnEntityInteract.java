package me.ghaxz.morphinator.eventhandlers;

import me.ghaxz.morphinator.Morphinator;
import me.ghaxz.morphinator.items.MorphinatorItem;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class OnEntityInteract implements Listener {
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        LivingEntity entity = (LivingEntity) event.getRightClicked();

        if(player.getItemInHand().isSimilar(MorphinatorItem.create()) && entity instanceof Mob) {
            Morphinator.getInstance().getMorphedPlayers().put(player, entity);

            player.setInvisible(true);
            player.setCollidable(false);
            entity.setCollidable(false);
            entity.setAI(false);


            player.teleport(entity);
        }
    }
}
