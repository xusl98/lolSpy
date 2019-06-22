package com.xusl98.lolapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import net.rithms.riot.constant.Platform;

public class SearchActivity extends AppCompatActivity {

    private Button btnSpy;
    private TextInputLayout input;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btnSpy = (Button) findViewById(R.id.btn_spy);
        input = (TextInputLayout) findViewById(R.id.input);

        toolbar = (Toolbar) findViewById(R.id.toolbarSearch);

        toolbar.inflateMenu(R.menu.platf_menu);

        //TODO add all the servers
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId()==R.id.action_EUW)
                {
                    StaticData.platform = Platform.EUW;
                }
                else if(menuItem.getItemId()== R.id.action_NA)
                {
                    StaticData.platform = Platform.NA;
                }
                else if(menuItem.getItemId()== R.id.action_NA)
                {
                    StaticData.platform = Platform.OCE;
                }
                else if(menuItem.getItemId()== R.id.action_RU)
                {
                    StaticData.platform = Platform.RU;
                }
                return false;
            }
        });

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lol_video);
        videoview.setVideoURI(uri);
        videoview.start();

        btnSpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchActivity.this, MainActivity.class);
                StaticData.summonerName = input.getEditText().getText().toString();
                startActivity(i);
                finish();
            }
        });
    }


}
