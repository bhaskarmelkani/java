import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;


public class StartClient implements ActionListener{
JButton login;
JTextField logname;
JFrame jf;
String user;
public StartClient(){

jf = new JFrame("Login Window");

jf.setLocation(350,300);


login = new JButton("LOGIN");
logname = new JTextField("Enter your login Name", 25);
logname.select(0,21);

jf.add(logname);
jf.add(login);
jf.setLayout(new FlowLayout());
jf.setDefaultCloseOperation(3);
jf.pack();




login.addActionListener(this);
jf.setVisible(true);
}
public static void main(String ... arg){
new StartClient();
}

public void actionPerformed(ActionEvent ae){
user=logname.getText();
new MyClient(user);
jf.setVisible(false);
}
}


