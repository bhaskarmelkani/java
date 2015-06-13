import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextArea;


public class ServerThread implements Runnable{
Socket s;
ArrayList al,un;
JTextArea display;

ServerThread(Socket s,ArrayList al,ArrayList un,JTextArea display){
this.s=s;
this.al=al;
this.un=un;
this.display=display;
}

public void run(){
String s1,s2,s3;
try{
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());

do{
s1=din.readUTF();
if(s1.length()<13){
display.append("\n"+s1.toString());
tellEveryOne(s1);
}

else {
s2=s1.substring(0,13);

if(s2.equals("@#$qz56pm@#$+")){
s3=s1.substring(13,s1.length());
un.add(s3);
display.append("\nusers="+un.toString());

Iterator i = un.iterator();
String sr="@#$qz90pm@#$*";
while(i.hasNext()){
sr = sr +" "+(String)i.next()+"\n";
}
tellEveryOne(sr);
display.append("\nonline users  : "+sr);
}


else if(s2.equals("@#$qz56pm@#$-")){
s3=s1.substring(13,s1.length());
int inx=un.indexOf(s3);
un.remove(inx);
al.remove(inx);
display.append("\nusers="+un);
Iterator i = un.iterator();
String sr="@#$qz90pm@#$*";
while(i.hasNext()){
sr = sr + " "+(String)i.next()+"\n";
}
tellEveryOne(sr);
display.append("\n online users  : "+sr);
}

else
display.append("\n"+s1);
tellEveryOne(s1);
}


}while(true);
}catch(Exception e){display.append("\nServerThread1"+e.toString());}
}

public void tellEveryOne(String s1){
Iterator i = al.iterator();
while(i.hasNext()){
try{
Socket sc = (Socket)i.next();
DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
dout.writeUTF(s1);
dout.flush();
}
catch(Exception e){display.append("\nServerThread2"+e.toString());}
}
}
}

 