/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panaderiatriunfo.ui;

import Datos.Inventario;
import Datos.Producto;

/**
 *
 * @author ERVYSAD
 */
import Logica.Logica;
import Datos.Producto;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class PanaderiaTriunfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Panaderia El Triunfo");
        System.out.println("Telefono: 315 254 8420");
        System.out.println("Direccion: Cll26 No.33a-25 Bgta");
        
        
            Inventario inventario = new Inventario();            
            Logica logica = new Logica(inventario.getListProducto()); 
            logica.Productos();
            
            
            
            
           
           
            
            System.out.println("Menú Principal"); 
           
          System.out.println("¿Que desea hacer?");
          
          System.out.println("1. Registrar un producto");
          System.out.println("2. Eliminar un producto");
          System.out.println("3. Hacer una venta de producto");
          System.out.println("4. Cambiar un precio");
          
         Scanner capt5 = new Scanner(System.in);
               int a = capt5.nextInt();
               
               
          if (a==1) {
               inventario.agregarProducto(logica.creaar()); 
               logica.ResgistrarProducto();
        }
          if (a==2){
              logica.BorrarProducto();
              logica.ResgistrarProducto();
          }
          if (a==3) {
            logica.venta();
            logica.ResgistrarProducto();
        }
          if (a==4) {
            logica.ModificarPrecio();
        }
    }
    
}
