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

    public MatchAdapter(Context context, ArrayList<Match> listMatches) {
        this.context = context;
        this.listMatches = listMatches;

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
                put(164, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Camille.png");
                put(69, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Cassiopeia.png");
                put(31, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Chogath.png");
                put(42, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Corki.png");
                put(122, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Darius.png");
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
                put(82, "http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/Mordekaiser.png");
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

        try {
            final String imageUrl = getChampImg(match.getChampId());
            final String imageSum1Url = getSumImg(match.getSummoner1());
            final String imageSum2Url = getSumImg(match.getSummoner2());

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
                        holder.imageChamp.setImageBitmap(bitmap);
                        Bitmap bitmapSum1 = BitmapFactory.decodeStream((InputStream) new URL(imageSum1Url).getContent());
                        holder.sum1.setImageBitmap(bitmapSum1);
                        Bitmap bitmapSum2 = BitmapFactory.decodeStream((InputStream) new URL(imageSum2Url).getContent());
                        holder.sum2.setImageBitmap(bitmapSum2);
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
}
