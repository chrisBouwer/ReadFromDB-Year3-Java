/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Christiaan Bouwer VVF6HCS19
 */
public class RMIClient implements ActionListener{
    JPanel panel;
    JTextField studentIDTf;
    JTextField nameTf;
    JTextField surnameTf;
    JTextField contactTf;
    JTextField addressTf;
    JButton clearBtn;
    JButton searchBtn;    
    
    public void createForm() { //creation of the GUI
        JFrame frame = new JFrame("Student details");
        panel = new JPanel();
        JLabel studentIDLbl = new JLabel("Student ID");
        JLabel nameLbl = new JLabel("First Name");
        JLabel surnameLbl = new JLabel("Last Name");
        JLabel contactLbl = new JLabel("Contact Number");
        JLabel addressIDLbl = new JLabel("Address");
        studentIDTf = new JTextField();
        nameTf = new JTextField();
        surnameTf = new JTextField();
        contactTf = new JTextField();
        addressTf = new JTextField();
        clearBtn = new JButton("Clear");
        searchBtn = new JButton("Search");
        clearBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        GridLayout gird = new GridLayout(6,2);
        
        panel.setLayout(gird);
        panel.add(studentIDLbl);
        panel.add(studentIDTf);
        panel.add(nameLbl);
        panel.add(nameTf);
        panel.add(surnameLbl);
        panel.add(surnameTf);
        panel.add(contactLbl);
        panel.add(contactTf);
        panel.add(addressIDLbl);
        panel.add(addressTf);
        panel.add(clearBtn);
        panel.add(searchBtn);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearBtn){
            studentIDTf.setText("");
            nameTf.setText("");
            surnameTf.setText("");
            contactTf.setText("");
            addressTf.setText("");
        } else if (e.getSource()==searchBtn){
            String studentID = studentIDTf.getText();
            if(!studentID.isEmpty()){
                Registry regObj;
                try {
                    regObj = LocateRegistry.getRegistry("localhost", 1555);
                    StudentInterface serv = (StudentInterface)regObj.lookup("RMIImpInterface");
                    StudentDetails stud = serv.readFromDatabase(studentID);
                    studentIDTf.setText(stud.getStudentID());
                    nameTf.setText(stud.getName());
                    surnameTf.setText(stud.getSurname());
                    contactTf.setText(stud.getContact());
                    addressTf.setText(stud.getAddress());
                } catch (RemoteException ex) {
                    Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("No studentID has been entered");
            }
        }
    }  
}
