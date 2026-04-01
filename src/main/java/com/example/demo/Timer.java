package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Timer {

    private long startTime;
    private long elapsedTime;
    private boolean running;
    private List<Long> lapTimes;

    public Timer() {
        this.running = false;
        this.elapsedTime = 0;
        this.lapTimes = new ArrayList<>();
    }

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime;
            running = true;
        }
    }

    public void stop() {
        if (running) {
            elapsedTime = System.currentTimeMillis() - startTime;
            running = false;
        }
    }

    public void reset() {
        elapsedTime = 0;
        running = false;
        lapTimes.clear();
    }

    public long getElapsedTime() {
        return running ? System.currentTimeMillis() - startTime : elapsedTime;
    }

    public void addLap() {
        lapTimes.add(getElapsedTime());
    }

    public void deleteLap(int index) {
        if (index >= 0 && index < lapTimes.size()) {
            lapTimes.remove(index);
        }
    }

    public List<Long> getLapTimes() {
        return lapTimes;
    }
}
