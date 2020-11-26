import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.io.*;

import javax.annotation.processing.FilerException;
import javax.swing.*;
import com.tile.engine.board.Tile;
import com.tile.engine.players.*;



import java.util.TimerTask;
import java.util.Timer;



import com.tile.engine.board.Move;

public  class Game {
    
    private int altınSayısı;
    private int gizliAltınSayısı;

    public Game(int[][] oyunAlani){
      
      

      try {
        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
     } catch (Exception e) {
                e.printStackTrace();
     }
     
    JFrame gameFrame;
    JPanel panel;
    JLabel a,b,c,d,aSkor,bSkor,cSkor,dSkor;

    
    
    Login y = new Login();
    int row =y.getRow();//loginden alınan satır sayısını alma
    int col =y.getCol();//loginden alınan sütun sayısını alma
    int move=y.getMove();//loginden alınan hareket sayısını alma
    int oyuncuAltını=y.getOyuncuAltını();
    int aTarget =y.getTargetA(); 
    int bTarget =y.getTargetB();;
    int cTarget =y.getTargetC();;
    int dTarget =y.getTargetD();;
    int aMove = y.getMoveA();
    int bMove = y.getMoveB();;
    int cMove = y.getMoveC();;
    int dMove = y.getMoveD();;
    int altınOranı= y.getAltınOranı();
    int gAltınOranı = y.getGizliAltınOranı();
    int tümAltın = (row*col)*altınOranı/100;
    gizliAltınSayısı = tümAltın*gAltınOranı/100;
    altınSayısı=tümAltın-gizliAltınSayısı;
    
    


    int[] aKoordinatlari = {0,0};
    int[] bKoordinatlari = {0,col-1};
    int[] cKoordinatlari = {row-1,0};
    int[] dKoordinatlari = {row-1,col-1};
    Player aOyuncusu = new Player(aKoordinatlari,oyuncuAltını);
    Player bOyuncusu = new Player(bKoordinatlari,oyuncuAltını);
    Player cOyuncusu = new Player(cKoordinatlari,oyuncuAltını);
    Player dOyuncusu = new Player(dKoordinatlari,oyuncuAltını);
    
    Btn[][] board = new Btn [row][col];
     
      gameFrame = new JFrame("Gold Game");
      gameFrame.setSize(1500,1000);
      panel= new JPanel();
      panel.setBounds(100,150,1000,600); 
      panel.setLayout(new GridLayout(row,col));
      
      //Skorboard
      a= new JLabel("A altını:");
      a.setBounds(1200,150,80,20);
      b= new JLabel("B altını:");
      b.setBounds(1200,170,80,20);
      c= new JLabel("C altını:");
      c.setBounds(1200,190,80,20);
      d= new JLabel("D altını:");
      d.setBounds(1200,210,80,20);
     
      aSkor= new JLabel("");
      aSkor.setBounds(1280,150,80,20);
      aSkor.setText(Integer.toString(oyuncuAltını));
      bSkor= new JLabel("");
      bSkor.setBounds(1280,170,80,20);
      bSkor.setText(Integer.toString(oyuncuAltını));
      cSkor= new JLabel("");
      cSkor.setBounds(1280,190,80,20);
      cSkor.setText(Integer.toString(oyuncuAltını));
      dSkor= new JLabel("");
      dSkor.setBounds(1280,210,80,20);
      dSkor.setText(Integer.toString(oyuncuAltını));
      //Skorboard 
      
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
             /*
             if(Tile.gizliAltinVarMi(oyunAlani, koordinat)){
                 bt.setBackground(Color.GRAY);
                 bt.setBorderPainted(false);
             }
             */
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
    gameFrame.add(a);
    gameFrame.add(b);
    gameFrame.add(c);
    gameFrame.add(d);
    gameFrame.add(aSkor);
    gameFrame.add(bSkor);
    gameFrame.add(cSkor);
    gameFrame.add(dSkor);
       
    gameFrame.setLocationRelativeTo(null);
    gameFrame.setLayout(null);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setVisible(true);
    
    
    //////////////////////////////////////////////// Oyun
    int[] oyunAlaniBoyutu = {row,col};
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            System.out.print(oyunAlani[i][j]+" ");
        }
        System.out.println("\n");

     }
   
     int [][] altınHedefleri = new int[3][4];
     
     Timer timer = new Timer();
     Timer timerb = new Timer();
     Timer timerc = new Timer();
     Timer timerd = new Timer();

     // A OYUNCU TIMERİ
     TimerTask aOyuncu = new TimerTask(){
      @Override
      public void run(){
        if(altınSayısı==0 && gizliAltınSayısı==0){
            System.out.println("Altınlar bitti");
            timer.cancel();

        }
        else if(aOyuncusu.altinSayisi<=0){
            System.out.println("A oyuncusu elendi");
            timer.cancel();
              }
       
       else{
        if(aOyuncusu.hedefVarm() == true){
             
            int[] hedef =aOyuncusu.getHedef();
            if(oyunAlani[hedef[0]][hedef[1]]==0){
                System.out.println("A yeni hedef belirledi");
                aOyuncusu.hedefKontrol(false);
             }

        }

         if (aOyuncusu.hedefVarm() == false) {
            System.out.println("a oyuncusu altın:"+aOyuncusu.altinSayisi);
            aOyuncusu.altinGuncelle(-aTarget);
            aOyuncusu.hedefKontrol(true);
            System.out.println("a oyuncusu altın:"+aOyuncusu.altinSayisi);
            int[] aEnYakinKoordinatlar = A_oyuncusu.enYakinAltiniBul(oyunAlani,aOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu);
            aOyuncusu.setHedef(aEnYakinKoordinatlar);
        }
        int hedef []=aOyuncusu.getHedef();
         
         System.out.println("altın konumu:" +hedef[0]+" "+hedef[1]);
         altınHedefleri[0][0] = hedef[0];
         altınHedefleri[0][1] = hedef[1];
        
         int[] kordinat =Move.yeniKordinat(aOyuncusu.suAnkiKoordinat(),aOyuncusu.getHedef(),move);
         System.out.println("oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
         altınHedefleri[0][2] = kordinat[0];
         altınHedefleri[0][3] = kordinat[1];
        
         aOyuncusu.koordinatlariGuncelle(kordinat);
         System.out.println("a son hamle :"+Move.sonHamle());
         aOyuncusu.altinGuncelle(Move.sonHamle()*(-aMove));
         System.out.println("a oyuncusu altın:"+aOyuncusu.altinSayisi);
         board[kordinat[0]][kordinat[1]].setText("A");
       /*  try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }*/
        board[kordinat[0]][kordinat[1]].setText(" ");

        
         if(kordinat[0]==hedef[0] && kordinat[1]==hedef[1]){
              oyunAlani[kordinat[0]][kordinat[1]]=0;
              altınSayısı=altınSayısı-1;
              System.out.println("+altın sayısı:"+altınSayısı);
              board[kordinat[0]][kordinat[1]].setText("A");
              board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
              aOyuncusu.hedefKontrol(false);
              System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
              aOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
              aSkor.setText(Integer.toString(aOyuncusu.altinSayisi));
              System.out.println("a oyuncusu altın(altın aldı):"+aOyuncusu.altinSayisi);
              /*try{
                  Thread.sleep(1000);
              }
              catch(InterruptedException ex){
                  Thread.currentThread().interrupt();
              }*/
              board[kordinat[0]][kordinat[1]].setText(" ");
        }
    
    
        
    
       
       }
    }  
    };
    
    // B OYUNCU TIMERİ
    TimerTask bOyuncu = new TimerTask(){
        @Override
        public void run(){
            if(altınSayısı==0 && gizliAltınSayısı==0){
                System.out.println("Altınlar bitti");
                timerb.cancel();
    
            }
            else if(bOyuncusu.altinSayisi<=0){
                System.out.println("B oyuncusu elendi");
                timerb.cancel();
                  }
           
           else{
            
            if(bOyuncusu.hedefVarm() == true){
                int[] hedef =bOyuncusu.getHedef();
                if(oyunAlani[hedef[0]][hedef[1]]==0){
                   System.out.println("B yeni hedef belirledi");
                   bOyuncusu.hedefKontrol(false);
                }
   
           }
            
            
            if (bOyuncusu.hedefVarm() == false) {
                System.out.println("b oyuncusu altın:"+bOyuncusu.altinSayisi);
                bOyuncusu.altinGuncelle(-bTarget);
                bOyuncusu.hedefKontrol(true);
                System.out.println("b oyuncusu altın:"+bOyuncusu.altinSayisi);
                int[] bEnHesapliKoordinatlar = B_oyuncusu.enHesapliAltiniBul(oyunAlani,bOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu);
                bOyuncusu.setHedef(bEnHesapliKoordinatlar);

            }
            int[] hedef = bOyuncusu.getHedef();
            System.out.println("altın konumu:" +hedef[0]+" "+hedef[1]);
            altınHedefleri[1][0] = hedef[0];
            altınHedefleri[1][1] = hedef[1];

            int[] kordinat =Move.yeniKordinat(bOyuncusu.suAnkiKoordinat(),bOyuncusu.getHedef(),move);
            System.out.println("b oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
           
            altınHedefleri[1][2] = kordinat[0];
            altınHedefleri[1][3] = kordinat[1];
            
            bOyuncusu.koordinatlariGuncelle(kordinat);
            System.out.println("b son hamle :"+Move.sonHamle());
            bOyuncusu.altinGuncelle(Move.sonHamle()*(-bMove));
            System.out.println("+b oyuncusu altın:"+bOyuncusu.altinSayisi);
            board[kordinat[0]][kordinat[1]].setText("B");
           /* try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }*/
            board[kordinat[0]][kordinat[1]].setText(" ");

            if(kordinat[0]==hedef[0] && kordinat[1]==hedef[1]){
                oyunAlani[kordinat[0]][kordinat[1]]=0;
                altınSayısı=altınSayısı-1;
                System.out.println("altın sayısı:"+altınSayısı);
                board[kordinat[0]][kordinat[1]].setText("B");
                board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
                bOyuncusu.hedefKontrol(false);
                System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
                bOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
                bSkor.setText(Integer.toString(bOyuncusu.altinSayisi));
                System.out.println("b oyuncusu altın(altın aldı):"+aOyuncusu.altinSayisi);
                /*try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }*/
                board[kordinat[0]][kordinat[1]].setText(" ");
          }
      
          
      
      
          
        }
            
        }

    };
    
    //C OYUNCUSU TIMERİ
    TimerTask cOyuncu = new TimerTask(){
        @Override
        public void run(){
            if(altınSayısı==0 && gizliAltınSayısı==0){
                System.out.println("Altınlar bitti");
                timerc.cancel();
    
            }
            else if(cOyuncusu.altinSayisi<=0){
                System.out.println("C oyuncusu elendi");
                timerc.cancel();
                  }
           
           else{ 
            if(aOyuncusu.hedefVarm() == true){
             
                int[] hedef =cOyuncusu.getHedef();
                if(oyunAlani[hedef[0]][hedef[1]]==0){
                    System.out.println("C yeni hedef belirledi");
                    aOyuncusu.hedefKontrol(false);
                 }
    
            }
           
           
            if (cOyuncusu.hedefVarm() == false) {
                System.out.println("c oyuncusu altın:"+cOyuncusu.altinSayisi);
                cOyuncusu.altinGuncelle(-cTarget);
                cOyuncusu.hedefKontrol(true);
                System.out.println("c oyuncusu altın:"+cOyuncusu.altinSayisi);
                int[] bEnHesapliKoordinatlar = C_oyuncusu.enHesapliAltiniBul(oyunAlani,cOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu);
                cOyuncusu.setHedef(bEnHesapliKoordinatlar);
            }
            
            int[] hedef = bOyuncusu.getHedef();
            System.out.println("altın konumu:" +hedef[0]+" "+hedef[1]);
            altınHedefleri[2][0] = hedef[0];
            altınHedefleri[2][1] = hedef[1];


            int[] kordinat =Move.yeniKordinat(cOyuncusu.suAnkiKoordinat(),bOyuncusu.getHedef(),move);
            System.out.println("c oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
            
            altınHedefleri[2][2] = kordinat[0];
            altınHedefleri[2][3] = kordinat[1];

            cOyuncusu.koordinatlariGuncelle(kordinat);
            System.out.println("c son hamle :"+Move.sonHamle());
            cOyuncusu.altinGuncelle(Move.sonHamle()*(-cMove));
            System.out.println("+c oyuncusu altın:"+cOyuncusu.altinSayisi);
            board[kordinat[0]][kordinat[1]].setText("C");
           /* try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }*/
            board[kordinat[0]][kordinat[1]].setText(" ");

            if(kordinat[0]==hedef[0] && kordinat[1]==hedef[1]){
                oyunAlani[kordinat[0]][kordinat[1]]=0;
                System.out.println("c altın (altın aldı)"+cOyuncusu.altinSayisi);
                altınSayısı=altınSayısı-1;
                board[kordinat[0]][kordinat[1]].setText("C");
                board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
                cOyuncusu.hedefKontrol(false);
                System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
                //eğer gizli altınsa + ya çevirip ekleyecek
                if(board[kordinat[0]][kordinat[1]].kordinatAltını() < 0){
                    cOyuncusu.altinSayisi -= board[kordinat[0]][kordinat[1]].kordinatAltını();
                    cSkor.setText(Integer.toString(cOyuncusu.altinSayisi));
                }
                else{
                    cOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
                    cSkor.setText(Integer.toString(cOyuncusu.altinSayisi));
                }
               /* try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }*/
                board[kordinat[0]][kordinat[1]].setText(" ");
          }
      
      
      
      
          
              }
       
    
            




        }
    };
//D OYUNCUSU TIMERİ


TimerTask dOyuncu = new TimerTask(){
    @Override
    public void run(){
        if(altınSayısı==0 && gizliAltınSayısı==0){
            System.out.println("Altınlar bitti");
            timerd.cancel();

        }
        else if(dOyuncusu.altinSayisi<=0){
            System.out.println("D oyuncusu elendi");
            timerd.cancel();
              }
       
       else{
        
        if(dOyuncusu.hedefVarm() == true){
            int[] hedef =dOyuncusu.getHedef();
            if(oyunAlani[hedef[0]][hedef[1]]==0){
               System.out.println("D yeni hedef belirledi");
               dOyuncusu.hedefKontrol(false);
            }

       }

        
        
        if (dOyuncusu.hedefVarm() == false) {
            System.out.println("d oyuncusu altın:"+dOyuncusu.altinSayisi);
            dOyuncusu.altinGuncelle(-dTarget);
            dOyuncusu.hedefKontrol(true);
            System.out.println("d oyuncusu altın:"+dOyuncusu.altinSayisi);
            int[] dEnHesapliKoordinatlar = D_oyuncusu.enHesapliAltiniBul(oyunAlani,dOyuncusu.suAnkiKoordinat(),oyunAlaniBoyutu,altınHedefleri);
            bOyuncusu.setHedef(dEnHesapliKoordinatlar);
        }
        
        int[] hedef = dOyuncusu.getHedef();
        System.out.println("altın konumu:" +hedef[0]+" "+hedef[1]);
        

        int[] kordinat =Move.yeniKordinat(dOyuncusu.suAnkiKoordinat(), dOyuncusu.getHedef(),move);
        System.out.println("d oyuncu konumu"+ kordinat[0]+" "+kordinat[1]);
       
        
        
        dOyuncusu.koordinatlariGuncelle(kordinat);
        System.out.println("d son hamle :"+Move.sonHamle());
        dOyuncusu.altinGuncelle(Move.sonHamle()*(-dMove));
        System.out.println("+d oyuncusu altın:"+dOyuncusu.altinSayisi);
        board[kordinat[0]][kordinat[1]].setText("B");
       /* try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }*/
        board[kordinat[0]][kordinat[1]].setText(" ");

        if(kordinat[0]==hedef[0] && kordinat[1]==hedef[1]){
            oyunAlani[kordinat[0]][kordinat[1]]=0;
            System.out.println("d altın (altın aldı)"+dOyuncusu.altinSayisi);
            altınSayısı=altınSayısı-1;
            board[kordinat[0]][kordinat[1]].setText("D");
            board[kordinat[0]][kordinat[1]].setBackground(Color.WHITE);
            dOyuncusu.hedefKontrol(false);
            System.out.println("altın"+board[kordinat[0]][kordinat[1]].kordinatAltını());
            dOyuncusu.altinSayisi+=board[kordinat[0]][kordinat[1]].kordinatAltını();
            dSkor.setText(Integer.toString(dOyuncusu.altinSayisi));
           /* try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }*/
            board[kordinat[0]][kordinat[1]].setText(" ");
        }
      
     }
      

        
    }

};


    timer.schedule(aOyuncu,0,4000);
    timerb.schedule(bOyuncu, 1000, 4000);
    timerc.schedule(cOyuncu, 2000, 4000);
    timerd.schedule(dOyuncu, 3000, 4000);
    
    }

   


}
