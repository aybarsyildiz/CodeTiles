import java.awt.*;  
import javax.swing.*; 

public  class Game_interface {
  
   int a=5,b=5;
    JFrame game;
    JPanel panel;
    Btn[][] board = new Btn [a][b];
   
   public Game_interface(){
      game = new JFrame("Gold Game");
      game.setSize(1500,1000);
      panel= new JPanel();
      panel.setBounds(100,150,700,700); 
      panel.setLayout(new GridLayout(a,b));
     
   
    for (int i=0;i<a;i++){
         for(int j=0;j<b;j++){
             Btn bt= new Btn(i,j);
             panel.add(bt);
             board[i][j]=bt;
         }
     }

    game.add(panel);
    
    
    
    
    
    
    
    
    
    
    game.setLocationRelativeTo(null);
    game.setLayout(null);
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setVisible(true);


    }

   


}
