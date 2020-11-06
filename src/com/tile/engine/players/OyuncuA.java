package com.tile.engine.players;

import java.util.ArrayList;

public abstract class OyuncuA extends Player{


    OyuncuA(int playerPosition) {
        super(playerPosition);
        playerPosition = 0;
    }
    
    static Player aOyuncusu;
    
    public static ArrayList<Integer> aOyuncusuHareketleri(){
        ArrayList<Integer> aOyuncuTumHareketler = new ArrayList<>();
        

        return aOyuncuTumHareketler;
    }


    
}
