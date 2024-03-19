
package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int value=bar.getValue();
                
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                    
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(30);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel and Tour Management");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.GRAY);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);
        
        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading=new JLabel("loading..");
        loading.setBounds(200,130,150,30);
        loading.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,16));
        add(loading);
        JLabel user=new JLabel("Welcome"+ username);
        user.setBounds(20,310,400,40);
        user.setForeground(Color.BLUE);
        user.setFont(new Font("Tahoma",Font.BOLD,36));
        add(user);
        
        t.start();
        setVisible(true);
        
    }
    public static void main(String[] args){
        new Loading(" ");
    }
    
}
