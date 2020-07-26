/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

/**
 *
 * @author Christiaan Bouwer VVF6HCS19
 */
public class RMIImpInterface extends UnicastRemoteObject implements StudentInterface{

    @Override
    public StudentDetails readFromDatabase(String id) throws RemoteException {
        StudentDetails studentObj = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver has been loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PIHE2019", "root", "");
            System.out.println("Connected to the DB");
            String query = ("SELECT * FROM 'details' WHERE StudentID = ?");
            PreparedStatement statmentObj = con.prepareStatement(query);
            statmentObj.setString(1, studentObj.getStudentID());
            statmentObj.execute();
            ResultSet resultObj = statmentObj.getResultSet();
            
            if(resultObj.next()){
                String studentID = resultObj.getString(1);
                String name = resultObj.getString(1);
                String surname = resultObj.getString(1);
                String contact = resultObj.getString(1);
                String address = resultObj.getString(1);
                studentObj = new StudentDetails(studentID, name, surname, contact, address);
            }
            statmentObj.close();
            con.close();
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("An error has occured: "+exc);
        }
        return studentObj;
    }
}
