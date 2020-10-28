package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ghost
 */
public class Cliente {
    private void conectar_servidor(){
        try{
            // Se crea un enlace al registro con la ip del servidor
            // y el puerto que se va usar.
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 9999);

            // Busca el objeto remoto en el registro RMI de la máquina remota.
            // Se usa el mismo nombre que tiene el servidor "mates"
            // utilizando la interfaz que ya se ha creado (casting).
            iRMI interfaz = (iRMI)registro.lookup("mates");

            int suma;

            // Aquí se hace la invocación al método remoto: sumar()
            // como si se tratara de un método local
            suma = interfaz.sumar(5, 9);
            System.out.println("La suma es " + suma);
        }
        catch(RemoteException | NotBoundException rex){
            System.out.println(rex.getMessage());
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.conectar_servidor();
    }
}
