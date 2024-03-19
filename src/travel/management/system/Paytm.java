
package travel.management.system;
import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    JButton back;
    Paytm(){
       setBounds(500,200,800,600);
       
       JEditorPane pane=new JEditorPane();
       pane.setEditable(false);
        try{
            pane.setPage("https://khalti.com/");
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Cannot load,error 4048</html>");
        }
        
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);
        
        back=new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payment();
    }
    public static void main(String[] args){
        new Paytm();
    }
}
