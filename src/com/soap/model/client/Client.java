package com.soap.model.client;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.soap.model.BeanLogin;
import com.soap.service.ImplLogin;
import com.soap.service.ImplLoginProxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplLogin impl= new ImplLoginProxy();
		BeanLogin obj= new BeanLogin();
		int opcion=2;
		do{
			opcion=Integer.parseInt(JOptionPane.showInputDialog(null,""
					+ "1.Login \n"
					+ "2.salir"));
			switch(opcion){
			case 1: obj.setUser(JOptionPane.showInputDialog(null,"Ingrese user "));
					obj.setPassword(JOptionPane.showInputDialog(null,"Ingrese password "));
				try {
					obj=impl.validadLogin(obj);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			}
			if(obj.isStatus()){
				JOptionPane.showMessageDialog(null,obj.getMessage());
			}else{
				JOptionPane.showMessageDialog(null,obj.getMessage());
			}
		}while(opcion!=2);
	}

}
