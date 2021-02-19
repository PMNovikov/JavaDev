package ru.geekbrains;

import ru.geekbrains.course.Course;
import ru.geekbrains.course.RunningTrack;
import ru.geekbrains.course.SwimmingPool;
import ru.geekbrains.team.Participant;
import ru.geekbrains.team.Team;

public class Main {

    public static void main(String[] args) {
        Course[] courses = {new SwimmingPool(), new RunningTrack()};
        Team team = new Team(
                "JAVA SUN",
                new Participant("Nikolaj", 500, 30),
                new Participant("Roman", 250,100),
                new Participant("Oleg",75,75),
                new Participant("Vladimir", 100, 0));
        System.out.println(team.getTeamInfo());

        for(Course course : courses){
            System.out.println("Course: " + course);
            course.doIt(team);
            team.showResult();
        }
    }
}
