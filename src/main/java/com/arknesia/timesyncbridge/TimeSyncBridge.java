package com.arknesia.timesyncbridge;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TimeSyncBridge extends JavaPlugin {
    private TimeManager timeManager;

    @Override
    public void onEnable() {
        this.timeManager = new TimeManager();

        Bukkit.getMessenger().registerIncomingPluginChannel(this, "timesync:time", new TimeListener(this));

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new TimeSyncPlaceholder(this).register();
            getLogger().info("PlaceholderAPI support enabled!");
        }

        getLogger().info("TimeSyncBridge has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TimeSyncBridge has been disabled!");
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }
}
