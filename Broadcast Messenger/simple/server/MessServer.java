import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.DataInputStream;


public class MessServer{

ArrayList al = new ArrayList();
ArrayList un = new ArrayList();

ServerSocket ss;
Socket s;

public MessServer(){

try{
ss = new ServerSocket(9);

System.out.println("SERVER STARTED ... \n");

while(true){
s = ss.accept();
al.add(s);
System.out.println(s+"in joining");
Runnable r = new ServerThread(s,al,un);
Thread t = new Thread(r);
t.start();
}
}catch(Exception e){System.out.println("scene7"+e);}
}

public static void main(String ... arg){
new MessServer();
}
}


