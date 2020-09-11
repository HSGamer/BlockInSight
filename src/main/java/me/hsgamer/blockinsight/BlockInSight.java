package me.hsgamer.blockinsight;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockInSight extends JavaPlugin {

  protected static final Map<UUID, BlockTask> TASK_MAP = new HashMap<>();
  private final MainConfig mainConfig = new MainConfig(this);

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
  }

  @Override
  public void onDisable() {
    HandlerList.unregisterAll(this);
  }

  public MainConfig getMainConfig() {
    return mainConfig;
  }
}
