package me.hsgamer.blockinsight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerListener implements Listener {
    private final Map<UUID, BlockTask> taskMap = new HashMap<>();

    private final JavaPlugin plugin;

    public PlayerListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        BlockTask blockTask = new BlockTask(player);
        int period = MainConfig.PERIOD.getValue();
        blockTask.runTaskTimer(plugin, period, period);
        taskMap.put(player.getUniqueId(), blockTask);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        taskMap.remove(event.getPlayer().getUniqueId()).cancel();
    }
}
