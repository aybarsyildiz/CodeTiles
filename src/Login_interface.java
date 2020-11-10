import java.awt.*;  
import javax.swing.*;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Login_interface {
   JFrame login;
   JLabel t1,t2,t3,t4,t5,t6,t7;
   Login_interface(){
    login = new JFrame("Login");
    login.setSize(500,500);
    t1= new JLabel("Kalem");
    t2= new JLabel("Kalem");
    t3= new JLabel("Kalem");
    t4= new JLabel("Kalem");
    t5= new JLabel("Kalem");
    t6= new JLabel();
    
    t4.setBackground(Color.red);
    t1.setBounds(20,20,50,20);
    t2.setBounds(20,50,50,20);
    t3.setBounds(20,80,50,20);
    t4.setBounds(20,110,50,20);
    t5.setBounds(20,140,50,20);
    login.add(t1);
    login.add(t2);
    login.add(t3);
    login.add(t4);
    login.add(t5);
    
    login.add(t6);
    
    login.setLocationRelativeTo(null);
    login.setLayout(null);
    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    login.setVisible(true);
   }

}
