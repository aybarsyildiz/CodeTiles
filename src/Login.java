import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Login implements ActionListener{
   
   JFrame loginFrame;
   JLabel t1,t2;
   JTextField tf1,tf2;
   JButton btn,btn2;
   private  int row=5,col=5;
   
   public Login(){
    loginFrame = new JFrame();
    loginFrame.setSize(700,700);
     tf1 = new JTextField();
     tf1.setBounds(60,20,100,20);
     tf2 = new JTextField();
     tf2.setBounds(60,50,100,20);
     t1= new JLabel("Satır");
     t2= new JLabel("Sütun");
     t1.setBounds(20,20,40,20);
     t2.setBounds(20,50,50,20);
   
    
    btn= new JButton("Sayıları yazdır");
    btn.setBounds(270,350,200,50);
    btn.addActionListener(this);
    
    btn2= new JButton("Oyun");
    btn2.setBounds(320,300,100,50);
    btn2.addActionListener(this);
    
    loginFrame.add(btn2);
    loginFrame.add(tf2);
    loginFrame.add(btn);
    loginFrame.add(t1);
    loginFrame.add(t2);
    loginFrame.add(tf1);
  
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setLayout(null);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   




}

@Override
public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btn){
   this.row = Integer.parseInt(tf1.getText());
   this.col = Integer.parseInt(tf2.getText());
   System.out.println(row);
   System.out.println(col);
   
  
  }
  if(e.getSource()==btn2){
    Game x =new Game();
    loginFrame.setVisible(false);

  }
}
public int getRow(){
  return this.row;
}
public int getCol(){
  return this.col;
}


}
