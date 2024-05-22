/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homee44;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFileChooser.FILES_AND_DIRECTORIES;
import static javax.swing.SpringLayout.SOUTH;

/**
 *
 * @author Update
 */


public class Homee44 extends JFrame implements ActionListener{
    private File t=null;
    private JButton cancel;
    private JMenu file,operation;
    private JMenuItem Import,Export,exit,add_a_new_students,Delete_a_student,Search_for_a_student,Modify_a_given_grade_for_a_student,change_a_given_grade_for_a_student,Display_All_students_a_recycle_view;
    private JPanel    S , N,center;
    private Connection con=null;
    private Statement state=null;
    private ResultSet rs=null;
    private PreparedStatement prep=null;
    private JTextField  f;
 private Connection getConnection() throws SQLException{
      String Driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:student";

        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Homee44.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DriverManager.getConnection(url);
 
 
 
 
 }
 
 
public Homee44() throws SQLException{
    
    super("hello in my home4 ^_^ ");
con=getConnection();
//state=con.createStatement();
 
setBounds(200,200,600,600);

cancel=new JButton("cancel");
file=new JMenu("File");
operation=new JMenu("Operations");
Import=new JMenuItem("import");
Export=new JMenuItem("export");
exit=new JMenuItem("exit");

add_a_new_students=new JMenuItem("add a new students");
Delete_a_student=new JMenuItem("Delete a student");
Search_for_a_student=new JMenuItem("Search for a student");
Modify_a_given_grade_for_a_student=new JMenuItem("Modify a given grade for a student");
change_a_given_grade_for_a_student=new JMenuItem("change a given grade for a student");
Display_All_students_a_recycle_view=new JMenuItem("Display All students a recycle view");
f=new JTextField("1234",15);
JMenuBar bar=new JMenuBar();
 setJMenuBar(bar);
 
 bar.add(file);
 bar.add(operation);
 file.add(Import);
 file.add(Export);
 file.add(exit);
 
 operation.add(add_a_new_students);
  operation.add(Delete_a_student);
  operation.add(Search_for_a_student);
  
  operation.add(Modify_a_given_grade_for_a_student);
  operation.add(change_a_given_grade_for_a_student);
  operation.add(Display_All_students_a_recycle_view);
  
S=new JPanel();
add(S,SOUTH);
S.add(cancel);
N=new JPanel();
add(N,NORTH);
N.add(f);


 int count=bar.getMenuCount();
 
 
  for ( int i = 0 ; i < count; i++)
         {
             JMenu  menu = bar.getMenu(i);
             
             int itemcount= menu.getItemCount();
             
             for (  int j= 0 ; j < itemcount ; j ++)
                 if ( menu.getItem(j) instanceof JMenuItem)
                   menu.getItem(j).addActionListener(this);
         
         }
 
 

cancel.addActionListener(this);




setVisible(true);











}
   
    public static void main(String[] args) throws SQLException { 
          
        new Homee44();
        System.out.println("conectedddddddddddddd");
    
    }

