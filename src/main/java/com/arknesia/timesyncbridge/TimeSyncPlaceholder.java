package com.arknesia.timesyncbridge;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class TimeSyncPlaceholder extends PlaceholderExpansion {
    private final TimeSyncBridge plugin;

    public TimeSyncPlaceholder(TimeSyncBridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "timesync";
    }

    @Override
    public String getAuthor() {
        return "Lexivale";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        long ticks = plugin.getTimeManager().getCurrentTicks();
        String date = plugin.getTimeManager().getCurrentDate();
        int day = plugin.getTimeManager().getCurrentDay();
        int month = plugin.getTimeManager().getCurrentMonth();
        int year = plugin.getTimeManager().getCurrentYear();

        switch (identifier.toLowerCase()) {
            case "time_24h":
                return plugin.getTimeManager().getCurrentTime();
            case "time_12h":
                return get12HourTime(ticks);
            case "time_ampm":
                return getAMPM(ticks);
            case "date":
                return String.valueOf(day);
            case "date_ordinal":
                return getOrdinalNumber(day);
            case "day_of_year":
                return String.valueOf((month - 1) * 30 + day);
            case "month":
                return String.valueOf(month);
            case "season":
                return getSeason(month);
            case "year":
                return String.valueOf(year);
            case "dayparts":
                return getDayPartSymbol(ticks);
            default:
                return null;
        }
    }

    private String get12HourTime(long ticks) {
        int hours = (int) (((ticks / 1000) + 6) % 24);
        int minutes = (int) ((ticks % 1000) * 60 / 1000);
        String period = (hours >= 12) ? "PM" : "AM";
        if (hours > 12) hours -= 12;
        if (hours == 0) hours = 12;
        return String.format("%02d:%02d %s", hours, minutes, period);
    }

    private String getAMPM(long ticks) {
        int hours = (int) (((ticks / 1000) + 6) % 24);
        return (hours >= 12) ? "PM" : "AM";
    }

    private String getOrdinalNumber(int day) {
        if (day >= 11 && day <= 13) return day + "th";
        switch (day % 10) {
            case 1: return day + "st";
            case 2: return day + "nd";
            case 3: return day + "rd";
            default: return day + "th";
        }
    }

    private String getSeason(int month) {
        switch (month) {
            case 1: return "Mid Winter";
            case 2: return "Late Winter";
            case 3: return "Early Spring";
            case 4: return "Mid Spring";
            case 5: return "Late Spring";
            case 6: return "Early Summer";
            case 7: return "Mid Summer";
            case 8: return "Late Summer";
            case 9: return "Early Autumn";
            case 10: return "Mid Autumn";
            case 11: return "Late Autumn";
            case 12: return "Early Winter";
            default: return "Unknown";
        }
    }

    private String getDayPartSymbol(long ticks) {
        if (ticks < 1000) return "ᜥ";
        if (ticks < 12000) return "ᜦ";
        if (ticks < 13000) return "ᜧ";
        return "ᜨ";
    }
}