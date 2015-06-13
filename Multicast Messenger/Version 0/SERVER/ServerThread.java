import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class ServerThread implements Runnable{
Socket s;
ArrayList al,un;

ServerThread(Socket s,ArrayList al,ArrayList un){
this.s=s;
this.al=al;
this.un=un;
}

public void run(){
String s1,s2,s3;
try{
DataInputStream din = new DataInputStream(s.getInputStream());
DataOutputStream dout = new DataOutputStream(s.getOutputStream());

do{
s1=din.readUTF();
if(s1.length()<13){
System.out.println(s1);
tellEveryOne(s1);
}

else {
s2=s1.substring(0,13);

if(s2.equals("@#$qz56pm@#$+")){
s3=s1.substring(13,s1.length());
un.add(s3);
System.out.println("users="+un);

Iterator i = un.iterator();
String sr="@#$qz90pm@#$*";
while(i.hasNext()){
sr = sr +" "+(String)i.next()+"\n";
}
tellEveryOne(sr);
System.out.println("online users  : "+sr);
}


else if(s2.equals("@#$qz56pm@#$-")){
s3=s1.substring(13,s1.length());
un.remove(s3);
System.out.println("users="+un);
Iterator i = un.iterator();
String sr="@#$qz90pm@#$*";
while(i.hasNext()){
sr = sr + " "+(String)i.next()+"\n";
}
tellEveryOne(sr);
System.out.println("online users  : "+sr);
}

else
System.out.println(s1);
tellEveryOne(s1);
}


}while(true);
}catch(Exception e){System.out.println("scene5"+e);}
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
catch(Exception e){System.out.println("scene6"+e);}
}
}
}

 