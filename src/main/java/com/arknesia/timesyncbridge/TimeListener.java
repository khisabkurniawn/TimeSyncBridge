package com.arknesia.timesyncbridge;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

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
        String date = readString(buffer);

        for (World world : Bukkit.getWorlds()) {
            world.setTime(ticks);
        }

        plugin.getTimeManager().updateTime(ticks, date);
    }

    private String readString(ByteBuffer buffer) {
        int length = buffer.getShort();
        byte[] bytes = new byte[length];
        buffer.get(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}