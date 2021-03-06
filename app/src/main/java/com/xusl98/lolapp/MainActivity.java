package com.xusl98.lolapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.champion.dto.ChampionInfo;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.league.dto.LeagueEntry;
import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.league.methods.GetLeaguePositionsBySummonerId;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.Participant;
import net.rithms.riot.api.endpoints.match.dto.ParticipantStats;
import net.rithms.riot.api.endpoints.static_data.dto.Champion;
import net.rithms.riot.api.endpoints.static_data.dto.ChampionList;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView viewLvl;
    private TextView viewRank;

    private Button btnHistory;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    private Toolbar toolbar;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarMain);

        viewLvl = (TextView) findViewById(R.id.view_lvl);
        viewRank = (TextView) findViewById(R.id.view_rank);

        btnHistory = (Button) findViewById(R.id.btn_history) ;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        mContext = this;

        StaticData.mainContext = this;

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intentBack);
                finish();
            }
        });


        final ApiConfig config = new ApiConfig().setKey("RGAPI-e24ac602-c50b-4b49-b9e3-09ac98d31e07");
        final RiotApi api = new RiotApi(config);

        final String summonerName;
        summonerName = StaticData.summonerName;

        toolbar.setTitle(summonerName);


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {


                    Summoner summoner = api.getSummonerByName(StaticData.platform, summonerName);
                    List<ChampionMastery> masteriesList = api.getChampionMasteriesBySummoner(StaticData.platform, summoner.getId());
                    String x = "";
                    ArrayList<Mastery> myMasteries = new ArrayList<Mastery>();
                    for (ChampionMastery c : masteriesList) {
                        myMasteries.add(new Mastery(c.getChampionId(), c.getChampionPoints()));
                    }

                    adapterInstructions(myMasteries);
                    setTextView(viewLvl, "Level: " + String.valueOf(summoner.getSummonerLevel()));
                    Set<LeagueEntry> rank  = api.getLeagueEntriesBySummonerId(StaticData.platform, summoner.getId());
                    for (LeagueEntry l : rank){
                        if (l.getQueueType().equals("RANKED_SOLO_5x5")){
                            viewRank.setText(l.getTier() + " " + l.getRank() + " " + l.getLeaguePoints() + "LP");
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



        //HISTORY BUTTON
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
                finish();
            }
        });


    }

    private void setTextView(final TextView text, final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    private void adapterInstructions(final ArrayList<Mastery> myMasteries) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Mastery> first20 = new ArrayList<Mastery>();
                for (int i = 0; i < 20; i++) {
                    first20.add(myMasteries.get(i));
                }
                adapter = new MasteriesAdapter(mContext, first20);
                recyclerView.setAdapter(adapter);
            }
        });
    }


}


