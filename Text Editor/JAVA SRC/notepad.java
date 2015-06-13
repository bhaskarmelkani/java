//  ******************************************** CODED BY BHASKAR **************************************************************************
//  *************************************************  SATAN     **************************************************************************

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.datatransfer.*;
import java.io.*;


public class notepad extends Frame  implements ActionListener,WindowListener{

//	declaring variables.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	
	String months[]={
		"Jan","Feb","Mar","Apr",
		"May","Jun","Jul","Aug",
		"Sep","Oct","Nov","Dec"};
	Font fnt;
	TextArea ta;
    MenuBar mbar;
	Menu file,edit,format,font,fstyle,fsize,help;
	MenuItem New,Open,Save,Saveas,Exit,About,fbox;
	MenuItem Cut,Copy,Paste,Selectall,Timedate,Delete;
	MenuItem fname1,fname2,fname3,fname4;
	MenuItem fstyle1,fstyle2,fstyle3,fstyle4;
	MenuItem fsize1,fsize2,fsize3,fsize4;
	String command;
    GregorianCalendar gc;
    String str1=" ",str2= " ",str3 =" ",str4 = " ";
	String str6=" ",str7=" ",str8=" ",str9 = " ",ttle;
	String tastart, tanow="";
	Boolean flag;
	
//	declaring ends.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
  public notepad(String title){}
  

//	constructor starts here .	.	.	.	.	.	.	.	.	.	.	.	.	.	.

	public notepad(String title,int sh,int sw,int lx , int ly){
	
	super(title);
	ttle = title;
	setBackground(SystemColor.control);
	setSize(sh,sw);
	setLocation(lx,ly);
		
	ta = new TextArea(20,30);														// text area created
	add(ta);																		//added to frame
	
	// menu bar starts here	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	mbar = new MenuBar();
    
	
	file = new Menu("File");
	edit = new Menu("Edit");
	format = new Menu("Format");
	font = new Menu("Font");
	fstyle = new Menu("Font Style");
	fsize = new Menu("Font Size");
	
	
	file.add(New = new MenuItem("New"));												// file menu starts
	New.setShortcut(new MenuShortcut(KeyEvent.VK_N));
	file.add(Open = new MenuItem("Open..."));
	Open.setShortcut(new MenuShortcut(KeyEvent.VK_O));
	file.add(Save = new MenuItem("Save"));
	Save.setShortcut(new MenuShortcut(KeyEvent.VK_S));
	file.add(Saveas = new MenuItem("Save As..."));
	file.addSeparator();
	file.add(Exit = new MenuItem("Exit"));
	
	mbar.add(file);
	
	
	edit.add(Cut = new MenuItem("Cut"));												// edit menu starts
//	Cut.setShortcut(new MenuShortcut(KeyEvent.VK_X));
	edit.add(Copy = new MenuItem("Copy"));
//	Copy.setShortcut(new MenuShortcut(KeyEvent.VK_C));
	edit.add(Paste = new MenuItem("Paste"));
//	Paste.setShortcut(new MenuShortcut(KeyEvent.VK_V));
	edit.add(Delete = new MenuItem("Delete"));
	edit.add(Selectall = new MenuItem("Select All..."));
//	Selectall.setShortcut(new MenuShortcut(KeyEvent.VK_A));
	edit.addSeparator();
	edit.add(Timedate = new MenuItem("Time/Date"));
	
	mbar.add(edit);
	

	
	format.add(font);																	// format starts
	format.addSeparator();
	format.add(fstyle);
	format.addSeparator();
	format.add(fsize);
	
	
	font.add(fname1= new MenuItem("Courier"));											// font
	font.add(fname2= new MenuItem("Sans Serif"));
	font.add(fname3= new MenuItem("Monospaced"));
	font.add(fname4= new MenuItem("Symbol"));
	
	
	fstyle.add(fstyle1 = new MenuItem("Regular"));										//style
	fstyle.add(fstyle2 = new MenuItem("Italic"));
	fstyle.add(fstyle3 = new MenuItem("Bold"));
	fstyle.add(fstyle4 = new MenuItem("Bold Italic"));
	
	
	fsize.add(fsize1 = new MenuItem("12"));												// size
	fsize.add(fsize2 = new MenuItem("14"));
	fsize.add(fsize3 = new MenuItem("18"));
	fsize.add(fsize4 = new MenuItem("20"));
		
	mbar.add(format);
	
	
	help = new Menu("Help");															//help
	help.add(About = new MenuItem("About"));
	mbar.add(help);

	// menu ends .	.	.	..	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	
	
	// registering events .	.	..	.	.	.	.	.	.	.	.	.	.	.	.	.	.	
	
	New.addActionListener(this);
	Open.addActionListener(this);
	Saveas.addActionListener(this);	
	Save.addActionListener(this);
	Exit.addActionListener(this);
	Cut.addActionListener(this);
	Copy.addActionListener(this);
	Paste.addActionListener(this);
	Delete.addActionListener(this);
	Selectall.addActionListener(this);
	Timedate.addActionListener(this);
	fname1.addActionListener(this);
	fname2.addActionListener(this);
	fname3.addActionListener(this);
	fname4.addActionListener(this);
	fstyle1.addActionListener(this);
	fstyle2.addActionListener(this);
	fstyle3.addActionListener(this);
	fstyle4.addActionListener(this);
	fsize1.addActionListener(this);
	fsize2.addActionListener(this);
	fsize3.addActionListener(this);
	fsize4.addActionListener(this);
	help.addActionListener(this);
	addWindowListener(this);
	
	// registering ends .	.	.	.	..	.	.	.	.	.	.	.	.	.	.	.	.
	
	setMenuBar(mbar);
	//pack();
	setVisible(true);																		// frame visible
	
	fnt = new Font("Dialog", Font.PLAIN, 12);												// set  defalut font
	ta.setFont(fnt);
	tastart =ta.getText();;
	flag = false;
	}
	
// constructor ends here	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.



// main starts here .	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.

