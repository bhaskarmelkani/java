import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.text.DefaultCaret;


public class MessServer extends JFrame implements ActionListener{

ArrayList al = new ArrayList();
ArrayList un = new ArrayList();

Toolkit tkt = Toolkit.getDefaultToolkit();
Dimension dm = tkt.getScreenSize();

ServerSocket ss;
Socket s;
JButton start,stop;
JTextField port;
JLabel portl;
JPanel jp1,jp2;
JTextArea display;
JScrollPane jsp;



public MessServer(){            // cons truct

start = new JButton("Start Server");  
stop = new JButton("Stop Server");
port = new JTextField(6);
display = new JTextArea(50,0);
portl= new JLabel("Port No.   :    ");
jp1 = new JPanel();
jp2 = new JPanel();
jsp = new JScrollPane(display);

DefaultCaret caret = (DefaultCaret)display.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
display.setEditable(false);

jp1.add(portl);
jp1.add(port);

jp2.add(start);
jp2.add(stop);



setLayout(new BorderLayout());
start.addActionListener(this);
stop.addActionListener(this);

add(jp1,BorderLayout.NORTH);
add(jsp,BorderLayout.CENTER);
add(jp2,BorderLayout.SOUTH);


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize((3*dm.width/4),(3*dm.height/4));
setLocation(dm.width/8,dm.height/8);
setVisible(true);
}


public void actionPerformed(ActionEvent ae){


if(ae.getActionCommand().equals("Start Server")){

try{
ss = new ServerSocket(Integer.parseInt(port.getText()));

display.append("\nSERVER STARTED ... \n");
display.append("\n"+ss.toString());
display.append("\nWAITING FOR CLIENTS ... \n");
Runnable r = new StartServer(s,ss,al,un,display);      // for gui
Thread t = new Thread(r);
t.start();
}catch(Exception e){display.append("\nMessServer1"+e.toString());}
}


if(ae.getActionCommand().equals("Stop Server")){
try{
ss.close();
display.append("\n Server is now off line");
}catch(Exception e){display.append("\nMessServer2"+e.toString());}
}
}


public static void main(String ... args){
new MessServer();
}
}


