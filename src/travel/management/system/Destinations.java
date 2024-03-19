
package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable{
    Thread t1;
    JLabel l1,l2,l3,l4,l5;
    JLabel[] label=new JLabel[]{l1,l2,l3,l4,l5};
    JLabel caption;
    
    public void run(){
        String[] text=new String[]{"EverGreen hotel","Seasore Hotel","Travist Motel","Everest Hotel","Top To Hotel"};
        try{
            for(int i=0;i<=4;i++){
                label[i].setVisible(true);
                
                Thread.sleep(3000);
                label[i].setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    Destinations(){
      setBounds(500,100,800,600);
      
      caption=new JLabel();
      caption.setBounds(50,500,1000,70);
      caption.setFont(new Font("Tahoma",Font.PLAIN,25));
      caption.setForeground(Color.WHITE);
      add(caption);
      
      ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null;
      ImageIcon[] image=new ImageIcon[]{i1,i2,i3,i4,i5};
      
      
      Image j1=null,j2=null,j3=null,j4=null,j5=null;
      Image[] jimage=new Image[]{j1,j2,j3,j4,j5};
      
      ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null;
      ImageIcon[] kimage=new ImageIcon[]{k1,k2,k3,k4,k5};
      
      for(int i=0;i<=4;i++){
      
      image[i]=new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
      jimage[i] =image[i].getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
      kimage [i]=new ImageIcon(jimage[i]);
      label[i]=new JLabel(kimage[i]);
      label[i].setBounds(0,0,800,600);
      add(label[i]);
      
      }
      
      t1=new Thread(this);
      t1.start();
      
      setVisible(true);
    }
    public static void main(String[] args){
        new Destinations();
        
    }
    
}
