import java.io.DataInputStream;
import javax.swing.JTextArea;
import java.io.DataOutputStream;
import javax.swing.JFrame;


public class ClientThread implements Runnable{
DataInputStream din;
JTextArea ta1,ta2;
JFrame f;

public ClientThread(DataInputStream din,JTextArea ta1,JTextArea ta2,JFrame f){
this.din=din;
this.ta1=ta1;
this.ta2=ta2;
this.f=f;
}

public void run(){

String s1 = " ",s2,s3;
do{
try{
s1 = din.readUTF();

if(s1.length()<13){
ta1.append(s1+"\n");
f.setExtendedState(JFrame.NORMAL);

}

else {
s2=s1.substring(0,13);
if(s2.equals("@#$qz56pm@#$+")){}
else if(s2.equals("@#$qz56pm@#$-")){}
else if(s2.equals("@#$qz90pm@#$*")){ ta2.setText(s1.substring(13,s1.length()));}


else{
ta1.append(s1+"\n");
f.setExtendedState(JFrame.NORMAL);
}
}


}catch(Exception e){System.out.println("scene4"+e);};
}while(true);

}

}


