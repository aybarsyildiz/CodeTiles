import java.awt.*;  
import javax.swing.*;
import com.tile.engine.board.Tile;





public  class Game {
    
    JFrame gameFrame;
    JPanel panel;
    
   public Game(int[][] oyunAlani){
    Login y = new Login();
    int row =y.getRow();//loginden alınan satır sayısını alma
    int col =y.getCol();//loginden alınan sütun sayısını alma
    System.out.println(col);
    System.out.println(row);
    Btn[][] board = new Btn [row][col];
     
      gameFrame = new JFrame("Gold Game");
      gameFrame.setSize(1500,1000);
      panel= new JPanel();
      panel.setBounds(100,150,600,600); 
      panel.setLayout(new GridLayout(row,col));
     
   
    for (int i=0;i<row;i++){
         for(int j=0;j<col;j++){
             Btn bt= new Btn(i,j);
             int[] koordinat = {i,j};
             bt.setOpaque(true);
             if(Tile.AltinVarMi(oyunAlani, koordinat)){
                bt.setBackground(Color.YELLOW);
                bt.setText(Integer.toString(oyunAlani[i][j]));
             }
             if(Tile.gizliAltinVarMi(oyunAlani, koordinat)){
                 bt.setBackground(Color.GRAY);
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
