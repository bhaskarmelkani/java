import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClientThread implements Runnable,ActionListener{

Socket s;
ServerSocket ss;
DataInputStream din;
DataOutputStream dout;
JTextArea ta1;
JTextField ta3,ta2,ta4;

ClientThread(JTextArea ta1,JTextField ta2,JTextField ta3,JTextField ta4){
this.ta1=ta1;
this.ta2=ta2;
this.ta3=ta3;
this.ta4=ta4;
ta3.addActionListener(this);
}

public void run(){
try{

String ip=ta4.getText();
s = new Socket(ip,5001);
dout = new DataOutputStream(s.getOutputStream());
ta1.setText("CONNECTED \n");
Runnable r = new ClientThread1(s,ta1,ta3);
Thread t = new Thread(r);
t.start();

}catch(Exception e){System.out.println("scene7"+e);}
}

public void actionPerformed(ActionEvent e){

if(e.getSource()==ta3){
try{

String tt = ta3.getText();
String us = ta2.getText();
 dout.writeUTF(us+" : "+tt);
 ta3.setText("");
 ta1.append(us+" : "+tt+"\n");
}catch(Exception e1){System.out.println("scene1"+e);}
}


}

}



