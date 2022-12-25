

package csci.pkg366.pracdb;
import java.sql.*;
import java.util.Scanner;
        


/**
 *
 * @author Admin
 */
public class CSCI366PracDB {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        
        
        String jdbcURL = "jdbc:postgresql://localhost:5432/RIght one";
        String username ="postgres";
        String password = "Khnlipid18";
        
        try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connected");
            
            
            //NB: PLEASE ALL HAVE BEEN COMMENTED AND NEEDS TO BE UNCOMMENTED TO BE ABLE TO RUN. THANK YOU
            
         
            //DOCTOR
         //Insert values
          
      /** 
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter doctor ID: ");
        String ID = scan.nextLine();
        System.out.print("Enter doctor firstname: ");
        String firstname = scan.nextLine();
        System.out.print("Enter doctor lastname: ");
        String lastname = scan.nextLine();
        System.out.print("Enter doctor gender: ");
        String gend = scan.nextLine();
        System.out.print("Enter doctor Address: ");
        String Address = scan.nextLine();
        System.out.print("Enter doctor taskDateAndTime: ");
        String taskdateAndTime = scan.nextLine();
        System.out.print("Enter doctor task: ");
        String task = scan.nextLine();
        
        Doctor doc = new Doctor(Integer.parseInt(ID),firstname,lastname,gend,Address,taskdateAndTime,task);
        doc.insertARecord(connection);
        
        */
       
       
       
       
       // delete row
     
   /**     
      Scanner scan5 = new Scanner(System.in);
            System.out.print("Enter lastname: ");
            String firstname = scan5.nextLine();
            
            Doctor d = new Doctor();
            d.deleteRow(connection, firstname);
    
    
     */
     
       
       
       
     //show the doctor table
     
      /**
          Doctor doct = new Doctor();
          doct.showTable(connection);
     
     */
   
   
   
   
         
            // find by ID
 /**    
     
     Scanner scan1 = new Scanner(System.in);
            System.out.print("Enter ID: ");
            String id = scan1.nextLine();
            Doctor doc = Doctor.findDoctorByID(connection, Integer.parseInt(id));
            System.out.println("Doctor is: "+ doc);
        
          
            
  
      
              Scanner scan3 = new Scanner(System.in);
               System.out.print("ENter ID: ");
               String isd = scan3.nextLine();
               Doctor docx = new Doctor();
               docx.deleteTask(connection, 7);
              */
       
       
     /** //update value
       Scanner scan4 = new Scanner(System.in);
       
       System.out.print("Enter doctor firstname: ");
        String firstname = scan4.nextLine();
        System.out.print("Enter doctor lastname: ");
        String lastname = scan4.nextLine();
        System.out.print("Enter doctor gender: ");
        String gend = scan4.nextLine();
        System.out.print("Enter doctor Address: ");
        String Address = scan4.nextLine();
        System.out.print("Enter doctor taskDateAndTime: ");
        String taskdateAndTime = scan4.nextLine();
        System.out.print("Enter doctor task: ");
        String task = scan4.nextLine();
        System.out.print("Enter doctor ID: ");
        int ID = scan4.nextInt();
        
        Doctor doctr = new Doctor(ID,firstname,lastname,gend,Address,taskdateAndTime,task);
         doctr.updateRow(connection);
        
    */
     
     
     
     
     
     //PATIENT
     
 /**    // update values for patient
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter patient firstname: ");
            String uFirstname = scan.nextLine();
            System.out.print("Enter patient lastname: ");
            String uLastname = scan.nextLine();
            System.out.print("Enter patient address: ");
            String uAddress = scan.nextLine();
            System.out.print("Enter patient phone: ");
            String uPhone = scan.nextLine();
            System.out.print("Enter patient diagnosis: ");
            String uDiagnosis = scan.nextLine();
            System.out.print("Enter patient medication: ");
            String uMed = scan.nextLine();
            System.out.print("Enter patient gender: ");
            String uGender = scan.nextLine();
            System.out.println("Enter patient appointment date :  ");
            String uApptDT = scan.nextLine();
            System.out.print("Enter patient's doctor ID: "); //doctor IDs are 1-5. They're only 5 doctors.
            int uDID = scan.nextInt();
            System.out.print("Enter patient id: ");
            int uPatientID = scan.nextInt();

            Patient uPT = new Patient(uPatientID, uFirstname, uLastname, uAddress, uPhone, uDiagnosis, uMed, uGender, uApptDT, uDID);

            uPT.updatePatientData(connection);
           
       */
            

