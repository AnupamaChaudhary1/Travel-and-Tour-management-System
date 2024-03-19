package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetail extends JFrame implements ActionListener {
    JButton back, get;
    String username;
    JLabel labelid, labelname, labelnumber, labelgender, labeladdress, labelphone, labelcountry, labelemail;
    JTextField labelusername;

    DeleteDetail(String username) {
        this.username = username;
        setBounds(450, 150, 870, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        labelusername = new JTextField();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);
        labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 280, 150, 25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);
        labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 110, 150, 25);
        add(lbladdress);
        labeladdress = new JLabel();
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 170, 150, 25);
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 270, 150, 25);
        add(lblemail);
        labelemail = new JLabel();
        labelemail.setBounds(690, 270, 150, 25);
        add(labelemail);

        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        get = new JButton("Get");
        get.setBackground(Color.BLACK);
        get.setForeground(Color.WHITE);
        get.setBounds(460, 350, 100, 25);
        get.addActionListener(this);
        add(get);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == get) {
            try {
                 Conn c = new Conn();
                String query = "SELECT * FROM customer WHERE username='" + labelusername.getText() + "'";
               
                ResultSet rs = c.stmt.executeQuery(query);
                if (rs.next()) {
                    labelid.setText(rs.getString("id"));
                    labelnumber.setText(rs.getString("number"));
                    labelname.setText(rs.getString("name"));
                    labelgender.setText(rs.getString("gender"));
                    labelcountry.setText(rs.getString("country"));
                    labeladdress.setText(rs.getString("address"));
                    labelphone.setText(rs.getString("phone"));
                    labelemail.setText(rs.getString("email"));
                } else {
                    JOptionPane.showMessageDialog(null, "No record found for the provided username", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == back) {
            try {
                Conn c = new Conn();
                int rows1 = c.stmt.executeUpdate("DELETE FROM account WHERE username='" + username + "'");
                int rows2 = c.stmt.executeUpdate("DELETE FROM customer WHERE username='" + username + "'");
                int rows3 = c.stmt.executeUpdate("DELETE FROM bookpackage WHERE username='" + username + "'");
                int rows4 = c.stmt.executeUpdate("DELETE FROM bookhotel WHERE username='" + username + "'");

                if (rows1 > 0 || rows2 > 0 || rows3 > 0 || rows4 > 0) {
                    JOptionPane.showMessageDialog(null, "Details deleted!!");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No records found for the provided username", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new DeleteDetail("sita");
    }
}



/*package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetail extends JFrame implements ActionListener {
    JButton back, get;
    String username;
    JLabel labelid, labelname, labelnumber, labelgender, labeladdress, labelphone, labelcountry, labelemail;
    JTextField labelusername;

    DeleteDetail(String username) {
        this.username = username;
        setBounds(450, 150, 870, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        labelusername = new JTextField();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);
        labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 280, 150, 25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);
        labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 110, 150, 25);
        add(lbladdress);
        labeladdress = new JLabel();
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 170, 150, 25);
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 270, 150, 25);
        add(lblemail);
        labelemail = new JLabel();
        labelemail.setBounds(690, 270, 150, 25);
        add(labelemail);

        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        get = new JButton("Get");
        get.setBackground(Color.BLACK);
        get.setForeground(Color.WHITE);
        get.setBounds(460, 350, 100, 25);
        get.addActionListener(this);
        add(get);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == get) {
        try {
            String query = "SELECT * FROM customer WHERE username='" + labelusername.getText() + "'";
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery(query);
            if (rs.next()) {
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "No record found for the provided username", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (ae.getSource() == back) {
        try {
            Conn c = new Conn();
            int rows1 = c.stmt.executeUpdate("DELETE FROM account WHERE username='" + username + "'");
            int rows2 = c.stmt.executeUpdate("DELETE FROM customer WHERE username='" + username + "'");
            int rows3 = c.stmt.executeUpdate("DELETE FROM bookpackage WHERE username='" + username + "'");
            int rows4 = c.stmt.executeUpdate("DELETE FROM bookhotel WHERE username='" + username + "'");

            if (rows1 > 0 || rows2 > 0 || rows3 > 0 || rows4 > 0) {
                JOptionPane.showMessageDialog(null, "Details deleted!!");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No records found for the provided username", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    public static void main(String[] args) {
        new DeleteDetail("abcd");
    }
}
*/

