package csci.pkg366.pracdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sokiristeezy
 */
public class Bill {

    private int billID;
    private int numDays;
    private int roomCharge;
    private int doctorCharge;
    private int patientID;
    private int roomNum;

    /**
     * @return the billID
     */
    public int getBillID() {
        return billID;
    }

    /**
     * @param billID the billID to set
     */
    public void setBillID(int billID) {
        this.billID = billID;
    }

    /**
     * @return the numDays
     */
    public int getNumDays() {
        return numDays;
    }

    /**
     * @param numDays the numDays to set
     */
    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    /**
     * @return the roomCharge
     */
    public int getRoomCharge() {
        return roomCharge;
    }

    /**
     * @param roomCharge the roomCharge to set
     */
    public void setRoomCharge(int roomCharge) {
        this.roomCharge = roomCharge;
    }

    /**
     * @return the doctorCharge
     */
    public int getDoctorCharge() {
        return doctorCharge;
    }

    /**
     * @param doctorCharge the doctorCharge to set
     */
    public void setDoctorCharge(int doctorCharge) {
        this.doctorCharge = doctorCharge;
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
     * @return the roomNum
     */
    public int getRoomNum() {
        return roomNum;
    }

    /**
     * @param roomNum the roomNum to set
     */
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Bill(int bID, int numDays, int roomCharge, int doctorCharge, int pID, int rnum) {

        this.billID = bID;
        this.numDays = numDays;
        this.roomCharge = roomCharge;
        this.doctorCharge = doctorCharge;
        this.patientID = pID;
        this.roomNum = rnum;

    }

    public Bill() {

    }

    public void saveBillInsertion(Connection con) {

        String insertBill = "insert into bills (bills_id, days_num, room_charges, doctor_charges, patient_id, room_id)"
                + "values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(insertBill);
            pstmt.setInt(1, this.billID);
            pstmt.setInt(2, this.numDays);
            pstmt.setInt(3, this.roomCharge);
            pstmt.setInt(4, this.doctorCharge);
            pstmt.setInt(5, this.patientID);
            pstmt.setInt(6, this.roomNum);

            int numOfRec = pstmt.executeUpdate();
            System.out.println(numOfRec + " been inserted.");
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void updateBill(Connection con) {

        String updateBill = "UPDATE bills SET bills_id=?, days_num=?, room_charges=?, doctor_charges=?, patient_id=? where room_id=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(updateBill);
            pstmt.setInt(1, this.billID);
            pstmt.setInt(2, this.numDays);
            pstmt.setInt(3, this.roomCharge);
            pstmt.setInt(4, this.doctorCharge);
            pstmt.setInt(5, this.patientID);
            pstmt.setInt(6, this.roomNum);

            int numOfRec = pstmt.executeUpdate();
            System.out.println(numOfRec + " been updated.");
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void getBillData(Connection con) throws SQLException {

        String all = " select * from bills ";

        Statement s = con.createStatement();

        ResultSet result = s.executeQuery(all);

        try {

            while (result.next()) {

                int billsId = result.getInt("bills_id");
                int numOfDays = result.getInt("days_num");
                int roomCharge = result.getInt("room_charges");
                int doctorCharge = result.getInt("doctor_charges");
                int patientID = result.getInt("patient_id");
                int roomNum = result.getInt("room_num");

                System.out.println("Bill ID: " + billsId + " Number of Days: " + numOfDays + " Room Charge: " + roomCharge + " DoctorCharge: " + doctorCharge + " PatientID: "
                        + patientID + " Room Number: " + roomNum);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
