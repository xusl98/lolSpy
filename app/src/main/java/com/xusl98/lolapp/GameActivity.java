package com.xusl98.lolapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.endpoints.league.dto.LeagueEntry;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.match.dto.Participant;
import net.rithms.riot.api.endpoints.match.dto.ParticipantIdentity;
import net.rithms.riot.api.endpoints.match.dto.ParticipantStats;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    private RecyclerView recyclerViewRed;
    private RecyclerView.Adapter adapterRed;
    private RecyclerView.LayoutManager managerRed;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        StaticData.gameContext = this;

        mContext = this;

        recyclerView = findViewById(R.id.recycler_blue);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        recyclerViewRed = findViewById(R.id.recycler_red);
        managerRed = new LinearLayoutManager(this);
        recyclerViewRed.setLayoutManager(managerRed);

        toolbar = (Toolbar) findViewById(R.id.toolbarGame);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameActivity.this, HistoryActivity.class);
                startActivity(i);
                finish();
            }
        });

        final ApiConfig config = new ApiConfig().setKey("RGAPI-e24ac602-c50b-4b49-b9e3-09ac98d31e07");
        final RiotApi api = new RiotApi(config);

        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {


                    net.rithms.riot.api.endpoints.match.dto.Match match = StaticData.match;
                    MatchReference matchReference = StaticData.matchReference;

                    List<ParticipantIdentity> pId = match.getParticipantIdentities();

                    ArrayList<com.xusl98.lolapp.Participant> myParticipantsBlue = new ArrayList<com.xusl98.lolapp.Participant>();
                    ArrayList<com.xusl98.lolapp.Participant> myParticipantsRed = new ArrayList<com.xusl98.lolapp.Participant>();


                    for (int i = 0; i < pId.size(); i++) {
                        //Summoner name
                        String summonerName = pId.get(i).getPlayer().getSummonerName();

                        Participant participant = match.getParticipantBySummonerName(summonerName);
                        ParticipantStats participantStats = participant.getStats();
                        //sums
                        int sum1 = participant.getSpell1Id();
                        int sum2 = participant.getSpell2Id();
                        //items
                        int item1 = participantStats.getItem1();
                        int item2 = participantStats.getItem2();
                        int item3 = participantStats.getItem3();
                        int item4 = participantStats.getItem4();
                        int item5 = participantStats.getItem5();
                        int item6 = participantStats.getItem6();
                        //champ
                        int champ = participant.getChampionId();
                        //teamID
                        int teamId = participant.getTeamId();

                        //rank
                        String rankString = "";
                        Set<LeagueEntry> rank = api.getLeagueEntriesBySummonerId(StaticData.platform, api.getSummonerByName(StaticData.platform, summonerName).getId());
                        for (LeagueEntry l : rank) {
                            if (l.getQueueType().equals("RANKED_SOLO_5x5")) {
                                String x = l.getRank();
                                System.out.println("RANGO: " + x);

                                switch (x) {
                                    case "IV":
                                        rankString += String.valueOf(l.getTier().charAt(0)) + 4;
                                        break;
                                    case "III":
                                        rankString += String.valueOf(l.getTier().charAt(0)) + 3;
                                        break;
                                    case "II":
                                        rankString += String.valueOf(l.getTier().charAt(0)) + 2;
                                        break;
                                    case "I":
                                        rankString += String.valueOf(l.getTier().charAt(0)) + 1;
                                        break;
                                }

                            }
                        }

                        if (teamId == 100) {
                            myParticipantsBlue.add(new com.xusl98.lolapp.Participant(summonerName, sum1, sum2, item1, item2, item3, item4, item5, item6, champ, teamId, rankString, participantStats.getKills(), participantStats.getDeaths(), participantStats.getAssists()));
                        } else {
                            myParticipantsRed.add(new com.xusl98.lolapp.Participant(summonerName, sum1, sum2, item1, item2, item3, item4, item5, item6, champ, teamId, rankString, participantStats.getKills(), participantStats.getDeaths(), participantStats.getAssists()));
                        }

                    }
                    adapterInstructions(myParticipantsBlue);
                    adapterInstructionsRed(myParticipantsRed);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread3.start();


    }

    private void adapterInstructions(final ArrayList<com.xusl98.lolapp.Participant> myParticipants) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new ParticipantAdapter(mContext, myParticipants);
                recyclerView.setAdapter(adapter);

            }
        });
    }

    private void adapterInstructionsRed(final ArrayList<com.xusl98.lolapp.Participant> myParticipants) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapterRed = new ParticipantAdapter(mContext, myParticipants);
                recyclerViewRed.setAdapter(adapterRed);

            }
        });
    }
}
