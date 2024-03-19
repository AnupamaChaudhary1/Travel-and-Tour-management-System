
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays,labelusername,labelid,labelnumber,labelphone;
    String username;
    JLabel labelprice;
    JButton checkprice,bookpackage,back;
    BookHotel(String username){
        this.username=username;
        setBounds(300,150,1000,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Book Hotel");
        
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblusername.setBounds(40,70,100,20);
      add(lblusername);
      labelusername=new JTextField();
      labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
      labelusername.setBounds(250,70,200,20);
      add(labelusername);
      
      JLabel lblpackage=new JLabel("Select Hotel");
      lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblpackage.setBounds(40,110,150,20);
      add(lblpackage);
      
      chotel=new  Choice();
      
      chotel.setBounds(250,110,200,20);
      add(chotel);
      
      try{
         Conn c=new Conn();
         ResultSet rs=c.stmt.executeQuery("select*from hotel");
         while(rs.next()){
             chotel.add(rs.getString("name"));
         }
      }catch(Exception e){
          e.printStackTrace();
      }
      
      JLabel lblperson=new JLabel("Total People");
      lblperson.setBounds(40,150,150,25);
      lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
      add(lblperson);
      tfperson=new JTextField("1");
      tfperson.setBounds(250,150,200,25);
      add(tfperson);
      
      JLabel lbldays=new JLabel("No of days");
      lbldays.setBounds(40,190,150,25);
      lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
      add(lbldays);
      tfdays=new JTextField("1");
      tfdays.setBounds(250,190,200,25);
      add(tfdays);
      
      JLabel lblac=new JLabel("AC/ NO AC");
      lblac.setBounds(40,230,150,25);
      lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
      add(lblac);
      
      cac=new Choice();
      cac.add("AC");
      cac.add("NO AC");
      cac.setBounds(250,230,200,20);
      add(cac);
      
      JLabel lblfood=new JLabel("Food Selected");
      lblfood.setBounds(40,270,150,25);
      lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
      add(lblfood);
      
      cfood=new Choice();
      cfood.add("Yes");
      cfood.add("No");
      cfood.setBounds(250,270,200,20);
      add(cfood);
      
      JLabel lblid=new JLabel("Id");
      lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblid.setBounds(40,310,150,20);
      add(lblid);
      labelid=new JTextField();
      labelid.setBounds(250,310,200,25);
      add(labelid);
      
      JLabel lblnumber=new JLabel("Number");
      lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblnumber.setBounds(40,350,150,25);
      add(lblnumber);
      labelnumber=new JTextField();
      labelnumber.setBounds(250,350,150,25);
      add(labelnumber);
      
      JLabel lblphone=new JLabel("Phone");
      lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblphone.setBounds(40,390,150,25);
      add(lblphone);
      labelphone=new JTextField();
      labelphone.setBounds(250,390,150,25);
      add(labelphone);
      
      JLabel lblprice=new JLabel("Total Price");
      lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
      lblprice.setBounds(40,430,150,25);
      add(lblprice);
      labelprice=new JLabel();
      labelprice.setBounds(250,430,150,25);
      add(labelprice);
        
      try{
          Conn conn=new Conn();
          String query="select*from customer where username='"+username+"'";
          ResultSet rs=conn.stmt.executeQuery(query);
          while(rs.next()){
              labelusername.setText(rs.getString("username"));
              labelid.setText(rs.getString("id"));
              labelnumber.setText(rs.getString("number"));
              
              labelphone.setText(rs.getString("phone"));
              
      checkprice=new JButton("Check Price");
      checkprice.setBackground(Color.BLACK);
      checkprice.setForeground(Color.WHITE);
      checkprice.setBounds(60,490,120,25);
      checkprice.addActionListener(this);
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      
      add(checkprice);
      
      bookpackage=new JButton("Book Hotel");
      bookpackage.setBackground(Color.BLACK);
      bookpackage.setForeground(Color.WHITE);
      bookpackage.setBounds(200,490,120,25);
      bookpackage.addActionListener(this);
      add(bookpackage);
      
      back=new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setBounds(340,490,120,25);
      back.addActionListener(this);
      add(back);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
    Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel l12=new JLabel(i3);
    l12.setBounds(500,50,600,300);
    add(l12);
      
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select*from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                //int cost=Integer.parseInt("costperperson");
                //int ac=Integer.parseInt("acroom");
                //int food=Integer.parseInt("foodincluded");
                
                int cost = rs.getInt("costperperson");
                int ac = rs.getInt("acroom");
                int food = rs.getInt("foodincluded");
                
                
                int person=Integer.parseInt(tfperson.getText());
                int days=Integer.parseInt(tfdays.getText());
                
                String acselected=cac.getSelectedItem();
                String foodselected=cfood.getSelectedItem();
                
                if(person*days>0){
                    int total =0;
                    total+=acselected.equals("AC")?ac:0;
                    total+=foodselected.equals("Yes")?food:0;
                    total+=cost;
                    total=total*person*days;
                    
                    labelprice.setText("Rs" + total);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Enter valid number");
                }
            }
           
        
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c=new Conn();
                c.stmt.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem() +"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"' )");
                JOptionPane.showMessageDialog(null,"Hotel Booked");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);               
        }
    }
    public static void main(String[] args){
        new BookHotel("Anupama1");
    }
    
}
