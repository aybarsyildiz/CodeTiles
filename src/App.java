import com.tile.engine.board.Move;
import com.tile.engine.players.Player;
import java.util.Scanner;
import com.tile.engine.board.Tile;
import com.tile.engine.players.A_oyuncusu;
import com.tile.engine.players.B_oyuncusu;
public class App {
    public static void main(String[] args) throws Exception {
        // ilk iki oyuncu kordinat 2. si altın kordinatı
       
        
        Login login= new Login();
        login.loginFrame.setVisible(true);

        Tile tileCreated;
        int[] aCoordinat = {0,0};
        
        //Oyuncuların hareket etmeleri vs bu şekilde olacak.
        Player aOyuncusu = new Player(aCoordinat,200);
        int[] oyunAlaniBoyutu = {20,20};
        int[][] oyunAlani = Tile.createAllPossibleTiles(20,20,20,10);
        int[] aEnYakinKoordinatlar = A_oyuncusu.enYakinAltiniBul(oyunAlani, aCoordinat,oyunAlaniBoyutu);
        while(aOyuncusu.altinSayisi>0){
             
            int[] aYeniKoordinatlar = aOyuncusu.koordinatlariGuncelle(aEnYakinKoordinatlar);
            aOyuncusu.altinGuncelle(5);
            oyunAlani[aEnYakinKoordinatlar[0]][aEnYakinKoordinatlar[1]]=0;
            System.out.println("yeni altın sayısı: "+aOyuncusu.altinSayisi);
            System.out.println("a oyuncusu yeni koordinatlari: "+aYeniKoordinatlar[0]+" "+aYeniKoordinatlar[1]);
            aEnYakinKoordinatlar = A_oyuncusu.enYakinAltiniBul(oyunAlani, aCoordinat,oyunAlaniBoyutu);
        }
        

/* TEST
        Tile tileCreated;
        int[] aCoordinat = {0,0};
        
        //Oyuncuların hareket etmeleri vs bu şekilde olacak.
        Player aOyuncusu = new Player(aCoordinat);
        
        int[] aOyuncusununKoordinatlari = aOyuncusu.playerPosition;
        System.out.println("A oyuncusunun sahip olduğu konum: "+aOyuncusu.playerPosition[0]+" "+aOyuncusu.playerPosition[1]);
        aOyuncusununKoordinatlari[0] += 1;
        aOyuncusu.koordinatlariGuncelle(aOyuncusununKoordinatlari);
        System.out.println("A oyuncusunun bir sağ birime hareket ettiğindeki konumu: "+aOyuncusu.playerPosition[0]+" "+aOyuncusu.playerPosition[1]);
        
        Scanner scn = new Scanner(System.in);
        int tileSayisi = scn.nextInt();
        int[] bCoordinat = {tileSayisi-1,0};
        Player bOyuncusu = new Player(bCoordinat);
        int[][] oyunAlani = new int[tileSayisi][tileSayisi];
        
        oyunAlani = Tile.createAllPossibleTiles(tileSayisi);
        
        for (int i = 0; i < tileSayisi; i++) {

            for (int j = 0; j < tileSayisi; j++) {
                System.out.print(oyunAlani[i][j]+" ");
            }
            System.out.print("\n");
        }
        
        int[] enYakinAltinKoordinatlariA = A_oyuncusu.enYakinAltiniBul(oyunAlani, aOyuncusu.playerPosition, tileSayisi);
        //[1] x koordinatı [0] y koordinatı niye bilmiyom
        System.out.println("A oyuncusuna en yakın altının koordinatları: "+enYakinAltinKoordinatlariA[1]+" "+enYakinAltinKoordinatlariA[0]);
        int[] enHesapliAltinKoordinatlariB = B_oyuncusu.enHesapliAltiniBul(oyunAlani, bOyuncusu.playerPosition, tileSayisi);
        System.out.println("B oyuncusu için en hesaplı altın koordinatları: "+ enHesapliAltinKoordinatlariB[0]+" "+enHesapliAltinKoordinatlariB[1]);
        
        
       */ 
    }
    
}
