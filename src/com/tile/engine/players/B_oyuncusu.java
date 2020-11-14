package com.tile.engine.players;
import com.tile.engine.board.Tile;

public class B_oyuncusu {

    private static double uzaklikBul(int x1, int y1, int x2, int y2){
        double x = Math.pow(x2 - x1,2);
        double y = Math.pow(y2 - y1,2);
        return Math.sqrt(x+y);
    }
    
    private static double MaaliyetHesapla(int[][] oyunAlani,int[] altinKoordinati, double uzaklik){
        return  (uzaklik *2) - oyunAlani[altinKoordinati[0]][altinKoordinati[1]];
    }   

    public static int[] enHesapliAltiniBul(int[][] oyunAlani, int[] oyuncuKoordinatlari,int oyunAlaniBoyutu){
        
        int oyuncununXKoordinati = oyuncuKoordinatlari[0];
        int oyuncununYKoordinati = oyuncuKoordinatlari[1];
        int[] enHesapliAltinKoordinatlari = {oyunAlaniBoyutu-1, oyunAlaniBoyutu-1};
        double uzaklik = uzaklikBul(oyuncununXKoordinati, oyuncununYKoordinati, enHesapliAltinKoordinatlari[0], enHesapliAltinKoordinatlari[1]);
        double maaliyet = MaaliyetHesapla(oyunAlani, enHesapliAltinKoordinatlari, uzaklik);

        for (int i = 0; i < oyunAlaniBoyutu; i++) {
            for (int j = 0; j < oyunAlaniBoyutu ; j++) {
                int[] tileKoordinati = {i,j};

                if(Tile.AltinVarMi(oyunAlani,tileKoordinati)){
                    uzaklik = uzaklikBul(oyuncununXKoordinati,oyuncununYKoordinati,i,j);
                    if(maaliyet > MaaliyetHesapla(oyunAlani, tileKoordinati, uzaklik)){
                            maaliyet = MaaliyetHesapla(oyunAlani, tileKoordinati, uzaklik);
                            System.out.println(i+" "+j+". en hesapli:"+ maaliyet);
                            enHesapliAltinKoordinatlari[0] = i;
                            enHesapliAltinKoordinatlari[1] = j;

                    }
                }


            }
            
        }


        return enHesapliAltinKoordinatlari;
    }
}
