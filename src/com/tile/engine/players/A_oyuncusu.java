package com.tile.engine.players;
import com.tile.engine.board.Tile;

public class A_oyuncusu {

    
    //uzaklık hesaplaması
    public static double uzaklikBul(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }


    public static int[] enYakinAltiniBul(int[][] oyunAlani, int[] oyuncuKoordinatlari,int[] oyunAlaniBoyutu){
        
        int oyuncununXKoordinati = oyuncuKoordinatlari[0];
        int oyuncununYKoordinati = oyuncuKoordinatlari[1];
        int[] enYakinAltinKoordinatlari = {50000000,50000000};
        double uzaklik = uzaklikBul(oyuncununXKoordinati, oyuncununYKoordinati, enYakinAltinKoordinatlari[0], enYakinAltinKoordinatlari[1]);
        for (int i = 0; i < oyunAlaniBoyutu[0]; i++) {
            for (int j = 0; j < oyunAlaniBoyutu[1] ; j++) {
                int[] tileKoordinati = {i,j};

                if(Tile.AltinVarMi(oyunAlani,tileKoordinati)){
                    if(uzaklikBul(oyuncununXKoordinati, oyuncununYKoordinati, i, j) < uzaklik){
                            uzaklik = uzaklikBul(oyuncununXKoordinati, oyuncununYKoordinati, i, j);
                            enYakinAltinKoordinatlari[0] = i;
                            enYakinAltinKoordinatlari[1] = j;

                    }
                }


            }
            
        }
        

        return enYakinAltinKoordinatlari;
    }
    
}
