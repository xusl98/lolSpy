package com.xusl98.lolapp;

public class Participant {

    private String summonerName;
    private int sum1;
    private int sum2;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int champId;
    private int teamId;
    private String rank;
    private int kills;
    private int deaths;
    private int assists;

    public Participant(String summonerName, int sum1, int sum2, int item1, int item2, int item3, int item4, int item5, int item6, int champId, int teamId, String rank, int kills, int deaths, int assists) {
        this.summonerName = summonerName;
        this.sum1 = sum1;
        this.sum2 = sum2;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.champId = champId;
        this.teamId = teamId;
        this.rank = rank;
        this.kills = kills;
        this.assists = assists;
        this.deaths = deaths;
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

    public String getRank() {
        return rank;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public int getSum1() {
        return sum1;
    }

    public int getSum2() {
        return sum2;
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

    public int getChampId() {
        return champId;
    }
}
