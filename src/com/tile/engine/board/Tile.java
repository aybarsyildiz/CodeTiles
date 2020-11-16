package com.tile.engine.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.tile.engine.players.Player;

public abstract class Tile {
    private static int row =0,col =0,altınOranı=0,gAltınOranı=0;
    static Random rand = new Random();
    


    
    //public static int sayi = 20;
    //burdaki sayi değeri değişebilecek. default olarak tahta 20x20 o yüzden onu ekledik.
    
    //private static final Map<Integer, Integer> ALL_TILES = createAllPossibleTiles(sayi);
    public static final int[][] TILES_ALL = createAllPossibleTiles(row,col,altınOranı,gAltınOranı);
    
    // hash-map kullanarak board oluşturulması
    public static int[][] createAllPossibleTiles(int row,int col,int altınOranı,int gAltınOranı) {

        //final Map<Integer, Integer> allTileMap = new HashMap<>();
        final int[][] tileMapAll = new int[row][col];

        ArrayList<Integer> altinOlanKareler = new ArrayList<>();
        ArrayList<Integer> gizliAltinOlanKareler = new ArrayList<>();
        int[] altinDegerleri = { 5, 10, 15, 20, -5, -10, -15, -20 };
        int toplamKareSayisi = row * col;
        int altinOlanKareSayisi = (toplamKareSayisi*altınOranı)/100;//oran değişecek
        int gizliAltinOlanKareSayisi = (altinOlanKareSayisi*gAltınOranı)/100;//oran değişecek

        //görünür altın olan karelerin oluşturulması
        for (int i = 0; i < altinOlanKareSayisi; i++) {
            int value = rand.nextInt(toplamKareSayisi);
            
            while(altinOlanKareler.contains(value) || value == 0 || value == toplamKareSayisi-1 || value == row-1 || value == toplamKareSayisi-(row+1)){
                value = rand.nextInt(toplamKareSayisi);
            }
            
            altinOlanKareler.add(value);
            
        }
        System.out.println("cikmamasi gereken yer: "+(toplamKareSayisi-(row+1)));
        // gizli altın olan karelerin oluşturulması
        for (int i = 0; i < gizliAltinOlanKareSayisi; i++) {
            int value = rand.nextInt(toplamKareSayisi);
            
            //eğer o karede zaten altın veya gizli altın varsa gizli altın koymaz
            while(altinOlanKareler.contains(value) || gizliAltinOlanKareler.contains(value) || value == 0 || value == toplamKareSayisi-1 || value == row-1 || value == toplamKareSayisi-(row+1)){
                System.out.println("asd"+value);
                value = rand.nextInt(toplamKareSayisi);
            }
            
            gizliAltinOlanKareler.add(value);

        }

        //altın olan ve gizli altın olan karelerin yerleştirilmesi
        for (int i = 0; i < toplamKareSayisi; i++) {
            
            for(int j = 0; j< altinOlanKareler.size(); j++){

                if(i == altinOlanKareler.get(j)){
                    //allTileMap.put(i,altinDegerleri[rand.nextInt(4)]);
                    tileMapAll[altinOlanKareler.get(j)/row][altinOlanKareler.get(j)%col] = altinDegerleri[rand.nextInt(4)];
                    
                }
                
            }
            for(int k = 0; k<gizliAltinOlanKareler.size(); k++){
                if(i == gizliAltinOlanKareler.get(k)){

                    tileMapAll[gizliAltinOlanKareler.get(k)/row][gizliAltinOlanKareler.get(k)%col] = altinDegerleri[rand.nextInt(4)+4];
                    //allTileMap.put(i,altinDegerleri[rand.nextInt(4)+4]);
                    
                }
                
            }
            
            

        }
        
        return tileMapAll;
    }
    
    public static boolean AltinVarMi(int[][] oyunAlani,int[] koordinat){
        if(oyunAlani[koordinat[0]][koordinat[1]] > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean gizliAltinVarMi(int[][]oyunAlani, int[] koordinat){
        if(oyunAlani[koordinat[0]][koordinat[1]]<0){

            return true;
        }
        else{
            return false;
        }

    }



   

    
}
