
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonDetails,seePersonDetails,updatePersonalDetails,checkpackage,bookpackage,viewpackage;
    JButton viewhotels,destinations,bookhotel,viewbookedhotel,exit,payments,notepad,about,deletePersonDetails;
    Dashboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,60);
        p1.setLayout(null);
        add(p1);
       
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,55,300,900);
        p2.setLayout(null);
        add(p2);
        
        addPersonDetails=new JButton("Add Personal Details");
        addPersonDetails.setBounds(0,0,300,40);
        addPersonDetails.setBackground(new Color(0,0,102));
        addPersonDetails.setForeground(Color.WHITE);
        addPersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonDetails.setMargin(new Insets(0,0,0,60));
        addPersonDetails.addActionListener(this);
        p2.add(addPersonDetails);
        
        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,40,300,40);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        seePersonDetails=new JButton("See Details");
        seePersonDetails.setBounds(0,80,300,40);
        seePersonDetails.setBackground(new Color(0,0,102));
        seePersonDetails.setForeground(Color.WHITE);
        seePersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        seePersonDetails.setMargin(new Insets(0,0,0,140));
        seePersonDetails.addActionListener(this);
        p2.add(seePersonDetails);
        
        deletePersonDetails=new JButton("Delete Details");
        deletePersonDetails.setBounds(0,120,300,40);
        deletePersonDetails.setBackground(new Color(0,0,102));
        deletePersonDetails.setForeground(Color.WHITE);
        deletePersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonDetails.setMargin(new Insets(0,0,0,115));
        deletePersonDetails.addActionListener(this);
        p2.add(deletePersonDetails);
        
        checkpackage=new JButton("Check Package");
        checkpackage.setBounds(0,160,300,40);
        checkpackage.setBackground(new Color(0,0,102));
        checkpackage.setForeground(Color.WHITE);
        checkpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackage.setMargin(new Insets(0,0,0,105));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);
        
        bookpackage=new JButton("Book Package");
        bookpackage.setBounds(0,200,300,40);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage.setMargin(new Insets(0,0,0,112));
        bookpackage.addActionListener(this);                                                
        p2.add(bookpackage);
        
        viewpackage=new JButton("View Package");
        viewpackage.setBounds(0,240,300,40);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.setMargin(new Insets(0,0,0,112));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        viewhotels=new JButton("View Hotels");
        viewhotels.setBounds(0,280,300,40);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,125));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBounds(0,320,300,40);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.addActionListener(this);
        bookhotel.setMargin(new Insets(0,0,0,133));
        p2.add(bookhotel);
        
        viewbookedhotel=new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0,360,300,40);
        viewbookedhotel.setBackground(new Color(0,0,102));
        viewbookedhotel.setForeground(Color.WHITE);
        viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotel.addActionListener(this);
        viewbookedhotel.setMargin(new Insets(0,0,0,60));
        p2.add(viewbookedhotel);
        
        destinations=new JButton("Destinations");
        destinations.setBounds(0,400,300,40);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments=new JButton("Payments");
        payments.setBounds(0,440,300,40);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,141));
        payments.addActionListener(this);
        p2.add(payments);
        
        notepad=new JButton("Notepad");
        notepad.setBounds(0,480,300,40);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,160));
        notepad.addActionListener(this);
        p2.add(notepad);       
        
        about=new JButton("About");
        about.setBounds(0,520,300,40);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,190));
        about.addActionListener(this);
        p2.add(about);
      
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/Travel-Wallpaper.jpg"));
        Image i5=i4.getImage().getScaledInstance(1400,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1400,1000);
        add(image);
        
        JLabel text=new JLabel("Travel and Tour Management System");
        text.setBounds(350,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.PLAIN,60));
        image.add(text);
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonDetails){
            new AddCustomer();
        }else if(ae.getSource()==seePersonDetails){
            new ViewCustomer();
        }else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer("sita");
        }else if(ae.getSource()==checkpackage){
            new CheckPackage();
        }else if(ae.getSource()==bookpackage){
            new BookPackage();
        }else if(ae.getSource()==viewpackage){
            new ViewPackage();
        }
        else if(ae.getSource()==viewhotels){
            new CheckHotels();
        }else if(ae.getSource()==destinations){
            new Destinations();
        }else if(ae.getSource()==bookhotel){
            new BookHotel("Anupama1");
        }else if(ae.getSource()==viewbookedhotel){
            new ViewBookedHotel();
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==deletePersonDetails){
            new DeleteDetail("sita");
        }
        
        
    }
    public static void main(String[] args){
        new Dashboard("");
    }
    
}
