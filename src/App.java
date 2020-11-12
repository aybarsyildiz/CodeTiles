import com.tile.engine.players.Player;
import java.util.Scanner;
import com.tile.engine.board.Tile;
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
        int[][] oyunAlani = new int[tileSayisi][tileSayisi];
        
        oyunAlani = Tile.createAllPossibleTiles(tileSayisi);
        
        for (int i = 0; i < tileSayisi; i++) {

            for (int j = 0; j < tileSayisi; j++) {
                System.out.print(oyunAlani[i][j]+" ");
            }
            System.out.print("\n");
        }
        
        
        
        
    }
}
