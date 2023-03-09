import java.awt.event.*;
import javax.swing.*;  
public class Onlinetest
{
    String username,emailid,password,choice;
     public static void main(String args[]) 
     {  
        Onlinetest od=new Onlinetest();  
        String choice;
        int i=0;
        boolean ch= true;
        while(ch==true)
        {
            JOptionPane.showMessageDialog(null,"WELCOME ONLINE TEST EXAM");
            JOptionPane.showMessageDialog(null,"choice 1 for login\n"+"choice 2 for update\n"+"choice 3 for online test\n"+"choice  4for logout\n"+"choice 5 for exit");
            choice=JOptionPane.showInputDialog("Enter your choice");
            switch(choice) 
            {
                case "1":
                    od.login();
                    i=1;
                    break;
                
                case "2":
                   if(i==1)
                   {
                    od.update();
                    break;
                   }
                   else
                   {
                    JOptionPane.showMessageDialog(null,"YOU HAVEN'T LOGIN");
                   }
                case "3":
                    if(i==1)
                    {
                    Test ob =new Test("Online Test Of Java"); 
                    ob.actionPerformed(null);
                    ob.set();
                    ob.check();
                    break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"YOU HAVEN'T LOGIN");
                    }
                case "4":
                     od.logout();
                case "5":
                    System.exit(0);
                default:
                    break;
            } 
        
        }

    }
    public void  login()
    {
    
        username=JOptionPane.showInputDialog("Enter your username");   
        emailid=JOptionPane.showInputDialog("Enter your emailid");  
        password=JOptionPane.showInputDialog("Enter your password ");
        if(!username.equals("&")||emailid.equals("123@gmail.com")||password.equals("1234"))
        {
            JOptionPane.showMessageDialog(null,"Loggedin Successfully");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"LogIn Failed");
        }   
    }
    public void update()
    {
        JOptionPane.showMessageDialog(null,"1.Name\n"+"2.Emailid\n"+"3.Password\n"+"4.For All");
        choice=JOptionPane.showInputDialog("Enter your choice");
        
        switch(choice)
        {
            case "1":
                username=JOptionPane.showInputDialog("Enter the new Name:");
                JOptionPane.showMessageDialog(null,"Name updated successfully");
                break;
            case "2":
                emailid=JOptionPane.showInputDialog("Enter the new Email:");
                JOptionPane.showMessageDialog(null,"Email updated successfully");  
                break; 
            case "3":
                password=JOptionPane.showInputDialog("Enter the new Password:");
                JOptionPane.showMessageDialog(null,"Password updated successfully");  
                break;
            case "4":
                username=JOptionPane.showInputDialog("Enter the new Name:");
                emailid=JOptionPane.showInputDialog("Enter the new Name:");
                password=JOptionPane.showInputDialog("Enter the new Name:");
            default:
            JOptionPane.showMessageDialog(null,"You have chosen a wrong choice");
        }
        JOptionPane.showMessageDialog(null,"Name      :"+username+"\nEmail ID  :"+emailid);
    }
    public void logout()
    {
        username=null;
        emailid=null;
        password=null;
        JOptionPane.showMessageDialog(null,"Logged out successfully");
    }
}
class Test extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    Test(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }   
        b1=new JButton("Next");  
        b2=new JButton("Submit");  
        b1.addActionListener(this);  
        b2.addActionListener(this);
        add(b1);
        add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Submit"))
        {
            JOptionPane.showMessageDialog(this,"Do you want to submit");
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(1);
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals(""+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
    
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);   
        }  
    
    }  
 
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which one among these is non-primitive datatype in java?");  
            jb[0].setText("int");
            jb[1].setText("Float");
            jb[2].setText("boolean");
            jb[3].setText("enum");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: How do you insert COMMENTS in java?");  
            jb[0].setText("// COMMENT");
            jb[1].setText("# COMMENT");
            jb[2].setText("/* COMMENT");
            jb[3].setText("/# COMMENT");
             
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which data type is used to create a varible that should store text");  
            jb[0].setText("Txt");
            jb[1].setText("my string");
            jb[2].setText("String");
            jb[3].setText("string");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");
            jb[1].setText("Swing");
            jb[2].setText("Applet");
            jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Array indexes start with?");  
            jb[0].setText("0");
            jb[1].setText("1");
            jb[2].setText("-1");
            jb[3].setText("none of the above");
        
        }  
        if(current==5)  
        {  
            l.setText("Que6: How do you call a method in java?");  
            jb[0].setText("method name;");
            jb[1].setText("(method Name);");
            jb[2].setText("methodName();");
            jb[3].setText("methodName[];");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which method can be used to find the highest value of x and y? ");  
            jb[0].setText("Math.largest(x,y)");
            jb[1].setText("Math.maxNum(x,y)");
            jb[2].setText("Math.maximum(x,y)");  
             jb[3].setText("Math.max(x,y)");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: which one among these is not a function of Object class?");  
            jb[0].setText("toString");
            jb[1].setText("finalize");
            jb[2].setText("equals");  
            jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: which keyword is used to return a value inside a method ?");  
            jb[0].setText("get");
            jb[1].setText("void");
            jb[2].setText("break");
            jb[3].setText("return");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which keyword is used to import a package from the java API library?");  
            jb[0].setText("package");
            jb[1].setText("lib");
            jb[2].setText("import");  
            jb[3].setText("getlib");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[3].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    } 
    }
     



