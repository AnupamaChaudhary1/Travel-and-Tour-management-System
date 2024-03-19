
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
       setBounds(600,200,500,550);
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);
       
       JLabel l1=new JLabel("About");
       l1.setBounds(200,10,100,40);
       l1.setForeground(Color.PINK);
       l1.setFont(new Font("Tahome",Font.BOLD,20));
       add(l1);
      
       String s="About Project\n"+
               "\n"+
               "The purpose of Travel and Tour Management system is to develop a system useful in planning a tour and journey. This system is desktop based using which users can take details, view destinations and reserve their travel."+
               "\n"+
               "This system will help in finding the destinations of interest within the less time saving the time and efforts."+
               "\n"+
               "Deliverables:\n"+
               "Provides exact information\n"+
               "Simplifies the mannual system\n"+
               "Detail can be provided\n"+
               "Most reliable";
       
       
               
       
       
       TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
       area.setEditable(false);
       area.setBounds(20,100,450,300);
       add(area);
       
       back=new JButton("Back");
       back.setBounds(200,420,100,25);
       back.addActionListener(this);
       add(back);
       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
        setVisible(false);
        }
    }
    public static void main(String[] args){
        new About();
    }
    
}
