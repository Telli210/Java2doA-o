package Datos;
import java.io.*;


import LogicadeNegocio.Stock;
public class GuardarDatos {
	//Lote numero 1
	public void grabar(Stock x) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream("fichero.Txt");
		ObjectOutputStream out= new ObjectOutputStream(fileOutputStream);
		out.writeObject(x);
		out.close();
	}
	//----------------------
	public Stock recuperar()throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("fichero.Txt");
		ObjectInputStream input= new ObjectInputStream(fileInputStream);
		Stock n1= (Stock) input.readObject();
		input.close();
		return n1;
	}

}