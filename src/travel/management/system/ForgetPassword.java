package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tuname,tname,tpass,tqs,tanswer;
    JButton search,retrieve,back;
    Choice tsecurity;
    ForgetPassword(){
        setBounds(350,200,550,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel luname=new JLabel("Username");
        luname.setFont(new Font("Tahome",Font.BOLD,14));
        luname.setBounds(50,20,125,25);
        p1.add(luname);
        tuname=new JTextField();
        tuname.setBounds(190,20,180,25);
        p1.add(tuname);
        
        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lname=new JLabel("Name");
        lname.setFont(new Font("Tahome",Font.BOLD,14));
        lname.setBounds(50,60,125,25);
        p1.add(lname);
        tname=new JTextField();
        tname.setBounds(190,60,180,25);
        p1.add(tname);
        
       // JLabel lqs=new JLabel("Sequirity Question");
        //lqs.setBounds(50,90,125,25);
        //p1.add(lqs);
        //tqs=new JTextField();
        //tqs.setBounds(190,90,200,25);
        //p1.add(tqs);
        
        JLabel lqs=new JLabel("Security Question");
        lqs.setFont(new Font("Tahome",Font.BOLD,14));
        lqs.setBounds(50,90,125,25);
        p1.add(lqs);
        tsecurity=new Choice();
        tsecurity.add("Fav movie");
        tsecurity.add("Fav color");
        tsecurity.setBounds(190,95,180,25);
        p1.add(tsecurity);
        
        JLabel lanswer=new JLabel("Answer");
        lanswer.setBounds(50,140,180,25);
        p1.add(lanswer);
        tanswer=new JTextField();
        tanswer.setBounds(190,140,200,25);
        p1.add(tanswer);
        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        
        JLabel lpass=new JLabel("Password");
        lpass.setFont(new Font("Tahome",Font.BOLD,14));
        lpass.setBounds(50,180,125,25);
        p1.add(lpass);
        tpass=new JTextField();
        tpass.setBounds(190,180,180,25);
        p1.add(tpass);
        
        
        
        
        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200,220,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query="select * from account where username= '"+tuname.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery(query);
                while(rs.next()){
                    tname.setText(rs.getString("name"));
                    tqs.setText(rs.getString("security"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource()== retrieve){
            try{
                String query="select * from account where answer='"+tanswer.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery(query);
                while(rs.next()){
                    tpass.setText(rs.getString("password"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
            new Login();
        }
    
        
    }
    
    public static void main(String[] args){
        new ForgetPassword();
    }
    
}
