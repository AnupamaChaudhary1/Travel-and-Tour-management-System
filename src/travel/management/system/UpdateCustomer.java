
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCustomer extends JFrame implements ActionListener {
   
    //JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfid,tfgender,labelusername,labelname;
    //JRadioButton rmale,rfemale;
    JButton add,back;
    UpdateCustomer(String username){
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Update Customer Details");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername=new JTextField(username);
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        /*comboid=new JComboBox(new String[] {"Passport","Citizenship","StudentId"});
        comboid.setBounds(220,90,150,25);
        add(comboid); */
        
       tfid=new JTextField();
       tfid.setBounds(220,90,150,25);
       add(tfid); 
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname=new JTextField();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        /*
        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale); */
        tfgender=new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender); 
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(220,370,150,25);
        add(tfphone);
        
        add=new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,90,450,300);
        add(image);
        /*
        try{
            Conn c= new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from customer where username='username'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }*/
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        String username = labelusername.getText();
        String id = tfid.getText();
        String number = tfnumber.getText();
        String name = labelname.getText();
        String gender =tfgender.getText(); //(rmale.isSelected()) ? "Male" : "Female"; // Assuming radio buttons for gender

        String country = tfcountry.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();

        if (username.isEmpty() || id.isEmpty() || number.isEmpty() || name.isEmpty() || gender.isEmpty() || country.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Conn c = new Conn();
            String query = "UPDATE customer SET id='" + id + "', number='" + number + "', name='" + name + "', gender='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "' WHERE username='" + username + "'";
            int rowsUpdated = c.stmt.executeUpdate(query);

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Customer Update successful");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update customer", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        setVisible(false);
    }
}

    
    /*
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=tfid.getText();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=tfgender.getText();
            
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            
            try{
                Conn c=new Conn();
                 String query = "UPDATE customer SET id='" + id + "', number='" + number + "', name='" + name + "', gender='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "' WHERE username='" + username + "'";
                //String query="UPDATE customer SET username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                c.stmt.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Update successful");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    } */
    public static void main(String[] args){
        new UpdateCustomer("abcd");
    }
    
}

