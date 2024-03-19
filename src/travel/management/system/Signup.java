package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField t,tname,tpass,tanswer;
    Choice tsecurity;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        JLabel l=new JLabel("Username");
        l.setFont(new Font("Tahome",Font.BOLD,30));
        l.setBounds(50,20,200,25);
        p1.add(l);
        t=new JTextField();
        t.setBounds(190,20,300,25);
        p1.add(t);
        JLabel lname=new JLabel("Name");
        lname.setFont(new Font("Tahome",Font.BOLD,14));
        lname.setBounds(50,60,125,25);
        p1.add(lname);
        tname=new JTextField();
        tname.setBounds(190,60,180,25);
        p1.add(tname);
        
        JLabel lpass=new JLabel("Password");
        lpass.setFont(new Font("Tahome",Font.BOLD,14));
        lpass.setBounds(50,95,125,25);
        p1.add(lpass);
        tpass=new JTextField();
        tpass.setBounds(190,95,180,25);
        p1.add(tpass);
        
        JLabel lsecurity=new JLabel("Security Question");
        lsecurity.setFont(new Font("Tahome",Font.BOLD,14));
        lsecurity.setBounds(50,130,125,25);
        p1.add(lsecurity);
        tsecurity=new Choice();
        tsecurity.add("Fav movie");
        tsecurity.add("Fav color");
        tsecurity.setBounds(190,130,180,25);
        p1.add(tsecurity);
        JLabel lanswer=new JLabel("Answer");
        lanswer.setFont(new Font("Tahome",Font.BOLD,14));
        lanswer.setBounds(50,170,125,25);
        p1.add(lanswer);
        tanswer=new JTextField();
        tanswer.setBounds(190,170,180,25);
        p1.add(tanswer);
        
        
        
        
        create=new JButton("Create");
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(100,220,100,25);
        create.addActionListener(this);
        p1.add(create);
        back=new JButton("Back");
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(230,220,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(480,50,250,250);
        add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String username=t.getText();
            String name=tname.getText();
            String security=tsecurity.getSelectedItem();
            String answer=tanswer.getText();
            String password=tpass.getText();
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
            try{
                Conn c=new Conn();
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Successful");
                new Loading("");
                setVisible(false);
                 
                
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }                                       
        else if(ae.getSource()==back){
            setVisible(false);
            new Login();            
        }
        
    }
    public static void main(String[] args){
    new Signup();
    }
    
}
