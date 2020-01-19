package com.oleg.trello.model;

public class TeamData {
    private  String teamName;
    private  String teamDescr;

//    public TeamData(String teamName, String teamDescr) {
//        this.teamName = teamName;
//        this.teamDescr = teamDescr;
//    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDescr() {
        return teamDescr;
    }

    public TeamData withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamData withTeamDescr(String teamDescr) {
        this.teamDescr = teamDescr;
        return this;
    }
}
