/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Christiaan Bouwer VVF6HCS19
 */
public class RMIServer {
         
    public RMIServer() throws RemoteException, AlreadyBoundException{
        RMIImpInterface serverObj = new RMIImpInterface();
        Registry regObj = LocateRegistry.createRegistry(1555);
        regObj.bind("RMIImpInterface", serverObj);
    }
}
