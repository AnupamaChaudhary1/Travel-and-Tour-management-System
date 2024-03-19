
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,signup,forget;
    JTextField tuname,tpass;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel luname=new JLabel("Username");
        luname.setBounds(60,20,100,25);
        luname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(luname);
        tuname=new JTextField();
        tuname.setBounds(60,60,200,30);
        p2.add(tuname);
        
        JLabel lpass=new JLabel("Password");
        lpass.setBounds(60,100,100,25);
        lpass.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lpass);
        tpass=new JTextField();
        tpass.setBounds(60,130,200,30);
        p2.add(tpass);
        
        login=new JButton("login");
        login.setBounds(60,175,90,30);
        login.addActionListener(this);
        p2.add(login);
        
        signup=new JButton("signup");
        signup.setBounds(160,175,90,30);
        signup.addActionListener(this);
        p2.add(signup);
        
        forget=new JButton("ForgetPassword");
        forget.setBounds(100,215,150,30);
        forget.addActionListener(this);
        p2.add(forget);
        
        JLabel text=new JLabel("Login Problem");
        text.setBounds(100,250,150,20);
        p2.add(text);
        setVisible(true);        
        
    } 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
                String username=tuname.getText();
                String password=tpass.getText();
                String query="select*from account where username='"+username+"' AND password='"+password+"'";
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"incorresct username of password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
            
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
