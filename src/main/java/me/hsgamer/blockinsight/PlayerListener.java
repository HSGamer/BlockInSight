package me.hsgamer.blockinsight;

import static me.hsgamer.blockinsight.BlockInSight.TASK_MAP;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerListener implements Listener {

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
    TASK_MAP.put(player.getUniqueId(), blockTask);
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    TASK_MAP.remove(event.getPlayer().getUniqueId()).cancel();
  }
}
