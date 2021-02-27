package me.hsgamer.blockinsight;

import me.hsgamer.hscore.bukkit.config.BukkitConfig;
import me.hsgamer.hscore.config.AdvancedConfigPath;
import me.hsgamer.hscore.config.Config;
import me.hsgamer.hscore.config.PathableConfig;
import me.hsgamer.hscore.config.path.IntegerConfigPath;
import me.hsgamer.hscore.config.path.Paths;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

public class MainConfig extends PathableConfig {

    public static final AdvancedConfigPath<String, Material> MATERIAL = new AdvancedConfigPath<String, Material>("material", Material.BEDROCK) {
        @Override
        public String getFromConfig(Config config) {
            return config.getInstance(getPath(), String.class);
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
    public static final IntegerConfigPath MAX_DISTANCE = Paths.integerPath("max-distance", 50);

    public MainConfig(Plugin plugin) {
        super(new BukkitConfig(plugin, "config.yml"));
    }
}
