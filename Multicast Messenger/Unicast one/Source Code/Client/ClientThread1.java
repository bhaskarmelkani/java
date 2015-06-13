import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientThread1 implements Runnable {
Socket s;
JTextArea ta1;
JTextField ta3;

ClientThread1(Socket s,JTextArea ta1,JTextField ta3){
this.s=s;
this.ta1=ta1;
this.ta3=ta3;
}

public void run(){
String s1,s2,s3;
try{
DataInputStream din = new DataInputStream(s.getInputStream());

do{
s1=din.readUTF();
ta1.append(s1+"\n");
}while(true);
}catch(Exception e){System.out.println("scene5"+e);}
}
}

 