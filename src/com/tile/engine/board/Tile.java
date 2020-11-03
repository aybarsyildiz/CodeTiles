package com.tile.engine.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.tile.engine.players.Player;

public abstract class Tile {
    static Random rand = new Random();
    protected final int tileCoordinate;
    
    private static final Map<Integer, Integer> ALL_TILES = createAllPossibleTiles();

    // hash-map kullanarak board oluşturulması
    private static Map<Integer, Integer> createAllPossibleTiles() {

        final Map<Integer, Integer> allTileMap = new HashMap<>();

        ArrayList<Integer> altinOlanKareler = new ArrayList<>();
        int altinDegerleri[] = {5,10,15,20,-5,-10,-15,-20};

        for (int i = 0; i < 80; i++) {
            int value = rand.nextInt(400);
            
            while(altinOlanKareler.contains(value)){
                value = rand.nextInt(400);
            }
            
            altinOlanKareler.add(value);
            
        }

        for (int i = 0; i < 400; i++) {
            for(int j = 0; j< altinOlanKareler.size(); j++){

                if(i == altinOlanKareler.get(j)){
                    allTileMap.put(i,altinDegerleri[rand.nextInt(8)]);
                }
                else{
                    allTileMap.put(i,0);
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
