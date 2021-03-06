package com.tile.engine.players;

import com.tile.engine.board.Tile;

public class D_oyuncusu {

    public static double uzaklikBul(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }

    private static double MaaliyetHesapla(int[][] oyunAlani,int[] altinKoordinati, double uzaklik){
        return   (uzaklik*5)-oyunAlani[altinKoordinati[0]][altinKoordinati[1]];
    }   

    

    public static int[] enHesapliAltiniBul(int[][] oyunAlani, int[] oyuncuKoordinatlari,int[] oyunAlaniBoyutu,int[][] altinHedefleri){
        
        int oyuncununXKoordinati = oyuncuKoordinatlari[0];
        int oyuncununYKoordinati = oyuncuKoordinatlari[1];
        int[] enHesapliAltinKoordinatlari = {oyunAlaniBoyutu[0]-1,0};
        double uzaklik = uzaklikBul(oyuncununXKoordinati, oyuncununYKoordinati, enHesapliAltinKoordinatlari[0], enHesapliAltinKoordinatlari[1]);
        double maaliyet = MaaliyetHesapla(oyunAlani, enHesapliAltinKoordinatlari, uzaklik);

        for (int i = 0; i < oyunAlaniBoyutu[0]; i++) {
            for (int j = 0; j < oyunAlaniBoyutu[1] ; j++) {
                int[] tileKoordinati = {i,j};

                if(Tile.AltinVarMi(oyunAlani,tileKoordinati)){
                   
                   
                    uzaklik = uzaklikBul(oyuncununXKoordinati,oyuncununYKoordinati,i,j);
                    
                    
                    if(i==altinHedefleri[0][0] && j==altinHedefleri[0][1]){
                    double aUzaklık=uzaklikBul(altinHedefleri[0][0],altinHedefleri[0][1],altinHedefleri[0][2],altinHedefleri[0][3]);
                        if(uzaklik>aUzaklık){
                           continue;
                        }

                    }
                    if(i==altinHedefleri[1][0] && j==altinHedefleri[1][1]){
                        double bUzaklık=uzaklikBul(altinHedefleri[1][0],altinHedefleri[1][1],altinHedefleri[1][2],altinHedefleri[1][3]);
                            if(uzaklik>bUzaklık){
                               continue;
                            }
    
                        }
                        
                    if(i==altinHedefleri[2][0] && j==altinHedefleri[2][1]){
                            
                        double cUzaklık=uzaklikBul(altinHedefleri[2][0],altinHedefleri[2][1],altinHedefleri[2][2],altinHedefleri[2][3]);
                            if(uzaklik>cUzaklık){
                                 continue;
                            }
        
                     }
                    
                    
                    if(maaliyet > MaaliyetHesapla(oyunAlani, tileKoordinati, uzaklik)){  
                        
                        maaliyet = MaaliyetHesapla(oyunAlani, tileKoordinati, uzaklik);
                           



                            enHesapliAltinKoordinatlari[0] = i;
                            enHesapliAltinKoordinatlari[1] = j;

                    }
               
               
               
               
               
                }



            }
            
        }

        return enHesapliAltinKoordinatlari;
    }

    public static boolean hedefAlindiMi(int hedefKoordinatlar[], int oyuncularinHedefleri[][]){

        if(oyuncularinHedefleri[0][0] == hedefKoordinatlar[0] && oyuncularinHedefleri[1][0] == hedefKoordinatlar[1]
        || oyuncularinHedefleri[0][1] == hedefKoordinatlar[0] && oyuncularinHedefleri[1][1] == hedefKoordinatlar[1]
        || oyuncularinHedefleri[0][2] == hedefKoordinatlar[0] && oyuncularinHedefleri[1][2] == hedefKoordinatlar[1]){
            return true;
        }
        else{
        return false;
        }
    }
    
}
