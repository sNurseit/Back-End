package com.example.soccer;

public class MatchTable {
    private Long id;

    private String team;
    private int played;
    private int won;
    private int draw;
    private int lost;
    private int scored;
    private int missed;
    private int points;

    public MatchTable(){
        this.played = 0;
        this.won = 0;
        this.draw = 0;
        this.lost = 0;
        this.scored = 0;
        this.missed = 0;
        this.points = 0;
    }

    public MatchTable(Long id,  String team, int played, int won, int draw, int lost, int scored, int missed, int points) {
        this.id = id;
        this.team = team;
        this.played = played;
        this.won = won;
        this.draw = draw;
        this.lost = lost;
        this.scored = scored;
        this.missed = missed;
        this.points = points;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public int getMissed() {
        return missed;
    }

    public void setMissed(int missed) {
        this.missed = missed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}

