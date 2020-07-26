/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

/**
 *
 * @author Christiaan Bouwer VVF6HCS19
 */
public class StudentDetails implements java.io.Serializable {

    private String studentID, name, surname, contact, address;

    public StudentDetails(String studentID, String name, String surname, String contact, String address) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.contact = contact;
        this.address = address;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
