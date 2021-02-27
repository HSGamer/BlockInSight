package me.hsgamer.blockinsight;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockTask extends BukkitRunnable {

    private final Player player;
    private Location lastBlockLocation;

    public BlockTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        Block block = player.getTargetBlock(null, Math.min(100, MainConfig.MAX_DISTANCE.getValue()));
        if (block.getType().equals(Material.AIR)) {
            return;
        }

        Location location = block.getLocation();
        if (lastBlockLocation == null) {
            lastBlockLocation = location;
            return;
        }

        if (location.equals(lastBlockLocation)) {
            return;
        }

        lastBlockLocation.getBlock().setType(MainConfig.MATERIAL.getValue());
        lastBlockLocation = location;
    }
}
