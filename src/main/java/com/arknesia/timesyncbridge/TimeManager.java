package com.arknesia.timesyncbridge;

import java.util.Calendar;

public class TimeManager {
    private long currentTicks;

    public TimeManager() {
        this.currentTicks = 0;
    }

    public void updateTime(long ticks) {
        this.currentTicks = ticks;
    }

    public long getCurrentTicks() {
        return currentTicks;
    }

    public String getCurrentTime() {
        int hours = (int) (((currentTicks / 1000) + 6) % 24);
        int minutes = (int) ((currentTicks % 1000) * 60 / 1000);
        return String.format("%02d:%02d", hours, minutes);
    }

    public Calendar getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, Calendar.JANUARY, 1);
        long daysPassed = currentTicks / 24000;
        calendar.add(Calendar.DAY_OF_YEAR, (int) daysPassed);
        return calendar;
    }
}