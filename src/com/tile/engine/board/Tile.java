package com.tile.engine.board;

import com.tile.engine.players.Player;

public abstract class Tile {

    protected final int tileCoordinate;

    Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean altinVarMi();

    public abstract Player getPlayer();

    public static final class EmptyTile extends Tile{

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
