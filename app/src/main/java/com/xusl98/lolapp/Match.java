package com.xusl98.lolapp;

public class Match {

    private int champId;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int summoner1;
    private int summoner2;
    private int kills;
    private int deaths;
    private int assists;
    private int queue;
    private boolean matchResult;

    public Match(int champId, int item1, int item2, int item3, int item4, int item5, int item6, int summoner1, int summoner2, int kills, int deaths, int assists, boolean matchResult, int queue) {
        this.champId = champId;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.summoner1 = summoner1;
        this.summoner2 = summoner2;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.matchResult = matchResult;
        this.queue = queue;
    }

    public int getQueue() {
        return queue;
    }

    public int getChampId() {
        return champId;
    }

    public int getItem1() {
        return item1;
    }

    public int getItem2() {
        return item2;
    }

    public int getItem3() {
        return item3;
    }

    public int getItem4() {
        return item4;
    }

    public int getItem5() {
        return item5;
    }

    public int getItem6() {
        return item6;
    }

    public int getSummoner1() {
        return summoner1;
    }

    public int getSummoner2() {
        return summoner2;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public boolean getMatchResult() {
        return matchResult;
    }
}
