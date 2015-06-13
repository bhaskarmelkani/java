import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.util.Stack;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;


public class WebBrowser {

JFrame jf;
JEditorPane jep;
JTextField jt;
Stack<String> url,url1;
JButton load,back,next;
JCheckBox editable;
JLabel ul,edt;
JPanel jp;

public WebBrowser(){

Toolkit tkt = Toolkit.getDefaultToolkit();
Dimension dm = tkt.getScreenSize();



jf = new JFrame("MINI WEB BROWSER !!! ");
jep = new JEditorPane();
jt = new JTextField(30);
jp = new JPanel();
url = new Stack<String>();
url1 = new Stack<String>();
load = new JButton("LOAD");
back = new JButton("BACK");
next = new JButton("NEXT");
ul = new JLabel("URL : ");
editable = new JCheckBox();
edt = new JLabel("EDITABLE");

jf.setLayout(new BorderLayout());
jf.setSize((3*dm.width/4),(3*dm.height/4));
jf.setLocation(dm.width/8,dm.height/8);

jp.setLayout(new FlowLayout());

jep.setEditable(false);


jp.add(ul);
jp.add(jt);
jp.add(back);
jp.add(load);
jp.add(next);
jp.add(edt);
jp.add(editable);
jf.add(jp,BorderLayout.NORTH);
jf.add(new JScrollPane(jep),BorderLayout.CENTER);


load.addActionListener( new ActionListener()
                    { 
					   public void actionPerformed(ActionEvent ae){
					   try{
					   url.push(jt.getText());
					   jep.setPage(jt.getText());
					   jf.setTitle(jt.getText());
					   }catch(Exception ex){jep.setText("Exception : " + ex);}}
					});
					   
					   
back.addActionListener( new ActionListener()
					{
						public void actionPerformed(ActionEvent ae1){
						if(url.size()<=1) return;
						try{
						url1.push(url.pop());
						String sul = url.peek();
						jt.setText(sul);
						jf.setTitle(sul);
						jep.setPage(sul);
						}catch(Exception ex1){jep.setText("Exception : " +ex1);}}
					} );
					
next.addActionListener( new ActionListener()
					{
						public void actionPerformed(ActionEvent ae5){
						if(url1.size()<1) return;
						try{
						String sul = url1.peek();
						url.push(url1.pop());
						jt.setText(sul);
						jf.setTitle(sul);
						jep.setPage(sul);
						}catch(Exception ex5){jep.setText("Exception : " +ex5);}}
					} );					
						
jt.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent ae2){
					   try{
					   url.push(jt.getText());
					   jep.setPage(jt.getText());
					   jf.setTitle(jt.getText());
					   }catch(Exception ex2){jep.setText("Exception : " + ex2);}}
					});
					
editable.addActionListener(new ActionListener()
					{	
						public void  actionPerformed(ActionEvent ae3){
						jep.setEditable(editable.isSelected());
						}
					});

jep.addHyperlinkListener(new HyperlinkListener()
					{
						public void hyperlinkUpdate(HyperlinkEvent he){
						if(he.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
						try{
						String hes = he.getURL().toString();
						url.push(hes);
						jf.setTitle(hes);
						jt.setText(hes);
						jep.setPage(hes);
						}catch(Exception hex){jep.setText("Exception : " + hex);}
						}}
					});
					
					
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setVisible(true);
}


public static void main(String ... a){

new WebBrowser();
}
}






