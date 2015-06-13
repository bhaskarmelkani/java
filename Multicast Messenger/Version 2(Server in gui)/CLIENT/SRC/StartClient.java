import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;




public class StartClient implements ActionListener{
JButton login;
JTextField logname,ip,port;
JFrame jf;
JLabel loginl,ipl,portl;
String user,ipa;
int pn;
public StartClient(){

jf = new JFrame("Login Window");

jf.setLocation(350,300);
jf.setLayout(null);
jf.setSize(400,180);
jf.setResizable(false);


login = new JButton("LOGIN");
logname = new JTextField(25);

ip = new JTextField(12);
port = new JTextField(5);
ipl = new JLabel("Enter the ip address of server : ");
portl = new JLabel("Enter the port : ");
loginl = new JLabel("Enter your login name : ");

loginl.setBounds(10,5,200,25);
logname.setBounds(215,5,150,25);
ipl.setBounds(10,35,200,25);
ip.setBounds(215,35,150,25);
portl.setBounds(10,65,200,25);
port.setBounds(215,65,150,25);
login.setBounds(150,95,100,25);


jf.add(loginl);
jf.add(logname);
jf.add(ipl);
jf.add(ip);
jf.add(portl);
jf.add(port);
jf.add(login);
jf.setDefaultCloseOperation(3);





login.addActionListener(this);
jf.setVisible(true);
}
public static void main(String ... arg){
new StartClient();
}


public void actionPerformed(ActionEvent ae){
user=logname.getText();
ipa=ip.getText();
pn=Double.valueOf(port.getText()).intValue();

new MyClient(user,ipa,pn);

jf.setVisible(false);

}
}


