import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class MyClient extends WindowAdapter implements ActionListener{
JFrame f;
JTextArea ta1,ta2;
JTextField ta3;
JButton lo;
Socket s;
DataInputStream din;
DataOutputStream dout;
String s1,s2,user,ipa;
int port;
JScrollPane jp1,jp2,jp3;
JLabel l1,l2,l3;



public MyClient(String user,String ipa,int port){

this.user=user;
this.ipa=ipa;
this.port=port;

Font fn = new Font("Dialog",Font.PLAIN,12);

f = new JFrame("HELLO "+user+" !!!");
f.setLayout(null);
f.setSize(800,510);
f.setLocation(250,50);
f.setResizable(false);




l1 = new JLabel("HAPPY CHATING !!!");
f.add(l1);
l1.setBounds(30,5,320,20);
ta1 = new JTextArea(100,100);
ta1.setEditable(false);
ta1.setFont(new Font("Dialog",Font.PLAIN,18));
JScrollPane jp1 = new JScrollPane(ta1);
f.add(jp1);
jp1.setBounds(30,25,500,350);
DefaultCaret caret = (DefaultCaret)ta1.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);





l2 = new JLabel("WHOS ONLINE ...");
f.add(l2);
l2.setBounds(560,5,320,20);
ta2 = new JTextArea(100,100);
ta2.setEditable(false);
ta2.setFont(new Font("Dialog",Font.PLAIN,18));
JScrollPane jp2 = new JScrollPane(ta2);
f.add(jp2);
jp2.setBounds(560,25,200,350);


l3 = new JLabel("TYPE YOUR MESSAGE HERE ...");
f.add(l3);
l3.setBounds(30,380,320,20);
ta3 = new JTextField();
ta3.setFont(new Font("Dialog",Font.PLAIN,18));
JScrollPane jp3 =  new JScrollPane(ta3);
f.add(jp3);
jp3.setBounds(30,400,500,65);

lo=new JButton("LOGOUT");
f.add(lo);
lo.setBounds(560,400,200,65);


try{
s = new Socket(ipa,port);
din = new DataInputStream(s.getInputStream());
dout = new DataOutputStream(s.getOutputStream());

ClientThread m = new ClientThread(din,ta1,ta2,f);
Thread t1 = new Thread(m);

dout.writeUTF(user+" : HEY I AM LOGGED IN");
dout.writeUTF("@#$qz56pm@#$+"+user);
t1.start();

}catch(Exception e){System.out.println("scene3"+e);}


ta3.addActionListener(this);
lo.addActionListener(this);
f.addWindowListener(this);
f.setVisible(true);
}


public void actionPerformed(ActionEvent e){

if(e.getSource()==ta3){

try{
s1 = ta3.getText();
if(!s1.equals("")){
dout.writeUTF(user+" : "+s1);
ta3.setText("");}
}catch(Exception e1){System.out.println("scene1"+e);}
}

else if(e.getSource()== lo)
{try{
dout.writeUTF(user+" : IS LOGGED OUT");
dout.writeUTF("@#$qz56pm@#$-"+user);
}catch(Exception ex){System.out.println("scene8"+e);}
System.exit(0);
}
}




public void windowClosing(WindowEvent e){
try{
dout.writeUTF(user+" : IS LOGGED OUT");
dout.writeUTF("@#$qz56pm@#$-"+user);
}catch(Exception ex){System.out.println("scene2"+e);}
System.exit(0);
}

public void windowIconified(WindowEvent e) {
System.out.println("abc");}

}

