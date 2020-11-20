import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import com.tile.engine.board.Tile;
import com.tile.engine.players.*;
import java.util.TimerTask;
import java.util.Timer;
import com.tile.engine.players.A_oyuncusu;
import com.tile.engine.players.B_oyuncusu;
import com.tile.engine.board.Move;

public  class Game {
    
    public Game(int[][] oyunAlani){
      
      
       
      try {
        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
     } catch (Exception e) {
                e.printStackTrace();
     }
     
    JFrame gameFrame;
    JPanel panel;
    

    
    
    Login y = new Login();
    int row =y.getRow();//loginden alınan satır sayısını alma
    int col =y.getCol();//loginden alınan sütun sayısını alma
    int oyuncuAltını=y.getOyuncuAltını();
    int[] aKoordinatlari = {0,0};
    int[] bKoordinatlari = {0,col-1};
    int[] cKoordinatlari = {row-1,0};
    int[] dKoordinatlari = {row-1,col-1};
    Player aOyuncusu = new Player(aKoordinatlari,oyuncuAltını);
    Player bOyuncusu = new Player(bKoordinatlari,oyuncuAltını);
    Player cOyuncusu = new Player(cKoordinatlari,oyuncuAltını);
    
    Btn[][] board = new Btn [row][col];
     
      gameFrame = new JFrame("Gold Game");
      gameFrame.setSize(1500,1000);
      panel= new JPanel();
      panel.setBounds(100,150,1000,600); 
      panel.setLayout(new GridLayout(row,col));
     
   
    for (int i=0;i<row;i++){
         for(int j=0;j<col;j++){
            
            
            
            Btn bt= new Btn(i,j);
            int[] koordinat = {i,j};
             bt.setBackground(Color.WHITE);
             bt.setOpaque(true);
             bt.setBorderPainted(true);
             if(Tile.AltinVarMi(oyunAlani, koordinat)){
                bt.setBackground(Color.YELLOW);
                bt.setText(Integer.toString(oyunAlani[i][j]));
                bt.altınEkle(oyunAlani[i][j]);
                //bt.setBorderPainted(false);
             }
             if(Tile.gizliAltinVarMi(oyunAlani, koordinat)){
                 bt.setBackground(Color.GRAY);
                 bt.setBorderPainted(false);
             }
             if(i==aKoordinatlari[0] && j==aKoordinatlari[1]){
                 bt.setText("A");
             }
             if(i == bKoordinatlari[0] && j == bKoordinatlari[1]){
                 bt.setText("B");
             }
             if(i == cKoordinatlari[0] && j == cKoordinatlari[1]){
                 bt.setText("C");
             }
             if(i== dKoordinatlari[0] && j == dKoordinatlari[1]){
                 bt.setText("D");
             }
            
             
             panel.add(bt);
             
            
             board[i][j]=bt;
         }
     }

    gameFrame.add(panel);
    
    
    
    
    
    
    
    
    
    
    gameFrame.setLocationRelativeTo(null);
    gameFrame.setLayout(null);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setVisible(true);
    
    
    //////////////////////////////////////////////// oyun
    int[] oyunAlaniBoyutu = {row,col};
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            System.out.print(oyunAlani[i][j]+" ");
        }
        System.out.println("\n");

     }
   
     
     Timer timer = new Timer();
     // A OYUNCU TIMERİ
     TimerTask aOyuncu = new TimerTask(){
      @Override
      public void run(){
        //int[][] hedefAlinanKareler = new int[2][3];
        /*
            hedef alınan kareler:
            0 0 --> A'nın hedef aldığı kare
            0 0 --> B'nin hedef aldığı kare
            0 0 --> C'nin hedef aldığı kare

            D oyuncusu hedef belirlerken bunları kontrol eder,
            hedef aldığı kare eğer buradaki karelerle çakışıyorsa
            o kareyi hedef almaz.

        */
         if (aOyuncusu.hedefVarm() == false) {
            aOyuncusu.altinGuncelle(-5);
            aOyuncusu.hedefKontrol(true);
            System.out.println("a oyuncusu altın:"+aOyuncusu.altinSayisi);
        }
        
         int[] aEnYakinKoordinatlar = A_oyuncusu.enYakinAltiniBul(oyunAlani,aOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu);
         System.out.println("altın konumu:" +aEnYakinKoordinatlar[0]+" "+aEnYakinKoordinatlar[1]);
         
        
         int[] kordinat =Move.yeniKordinat(aOyuncusu.suAnkiKoordinat(),aEnYakinKoordinatlar);
         System.out.println("oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
         
         aOyuncusu.koordinatlariGuncelle(kordinat);
         System.out.println("a son hamle :"+Move.sonHamle());
         aOyuncusu.altinGuncelle(Move.sonHamle()*(-5));
         System.out.println("+a oyuncusu altın:"+aOyuncusu.altinSayisi);
         board[kordinat[0]][kordinat[1]].setText("A");
         try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        board[kordinat[0]][kordinat[1]].setText(" ");

        
         if(kordinat[0]==aEnYakinKoordinatlar[0] && kordinat[1]==aEnYakinKoordinatlar[1]){
              oyunAlani[kordinat[0]][kordinat[1]]=0;
              board[kordinat[0]][kordinat[1]].setText("A");
              board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
              aOyuncusu.hedefKontrol(false);
              System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
              aOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
              try{
                  Thread.sleep(1000);
              }
              catch(InterruptedException ex){
                  Thread.currentThread().interrupt();
              }
              board[kordinat[0]][kordinat[1]].setText(" ");
        }
    
    
    
    
        if(aOyuncusu.altinSayisi<=0){
        System.out.println("A oyuncusu elendi");
        timer.cancel();
    }
    
    }
    // B OYUNCU TIMERİ
    };
    TimerTask bOyuncu = new TimerTask(){
        @Override
        public void run(){
            if (bOyuncusu.hedefVarm() == false) {
                bOyuncusu.altinGuncelle(-10);
                bOyuncusu.hedefKontrol(true);
                System.out.println("b oyuncusu altın:"+bOyuncusu.altinSayisi);
            }
            int[] bEnHesapliKoordinatlar = B_oyuncusu.enHesapliAltiniBul(oyunAlani,bOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu);
            System.out.println("altın konumu:" +bEnHesapliKoordinatlar[0]+" "+bEnHesapliKoordinatlar[1]);
         
            int[] kordinat =Move.yeniKordinat(bOyuncusu.suAnkiKoordinat(),bEnHesapliKoordinatlar);
            System.out.println("b oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
            
            bOyuncusu.koordinatlariGuncelle(kordinat);
            System.out.println("b son hamle :"+Move.sonHamle());
            bOyuncusu.altinGuncelle(Move.sonHamle()*(-5));
            System.out.println("+b oyuncusu altın:"+bOyuncusu.altinSayisi);
            board[kordinat[0]][kordinat[1]].setText("B");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            board[kordinat[0]][kordinat[1]].setText(" ");

            if(kordinat[0]==bEnHesapliKoordinatlar[0] && kordinat[1]==bEnHesapliKoordinatlar[1]){
                oyunAlani[kordinat[0]][kordinat[1]]=0;
                board[kordinat[0]][kordinat[1]].setText("B");
                board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
                bOyuncusu.hedefKontrol(false);
                System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
                bOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                board[kordinat[0]][kordinat[1]].setText(" ");
          }
      
      
      
      
          if(bOyuncusu.altinSayisi<=0){
          System.out.println("B oyuncusu elendi");
          timer.cancel();
            }
    
            
        }

    };
    //C OYUNCUSU TIMERİ
    TimerTask cOyuncu = new TimerTask(){
        @Override
        public void run(){
            if (cOyuncusu.hedefVarm() == false) {
                cOyuncusu.altinGuncelle(-15);
                cOyuncusu.hedefKontrol(true);
                System.out.println("c oyuncusu altın:"+cOyuncusu.altinSayisi);
            }
            int[] cEnHesapliKoordinatlar = C_oyuncusu.enHesapliAltiniBul(oyunAlani,cOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu);
            System.out.println("altın konumu:" +cEnHesapliKoordinatlar[0]+" "+cEnHesapliKoordinatlar[1]);
         
            int[] kordinat =Move.yeniKordinat(cOyuncusu.suAnkiKoordinat(),cEnHesapliKoordinatlar);
            System.out.println("c oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
            
            cOyuncusu.koordinatlariGuncelle(kordinat);
            System.out.println("c son hamle :"+Move.sonHamle());
            cOyuncusu.altinGuncelle(Move.sonHamle()*(-5));
            System.out.println("+c oyuncusu altın:"+cOyuncusu.altinSayisi);
            board[kordinat[0]][kordinat[1]].setText("C");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            board[kordinat[0]][kordinat[1]].setText(" ");

            if(kordinat[0]==cEnHesapliKoordinatlar[0] && kordinat[1]==cEnHesapliKoordinatlar[1]){
                oyunAlani[kordinat[0]][kordinat[1]]=0;
                board[kordinat[0]][kordinat[1]].setText("C");
                board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
                cOyuncusu.hedefKontrol(false);
                System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
                //eğer gizli altınsa + ya çevirip ekleyecek
                if(board[kordinat[0]][kordinat[1]].kordinatAltını() < 0){
                    cOyuncusu.altinSayisi -= board[kordinat[0]][kordinat[1]].kordinatAltını();
                }
                else{
                    cOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
                }
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                board[kordinat[0]][kordinat[1]].setText(" ");
          }
      
      
      
      
          if(cOyuncusu.altinSayisi<=0){
          System.out.println("B oyuncusu elendi");
          timer.cancel();
            }
    
            




        }
    };

    timer.schedule(aOyuncu,0,1000);
    timer.schedule(bOyuncu, 0, 1000);
    timer.schedule(cOyuncu, 0, 1000);


    
    
    }

   


}