	public static void main(String args[]){

		notepad n = new notepad("NOTEPAD ~ ^^$@T@N^^",900,550,200,150);
	}
	
//main ends here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.


// window listeners are here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.

	public void windowClosing(WindowEvent e){
	System.exit(0);
		dispose();	
	}

	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

// window listener ends .	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	

// action listener is here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.

	public void actionPerformed(ActionEvent ae){

	command = (String) ae.getActionCommand();
	
	// file starts.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	if(command.equals("New")){																			//new
		ta.setText(" ");	
	     flag = false;
		this.setTitle("NOTEPAD  ~  ^^$@T@N^^");
	}

	
	try{
	if(command.equals("Open...")){																		//open
	str4=" ";
	notepad f = new notepad("NOTEPAD  ~  ^^$@T@N^^"); 
	FileDialog fdo = new FileDialog(f,"Open");
	fdo.setVisible(true);
	str1 = fdo.getDirectory();
	str2 = fdo.getFile();
	str3 = str1 + str2;
	File fli = new File(str3);
	FileInputStream fi=new FileInputStream(fli);
	int avl = (int)fli.length();
	for(int i = 0;i<avl;i++){
	char str5 = (char)fi.read();
	str4 = str4 + str5;
	}
	ta.setText(str4);	
	if(str3.equals("nullnull")){ttle="NOTEPAD  ~  ^^$@T@N^^";}
	else ttle = str3;
	ttle = str3;
	System.out.println(ttle);
	flag=true;
	this.setTitle(ttle);
	}
	}catch(IOException e){}

	
	try{
	if(command.equals("Save")){																		//save 
	if(flag){
	String str10 = ta.getText();
	int lent = str10.length();
	byte buf1[] = str10.getBytes();
	File fot = new File(ttle);
	FileOutputStream fst = new FileOutputStream(fot);
	fst.write(buf1);
	fst.close();
	flag = true;
	}
	else{notepad f = new notepad("NOTEPAD  ~  ^^$@T@N^^"); 
	FileDialog fds = new FileDialog(f,"Save",FileDialog.SAVE);
	fds.setVisible(true);
	str6 = fds.getDirectory();
	str7 = fds.getFile();
	str8 = str6 + str7;
	str9 = ta.getText();
	int lent = str9.length();
	byte buf[] = str9.getBytes();
	File flo = new File(str8);
	FileOutputStream fo = new FileOutputStream(flo);
	fo.write(buf);
	fo.close();
	if(str8.equals("nullnull")){ttle="NOTEPAD  ~  ^^$@T@N^^";}
	else ttle = str8;
	flag = true;
	}
	this.setTitle(ttle);
	}	
	}catch(IOException e){}
	

	
	try{
	if(command.equals("Save As...")){																		//save 
	notepad f = new notepad("NOTEPAD  ~  ^^$@T@N^^"); 
	FileDialog fds = new FileDialog(f,"Save",FileDialog.SAVE);
	fds.setVisible(true);
	str6 = fds.getDirectory();
	str7 = fds.getFile();
	str8 = str6 + str7;
	str9 = ta.getText();
	int lent = str9.length();
	byte buf[] = str9.getBytes();
	File flo = new File(str8);
	FileOutputStream fo = new FileOutputStream(flo);
	fo.write(buf);
	fo.close();
	if(str8.equals("nullnull")){ttle="NOTEPAD  ~  ^^$@T@N^^";}
	else ttle = str8;
	flag = true;
	this.setTitle(ttle);
	}
	
	
	}catch(IOException e){}

	
	if(command.equals("Exit")){																			// exit
		System.exit(0);	
		
	}
	
	
	// file ends here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	
	//edit starts here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	if(command.equals("Cut")){																			// cut
	Clipboard cpboard = getToolkit().getSystemClipboard();
	StringSelection data = new StringSelection(ta.getSelectedText());
	cpboard.setContents(data , null);
	String tempmsg = ta.getSelectedText();
	int locstart = ta.getSelectionStart();
	int locend = ta.getSelectionEnd();
	ta.replaceRange("",locstart,locend);
	}


	if(command.equals("Copy")){																			//copy	
	Clipboard cpboard = getToolkit().getSystemClipboard();
	StringSelection data = new StringSelection(ta.getSelectedText());
	cpboard.setContents(data , null);
	}

	
	if(command.equals("Paste")){																		//paste
	Clipboard clipboard = getToolkit().getSystemClipboard();
	Transferable clipData = clipboard.getContents(this);
      String s;
      try {
        s = (String) (clipData.getTransferData(DataFlavor.stringFlavor));
      } 
      catch (Exception ex) {
        s = ex.toString();
      }
      int carposn = ta.getCaretPosition();
	  ta.insert(s,carposn);

	}

	
	if(command.equals("Delete")){																		//delete
	int locstart = ta.getSelectionStart();
	int locend = ta.getSelectionEnd();
	ta.replaceRange("",locstart,locend);
	String msg=ta.getSelectedText();
	int tai=ta.getText().indexOf(msg);
	ta.replaceRange("",tai,(tai+msg.length()));
	}

	
	if(command.equals("Select All...")){																//selectall
	String satxt = ta.getText();
	int salen = satxt.length();
	ta.select(0,salen);
	}

	
	if(command.equals("Time/Date")){																	//time/date
	gc = new GregorianCalendar();
	String hr = String.valueOf(gc.get(Calendar.HOUR));
	String min = String.valueOf(gc.get(Calendar.MINUTE));
	String sec = String.valueOf(gc.get(Calendar.SECOND));
	String mon = months[gc.get(Calendar.MONTH)];
	String date = String.valueOf(gc.get(Calendar.DATE));
	String year = String.valueOf(gc.get(Calendar.YEAR));
	String td = "Time-"+hr+":"+min+":"+sec+"Date-"+date+"/"+mon+"/"+year ;
	int loc = ta.getCaretPosition();
	ta.insert(td,loc);
	}

	// edit ends here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	
	
	// format starts here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	
	if(command.equals("Courier")){																	//fonts
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font("Courier",ffstyle,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("Sans Serif")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font("Sans Serif",ffstyle,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("Monospaced")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font("Monospaced",ffstyle,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("Symbol")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font("Symbol",ffstyle,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("Regular")){																			//style
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,Font.PLAIN,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("Italic")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,Font.ITALIC,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("Bold")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,Font.BOLD,ffsize);
	ta.setFont(fnt);
	}

	
	if(command.equals("Bold Italic")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,Font.BOLD|Font.ITALIC,ffsize);
	ta.setFont(fnt);
	}


	if(command.equals("12")){																					//size
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,ffstyle,12);
	ta.setFont(fnt);
	}
	
	
	if(command.equals("14")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,ffstyle,14);
	ta.setFont(fnt);
	}


	if(command.equals("18")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,ffstyle,18);
	ta.setFont(fnt);
	}


	if(command.equals("20")){
	String fontname = fnt.getName();
	String fontfamily= fnt.getFamily();
	int ffsize = fnt.getSize();
	int ffstyle = fnt.getStyle();
	fnt = new Font(fontname,ffstyle,20);
	ta.setFont(fnt);
	}	
	
	
	// format ends here.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	//about starts .	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	
	
	if(command.equals("About")){
	dialog dd = new dialog();
	}


	//about ends.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.
	
	}
// listener ends .	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.

}
// notepad class ends 	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	







// about dialog class starts here .	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.

class dialog implements WindowListener {

	public dialog(){
	notepad df = new notepad("NOTEPAD  ~  ^^$@T@N^^");
	Dialog d1 = new Dialog(df , " ^^$@T@N^^",true);
	Label la= new Label("This application is created by:");
	Label lb= new Label("BHASKAR MELKANI");
	Label lc= new Label("(08565)");
	d1.addWindowListener(this);
	d1.setSize(200,100);
	d1.setLocation(520,370);
	d1.add(la,BorderLayout.NORTH);
	d1.add(lb,BorderLayout.CENTER);
	d1.add(lc,BorderLayout.SOUTH);
	d1.setVisible(true);
	d1.addWindowListener(this);
	}
    
	
	public void windowClosing(WindowEvent e){
	((Window)e.getSource()).setVisible(false);
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	}
	
// about dialog ends .	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	.	