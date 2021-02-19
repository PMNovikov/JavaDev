package ru.geekbrains.team;

public class Participant {
    private String participantName;
    private int maxRunningDistance;
    private int maxSwimmingDistance;
    private boolean isPassed;

    public Participant(String participantName, int maxRunningDistance, int maxSwimmingDistance) {
        this.participantName = participantName;
        this.maxRunningDistance = maxRunningDistance;
        this.maxSwimmingDistance = maxSwimmingDistance;
        this.isPassed = false;
    }

    public int getMaxRunningDistance() {
        return maxRunningDistance;
    }

    public int getMaxSwimmingDistance() {
        return maxSwimmingDistance;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isPassed() {
        return isPassed;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "Name='" + participantName + '\'' +
                ", maxRunningDistance=" + maxRunningDistance +
                ", maxSwimmingDistance=" + maxSwimmingDistance +
                '}';
    }
}
