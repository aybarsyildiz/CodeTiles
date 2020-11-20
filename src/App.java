import com.tile.engine.board.Move;
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
        


    }
    
}
