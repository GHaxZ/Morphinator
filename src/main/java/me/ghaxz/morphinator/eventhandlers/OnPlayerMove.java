package me.ghaxz.morphinator.eventhandlers;

import me.ghaxz.morphinator.Morphinator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMove implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if(Morphinator.getInstance().getMorphedPlayers().containsKey(player)) {
            Morphinator.getInstance().getMorphedPlayers().get(player).teleport(player);
        }
    }
}
