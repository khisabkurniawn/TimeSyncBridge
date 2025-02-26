package com.arknesia.timesyncbridge;

public class TimeManager {
    private long currentTicks;
    private String currentDate;

    public TimeManager() {
        this.currentTicks = 0;
        this.currentDate = "Day 1, Month 1, Year 1";
    }

    public void updateTime(long ticks, String date) {
        this.currentTicks = ticks;
        this.currentDate = date;
    }

    public long getCurrentTicks() {
        return currentTicks;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getCurrentTime() {
        int hours = (int) (((currentTicks / 1000) + 6) % 24);
        int minutes = (int) ((currentTicks % 1000) * 60 / 1000);
        return String.format("%02d:%02d", hours, minutes);
    }

    public int getCurrentDay() {
        String[] parts = currentDate.split(", ");
        return Integer.parseInt(parts[0].split(" ")[1]);
    }

    public int getCurrentMonth() {
        String[] parts = currentDate.split(", ");
        return Integer.parseInt(parts[1].split(" ")[1]);
    }

    public int getCurrentYear() {
        String[] parts = currentDate.split(", ");
        return Integer.parseInt(parts[2].split(" ")[1]);
    }
}