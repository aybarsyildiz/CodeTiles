package com.tile.engine.players;
import com.tile.engine.board.Tile;

public class A_oyuncusu {

    
    //uzaklık hesaplaması
    private static double uzaklikBul(int x1, int y1, int x2, int y2){
        double x = Math.pow(x2 - x1,2);
        double y = Math.pow(y2 - y1,2);
        return Math.sqrt(x+y);
    }


    public static int[] enYakinAltiniBul(int[][] oyunAlani, int[] oyuncuKoordinatlari){
        int [] enYakinAltinKoordinatlari = new int[2];
        int oyuncununXKoordinati = oyuncuKoordinatlari[0];
        int oyuncununYKoordinati = oyuncuKoordinatlari[1];
        





        return enYakinAltinKoordinatlari;
    }
    
}
