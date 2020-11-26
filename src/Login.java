import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.tile.engine.board.Tile;


public class Login implements ActionListener{
   
   JFrame loginFrame;
   JLabel rowLabel,colLabel,gRateLabel,sGoldRateLabel,pGoldLabel,moveLabel,aPlayerLabel,aMoveLabel,
   aTargetLabel,bPlayerLabel,bMoveLabel,bTargetLabel,cPlayerLabel,cMoveLabel,cTargetLabel,dPlayerLabel,dMoveLabel,dTargetLabel;
   JTextField rowText,colText,gRateText,sGoldRateText,pGoldText,moveText,aMoveText,aTargetText,
   bMoveText,bTargetText,cMoveText,cTargetText,dMoveText,dTargetText;
   JButton btn;
   
   private static int row=20,col=20,altınOranı=20,gAltınOranı=10,oyuncuAltını=200,move=3;
   private static int aTarget=5,aMove=5;
   private static int bTarget=10,bMove=5;
   private static int cTarget=15,cMove=5;
   private static int dTarget=20,dMove=5;
   
   public Login() {


    loginFrame = new JFrame();
    loginFrame.setSize(500,500);
     
    //satır alan text
     rowText = new JTextField();
     rowText.setBounds(140,20,70,20);
     //sütun alan text
     colText = new JTextField();
     colText.setBounds(140,50,70,20);
     //Altın oranı alan text
     gRateText = new JTextField();
     gRateText.setBounds(140,80,70,20);
     //Gizli altın oranı alan text
     sGoldRateText = new JTextField();
     sGoldRateText.setBounds(140,110,70,20);
     //Oyuncu altını alan text
     pGoldText = new JTextField();
     pGoldText.setBounds(140,140,70,20);
     //Hamle sayısı alan text
     moveText = new JTextField();
     moveText.setBounds(140,170,70,20);
     //A oyuncusu hamle altını alan text
     aMoveText = new JTextField();
     aMoveText.setBounds(140,230,70,20);
     //A oyuncusu hedef belirleme altını alan text
     aTargetText = new JTextField();
     aTargetText.setBounds(140,260,70,20);
     //B oyuncusu hamle altını alan text
     bMoveText = new JTextField();
     bMoveText.setBounds(360,50,70,20);
     //B oyuncusu hedef belirleme altını alan text
     bTargetText = new JTextField();
     bTargetText.setBounds(360,80,70,20);
     //C oyuncusu hamle altını alan text
     cMoveText = new JTextField();
     cMoveText.setBounds(360,140,70,20);
     //C oyuncusu hedef belirleme altını alan text
     cTargetText = new JTextField();
     cTargetText.setBounds(360,170,70,20);
     //D oyuncusu hamle altını alan text
     dMoveText = new JTextField();
     dMoveText.setBounds(360,230,70,20);
     //D oyuncusu hedef belirleme altını alan text
     dTargetText = new JTextField();
     dTargetText.setBounds(360,260,70,20);
     


     rowLabel= new JLabel("Satır:");
     rowLabel.setBounds(40,20,40,20);
     
     colLabel= new JLabel("Sütun:");
     colLabel.setBounds(40,50,50,20);
    
     gRateLabel= new JLabel("Altın oranı:");
     gRateLabel.setBounds(40,80,100,20);
    
     sGoldRateLabel= new JLabel("G.altın oranı:");
     sGoldRateLabel.setBounds(40,110,150,20);
    
     pGoldLabel= new JLabel("Oyuncu Altını:");
     pGoldLabel.setBounds(40,140,150,20);
     
     moveLabel= new JLabel("Adım Sayısı:");
     moveLabel.setBounds(40,170,150,20);
      
     aPlayerLabel= new JLabel("            A oyuncusu:");
     aPlayerLabel.setBounds(40,200,150,20);

     aMoveLabel= new JLabel("Hamle altını:");
     aMoveLabel.setBounds(40,230,150,20);

     aTargetLabel= new JLabel("H.belirleme altını:");
     aTargetLabel.setBounds(40,260,150,20);

     bPlayerLabel= new JLabel("            B oyuncusu:");
     bPlayerLabel.setBounds(250,20,150,20);

     bMoveLabel= new JLabel("Hamle altını:");
     bMoveLabel.setBounds(250,50,150,20);

     bTargetLabel= new JLabel("H.belirleme altını:");
     bTargetLabel.setBounds(250,80,150,20);

     cPlayerLabel= new JLabel("            C oyuncusu:");
     cPlayerLabel.setBounds(250,110,150,20);

     cMoveLabel= new JLabel("Hamle altını:");
     cMoveLabel.setBounds(250,140,150,20);

     cTargetLabel= new JLabel("H.belirleme altını:");
     cTargetLabel.setBounds(250,170,150,20);
     
     dPlayerLabel= new JLabel("            D oyuncusu:");
     dPlayerLabel.setBounds(250,200,150,20);

     dMoveLabel= new JLabel("Hamle altını:");
     dMoveLabel.setBounds(250,230,150,20);

     dTargetLabel= new JLabel("H.belirleme altını:");
     dTargetLabel.setBounds(250,260,150,20);
     
     


     btn= new JButton("Oyun");
     btn.setBounds(320,350,100,50);
     btn.addActionListener(this);
    
    loginFrame.add(rowText);
    loginFrame.add(colText); 
    loginFrame.add(gRateText);
    loginFrame.add(sGoldRateText);
    loginFrame.add(pGoldText);
    loginFrame.add(moveText);
    loginFrame.add(aMoveText);
    loginFrame.add(aTargetText);
    loginFrame.add(bMoveText);
    loginFrame.add(bTargetText);
    loginFrame.add(cMoveText);
    loginFrame.add(cTargetText);
    loginFrame.add(dMoveText);
    loginFrame.add(dTargetText);
    



    loginFrame.add(rowLabel);
    loginFrame.add(colLabel);
    loginFrame.add(gRateLabel);
    loginFrame.add(sGoldRateLabel);
    loginFrame.add(pGoldLabel);
    loginFrame.add(moveLabel);
    loginFrame.add(aPlayerLabel);
    loginFrame.add(aMoveLabel);
    loginFrame.add(aTargetLabel);
    loginFrame.add(bPlayerLabel);
    loginFrame.add(bMoveLabel);
    loginFrame.add(bTargetLabel);
    loginFrame.add(cPlayerLabel);
    loginFrame.add(cMoveLabel);
    loginFrame.add(cTargetLabel);
    loginFrame.add(dPlayerLabel);
    loginFrame.add(dMoveLabel);
    loginFrame.add(dTargetLabel);
    
    
    loginFrame.add(btn);
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setLayout(null);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}

@Override
public  void actionPerformed(ActionEvent e) {
  if(e.getSource()==btn){
    
    try {
      
      this.row = Integer.parseInt(rowText.getText());// Play'e baasınca satır sayısını alıyor
      this.col = Integer.parseInt(colText.getText());// Play'e basınca sütun sayısını alıyor
      this.altınOranı= Integer.parseInt(gRateText.getText());//Play'e basınca altın oranını alıyor
      this.gAltınOranı= Integer.parseInt(sGoldRateText.getText());// Play'e basınca gizli altın oranını alıyor
      this.oyuncuAltını= Integer.parseInt(pGoldText.getText());// Play'e basınca oyuncu altınını alıyor
      this.move = Integer.parseInt(moveText.getText());//Play'e basınca oyuncu hareketini alıyor
      this.aTarget = Integer.parseInt(aTargetText.getText());
      this.bTarget = Integer.parseInt(bTargetText.getText());
      this.cTarget = Integer.parseInt(cTargetText.getText());
      this.dTarget = Integer.parseInt(dTargetText.getText());
      this.aMove = Integer.parseInt(aMoveText.getText());
      this.bMove = Integer.parseInt(bMoveText.getText());
      this.cMove = Integer.parseInt(cMoveText.getText());
      this.dMove = Integer.parseInt(dMoveText.getText());

    } catch (Exception exception) {
      System.out.println("Varsayılan ayarlandı.");
      this.row = 20;
      this.col = 20;
      this.altınOranı=20;
      this.gAltınOranı=10;
      this.oyuncuAltını=200;
      this.move=3;
      this.aTarget =5; 
      this.bTarget =10;
      this.cTarget =15;
      this.dTarget =20;
      this.aMove = 5;
      this.bMove = 5;
      this.cMove = 5;
      this.dMove = 5;
    }
   
   System.out.println(row);
   System.out.println(col);
   System.out.println(altınOranı);
   System.out.println(gAltınOranı);
   System.out.println(move);
   int[][] oyunAlani = Tile.createAllPossibleTiles(row,col,altınOranı,gAltınOranı);
   Game x =new Game(oyunAlani);
   loginFrame.setVisible(false);
  
  }
  
}

public int getRow(){
  return this.row;
}
public int getCol(){
  return this.col;
}
public int getAltınOranı(){
  return this.altınOranı;
}
public int getGizliAltınOranı(){
  return this.gAltınOranı;
}
public int getOyuncuAltını(){
  return this.oyuncuAltını;
}
public int getMove(){
  return this.move;
}
public int getTargetA(){
  return this.aTarget;
}
public int getTargetB(){
  return this.bTarget;
}
public int getTargetC(){
  return this.cTarget;
}
public int getTargetD(){
  return this.dTarget;
}
public int getMoveA(){
  return this.aMove;
}
public int getMoveB(){
  return this.bMove;
}
public int getMoveC(){
  return this.cMove;
}
public int getMoveD(){
  return this.dMove;
}




}