        /**    //inserts values for patient
            Scanner scan1 = new Scanner(System.in);
            System.out.print("Enter patient id: ");
            String patientID = scan1.nextLine();
            System.out.print("Enter patient firstname: ");
            String firstname = scan1.nextLine();
            System.out.print("Enter patient lastname: ");
            String lastname = scan1.nextLine();
            System.out.print("Enter patient address: ");
            String address = scan1.nextLine();
            System.out.print("Enter patient phone: ");
            String phone = scan1.nextLine();
            System.out.print("Enter patient diagnosis: ");
            String diagnosis = scan1.nextLine();
            System.out.print("Enter patient medication: ");
            String med = scan1.nextLine();
            System.out.print("Enter patient gender: ");
            String gender = scan1.nextLine();
            System.out.println("Enter patient appointment date and time (example: Thursday, December 15th 2011 1:00pm): ");
            String apptDT = scan1.nextLine();
            System.out.print("Enter patient's doctor ID: "); //doctor IDs are 1-5. They're only 5 doctors.
            int dID = scan1.nextInt();

            Patient pt = new Patient(Integer.parseInt(patientID), firstname, lastname, address, phone, diagnosis, med, gender, apptDT, dID);
            pt.saveInsertion(connection);
*/
            
            
        /**    //finds patient by ID.
            Scanner scan2 = new Scanner(System.in);
            System.out.print("Enter patient id: ");
            String patient1ID = scan2.nextLine();
            Patient p = Patient.findPatientByID(connection, Integer.parseInt(patient1ID));
            System.out.println("The patient is " + p);
            */
        
        
            /**
                        //deletes patient by phone number.
            Scanner scan6 = new Scanner(System.in);
            System.out.print("Enter phone number: ");
            String phonenum = scan6.nextLine();
            Patient pt2 = new Patient();
            pt2.DeletePatientByPhoneNum(connection, phonenum);

*/
            
      /**      //show patient data
            Patient pt3 = new Patient();
            pt3.getAllData(connection);

*/
            
            
            
            
            //BILLS
            
            
         /**  //bill update
            Scanner scan5 = new Scanner(System.in);
            System.out.print("Enter Bill ID: ");
            int billID = scan5.nextInt();
            System.out.print("Enter Number of Days: ");
            int numOfDays = scan5.nextInt();
            System.out.print("Enter Room Charge: ");
            int roomCharge = scan5.nextInt();
            System.out.print("Enter doctor charge: ");
            int doctorCharge = scan5.nextInt();
            System.out.print("Enter patient ID: ");
            int bPatientID = scan5.nextInt();
            System.out.print("Enter Room number : ");
            int roomNum = scan5.nextInt();

            Bill pt5 = new Bill(billID, numOfDays, roomCharge, doctorCharge, bPatientID, roomNum);
            pt5.updateBill(connection);

            */
         
         
        /**    //show bills data
            Bill b = new Bill();
            b.getBillData(connection);
*/
            
      /**                  //insertion values for bill
            Scanner scan7 = new Scanner(System.in);
            System.out.print("Enter Bill id: ");
            int bBillID = scan7.nextInt();
            System.out.print("Enter Bill Number of Days: ");
            int bNumOfDays = scan7.nextInt();
            System.out.print("Enter room charge: ");
            int bRoomCharge = scan7.nextInt();
            System.out.print("Enter doctor charge: ");
            int bDoctorCharge = scan7.nextInt();
            System.out.print("Enter patient ID: ");
            int b2PatientID = scan7.nextInt();
            System.out.print("Enter room number for patient: ");
            int bRoomNum = scan7.nextInt();

            Bill bh = new Bill(bBillID, bNumOfDays, bRoomCharge, bDoctorCharge, b2PatientID, bRoomNum);
            bh.saveBillInsertion(connection);

*/
            
            
            

  
     
        }
        catch(SQLException e){
            
           
            
        }
        
        
       
        
        
    }
    
}
