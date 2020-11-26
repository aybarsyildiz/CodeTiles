package com.tile.engine.board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.tile.engine.players.Player;

public abstract class Tile
{
    
    static Random rand = new Random();
    
    
    
    //private static final Map<Integer, Integer> ALL_TILES = createAllPossibleTiles(sayi);
    //public static final int[][] TILES_ALL = createAllPossibleTiles(row,col,altınOranı,gAltınOranı);
    
    // hash-map kullanarak board oluşturulması
    public static int[][] createAllPossibleTiles(int row,int col,int altınOranı,int gAltınOranı) 
    {    System.out.println("alın gizli altın"+row+" "+col+" "+altınOranı+" "+gAltınOranı);

        //final Map<Integer, Integer> allTileMap = new HashMap<>();
        final int[][] tileMapAll = new int[row][col];

        ArrayList<Integer> altinOlanKareler = new ArrayList<>();
        ArrayList<Integer> gizliAltinOlanKareler = new ArrayList<>();
        int[] altinDegerleri = { 5, 10, 15, 20, -5, -10, -15, -20 };

        int toplamKareSayisi = row * col;
        int toplamAltın = (toplamKareSayisi*altınOranı)/100;
        int gizliAltinOlanKareSayisi = (toplamAltın*gAltınOranı)/100;
        int altinOlanKareSayisi = toplamAltın-gizliAltinOlanKareSayisi;
        
        System.out.println("altın olan kare sayısı :"+altinOlanKareSayisi);
        System.out.println("gizli altın olan kare sayısı :"+gizliAltinOlanKareSayisi);
        
        //görünür altın olan karelerin oluşturulması
        for (int i = 0; i < altinOlanKareSayisi; i++) {
            int value = rand.nextInt(toplamKareSayisi);
            
            while(altinOlanKareler.contains(value) || value == 0 || value == toplamKareSayisi-1 || value == col-1 || value ==col*(row-1)){
                value = rand.nextInt(toplamKareSayisi);
            }
            
            altinOlanKareler.add(value);
            
        }
        System.out.println("cikmamasi gereken yer: "+(toplamKareSayisi-(row+1)));
        // gizli altın olan karelerin oluşturulması
        for (int i = 0; i < gizliAltinOlanKareSayisi; i++) {
            int value = rand.nextInt(toplamKareSayisi);
            
            //eğer o karede zaten altın veya gizli altın varsa gizli altın koymaz
            while(altinOlanKareler.contains(value) || gizliAltinOlanKareler.contains(value) || value == 0 || value == toplamKareSayisi-1 || value == col-1 || value == col*(row-1)){
                System.out.println("Gizli: "+value);
                value = rand.nextInt(toplamKareSayisi);
            }
            
            gizliAltinOlanKareler.add(value);

        }

        //altın olan ve gizli altın olan karelerin yerleştirilmesi
        for (int i = 0; i < toplamKareSayisi; i++) 
        {
            
            for(int j = 0; j< altinOlanKareler.size(); j++)
            {

                if(i == altinOlanKareler.get(j))
                {
                    //allTileMap.put(i,altinDegerleri[rand.nextInt(4)]);
                    tileMapAll[altinOlanKareler.get(j)/row][altinOlanKareler.get(j)%col] = altinDegerleri[rand.nextInt(4)];
                    
                }
                
            }
            for(int k = 0; k<gizliAltinOlanKareler.size(); k++)
            {
                if(i == gizliAltinOlanKareler.get(k))
                {

                    tileMapAll[gizliAltinOlanKareler.get(k)/row][gizliAltinOlanKareler.get(k)%col] = altinDegerleri[rand.nextInt(4)+4];
                    //allTileMap.put(i,altinDegerleri[rand.nextInt(4)+4]);
                    
                }
                
            } 

        }
        
        return tileMapAll;
    }
    
    public static boolean AltinVarMi(int[][] oyunAlani,int[] koordinat)
    {
        if(oyunAlani[koordinat[0]][koordinat[1]] > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
   
    public static boolean gizliAltinVarMi(int[][]oyunAlani, int[] koordinat)
    {
        if(oyunAlani[koordinat[0]][koordinat[1]]<0)
        {

            return true;
        }
        else
        {
            return false;
        }

    }



   

    
}
