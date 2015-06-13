import java.awt.*;
import java.awt.event.*;

class fm extends Frame implements WindowListener{
    // 	constructer for creating the frame
	public fm(String title){
	super(title);
	setBackground(SystemColor.control);
	setSize(250,200);
	setLocation(200,150);
	addWindowListener(this);
	}

	public void windowClosing(WindowEvent e){
	dispose();
	System.exit(0);
	}

	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}

public class calc implements ActionListener{
	Panel keypad;
	Button key[];
	TextField lcd;
	private boolean clr,first;
	private int prev;
	private double result;
	public calc(){
		clr=true;
		first=true;
		result=0.0;
		prev=0;
		
		fm f = new fm("CALC  ~  ^^$@T@N^^");
		
		key = new Button[17];
		lcd = new TextField(30);
		keypad=new Panel();
		
		lcd.setEditable(true);
		
		for (int i = 0; i <=9; i++)
		key[i] = new Button(String.valueOf(i));
		key[10] = new Button(".");
		key[11] = new Button("+");
		key[12] = new Button("-");
		key[13] = new Button("*");
		key[14] = new Button("/");
		key[15] = new Button("=");
		key[16] = new Button("CLR");
	
		keypad.setLayout(new GridLayout (4,4,2,2));
	
		for(int x=7;x<=9;x++)          // add  7,8,9, to panel
		keypad.add(key[x]);
   
		keypad.add(key[14]);        //    /
   
		for(int x=4;x<=6;x++)    //  add 4,5,6 to panel
		keypad.add(key[x]);
   
		keypad.add(key[13]);      //   *
   
		for(int x=1;x<=3;x++)           //add 1,2,3 to panel
		keypad.add(key[x]);
   
		keypad.add(key[12]);       //      -
   
		keypad.add(key[11]);      //+
		keypad.add(key[0]);       //  0
		keypad.add(key[10]);             //  .
		keypad.add(key[15]);
  
		//  add action listner
		for(int i=0;i<=16;i++)
		key[i].addActionListener(this);
	
		//   add components to frame
		
		f.add(lcd,BorderLayout.NORTH);
		f.add(keypad, BorderLayout.CENTER);
		f.add(key[16], BorderLayout.EAST);
		f.pack();
		f.setVisible(true);
	}

	// MAIN FUNCTION HERE

	public static void main(String args[]){

		calc c = new calc();
	}

	// event handlers starts here
	public void actionPerformed(ActionEvent e)
	{  int i;
     
			for( i=0;i<=16;i++)
			{ if(e.getSource()==key[i])
			break;
			}
    
	
		if(0<=i && i<=10)
		{if(clr)
		{lcd.setText(" ");
		clr= false;
		}
		lcd.setText(lcd.getText()+key[i].getLabel());
		}
		
		if(i>=11 && i<=15)
		{   clr = true;
		if (first) // First operand
		{
		  if(lcd.getText().length()==0)
		   result = 0.0;
		  else
		   result = Double.valueOf(lcd.getText()).doubleValue();

		first = false;
	               prev = i; //save previous operator
		   }
	 
		else{
		switch(prev){
		
		case 11:{
		result += Double.valueOf(lcd.getText()).doubleValue();
		break;}
		case 12:{
		result -= Double.valueOf(lcd.getText()).doubleValue();
		break;}
		case 13:{
		result *= Double.valueOf(lcd.getText()).doubleValue();
		break;}
		case 14:{
		result /= Double.valueOf(lcd.getText()).doubleValue();
		break;}
		}

		lcd.setText(Double.toString(result));
		if(i==15)
		first = true;
		else
		prev=i;
		}
		}
		if(i==16)
		{clr=true;
		first=true;
		lcd.setText("");
		prev=0;
		result=0.0;
		}
   
	}
}


