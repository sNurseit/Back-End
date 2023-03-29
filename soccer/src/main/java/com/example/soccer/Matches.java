package com.example.soccer;


public class Matches {
    private Long id;
    private Long home_team_id;
    private Long away_team_id;
    private int home_team_goals;
    private int away_team_goals;

    public Matches(){
    }

    public Matches(Long home_team_id, Long away_team_id, int home_team_goals, int away_team_goals) {
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
        this.home_team_goals = home_team_goals;
        this.away_team_goals = away_team_goals;
    }

    public Matches(Long id, Long home_team_id, Long away_team_id, int home_team_goals, int away_team_goals) {
        this.id = id;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
        this.home_team_goals = home_team_goals;
        this.away_team_goals = away_team_goals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(Long home_team_id) {
        this.home_team_id = home_team_id;
    }

    public Long getAway_team_id() {
        return away_team_id;
    }

    public void setAway_team_id(Long away_team_id) {
        this.away_team_id = away_team_id;
    }

    public int getHome_team_goals() {
        return home_team_goals;
    }

    public void setHome_team_goals(int home_team_goals) {
        this.home_team_goals = home_team_goals;
    }

    public int getAway_team_goals() {
        return away_team_goals;
    }

    public void setAway_team_goals(int away_team_goals) {
        this.away_team_goals = away_team_goals;
    }
}

