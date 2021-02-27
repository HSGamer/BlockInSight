package me.hsgamer.blockinsight;

import me.hsgamer.hscore.bukkit.baseplugin.BasePlugin;

public final class BlockInSight extends BasePlugin {

    private final MainConfig mainConfig = new MainConfig(this);

    @Override
    public void load() {
        mainConfig.setup();
    }

    @Override
    public void enable() {
        registerListener(new PlayerListener(this));
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }
}
