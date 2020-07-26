/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import java.rmi.*;

/**
 *
 * @author Christiaan Bouwer VVF6HCS19
 */
public interface StudentInterface extends Remote{
    StudentDetails readFromDatabase(String id) throws RemoteException;
}
