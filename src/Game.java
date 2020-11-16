import java.awt.*;  
import javax.swing.*;
import com.tile.engine.board.Tile;
import com.tile.engine.players.*;





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
    System.out.println(col);
    System.out.println(row);

    int[] aKoordinatlari = {0,0};
    int[] bKoordinatlari = {0,col-1};
    int[] cKoordinatlari = {row-1,0};
    int[] dKoordinatlari = {row-1,col-1};
    Player aOyuncusu = new Player(aKoordinatlari,200);
    Player bOyuncusu = new Player(bKoordinatlari,200);

    Btn[][] board = new Btn [row][col];
     
      gameFrame = new JFrame("Gold Game");
      gameFrame.setSize(1500,1000);
      panel= new JPanel();
      panel.setBounds(100,150,50*row,600); 
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

    

    
    }

   


}
