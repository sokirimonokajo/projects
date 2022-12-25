/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci.pkg366.pracdb;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class Doctor extends CSCI366PracDB {

   
    private int doctor_id;
    private String firstname;
    private String lastname;
    private String gender;
    private String address;
    private String task;
    private String taskdateAndTime;
    
    
    
    public Doctor(int dID, String fname, String lname,String gen, String add, String tas,String tdT){
        this.doctor_id = dID;
        this.firstname = fname;
        this.lastname = lname;
        this.gender = gen;
        this.task = tas;
        this.address = add;
        this.taskdateAndTime = tdT;
        
    }
    
    
    
    public Doctor(){
        
    }
    //works
    public void insertARecord(Connection conn) {
      String sql = "insert into doctor (firstname,lastname,gender,address,taskdateandtime,task)"+"values (?,?,?,?,?,?)";
      
      try{
          
      
        
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,this.firstname);
         pstmt.setString(2,this.lastname);
         pstmt.setString(3,this.gender);
         pstmt.setString(4,this.address);
         pstmt.setString(5,this.taskdateAndTime);
         pstmt.setString(6,this.task);
         pstmt.executeUpdate();
         
         int a = pstmt.executeUpdate();
          System.out.println(a+" inserted");
      }
      catch(SQLException ex){
          ex.printStackTrace();;
        
    }
      
}
    
    
  
    
   
    //works
    public void showTable(Connection conn)throws SQLException{
        String SQL = " select * from doctor";
      //  PreparedStatement pstmt = conn.prepareStatement(SQL);
      Statement stmt = conn.createStatement();
      ResultSet result = stmt.executeQuery(SQL);
       
        try{
            while(result.next()){
                int ID = result.getInt("doctor_id");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String gend = result.getString("gender");
                String address = result.getString("address");
                String taskdateTime = result.getString("taskdateAndTime");
                String task = result.getString("task");
                
                System.out.println(ID+":"+ firstname +": "+lastname+": "+ gend+": "+address+": "
                        + ""+ taskdateTime+": "+ task);
                
                
            }
        
        
        
        
        } 
        catch(SQLException ex){
            ex.printStackTrace();;
        }
    
      
    }
    
    
    public static Doctor findDoctorByID(Connection conn, int id){
        Doctor doct = new Doctor();
        
            String selectDoctor = "select * from doctor"+ "where doctor_id = ?";
          
          try{
              
          PreparedStatement pstmt = conn.prepareStatement(selectDoctor);
          pstmt.setInt(1, id);
          
            ResultSet rsDoctor = pstmt.executeQuery();
            while(rsDoctor.next()){
            
                doct.setFirstname(rsDoctor.getString("firstname"));
                 doct.setLastname(rsDoctor.getString("lastname"));
                  doct.setGender(rsDoctor.getString("gender"));
                  doct.setAddress(rsDoctor.getString("address"));
                  doct.setTaskDateAndTime(rsDoctor.getString("taskdateandtime"));
                  doct.setTask(rsDoctor.getString("task"));
                  doct.setDoctor_id(rsDoctor.getInt("doctor_id"));
            }
          }
            catch(SQLException ex){
                    ex.printStackTrace();
                    }
            
        
        return doct;
    }
    
    
    //works
    public void deleteRow(Connection conn,String add) throws SQLException{
        try{
            PreparedStatement pstmt = conn.prepareStatement("delete from doctor where lastname = ?");
            pstmt.setString(1, add);
            pstmt.executeUpdate();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    // works bur doesnt chnage
    public void updateRow(Connection conn) throws SQLException{
        String query = "update doctor set firstname =?, lastname=?,gender =?, address = ?, taskdateAndTime = ?, task = ? where doctor_id = ?";
        
        try{
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, this.firstname);
            pstmt.setString(2, this.lastname);
            pstmt.setString(3, this.gender);
            pstmt.setString(4, this.address);
            pstmt.setString(5, this.taskdateAndTime);
            pstmt.setString(6, this.task);
            pstmt.setInt(7, this.doctor_id);
            
            int b = pstmt.executeUpdate();
            
            System.out.println("table updated");
            
        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        
        
        
        
        
    }
    
    
    

    /**
     * @return the doctor_id
     */
    public int getDoctor_id() {
        return doctor_id;
    }

    
     /**
     * @param doctor_id the doctor_id to set
     */
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }
    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param fistname the firstname to set
     */
    public void setFirstname(String fistname) {
        this.firstname = fistname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
     
    public String gettaskDateAndTime(){
        return taskdateAndTime;
    }
    public void setTaskDateAndTime(String tdTs){
        this.taskdateAndTime = tdTs;
    }
    
     public String getTask(){
        return task;
    }
      public void setTask(String tsk){
        this.task = tsk;
    }
}
