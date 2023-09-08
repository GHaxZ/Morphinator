package me.ghaxz.morphinator.commands;

import me.ghaxz.morphinator.Morphinator;
import me.ghaxz.morphinator.items.MorphinatorItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MorphinatorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.getInventory().addItem(MorphinatorItem.create());
        }

        return true;
    }
}
