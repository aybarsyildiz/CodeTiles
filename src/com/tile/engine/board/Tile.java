package com.tile.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.tile.engine.players.Player;

public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllPossibleEmptyTiles();
    //hash-map kullanarak board oluşturulması
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles(){

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i<400; i++){
            emptyTileMap.put(i,new EmptyTile(i));
        }

        return emptyTileMap;
    }

    public static Tile createTile(final int tileCoordinate, final Player player){

        return player != null ? new AltinTile(tileCoordinate) : EMPTY_TILES.get(tileCoordinate);
        //eğer oyuncu o karede değilse altın karesi oluşturma methodu
    }

    private Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean altinVarMi();

    public abstract Player getPlayer();

    public static final class EmptyTile extends Tile{
        //altın olmayan boş kare sınıfı
        EmptyTile(final int coordiante){
            super(coordiante);
        }

        @Override
        public boolean altinVarMi(){
            return false;
        }

        @Override
        public Player getPlayer() {
            // TODO Auto-generated method stub
            return null;
        }

    }
    public static final class AltinTile extends Tile{
        
        //altın olan kare sınıfı

        AltinTile(int tileCoordinate){
            super(tileCoordinate);
            
        }
        @Override
        public boolean altinVarMi(){
            return true;
        }

        @Override
        public Player getPlayer() {
            // TODO Auto-generated method stub
            return null;
        }


    }
}
