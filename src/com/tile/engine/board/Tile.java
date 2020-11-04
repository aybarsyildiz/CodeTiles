package com.tile.engine.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.tile.engine.players.Player;

public abstract class Tile {
    static Random rand = new Random();
    protected final int tileCoordinate;
    static int sayi = 20;
    //burdaki sayi değeri değişebilecek. default olarak tahta 20x20 o yüzden onu ekledik.
    private static final Map<Integer, Integer> ALL_TILES = createAllPossibleTiles(sayi);
    
    // hash-map kullanarak board oluşturulması
    private static Map<Integer, Integer> createAllPossibleTiles(int sayi) {

        final Map<Integer, Integer> allTileMap = new HashMap<>();

        ArrayList<Integer> altinOlanKareler = new ArrayList<>();
        ArrayList<Integer> gizliAltinOlanKareler = new ArrayList<>();
        int altinDegerleri[] = {5,10,15,20,-5,-10,-15,-20};
        int toplamKareSayisi = sayi * sayi;
        int altinOlanKareSayisi = (toplamKareSayisi*20)/100;
        int gizliAltinOlanKareSayisi = (toplamKareSayisi*10)/100;

        //görünür altın olan karelerin oluşturulması
        for (int i = 0; i < altinOlanKareSayisi; i++) {
            int value = rand.nextInt(toplamKareSayisi);
            
            while(altinOlanKareler.contains(value)){
                value = rand.nextInt(toplamKareSayisi);
            }
            
            altinOlanKareler.add(value);
            
        }
        // gizli altın olan karelerin oluşturulması
        for (int i = 0; i < gizliAltinOlanKareSayisi; i++) {
            int value = rand.nextInt(toplamKareSayisi);
            
            while(altinOlanKareler.contains(value)){
                value = rand.nextInt(toplamKareSayisi);
            }
            
            gizliAltinOlanKareler.add(value);

        }
        //altın olan ve gizli altın olan karelerin yerleştirilmesi
        for (int i = 0; i < toplamKareSayisi; i++) {
            for(int j = 0; j< altinOlanKareler.size(); j++){

                if(i == altinOlanKareler.get(j)){
                    allTileMap.put(i,altinDegerleri[rand.nextInt(4)]);
                }
                else{
                    allTileMap.put(i,0);
                }
            }
            for(int k = 0; k<gizliAltinOlanKareler.size(); k++){
                if(i == gizliAltinOlanKareler.get(k)){
                    //if(allTileMap
                    //allTileMap.put(i,altinDegerleri[rand.nextInt(4)+4]);
                    
                }
                else{

                }
                

            }
        }
        

        return allTileMap;
    }



   

    private Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    

    public abstract Player getPlayer();

    public static final class EmptyTile extends Tile{
        //altın olmayan boş kare sınıfı
        private EmptyTile(final int coordiante){
            super(coordiante);
        }

        

        @Override
        public Player getPlayer() {
            // TODO Auto-generated method stub
            return null;
        }

    }
    public static final class AltinTile extends Tile{
        
        //altın olan kare sınıfı

        private AltinTile(int tileCoordinate){
            super(tileCoordinate);
            
        }
        

        @Override
        public Player getPlayer() {
            // TODO Auto-generated method stub
            return null;
        }


    }
}
