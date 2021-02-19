package ru.geekbrains.course;

import ru.geekbrains.team.Participant;
import ru.geekbrains.team.Team;

public abstract class AbstractCourse implements Course{

    @Override
    public void doIt(Team team) {
        for (Participant participant: team.getParticipants()){
            doIt(participant);
        }
    }

    protected abstract void doIt(Participant participant);
}
