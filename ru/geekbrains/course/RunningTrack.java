package ru.geekbrains.course;

import ru.geekbrains.team.Participant;

public class RunningTrack extends AbstractCourse {
    private int distance;

    public RunningTrack() {
        this(200);
    }

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    protected void doIt(Participant participant) {
        participant.setPassed(distance <= participant.getMaxRunningDistance());
    }

    @Override
    public String toString() {
        return "Running Track{" +
                "distance=" + distance +
                '}';
    }
}
