package com.xusl98.lolapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Match> listMatches;
    private Map<Integer, String> mapImages;
    private Map<Integer, String> mapSums;
    private Map<Integer, String> mapObj;
    private Map<Integer, String> mapQueue;

    public MatchAdapter(Context context, ArrayList<Match> listMatches) {
        this.context = context;
        this.listMatches = listMatches;

        // <editor-fold defaultstate="collapsed" desc="Mapa de imagenes de Campeones">
        mapImages = new HashMap<Integer, String>() {
            {
                put(266, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Aatrox.png");
                put(103, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ahri.png");
                put(84, "http://ddragon.leagueoflegends.com/cdn/9.11.1/img/champion/Akali.png");
                put(12, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Alistar.png");
                put(32, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Amumu.png");
                put(34, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Anivia.png");
                put(1, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Annie.png");
                put(22, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ashe.png");
                put(136, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/AurelionSol.png");
                put(268, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Azir.png");
                put(432, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Bard.png");
                put(53, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Blitzcrank.png");
                put(63, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Brand.png");
                put(201, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Braum.png");
                put(51, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Caitlyn.png");
                put(164, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Camille.png");
                put(69, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Cassiopeia.png");
                put(31, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Chogath.png");
                put(42, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Corki.png");
                put(122, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Darius.png");
                put(517, "http://ddragon.leagueoflegends.com/cdn/9.11.1/img/champion/Sylas.png");
                put(350, "http://ddragon.leagueoflegends.com/cdn/9.11.1/img/champion/Yuumi.png");
                put(131, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Diana.png");
                put(119, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Draven.png");
                put(36, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/DrMundo.png");
                put(245, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ekko.png");
                put(60, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Elise.png");
                put(28, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Evelynn.png");
                put(81, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ezreal.png");
                put(9, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Fiddlesticks.png");
                put(114, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Fiora.png");
                put(105, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Fizz.png");
                put(3, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Galio.png");
                put(41, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Gangplank.png");
                put(86, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Garen.png");
                put(150, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Gnar.png");
                put(79, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Gragas.png");
                put(104, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Graves.png");
                put(120, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Hecarim.png");
                put(74, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Heimerdinger.png");
                put(420, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Illaoi.png");
                put(39, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Irelia.png");
                put(427, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ivern.png");
                put(40, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Janna.png");
                put(59, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/JarvanIV.png");
                put(24, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Jax.png");
                put(126, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Jayce.png");
                put(202, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Jhin.png");
                put(222, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Jinx.png");
                put(145, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kaisa.png");
                put(429, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kalista.png");
                put(43, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Karma.png");
                put(30, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Karthus.png");
                put(38, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kassadin.png");
                put(55, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Katarina.png");
                put(10, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kayle.png");
                put(141, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kayn.png");
                put(85, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kennen.png");
                put(121, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Khazix.png");
                put(203, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kindred.png");
                put(240, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Kled.png");
                put(96, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/KogMaw.png");
                put(7, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Leblanc.png");
                put(64, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/LeeSin.png");
                put(89, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Leona.png");
                put(127, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Lissandra.png");
                put(236, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Lucian.png");
                put(117, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Lulu.png");
                put(99, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Lux.png");
                put(54, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Malphite.png");
                put(90, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Malzahar.png");
                put(57, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Maokai.png");
                put(11, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/MasterYi.png");
                put(21, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/MissFortune.png");
                put(62, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/MonkeyKing.png");
                put(82, "http://ddragon.leagueoflegends.com/cdn/9.12.1/img/champion/Mordekaiser.png");
                put(25, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Morgana.png");
                put(267, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Nami.png");
                put(75, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Nasus.png");
                put(111, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Nautilus.png");
                put(76, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Nidalee.png");
                put(56, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Nocturne.png");
                put(20, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Nunu.png");
                put(2, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Olaf.png");
                put(61, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Orianna.png");
                put(516, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ornn.png");
                put(80, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Pantheon.png");
                put(78, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Poppy.png");
                put(555, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Pyke.png");
                put(133, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Quinn.png");
                put(497, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Rakan.png");
                put(33, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Rammus.png");
                put(421, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/RekSai.png");
                put(58, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Renekton.png");
                put(107, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Rengar.png");
                put(92, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Riven.png");
                put(68, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Rumble.png");
                put(13, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ryze.png");
                put(113, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Sejuani.png");
                put(35, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Shaco.png");
                put(98, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Shen.png");
                put(102, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Shyvana.png");
                put(27, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Singed.png");
                put(14, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Sion.png");
                put(15, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Sivir.png");
                put(72, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Skarner.png");
                put(37, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Sona.png");
                put(16, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Soraka.png");
                put(50, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Swain.png");
                put(134, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Syndra.png");
                put(223, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/TahmKench.png");
                put(163, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Taliyah.png");
                put(91, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Talon.png");
                put(44, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Taric.png");
                put(17, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Teemo.png");
                put(412, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Thresh.png");
                put(18, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Tristana.png");
                put(48, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Trundle.png");
                put(23, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Tryndamere.png");
                put(4, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/TwistedFate.png");
                put(29, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Twitch.png");
                put(77, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Udyr.png");
                put(6, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Urgot.png");
                put(110, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Varus.png");
                put(67, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Vayne.png");
                put(45, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Veigar.png");
                put(161, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Velkoz.png");
                put(254, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Vi.png");
                put(112, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Viktor.png");
                put(8, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Vladimir.png");
                put(106, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Volibear.png");
                put(19, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Warwick.png");
                put(498, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Xayah.png");
                put(101, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Xerath.png");
                put(5, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/XinZhao.png");
                put(157, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Yasuo.png");
                put(83, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Yorick.png");
                put(154, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Zac.png");
                put(238, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Zed.png");
                put(115, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ziggs.png");
                put(26, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Zilean.png");
                put(142, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Zoe.png");
                put(143, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Zyra.png");

            }
        };
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mapa de imágenes summoners">
        mapSums = new HashMap<Integer, String>() {
            {
                put(21, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerBarrier.png");
                put(1, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerBoost.png");
                put(35, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerDarkStarChampSelect1.png");
                put(36, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerDarkStarChampSelect2.png");
                put(14, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerDot.png");
                put(3, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerExhaust.png");
                put(4, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerFlash.png");
                put(6, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerHaste.png");
                put(7, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerHeal.png");
                put(13, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerMana.png");
                put(30, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerPoroRecall.png");
                put(31, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerPoroThrow.png");
                put(33, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerSiegeChampSelect1.png");
                put(34, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerSiegeChampSelect2.png");
                put(11, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerSmite.png");
                put(39, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerSnowURFSnowball_Mark.png");
                put(32, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerSnowball.png");
                put(12, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/spell/SummonerTeleport.png");
            }
        };
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mapa imágenes de objetos">
        mapObj = new HashMap<Integer, String>() {
            {
                put(1001, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1001.png");
                put(1004, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1004.png");
                put(1006, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1006.png");
                put(1011, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1011.png");
                put(1018, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1018.png");
                put(1026, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1026.png");
                put(1027, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1027.png");
                put(1028, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1028.png");
                put(1029, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1029.png");
                put(1031, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1031.png");
                put(1033, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1033.png");
                put(1036, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1036.png");
                put(1037, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1037.png");
                put(1038, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1038.png");
                put(1039, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1039.png");
                put(1041, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1041.png");
                put(1042, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1042.png");
                put(1043, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1043.png");
                put(1051, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1051.png");
                put(1052, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1052.png");
                put(1053, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1053.png");
                put(1054, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1054.png");
                put(1055, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1055.png");
                put(1056, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1056.png");
                put(1057, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1057.png");
                put(1058, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1058.png");
                put(1082, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1082.png");
                put(1083, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1083.png");
                put(1400, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1400.png");
                put(1401, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1401.png");
                put(1402, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1402.png");
                put(1408, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1408.png");
                put(1409, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1409.png");
                put(1410, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1410.png");
                put(1412, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1412.png");
                put(1413, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1413.png");
                put(1414, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1414.png");
                put(1416, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1416.png");
                put(1418, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1418.png");
                put(1419, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/1419.png");
                put(2003, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2003.png");
                put(2009, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2009.png");
                put(2010, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2010.png");
                put(2015, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2015.png");
                put(2031, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2031.png");
                put(2032, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2032.png");
                put(2033, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2033.png");
                put(2045, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2045.png");
                put(2047, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2047.png");
                put(2049, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2049.png");
                put(2050, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2050.png");
                put(2051, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2051.png");
                put(2052, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2052.png");
                put(2053, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2053.png");
                put(2054, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2054.png");
                put(2055, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2055.png");
                put(2138, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2138.png");
                put(2139, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2139.png");
                put(2140, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2140.png");
                put(2301, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2301.png");
                put(2302, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2302.png");
                put(2303, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/2303.png");
                put(3001, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3001.png");
                put(3003, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3003.png");
                put(3004, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3004.png");
                put(3006, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3006.png");
                put(3007, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3007.png");
                put(3008, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3008.png");
                put(3009, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3009.png");
                put(3010, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3010.png");
                put(3020, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3020.png");
                put(3022, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3022.png");
                put(3024, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3024.png");
                put(3025, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3025.png");
                put(3026, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3026.png");
                put(3027, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3027.png");
                put(3028, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3028.png");
                put(3029, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3029.png");
                put(3030, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3030.png");
                put(3031, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3031.png");
                put(3033, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3033.png");
                put(3034, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3034.png");
                put(3035, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3035.png");
                put(3036, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3036.png");
                put(3040, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3040.png");
                put(3041, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3041.png");
                put(3042, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3042.png");
                put(3043, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3043.png");
                put(3044, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3044.png");
                put(3046, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3046.png");
                put(3047, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3047.png");
                put(3048, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3048.png");
                put(3050, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3050.png");
                put(3052, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3052.png");
                put(3053, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3053.png");
                put(3056, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3056.png");
                put(3057, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3057.png");
                put(3060, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3060.png");
                put(3065, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3065.png");
                put(3067, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3067.png");
                put(3068, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3068.png");
                put(3069, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3069.png");
                put(3070, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3070.png");
                put(3071, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3071.png");
                put(3072, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3072.png");
                put(3073, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3073.png");
                put(3074, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3074.png");
                put(3075, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3075.png");
                put(3077, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3077.png");
                put(3078, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3078.png");
                put(3082, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3082.png");
                put(3083, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3083.png");
                put(3084, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3084.png");
                put(3085, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3085.png");
                put(3086, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3086.png");
                put(3087, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3087.png");
                put(3089, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3089.png");
                put(3090, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3090.png");
                put(3091, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3091.png");
                put(3092, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3092.png");
                put(3094, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3094.png");
                put(3096, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3096.png");
                put(3097, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3097.png");
                put(3098, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3098.png");
                put(3100, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3100.png");
                put(3101, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3101.png");
                put(3102, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3102.png");
                put(3104, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3104.png");
                put(3105, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3105.png");
                put(3107, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3107.png");
                put(3108, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3108.png");
                put(3109, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3109.png");
                put(3110, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3110.png");
                put(3111, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3111.png");
                put(3112, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3112.png");
                put(3113, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3113.png");
                put(3114, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3114.png");
                put(3115, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3115.png");
                put(3116, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3116.png");
                put(3117, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3117.png");
                put(3122, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3122.png");
                put(3123, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3123.png");
                put(3124, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3124.png");
                put(3133, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3133.png");
                put(3134, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3134.png");
                put(3135, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3135.png");
                put(3136, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3136.png");
                put(3137, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3137.png");
                put(3139, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3139.png");
                put(3140, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3140.png");
                put(3142, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3142.png");
                put(3143, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3143.png");
                put(3144, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3144.png");
                put(3145, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3145.png");
                put(3146, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3146.png");
                put(3147, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3147.png");
                put(3151, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3151.png");
                put(3152, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3152.png");
                put(3153, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3153.png");
                put(3155, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3155.png");
                put(3156, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3156.png");
                put(3157, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3157.png");
                put(3158, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3158.png");
                put(3165, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3165.png");
                put(3170, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3170.png");
                put(3174, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3174.png");
                put(3175, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3175.png");
                put(3181, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3181.png");
                put(3184, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3184.png");
                put(3185, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3185.png");
                put(3187, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3187.png");
                put(3190, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3190.png");
                put(3191, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3191.png");
                put(3196, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3196.png");
                put(3197, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3197.png");
                put(3198, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3198.png");
                put(3200, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3200.png");
                put(3211, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3211.png");
                put(3222, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3222.png");
                put(3252, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3252.png");
                put(3285, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3285.png");
                put(3301, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3301.png");
                put(3302, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3302.png");
                put(3303, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3303.png");
                put(3340, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3340.png");
                put(3341, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3341.png");
                put(3345, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3345.png");
                put(3348, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3348.png");
                put(3361, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3361.png");
                put(3362, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3362.png");
                put(3363, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3363.png");
                put(3364, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3364.png");
                put(3401, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3401.png");
                put(3410, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3410.png");
                put(3416, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3416.png");
                put(3422, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3422.png");
                put(3455, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3455.png");
                put(3460, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3460.png");
                put(3461, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3461.png");
                put(3462, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3462.png");
                put(3504, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3504.png");
                put(3508, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3508.png");
                put(3512, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3512.png");
                put(3599, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3599.png");
                put(3630, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3630.png");
                put(3631, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3631.png");
                put(3632, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3632.png");
                put(3633, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3633.png");
                put(3634, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3634.png");
                put(3635, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3635.png");
                put(3636, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3636.png");
                put(3637, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3637.png");
                put(3640, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3640.png");
                put(3641, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3641.png");
                put(3642, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3642.png");
                put(3643, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3643.png");
                put(3645, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3645.png");
                put(3647, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3647.png");
                put(3648, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3648.png");
                put(3649, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3649.png");
                put(3671, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3671.png");
                put(3672, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3672.png");
                put(3673, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3673.png");
                put(3675, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3675.png");
                put(3680, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3680.png");
                put(3681, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3681.png");
                put(3682, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3682.png");
                put(3683, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3683.png");
                put(3706, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3706.png");
                put(3711, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3711.png");
                put(3715, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3715.png");
                put(3742, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3742.png");
                put(3748, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3748.png");
                put(3751, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3751.png");
                put(3800, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3800.png");
                put(3801, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3801.png");
                put(3802, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3802.png");
                put(3812, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3812.png");
                put(3814, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3814.png");
                put(3901, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3901.png");
                put(3902, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3902.png");
                put(3903, "http://ddragon.leagueoflegends.com/cdn/7.8.1/img/item/3903.png");
            }
        };
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mapa de nombres de colas">
        mapQueue = new HashMap<Integer, String>() {
            {
                put(98, "6v6 Hexakill");
                put(100, "5v5 ARAM");
                put(310, "Nemesis");
                put(313, "Black Market Brawlers");
                put(400, "5v5 Draft Pick");
                put(420, "5v5 Ranked Solo");
                put(430, "5v5 Blind Pick");
                put(440, "5v5 Ranked Flex");
                put(450, "5v5 ARAM");
                put(460, "3v3 Blind Pick");
                put(470, "3v3 Ranked Flex");
                put(600, "Blood Hunt Assassin");
                put(610, "Dark Star: Singularity");
                put(700, "Clash");
                put(800, "Co-op vs. AI Intermediate Bo");
                put(810, "Co-op vs. AI Intro Bot");
                put(820, "Co-op vs. AI Beginner Bot");
                put(830, "Co-op vs. AI Intro Bot");
                put(840, "Co-op vs. AI Beginner Bot ");
                put(850, "Co-op vs. AI Intermediate Bot");
                put(900, "ARURF");
                //TODO finish the map with all queue types
            }
        };
        //</editor-fold>
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.match, null);
        return new Holder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Match match = listMatches.get(position);
        final Holder holder = (Holder) viewHolder;
        holder.score.setText(match.getKills() + "/" + match.getDeaths() + "/" + match.getAssists());
        holder.queue.setText(getQueueName(match.getQueue()));


        try {
            final String imageUrl = getChampImg(match.getChampId());
            final String imageSum1Url = getSumImg(match.getSummoner1());
            final String imageSum2Url = getSumImg(match.getSummoner2());
            final String imageObj1Url = getObjImg(match.getItem1());
            final String imageObj2Url = getObjImg(match.getItem2());
            final String imageObj3Url = getObjImg(match.getItem3());
            final String imageObj4Url = getObjImg(match.getItem4());
            final String imageObj5Url = getObjImg(match.getItem5());
            final String imageObj6Url = getObjImg(match.getItem6());
            final boolean win = match.getMatchResult();

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        if (win == true) {
                            holder.background.setBackgroundColor(ContextCompat.getColor(context, R.color.colorBackground));
                        } else {
                            holder.background.setBackgroundColor(Color.RED);
                        }

                        //CHAMP IMAGE
                        Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
                        holder.imageChamp.setImageBitmap(bitmap);
                        //SUMS
                        Bitmap bitmapSum1 = BitmapFactory.decodeStream((InputStream) new URL(imageSum1Url).getContent());
                        holder.sum1.setImageBitmap(bitmapSum1);
                        Bitmap bitmapSum2 = BitmapFactory.decodeStream((InputStream) new URL(imageSum2Url).getContent());
                        holder.sum2.setImageBitmap(bitmapSum2);
                        //ITEMS
                        if (imageObj1Url.length() > 1) {
                            Bitmap bitmapObj1 = BitmapFactory.decodeStream((InputStream) new URL(imageObj1Url).getContent());
                            holder.item1.setImageBitmap(bitmapObj1);
                        }
                        if (imageObj2Url.length() > 1) {
                            Bitmap bitmapObj2 = BitmapFactory.decodeStream((InputStream) new URL(imageObj2Url).getContent());
                            holder.item2.setImageBitmap(bitmapObj2);
                        }if (imageObj3Url.length() > 1) {
                            Bitmap bitmapObj3 = BitmapFactory.decodeStream((InputStream) new URL(imageObj3Url).getContent());
                            holder.item3.setImageBitmap(bitmapObj3);
                        }if (imageObj4Url.length() > 1) {
                            Bitmap bitmapObj4 = BitmapFactory.decodeStream((InputStream) new URL(imageObj4Url).getContent());
                            holder.item4.setImageBitmap(bitmapObj4);
                        }if (imageObj5Url.length() > 1) {
                            Bitmap bitmapObj5 = BitmapFactory.decodeStream((InputStream) new URL(imageObj5Url).getContent());
                            holder.item5.setImageBitmap(bitmapObj5);
                        }if (imageObj6Url.length() > 1) {
                            Bitmap bitmapObj6 = BitmapFactory.decodeStream((InputStream) new URL(imageObj6Url).getContent());
                            holder.item6.setImageBitmap(bitmapObj6);
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return listMatches.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView imageChamp;
        ImageView sum1;
        ImageView sum2;
        ImageView item1;
        ImageView item2;
        ImageView item3;
        ImageView item4;
        ImageView item5;
        ImageView item6;
        TextView score;
        TextView queue;

        RelativeLayout background;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageChamp = (ImageView) itemView.findViewById(R.id.image_champ);
            sum1 = (ImageView) itemView.findViewById(R.id.image_sum1);
            sum2 = (ImageView) itemView.findViewById(R.id.image_sum2);
            item1 = (ImageView) itemView.findViewById(R.id.image_item1);
            item2 = (ImageView) itemView.findViewById(R.id.image_item2);
            item3 = (ImageView) itemView.findViewById(R.id.image_item3);
            item4 = (ImageView) itemView.findViewById(R.id.image_item4);
            item5 = (ImageView) itemView.findViewById(R.id.image_item5);
            item6 = (ImageView) itemView.findViewById(R.id.image_item6);
            score = (TextView) itemView.findViewById(R.id.score);
            queue = (TextView) itemView.findViewById(R.id.field_queue);
            background = (RelativeLayout) itemView.findViewById(R.id.back_match);
        }
    }

    public String getChampImg(final int champId) {

        Set<Integer> mapKeys = mapImages.keySet();
        for (int key : mapKeys) {
            if (champId == key) {
                String url = mapImages.get(key);
                return url;
            }
        }

        return "";
    }

    public String getSumImg(final int sumId) {

        Set<Integer> mapKeys = mapSums.keySet();
        for (int key : mapKeys) {
            if (sumId == key) {
                String url = mapSums.get(key);
                return url;
            }
        }

        return "";
    }

    public String getObjImg(final int objId) {

        Set<Integer> mapKeys = mapObj.keySet();
        for (int key : mapKeys) {
            if (objId == key) {
                String url = mapObj.get(key);
                return url;
            }
        }

        return "";
    }

    public String getQueueName(final int queueId) {

        Set<Integer> mapKeys = mapQueue.keySet();
        for (int key : mapKeys) {
            if (queueId == key) {
                String url = mapQueue.get(key);
                return url;
            }
        }

        return "";
    }
}
