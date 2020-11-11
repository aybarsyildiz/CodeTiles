import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
   
   
   JLabel t1,t2;
   JTextField tf1,tf2;
   JButton btn;
   
   public Login(){
   
     this.setSize(500,500);
     
     tf1 = new JTextField();
     tf1.setBounds(60,20,100,20);
     tf2 = new JTextField();
     tf2.setBounds(60,50,100,20);
     t1= new JLabel("Satır");
     t2= new JLabel("Sütun");
    
    
   
    t1.setBounds(20,20,40,20);
    t2.setBounds(20,50,50,20);
   
    
    btn= new JButton("Play");
    btn.setBounds(320,350,100,50);
    btn.addActionListener(this);
    
     
    
    this.add(tf2);
    this.add(btn);
    this.add(t1);
    this.add(t2);
  
    
    
    
    this.add(tf1);
    
       
     
       
    
    
    
    this.setLocationRelativeTo(null);
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
   




}

@Override
public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btn){
   int a = Integer.parseInt(tf1.getText());
   int b = Integer.parseInt(tf2.getText());
   System.out.println(a);
   System.out.println(b);
  }

}




}
