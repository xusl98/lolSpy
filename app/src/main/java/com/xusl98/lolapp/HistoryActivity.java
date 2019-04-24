package com.xusl98.lolapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.match.dto.Participant;
import net.rithms.riot.api.endpoints.match.dto.ParticipantStats;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    private Context mContext;

    private TextView viewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        viewName = (TextView) findViewById(R.id.view_name);

        mContext = this;

        recyclerView = findViewById(R.id.recyclerViewHistory);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        final ApiConfig config = new ApiConfig().setKey("RGAPI-68d1b0e4-6ee2-4759-a3b4-530bc0dd7ed2");
        final RiotApi api = new RiotApi(config);


        final String summonerName;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                summonerName = null;
            } else {
                summonerName = extras.getString("summonerName");
            }
        } else {
            summonerName = (String) savedInstanceState.getSerializable("summonerName");
        }

        viewName.setText(summonerName);


        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Summoner summoner = api.getSummonerByName(Platform.EUW, summonerName);

                    //TODO PARTICIPANT FOR MATCH
                    List<MatchReference> matches = api.getMatchListByAccountId(Platform.EUW, summoner.getAccountId()).getMatches();
                    ArrayList<MatchReference> only10 = new ArrayList<MatchReference>();
                    System.out.println("aqui1");
                    for (int i = 0; i < 10; i++){
                        only10.add(matches.get(i));
                    }
                    ArrayList<Match> matches2 = new ArrayList<Match>();
                    for (MatchReference mm : only10){
                        matches2.add(api.getMatch(Platform.EUW, mm.getGameId()));
                    }
                    ArrayList<com.xusl98.lolapp.Match> myMatches = new ArrayList<com.xusl98.lolapp.Match>();
                    for (int i = 0; i < matches2.size(); i++){
                        Match thisMatch = matches2.get(i);
                        Participant p = thisMatch.getParticipantByAccountId(summoner.getAccountId());
                        ParticipantStats stats = p.getStats();
                        myMatches.add(new com.xusl98.lolapp.Match(p.getChampionId(), stats.getItem1(), stats.getItem2(), stats.getItem3(), stats.getItem4(), stats.getItem5(),stats.getItem6(), p.getSpell1Id(), p.getSpell2Id(), stats.getKills(), stats.getDeaths(), stats.getAssists(), stats.isWin()));
                    }

                    adapterInstructions(myMatches);




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();

    }

    private void adapterInstructions(final ArrayList<com.xusl98.lolapp.Match> myMatches) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter =  new MatchAdapter(mContext, myMatches);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}
