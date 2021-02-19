package ru.geekbrains.team;

public class Team {
    private String teamName;
    private Participant[] participants;

    public Team(String teamName, Participant... participants){
        this.teamName = teamName;
        this.participants = participants;
    }

    public String getTeamInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Team name: ");
        sb.append(teamName);
        sb.append("\n");

        for (Participant participant : participants){
            sb.append('\t');
            sb.append(participant);
            sb.append('\n');
        }
        return sb.toString();
    }

    public void showTeamInfo(){
        System.out.println(getTeamInfo());
    }

    public String getPassedTeamInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Passed information:\n");
        sb.append("Team name: ");
        sb.append(teamName);
        sb.append("\n");

        boolean isNotPassedParticipant = true;
        for (Participant participant : participants){
            if (participant.isPassed()){
                sb.append('\t');
                sb.append(participant);
                sb.append('\n');
                isNotPassedParticipant = false;
            }
        }
        if (isNotPassedParticipant){
            sb.append("\tNobody went the distance.");
        }
        return sb.toString();
    }

    public void showResult(){
        System.out.println(getPassedTeamInfo());
    }

    public Participant[] getParticipants() {
        return participants;
    }
}
