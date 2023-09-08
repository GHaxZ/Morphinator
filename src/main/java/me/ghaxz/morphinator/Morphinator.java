package me.ghaxz.morphinator;

import me.ghaxz.morphinator.commands.MorphinatorCommand;
import me.ghaxz.morphinator.eventhandlers.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Morphinator extends JavaPlugin {
    private static Morphinator instance;
    private HashMap<Player, LivingEntity> morphedPlayers;

    @Override
    public void onEnable() {
        instance = this;
        morphedPlayers = new HashMap<>();

        getCommand("morphinator").setExecutor(new MorphinatorCommand());
        getServer().getPluginManager().registerEvents(new OnEntityInteract(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerMove(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerSneak(), this);
        getServer().getPluginManager().registerEvents(new OnEntityDamage(), this);
        getServer().getPluginManager().registerEvents(new OnEntityTargetEntity(), this);
        getServer().getPluginManager().registerEvents(new OnEntityExplode(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<Player, LivingEntity> getMorphedPlayers() {
        return morphedPlayers;
    }

    public static Morphinator getInstance() {
        return instance;
    }
}
