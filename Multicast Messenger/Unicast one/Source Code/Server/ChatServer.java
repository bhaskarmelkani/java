import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.net.Socket;
import java.net.ServerSocket;
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

public class ChatServer extends WindowAdapter implements ActionListener{
JFrame f;
JTextArea ta1;
JTextField ta3,ta2;
JButton lo;
Socket s;
ServerSocket ss;
DataInputStream din;
DataOutputStream dout;
String s1,s2,user,ipa;
int port;
JScrollPane jp1,jp2,jp3;
JLabel l1,l2,l3,l4;



public ChatServer(){


Font fn = new Font("Dialog",Font.PLAIN,12);

f = new JFrame("CHAT MESSENGER - SERVER!!!");
f.setLayout(null);
f.setSize(570,560);
f.setLocation(250,50);
f.setResizable(false);




l1 = new JLabel("START CHATTING");
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







l3 = new JLabel("ENTER YOUR TEXT");
f.add(l3);
l3.setBounds(30,380,320,20);
ta3 = new JTextField();
ta3.setFont(new Font("Dialog",Font.PLAIN,18));
JScrollPane jp3 =  new JScrollPane(ta3);
f.add(jp3);
jp3.setBounds(30,400,500,65);


l4=new JLabel("User Name :");
f.add(l4);
l4.setBounds(30,480,100,30);

ta2 = new JTextField();
f.add(ta2);
ta2.setBounds(110,480,150,30);


lo=new JButton("START SERVER");
f.add(lo);
lo.setBounds(377,480,150,30);



f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ta3.addActionListener(this);
 lo.addActionListener(this);
f.addWindowListener(this);
f.setVisible(true);
}


public void actionPerformed(ActionEvent e){

if(e.getSource()==lo){

try{




Runnable r = new ServerThread(ta1,ta2,ta3);
Thread t = new Thread(r);
t.start();

}catch(Exception e1){System.out.println("scene1"+e);}
}


}


public static void main(String ... ar){

new ChatServer();
}




}

