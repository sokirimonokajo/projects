package csci.pkg366.pracdb;



import java.sql.*;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author sokiristeezy
 */
public final class Patient {

    private int patientID;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String diagnosis;
    private String medication;
    private String gender;
    private String appointmentDT;
    private int doctorID;

    public Patient(int pID, String fname, String lname, String addr, String phone,
            String diag, String meds, String gender, String apptDT, int dID) {

        this.patientID = pID;
        this.firstname = fname;
        this.lastname = lname;
        this.address = addr;
        this.phone = phone;
        this.diagnosis = diag;
        this.medication = meds;
        this.gender = gender;
        this.appointmentDT = apptDT;
        this.doctorID = dID;

    }

    public Patient() {

    }

    public String toString() {

        return this.patientID + ": " + this.firstname + " " + this.lastname;

    }

    public void DeletePatientByPhoneNum(Connection con, String name) throws SQLException {

        try {

            PreparedStatement pstmt = con.prepareStatement(" delete from patient " + " where phone = ?");
            pstmt.setString(1, name);
            pstmt.executeUpdate();

            /*  p.setPatientID(rsPatient.getInt("patient_id"));
                p.setFirstname(rsPatient.getString("firstname"));
                p.setLastname(rsPatient.getString("lastname"));
                p.setAddress(rsPatient.getString("address"));
                p.setDiagnosis(rsPatient.getString("disease"));
                p.setMedication(rsPatient.getString("medication"));
                p.setGender(rsPatient.getString("gender"));
                p.setAppointmentDT(rsPatient.getString("appointment_date_time"));
                p.setDoctorID(rsPatient.getInt("doctor_id"));

             */
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void updatePatientData(Connection con) {

        String updatePatient = "UPDATE patient SET firstname = ?, lastname = ?, address = ?, phone = ?, disease = ?,"
                + " gender = ?, medication = ?, appointment_date_time  = ?, doctor_id = ? where patient_id = ?";

        try {

            PreparedStatement pstmt = con.prepareStatement(updatePatient);

            pstmt.setString(1, this.firstname);
            pstmt.setString(2, this.lastname);
            pstmt.setString(3, this.address);
            pstmt.setString(4, this.phone);
            pstmt.setString(5, this.diagnosis);
            pstmt.setString(6, this.gender);
            pstmt.setString(7, this.medication);
            pstmt.setString(8, this.appointmentDT);
            pstmt.setInt(9, this.doctorID);
            pstmt.setInt(10, this.patientID);

            int update = pstmt.executeUpdate();
            System.out.println(update + " been updated.");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void saveInsertion(Connection con) {

        String insertPatient = "insert into patient (patient_id, firstname, lastname, address, phone, disease,"
                + " gender, medication, appointment_date_time , doctor_id)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertPatient);
            pstmt.setInt(1, this.patientID);
            pstmt.setString(2, this.firstname);
            pstmt.setString(3, this.lastname);
            pstmt.setString(4, this.address);
            pstmt.setString(5, this.phone);
            pstmt.setString(6, this.diagnosis);
            pstmt.setString(7, this.gender);
            pstmt.setString(8, this.medication);
            pstmt.setString(9, this.appointmentDT);
            pstmt.setInt(10, this.doctorID);

            int numOfRec = pstmt.executeUpdate();
            System.out.println(numOfRec + " been inserted.");
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public static Patient findPatientByID(Connection con, int patientID) {

        Patient p = new Patient();

        String selectPatient = " select * from patient "
                + "where patient_id = ?";

        try {

            PreparedStatement pstmt = con.prepareStatement(selectPatient);
            pstmt.setInt(1, patientID);

            ResultSet rsPatient = pstmt.executeQuery();
            while (rsPatient.next()) {

                p.setFirstname(rsPatient.getString("firstname"));
                p.setLastname(rsPatient.getString("lastname"));
                p.setAddress(rsPatient.getString("address"));
                p.setPhone(rsPatient.getString("phone"));
                p.setDiagnosis(rsPatient.getString("disease"));
                p.setGender(rsPatient.getString("gender"));
                p.setMedication(rsPatient.getString("medication"));
                p.setAppointmentDT(rsPatient.getString("appointment_date_time"));
                p.setDoctorID(rsPatient.getInt("doctor_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public void getAllData(Connection con) throws SQLException {

        String all = " select * from patient ";

        Statement s = con.createStatement();

        ResultSet result = s.executeQuery(all);

        try {

            while (result.next()) {
                int id = result.getInt("patient_id");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String address = result.getString("address");
                String phone = result.getString("phone");
                String diagnosis = result.getString("disease");
                String gender = result.getString("gender");
                String medication = result.getString("medication");
                String appointmentDT = result.getString("appointment_date_time");
                int doctorID = result.getInt("doctor_id");

                System.out.println(" Patient ID: " + id + " First Name: " + firstname + " LastName: " + lastname + " Address: " + address + " Phone Number: "
                        + phone + " Diagnosis: " + diagnosis + " Gender: " + gender + " Medication: " + medication + " Appointment Date : " + appointmentDT + " Doctor ID: " + doctorID);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;

    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * @param diagnosis the diagnosis to set
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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
     * @return the appointmentDT
     */
    public String getAppointmentDT() {
        return appointmentDT;
    }

    /**
     * @param appointmentDT the appointmentDT to set
     */
    public void setAppointmentDT(String appointmentDT) {
        this.appointmentDT = appointmentDT;
    }

    /**
     * @return the medication
     */
    public String getMedication() {
        return medication;
    }

    /**
     * @param medication the medication to set
     */
    public void setMedication(String medication) {
        this.medication = medication;
    }

    /**
     * @return the doctorID
     */
    public int getDoctorID() {
        return doctorID;
    }

    /**
     * @param doctorID the doctorID to set
     */
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

}
