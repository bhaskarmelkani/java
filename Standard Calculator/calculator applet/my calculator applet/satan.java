import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="satan" height=500 width=500>
</applet>
*/

public class satan extends Applet implements ActionListener{

Button key[];
TextField lcd;
private boolean clr,first;
private int prev;
private double result;
public void init(){

clr=true;
first=true;
result=0.0;
prev=0;






key = new Button[17];
lcd = new TextField(30);


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
   
   
   
   
   for(int i=0;i<=16;i++)
   add(key[i]);
   
   add(lcd);
   for(int i=0;i<=16;i++)
   key[i].addActionListener(this);
   
   }
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
   
   
