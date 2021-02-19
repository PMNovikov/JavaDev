package ru.geekbrains.course;

import ru.geekbrains.team.Participant;

public class SwimmingPool extends AbstractCourse {
    private int distance;

    public SwimmingPool() {
        this(50);
    }

    public SwimmingPool(int distance) {
        this.distance = distance;
    }

    @Override
    protected void doIt(Participant participant) {
        participant.setPassed(distance <= participant.getMaxSwimmingDistance());
    }

    @Override
    public String toString() {
        return "Swimming Pool{" +
                "distance=" + distance +
                '}';
    }
}
