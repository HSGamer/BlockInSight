package me.hsgamer.blockinsight;

import me.hsgamer.hscore.bukkit.config.AdvancedConfigPath;
import me.hsgamer.hscore.bukkit.config.Paths;
import me.hsgamer.hscore.bukkit.config.PluginConfig;
import me.hsgamer.hscore.bukkit.config.path.IntegerConfigPath;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class MainConfig extends PluginConfig {

  public static final AdvancedConfigPath<String, Material> MATERIAL = new AdvancedConfigPath<String, Material>(
      "material", Material.BEDROCK) {
    @Override
    public String getFromConfig(PluginConfig pluginConfig) {
      return pluginConfig.getConfig().getString(getPath());
    }

    @Override
    public Material convert(String rawValue) {
      try {
        return Material.valueOf(rawValue);
      } catch (Exception e) {
        return null;
      }
    }

    @Override
    public String convertToRaw(Material value) {
      return value.name();
    }
  };
  public static final IntegerConfigPath PERIOD = Paths.integerPath("period", 0);

  public MainConfig(JavaPlugin plugin) {
    super(plugin, "config.yml");
    getConfig().options().copyDefaults(true);
    setDefaultConfig();
    saveConfig();
  }

  private void setDefaultConfig() {
    MATERIAL.setConfig(this);
    PERIOD.setConfig(this);
  }
}
