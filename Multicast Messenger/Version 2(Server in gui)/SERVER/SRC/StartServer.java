import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextArea;
import java.net.ServerSocket;

public class StartServer implements Runnable{
Socket s;
ServerSocket ss;
ArrayList al,un;
JTextArea display;

StartServer(Socket s,ServerSocket ss,ArrayList al,ArrayList un,JTextArea display){
this.s=s;
this.ss=ss;
this.al=al;
this.un=un;
this.display=display;
}

public void run(){
try{
while(true){
s = ss.accept();
al.add(s);
display.append("\n"+s.toString()+"in joining");
Runnable r = new ServerThread(s,al,un,display);
Thread t = new Thread(r);
t.start();
}
}catch(Exception e){display.append("\nStartServer1"+e.toString());}



}


}

 