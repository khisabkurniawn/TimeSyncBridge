package com.arknesia.timesyncbridge;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.nio.ByteBuffer;

public class TimeListener implements PluginMessageListener {
    private final TimeSyncBridge plugin;

    public TimeListener(TimeSyncBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPluginMessageReceived(String channel, org.bukkit.entity.Player player, byte[] message) {
        if (!channel.equals("timesync:time")) {
            return;
        }

        ByteBuffer buffer = ByteBuffer.wrap(message);
        long ticks = buffer.getLong();

        plugin.getTimeManager().updateTime(ticks);

        for (World world : Bukkit.getWorlds()) {
            world.setTime(ticks);
        }
    }
}