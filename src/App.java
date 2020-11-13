import com.tile.engine.players.Player;
import java.util.Scanner;
import com.tile.engine.board.Tile;
import com.tile.engine.players.A_oyuncusu;
import com.tile.engine.players.B_oyuncusu;
public class App {
    public static void main(String[] args) throws Exception {
        Login login= new Login();
        login.loginFrame.setVisible(true);




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
        
        
        
    }
}
