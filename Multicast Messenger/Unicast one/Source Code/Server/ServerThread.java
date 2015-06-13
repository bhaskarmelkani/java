import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerThread implements Runnable,ActionListener{

Socket s;
ServerSocket ss;
DataInputStream din;
DataOutputStream dout;
JTextArea ta1;
JTextField ta3,ta2;

ServerThread(JTextArea ta1,JTextField ta2,JTextField ta3){
this.ta1=ta1;
this.ta2=ta2;
this.ta3=ta3;
ta3.addActionListener(this);
}

public void run(){
try{
ss = new ServerSocket(5001);
ta1.append("SERVER STARTED ... \n");
ta1.append("WAITING FOR CLIENT ... \n");


s = ss.accept();
dout = new DataOutputStream(s.getOutputStream());
ta1.append("CLIENT CONNECTED \n");
Runnable r = new ServerThread1(s,ta1,ta3);
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



