import com.tile.engine.players.Player;
import java.util.Scanner;
import com.tile.engine.board.Tile;
public class App {
    public static void main(String[] args) throws Exception {

        Tile tileCreated;
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
