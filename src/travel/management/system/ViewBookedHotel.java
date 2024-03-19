

package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back,get;
    JTextField labelusername;
    JLabel labelid, labelnumber,labelprice,labelpackage,labelphone,labelperson,labelfood,labelac,labeldays;
    ViewBookedHotel(){
      setBounds(400,200,600,550);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel text=new JLabel("View Booked Hotel Detail");
      text.setFont(new Font("Tahoma",Font.BOLD,20));
      text.setBounds(60,0,300,30);
      
      JLabel lblusername=new JLabel("Username");
      lblusername.setBounds(30,50,150,25);
      add(lblusername);
      labelusername=new JTextField();
      labelusername.setBounds(220,50,150,25);
      add(labelusername);
      
      JLabel lblid=new JLabel("Hotel Name");
      lblid.setBounds(30,90,150,25);
      add(lblid);
      labelpackage=new JLabel();
      labelpackage.setBounds(220,90,150,25);
      add(labelpackage);
      
      JLabel lblnumber=new JLabel("Total Person");
      lblnumber.setBounds(30,130,150,25);
      add(lblnumber);
      labelperson=new JLabel();
      labelperson.setBounds(220,130,150,25);
      add(labelperson);
      
      JLabel lbldays=new JLabel("Total Days");
      lbldays.setBounds(30,170,150,25);
      add(lbldays);
       labeldays=new JLabel();
      labeldays.setBounds(220,170,150,25);
      add(labeldays);
      
      JLabel lblac=new JLabel("AC/NO-AC");
      lblac.setBounds(30,210,150,25);
      add(lblac);
      labelac=new JLabel();
      labelac.setBounds(220,210,150,25);
      add(labelac);
      
      JLabel lblfood=new JLabel("Food Included");
      lblfood.setBounds(30,250,150,25);
      add(lblfood);
      labelfood=new JLabel();
      labelfood.setBounds(220,250,150,25);
      add(labelfood);
      
      JLabel lblname=new JLabel("Id");
      lblname.setBounds(30,290,150,25);
      add(lblname);
      labelid=new JLabel();
      labelid.setBounds(220,290,150,25);
      add(labelid);
      
      JLabel lblgender=new JLabel("Number");
      lblgender.setBounds(30,330,150,25);
      add(lblgender);
      labelnumber=new JLabel();
      labelnumber.setBounds(220,330,150,25);
      add(labelnumber);
      
      JLabel lblcountry=new JLabel("Phone");
      lblcountry.setBounds(30,370,150,25);
      add(lblcountry);
      labelphone=new JLabel();
      labelphone.setBounds(220,370,150,25);
      add(labelphone);
      
      JLabel lbladdress=new JLabel("Total Price");
      lbladdress.setBounds(30,410,150,25);
      add(lbladdress);
      labelprice=new JLabel();
      labelprice.setBounds(220,410,150,25);
      add(labelprice);
      
      get=new JButton("Get");
      get.setBackground(Color.BLACK);
      get.setForeground(Color.WHITE);
      get.setBounds(240,460,100,25);
      get.addActionListener(this);
      add(get);
      
      back=new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setBounds(130,460,100,25);
      back.addActionListener(this);
      add(back);
      
     // try{
       //   Conn conn=new Conn();
         // String query="select*from bookhotel where username='"+username+"'";
          //ResultSet rs=conn.stmt.executeQuery(query);
          //while(rs.next()){
            //  labelusername.setText(rs.getString("username"));
              //labelid.setText(rs.getString("id"));
              //labelnumber.setText(rs.getString("number"));
              //labelpackage.setText(rs.getString("name"));
              //labelprice.setText(rs.getString("price"));
              //labelphone.setText(rs.getString("phone"));
              //labelperson.setText(rs.getString("person"));
              //labelfood.setText(rs.getString("food"));
              //labelac.setText(rs.getString("ac"));
              //labeldays.setText(rs.getString("days"));
              
              
        //  }
      //}catch(Exception e){
        //  e.printStackTrace();
      //}
      setVisible(true);
    }       
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == get){
            try{
               String query="select * from bookhotel where username= '"+labelusername.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery(query);
                while(rs.next()){
                   
                
                   labelusername.setText(rs.getString("username"));
                   labelid.setText(rs.getString("id"));
              labelnumber.setText(rs.getString("number"));
              labelpackage.setText(rs.getString("name"));
              labelprice.setText(rs.getString("price"));
              labelphone.setText(rs.getString("phone"));
              labelperson.setText(rs.getString("person"));
              labelfood.setText(rs.getString("food"));
              labelac.setText(rs.getString("ac"));
              labeldays.setText(rs.getString("days"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }    
            else{
        setVisible(false);
        }
    }
    public static void main(String[] args){
        new ViewBookedHotel();
    }
    
}
