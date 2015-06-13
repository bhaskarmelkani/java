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
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;



public class MyClient extends WindowAdapter implements ActionListener{
JFrame f;
JTextArea ta1,ta2,ta3;
JButton b,lo;
Socket s;
DataInputStream din;
DataOutputStream dout;
String s1,s2,user;
JPanel jp;
JScrollPane jp1,jp2,jp3;
JLabel l1,l2,l3;



public MyClient(String user){

this.user=user;

Font fn = new Font("Dialog",Font.PLAIN,12);

f = new JFrame("HELLO "+user+" !!!");
f.setLayout(null);
f.setSize(800,650);
f.setLocation(250,50);





l1 = new JLabel("HAPPY CHATING !!!");
f.add(l1);
l1.setBounds(30,5,320,20);
ta1 = new JTextArea(100,100);
ta1.setEditable(false);
ta1.setFont(new Font("Dialog",Font.PLAIN,18));
JScrollPane jp1 = new JScrollPane(ta1);
f.add(jp1);
jp1.setBounds(30,25,500,350);


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
ta3 = new JTextArea(10,55);
ta3.setFont(new Font("Dialog",Font.PLAIN,18));
JScrollPane jp3 =  new JScrollPane(ta3);
f.add(jp3);
jp3.setBounds(30,400,500,200);

b=new JButton("SEND");
f.add(b);
b.setBounds(560,400,200,120);

lo=new JButton("LOGOUT");
f.add(lo);
lo.setBounds(560,525,200,75);


try{
s = new Socket("localhost",9);
din = new DataInputStream(s.getInputStream());
dout = new DataOutputStream(s.getOutputStream());

ClientThread m = new ClientThread(din,ta1,ta2);
Thread t1 = new Thread(m);

dout.writeUTF(user+" : HEY I AM LOGGED IN");
dout.writeUTF("@#$qz56pm@#$+"+user);
t1.start();

}catch(Exception e){System.out.println("scene3"+e);}



b.addActionListener(this);
lo.addActionListener(this);
f.addWindowListener(this);
f.setVisible(true);
}


public void actionPerformed(ActionEvent e){

if(e.getSource()==b){

try{
s1 = ta3.getText();
dout.writeUTF(user+" : "+s1);
ta3.setText("");
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

