package me.ghaxz.morphinator.eventhandlers;

import me.ghaxz.morphinator.Morphinator;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class OnPlayerSneak implements Listener {
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();

        if(Morphinator.getInstance().getMorphedPlayers().containsKey(player)) {
            LivingEntity entity = Morphinator.getInstance().getMorphedPlayers().get(player);

            player.setInvisible(false);
            player.setCollidable(true);
            entity.setCollidable(true);
            entity.setAI(true);

            Morphinator.getInstance().getMorphedPlayers().remove(player);
        }

    }
}
