package com.xusl98.lolapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.ApiMethod;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.static_data.dto.Champion;
import net.rithms.riot.api.endpoints.static_data.dto.ChampionList;
import net.rithms.riot.constant.Platform;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MasteriesAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Mastery> listMasteries;
    private Map<Integer, String> mapChampions;
    private Map<Integer, String> mapImages;

    public MasteriesAdapter(Context context, ArrayList<Mastery> listMasteries) {
        this.context = context;
        this.listMasteries = listMasteries;
        // <editor-fold defaultstate="collapsed" desc="Mapa de campeones">
        mapChampions = new HashMap<Integer, String>() {
            {
                put(266, "Aatrox");
                put(103, "Ahri");
                put(84, "Akali");
                put(12, "Alistar");
                put(32, "Amumu");
                put(34, "Anivia");
                put(1, "Annie");
                put(22, "Ashe");
                put(136, "Aurelion Sol");
                put(268, "Azir");
                put(432, "Bard");
                put(53, "Blitzcrank");
                put(63, "Brand");
                put(201, "Braum");
                put(51, "Caitlyn");
                put(164, "Camille");
                put(69, "Cassiopeia");
                put(31, "Cho'Gath");
                put(42, "Corki");
                put(122, "Darius");
                put(131, "Diana");
                put(119, "Draven");
                put(36, "Dr. Mundo");
                put(245, "Ekko");
                put(60, "Elise");
                put(28, "Evelynn");
                put(81, "Ezreal");
                put(9, "Fiddlesticks");
                put(114, "Fiora");
                put(105, "Fizz");
                put(3, "Galio");
                put(41, "Gangplank");
                put(86, "Garen");
                put(150, "Gnar");
                put(79, "Gragas");
                put(104, "Graves");
                put(120, "Hecarim");
                put(74, "Heimerdinger");
                put(420, "Illaoi");
                put(39, "Irelia");
                put(427, "Ivern");
                put(40, "Janna");
                put(59, "Jarvan IV");
                put(24, "Jax");
                put(126, "Jayce");
                put(202, "Jhin");
                put(222, "Jinx");
                put(145, "Kai'Sa");
                put(429, "Kalista");
                put(43, "Karma");
                put(30, "Karthus");
                put(38, "Kassadin");
                put(55, "Katarina");
                put(10, "Kayle");
                put(141, "Kayn");
                put(85, "Kennen");
                put(121, "Kha'Zix");
                put(203, "Kindred");
                put(240, "Kled");
                put(96, "Kog'Maw");
                put(7, "LeBlanc");
                put(64, "Lee Sin");
                put(89, "Leona");
                put(127, "Lissandra");
                put(236, "Lucian");
                put(117, "Lulu");
                put(99, "Lux");
                put(54, "Malphite");
                put(90, "Malzahar");
                put(57, "Maokai");
                put(11, "Master Yi");
                put(21, "Miss Fortune");
                put(62, "Wukong");
                put(82, "Mordekaiser");
                put(25, "Morgana");
                put(267, "Nami");
                put(75, "Nasus");
                put(111, "Nautilus");
                put(76, "Nidalee");
                put(56, "Nocturne");
                put(20, "Nunu");
                put(2, "Olaf");
                put(61, "Orianna");
                put(516, "Ornn");
                put(80, "Pantheon");
                put(78, "Poppy");
                put(555, "Pyke");
                put(133, "Quinn");
                put(497, "Rakan");
                put(33, "Rammus");
                put(421, "Rek'Sai");
                put(58, "Renekton");
                put(107, "Rengar");
                put(92, "Riven");
                put(68, "Rumble");
                put(13, "Ryze");
                put(113, "Sejuani");
                put(35, "Shaco");
                put(98, "Shen");
                put(102, "Shyvana");
                put(27, "Singed");
                put(14, "Sion");
                put(15, "Sivir");
                put(72, "Skarner");
                put(37, "Sona");
                put(16, "Soraka");
                put(50, "Swain");
                put(134, "Syndra");
                put(223, "Tahm Kench");
                put(163, "Taliyah");
                put(91, "Talon");
                put(44, "Taric");
                put(17, "Teemo");
                put(412, "Thresh");
                put(18, "Tristana");
                put(48, "Trundle");
                put(23, "Tryndamere");
                put(4, "Twisted Fate");
                put(29, "Twitch");
                put(77, "Udyr");
                put(6, "Urgot");
                put(110, "Varus");
                put(67, "Vayne");
                put(45, "Veigar");
                put(161, "Vel'Koz");
                put(254, "Vi");
                put(112, "Viktor");
                put(8, "Vladimir");
                put(106, "Volibear");
                put(19, "Warwick");
                put(498, "Xayah");
                put(101, "Xerath");
                put(5, "Xin Zhao");
                put(157, "Yasuo");
                put(83, "Yorick");
                put(154, "Zac");
                put(238, "Zed");
                put(115, "Ziggs");
                put(26, "Zilean");
                put(142, "Zoe");
                put(143, "Zyra");

            }
        };
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Mapa de imagenes de Campeones">
        mapImages = new HashMap<Integer, String>() {
            {
                put(266, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Aatrox.png");
                put(103, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Ahri.png");
                put(84, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Akali.png");
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
                put(164, "Camille");
                put(69, "Cassiopeia");
                put(31, "Cho'Gath");
                put(42, "Corki");
                put(122, "Darius");
                put(131, "Diana");
                put(119, "Draven");
                put(36, "Dr. Mundo");
                put(245, "Ekko");
                put(60, "Elise");
                put(28, "Evelynn");
                put(81, "Ezreal");
                put(9, "Fiddlesticks");
                put(114, "Fiora");
                put(105, "Fizz");
                put(3, "Galio");
                put(41, "Gangplank");
                put(86, "Garen");
                put(150, "Gnar");
                put(79, "Gragas");
                put(104, "Graves");
                put(120, "Hecarim");
                put(74, "Heimerdinger");
                put(420, "Illaoi");
                put(39, "Irelia");
                put(427, "Ivern");
                put(40, "Janna");
                put(59, "Jarvan IV");
                put(24, "Jax");
                put(126, "Jayce");
                put(202, "Jhin");
                put(222, "Jinx");
                put(145, "Kai'Sa");
                put(429, "Kalista");
                put(43, "Karma");
                put(30, "Karthus");
                put(38, "Kassadin");
                put(55, "Katarina");
                put(10, "Kayle");
                put(141, "Kayn");
                put(85, "Kennen");
                put(121, "Kha'Zix");
                put(203, "Kindred");
                put(240, "Kled");
                put(96, "Kog'Maw");
                put(7, "LeBlanc");
                put(64, "Lee Sin");
                put(89, "Leona");
                put(127, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Lissandra.png");
                put(236, "Lucian");
                put(117, "Lulu");
                put(99, "Lux");
                put(54, "Malphite");
                put(90, "Malzahar");
                put(57, "Maokai");
                put(11, "Master Yi");
                put(21, "Miss Fortune");
                put(62, "Wukong");
                put(82, "Mordekaiser");
                put(25, "Morgana");
                put(267, "Nami");
                put(75, "Nasus");
                put(111, "Nautilus");
                put(76, "Nidalee");
                put(56, "Nocturne");
                put(20, "Nunu");
                put(2, "Olaf");
                put(61, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Orianna.png");
                put(516, "Ornn");
                put(80, "Pantheon");
                put(78, "Poppy");
                put(555, "Pyke");
                put(133, "Quinn");
                put(497, "Rakan");
                put(33, "Rammus");
                put(421, "Rek'Sai");
                put(58, "Renekton");
                put(107, "Rengar");
                put(92, "Riven");
                put(68, "Rumble");
                put(13, "Ryze");
                put(113, "Sejuani");
                put(35, "Shaco");
                put(98, "Shen");
                put(102, "Shyvana");
                put(27, "Singed");
                put(14, "Sion");
                put(15, "Sivir");
                put(72, "Skarner");
                put(37, "Sona");
                put(16, "Soraka");
                put(50, "Swain");
                put(134, "Syndra");
                put(223, "Tahm Kench");
                put(163, "Taliyah");
                put(91, "Talon");
                put(44, "Taric");
                put(17, "Teemo");
                put(412, "Thresh");
                put(18, "Tristana");
                put(48, "Trundle");
                put(23, "Tryndamere");
                put(4, "Twisted Fate");
                put(29, "Twitch");
                put(77, "Udyr");
                put(6, "Urgot");
                put(110, "Varus");
                put(67, "Vayne");
                put(45, "Veigar");
                put(161, "Vel'Koz");
                put(254, "Vi");
                put(112, "Viktor");
                put(8, "Vladimir");
                put(106, "Volibear");
                put(19, "Warwick");
                put(498, "Xayah");
                put(101, "Xerath");
                put(5, "Xin Zhao");
                put(157, "Yasuo");
                put(83, "Yorick");
                put(154, "Zac");
                put(238, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Zed.png");
                put(115, "Ziggs");
                put(26, "Zilean");
                put(142, "Zoe");
                put(143, "Zyra");

            }
        };
        // </editor-fold>
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.mastery, null);
        return new Holder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Mastery mastery = listMasteries.get(position);
        final Holder holder = (Holder) viewHolder;

//        holder.champName.setText(String.valueOf(mastery.getChampId()));
        holder.champName.setText(getChampName(mastery.getChampId()));
        holder.champPoints.setText(String.valueOf(mastery.getMastPoints()));

        try {
            final String imageUrl = getChampImg(mastery.getChampId());

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try  {
                        Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageUrl).getContent());
                        holder.champPhoto.setImageBitmap(bitmap);
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
        return listMasteries.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView champName;
        TextView champPoints;
        ImageView champPhoto;

        public Holder(@NonNull View itemView) {
            super(itemView);
            champName = itemView.findViewById(R.id.champ_name);
            champPoints = itemView.findViewById(R.id.champ_points);
            champPhoto = itemView.findViewById(R.id.champ_photo);
        }
    }


    public String getChampName(final int champId) {

        //create a map with all champ names and ids to translate the id we get to the name so that the holder can show it
        Set<Integer> mapKeys = mapChampions.keySet();
        for (int key : mapKeys) {
            if (champId == key) {
                String nombre = mapChampions.get(key);
                return nombre;
            }
        }

        return "";

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


}