    @Override
public void actionPerformed(ActionEvent e) {
    Object m = e.getSource();
    if (m == cancel) {
        dispose();
    } else if (m == Import) {
        JFileChooser x;
        x = new JFileChooser();
        x.setFileSelectionMode(FILES_AND_DIRECTORIES);
        int f = x.showOpenDialog(this);
        if (f == JFileChooser.APPROVE_OPTION) {
             String first = null;
            String last = null ;
            int id = 0;
            String sex = null;
            int g1 = 0;
            int g2 = 0;
            int g3 = 0;
            int g4 = 0;
            int g5 = 0;
            int g6 = 0;
            int g7 = 0;
            int g8 = 0;
            int g9 = 0;
            int g10 = 0;
            double avg = 0;
          t = new File(x.getSelectedFile().getAbsolutePath());
ArrayList stngFile = new ArrayList();
            try {
                Scanner scnr = new Scanner(new FileReader(x.getSelectedFile().getAbsolutePath()));
                 
            
               
           // String str = null;
           while (scnr.hasNext()) {
             first =scnr.next();
             last =scnr.next();
             id=scnr.nextInt();
             sex=scnr.next();
             g1=scnr.nextInt();
             g2=scnr.nextInt();
             g3=scnr.nextInt();
             g4=scnr.nextInt();
             g5=scnr.nextInt();
             g6=scnr.nextInt();
             g7=scnr.nextInt();
             g8=scnr.nextInt();
             g9=scnr.nextInt();
             g10=scnr.nextInt();
             avg=scnr.nextDouble();
             System.out.println(first + " "+ last + "  " + id + " "+ sex+ " " +g1 + " "+ g2 + "  " + g3 + " "+ g4+ " "+g5 + " "+ g6 + "  " + g7 + " "+ g8+" "+g9+" "+g10+ " "+avg) ; 
        }
       
            
            
                //for(int i=0;i<10;i++){
                    state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery("SELECT * FROM tab1");
                 if(rs.next()==false){
                 rs.first();
                 //while(rs.next()){
              rs.moveToInsertRow();
                rs.updateString(1,first);
               rs.updateObject(2,last);
               rs.updateObject(3,id);
               rs.updateString(4,sex);
               rs.updateObject(5,g1);
               rs.updateObject(6,g2);
               rs.updateObject(7,g3);
               rs.updateObject(8,g4);
               rs.updateObject(9,g5);
               rs.updateObject(10,g6);
               rs.updateObject(11,g7);
               rs.updateObject(12,g8);
               rs.updateObject(13,g9);
               rs.updateObject(14,g10);
              rs.updateObject(15,avg);
                //}
                 rs.insertRow();
                    rs.moveToCurrentRow();
                 //}
            
            
            }
            
            
           /* if(rs.next()==false){
            rs.first();
             while(rs.next()){
                str = scnr.next();
              rs.moveToInsertRow();
                rs.updateObject(1,str);
                rs.updateObject(2, str);
                  
                 // }
                  rs.insertRow();
                    rs.moveToCurrentRow();
            } 
           
            }*/
            }catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
              
               
        }
              
              
              
              
              } 
    else if (m==exit){
    
    dispose();
    }
    else if (m==Export){
        JFileChooser x;
        x = new JFileChooser();
        x.setFileSelectionMode(FILES_AND_DIRECTORIES);
        int f = x.showOpenDialog(this);
        if (f == JFileChooser.APPROVE_OPTION) {
         t = new File(x.getSelectedFile().getAbsolutePath()); 
         
    try {
    state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    rs=state.executeQuery("SELECT * FROM tab1");
    PrintStream XX=null;
    XX=new PrintStream(x.getSelectedFile().getAbsolutePath());
            while(rs.next()){
                
              XX.println(rs.getObject(1)  + " "+rs.getObject(2)+" "+rs.getObject(3)+" "+rs.getObject(4)+" "+rs.getObject(5)+" "+rs.getObject(6)+" "+rs.getObject(7)+" "+rs.getObject(8)+" "+rs.getObject(9)+" "+rs.getObject(10)+" "+rs.getObject(11)+" "+rs.getObject(12)+" "+rs.getObject(13)+" "+rs.getObject(14)+" "+rs.getObject(15));
      //System.out.println(rs.getObject(5));
      
       
            
            }
            System.setOut(XX);
            } catch (Exception ex) {
                Logger.getLogger(Homee44.class.getName()).log(Level.SEVERE, null, ex);
            }
           
         
 
        
        
 }
    
 }
    else if(m==add_a_new_students){
        try {
     state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       
    rs=state.executeQuery("SELECT * FROM tab1");
    
    
     // rs.first();
            //while(rs.next()){
             rs.moveToInsertRow();
                rs.updateObject(1,"suad");
               rs.updateObject(2,"khilfeh");
               rs.updateObject(3,16689);
               rs.updateObject(4,"male");
               rs.updateObject(5,99);
               rs.updateObject(6,40);
               rs.updateObject(7,100);
               rs.updateObject(8,66);
               rs.updateObject(9,77);
               rs.updateObject(10,98);
               rs.updateObject(11,87);
               rs.updateObject(12,60);
               rs.updateObject(13,95);
               rs.updateObject(14,93);
              rs.updateObject(15,81.5);
               
                 rs.insertRow();
                    rs.moveToCurrentRow();
    
   // }
    } catch (SQLException ex) {
            Logger.getLogger(Homee44.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

  else if (m==Delete_a_student){
    
        try {
            state=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
               rs=state.executeQuery("SELECT * FROM tab1");
                    Scanner in =new Scanner(System.in);
                    System.out.print("please enter the id of student to be deleted ^_^");
                    int ff= in.nextInt();
                    while(rs.next()){
                      int sss=rs.getInt(3);
                      if(sss==ff){
                          String dd=String.format("delete from tab1 where ID = " + sss);
                      state.executeUpdate(dd);
                      System.out.print ("the student is deleted");
                      
                      
                      }
                    
                     in.close();
                    }
                   
                    
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    
    
    }
  else if (m == Search_for_a_student) {
    try {
        state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = state.executeQuery("SELECT * FROM tab1");

        String searchInput = f.getText();
        int searchID = Integer.parseInt(searchInput);

        boolean studentFound = false;

        while (rs.next()) {
            int studentID = rs.getInt(3);
            if (studentID == searchID) {
                System.out.println("The student exists.");
                System.out.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.getObject(4) + " " + rs.getObject(5) + " " + rs.getObject(6) + " " + rs.getObject(7) + " " + rs.getObject(8) + " " + rs.getObject(9) + " " + rs.getObject(10) + " " + rs.getObject(11) + " " + rs.getObject(12) + " " + rs.getObject(13) + " " + rs.getObject(14) + " " + rs.getObject(15));
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("The student does not exist.");
        }

    } catch (SQLException ex) {
        Logger.getLogger(Homee44.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NumberFormatException ex) {
        System.out.println("Invalid input for student ID.");
    }
}



  else if (m==change_a_given_grade_for_a_student  || m== Modify_a_given_grade_for_a_student){
        try {
            state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             rs = state.executeQuery("SELECT * FROM tab1");

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the id of student that modify their grade ^-^");
        int studentID= in.nextInt();
        //System.out.print("Please enter the grade to modify ^-^");
        while (rs.next()) {
           int searchid=rs.getInt(3);
            if (studentID == searchid) {
                System.out.println("the id of student that modify their grade is :"+searchid );
               System.out.print("Please enter the number of  grade to modify ^-^");
                int gr=in.nextInt();
                System.out.println(rs.getObject(gr));
                System.out.print("Please enter the grade to modify ^-^");
                rs.updateInt( gr , in.nextInt() );
                  rs.updateRow();
                
            }
        }

       
        in.close();
           
        
       
        
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
            
        }
        }
  else if(m==Display_All_students_a_recycle_view){
        try {
            state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = state.executeQuery("SELECT * FROM tab1");
        while(rs.next()){
        System.out.println(rs.getObject(1)  + " "+rs.getObject(2)+" "+rs.getObject(3)+" "+rs.getObject(4)+" "+rs.getObject(5)+" "+rs.getObject(6)+" "+rs.getObject(7)+" "+rs.getObject(8)+" "+rs.getObject(9)+" "+rs.getObject(10)+" "+rs.getObject(11)+" "+rs.getObject(12)+" "+rs.getObject(13)+" "+rs.getObject(14)+" "+rs.getObject(15));
        
        
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(Homee44.class.getName()).log(Level.SEVERE, null, ex);
        }
             
  
  
  
  
  }
    
    
        
  
  
  
  
  
  }
         
            
            
}


        
    


                  
              
              
                 
                 
               /* if(rs.next()==false){
                rs.first();
                Scanner in=new Scanner(t);
                while(in.hasNext()){
                Object a[]=new Object[15];
                a[0]=in.next();
                a[1]=in.next();
                a[2]=in.nextInt();
                a[3]=in.next();
                a[4]=in.nextInt();
                a[5]=in.nextInt();
                a[6]=in.nextInt();
                a[7]=in.nextInt();
                a[8]=in.nextInt();
                a[9]=in.nextInt();
                a[10]=in.nextInt();
                a[11]=in.nextInt();
                a[12]=in.nextInt();
                a[13]=in.nextInt();
                a[14]=in.nextInt();
                
                
                
                System.out.println(a[0]+" "+ a[1]+ " "+ a[2]+ " "+a[3]+" "+ a[4]+ " "+ a[5]+" "+a[6]+" "+ a[7]+ " "+ a[8]+ " "+a[9]+" "+ a[10]+ " "+ a[11]+" "+a[12]+" "+ a[13]+ " "+ a[14]);
                
                rs.moveToInsertRow();
                rs.updateString(1, in.next());
                rs.updateString(2, in.next());
                rs.updateInt(3, in.nextInt());
                // rs.updateString(4, in.next());
                rs.updateInt(5, in.nextInt());
                rs.updateInt(6, in.nextInt());
                rs.updateInt(7, in.nextInt());
                rs.updateInt(8, in.nextInt());
                rs.updateInt(9, in.nextInt());
                rs.updateInt(10, in.nextInt());
                rs.updateInt(11, in.nextInt());
                rs.updateInt(12, in.nextInt());
                rs.updateInt(13, in.nextInt());
                rs.updateInt(14, in.nextInt());
                rs.updateInt(15, in.nextInt());
                
                rs.insertRow();
                rs.moveToCurrentRow();
                }
                
                */
                
                 
       
                
                
                
                
                
                
                
               