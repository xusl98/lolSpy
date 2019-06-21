package com.xusl98.lolapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.league.dto.LeagueEntry;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.match.dto.Participant;
import net.rithms.riot.api.endpoints.match.dto.ParticipantStats;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    private Context mContext;


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        mContext = this;

        recyclerView = findViewById(R.id.recyclerViewHistory);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        toolbar = (Toolbar) findViewById(R.id.toolbarHistory);


        final ApiConfig config = new ApiConfig().setKey("RGAPI-e24ac602-c50b-4b49-b9e3-09ac98d31e07");
        final RiotApi api = new RiotApi(config);


        final String summonerName;
        summonerName = StaticData.summonerName;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("PROBANDO");
                Intent i = new Intent(HistoryActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        toolbar.setTitle(summonerName);



        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Summoner summoner = api.getSummonerByName(StaticData.platform, summonerName);


                    // PARTICIPANT FOR MATCH
                    List<MatchReference> matches = api.getMatchListByAccountId(StaticData.platform, summoner.getAccountId()).getMatches();
                    ArrayList<MatchReference> only20 = new ArrayList<MatchReference>();
                    System.out.println("aqui1");
                    for (int i = 0; i < 20; i++) {
                        only20.add(matches.get(i));
                    }
                    ArrayList<Match> matches2 = new ArrayList<Match>();
                    for (MatchReference mm : only20) {
                        matches2.add(api.getMatch(StaticData.platform, mm.getGameId()));
                    }
                    ArrayList<com.xusl98.lolapp.Match> myMatches = new ArrayList<com.xusl98.lolapp.Match>();
                    for (int i = 0; i < matches2.size(); i++) {
                        Match thisMatch = matches2.get(i);
                        Participant p = thisMatch.getParticipantByAccountId(summoner.getAccountId());
                        ParticipantStats stats = p.getStats();

                        myMatches.add(new com.xusl98.lolapp.Match(p.getChampionId(), stats.getItem0(), stats.getItem1(), stats.getItem2(), stats.getItem3(), stats.getItem4(), stats.getItem5(), p.getSpell1Id(), p.getSpell2Id(), stats.getKills(), stats.getDeaths(), stats.getAssists(), stats.isWin(), thisMatch.getQueueId()));
                    }

                    adapterInstructions(myMatches);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread3.start();

    }

    private void adapterInstructions(final ArrayList<com.xusl98.lolapp.Match> myMatches) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new MatchAdapter(mContext, myMatches);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}
