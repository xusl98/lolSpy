package com.xusl98.lolapp;

import android.content.Context;

import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.constant.Platform;

public class StaticData {

    public static String summonerName;
    public static Platform platform = Platform.EUW;
    public static Context historyContext;
    public static Context mainContext;
    public static Context gameContext;

    public static Match match;
    public static MatchReference matchReference;

}
