/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.*;

/**
 *
 * @author Ghost
 */
public interface iRMI extends Remote{
    public int sumar(int n1, int n2)throws RemoteException;
    
}
