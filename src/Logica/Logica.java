/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ERVYSAD
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Datos.Producto;
import Persistence.FileManager;
import java.util.Iterator;
import javax.swing.JOptionPane;
import panaderiatriunfo.ui.PanaderiaTriunfo;



public class Logica {
  private List<Producto> listaProductos; 
  private FileManager fileManager;
  public double DineroPorVentast;
  public List<Producto> getListaProductos() {
        return listaProductos;
    }
  
  
   public Logica(List<Producto> list) {
        fileManager = new FileManager();
        listaProductos= list;
    }
   
 
   private String[] splitLine(String line, String separator){
        return line.split(separator);
    }
   
     private Producto crearProducto(String [] vector) throws NumberFormatException, Exception{
		return new Producto(vector[0], Double.parseDouble(vector[1]));
    }
    
    public void Productos(){
        try {            
            for (int i = 0; i < fileManager.readFileInventario().size(); i++) {                
                String[] vector = splitLine(fileManager.readFileInventario().get(i), ",");  
                listaProductos.add(crearProducto(vector));
            }
        } catch (IOException ex) {
            System.err.println("No se han podido cargar la informacion");
        } catch (Exception ex) {
        }
    }   
    
      
    public void ResgistrarProducto() {
        fileManager.open("src/Persistence/Inventario.txt");
        for (int i = 0; i <listaProductos.size(); i++) {
            fileManager.write(listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n");
        }
        fileManager.close();
    }
    
    public Producto creaar(){
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre a registrar");
                Double precio  = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio"));
                
                fileManager.open("src/Persistence/Inventario.txt");
        for (int i = 0; i <listaProductos.size(); i++) {
            fileManager.write(listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n");
        }
        fileManager.close();
        
                return new Producto(nombre, precio);
            
    
    }
    double DineroPorVentastotal = 0;
    public void BorrarProducto(){
        System.out.println("Dinero por ventas actual :" + DineroPorVentastotal);
        System.out.println("Los productos actuales son: " + "\n");
        for (int i = 0; i <listaProductos.size(); i++) {
            System.out.println(( (i+1) + " "+ listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n"));
        }
      
    
       
        System.out.println("Indique la posicion del elemento a elminiar");
        Scanner capt = new Scanner(System.in);
        int a = capt.nextInt();

            listaProductos.remove(a-1);
        
            System.out.println("Nueva lista de productos " +"\n");
            for (int i = 0; i <listaProductos.size(); i++) {
            System.out.println(((i+1) + " "+ listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n"));
        }
        fileManager.open("src/Persistence/Inventario.txt");
        for (int i = 0; i <listaProductos.size(); i++) {
            fileManager.write(listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n");
        }
        fileManager.close();
        
            }
    
    public double venta(){
        
         System.out.println("Dinero por ventas actual :" + DineroPorVentastotal);
        System.out.println("Los productos disponibles son: " + "\n");
        for (int i = 0; i <listaProductos.size(); i++) {
            System.out.println(( (i+1) + " "+ listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n"));
        }
        
        System.out.println("Seleccione el producto para la venta");
         Scanner capt = new Scanner(System.in);
        int a = capt.nextInt();

         System.out.println("Venta de tipo: ");
         System.out.println("1. detal");
         System.out.println("2. por mayor");
          Scanner capt1 = new Scanner(System.in);
        int b = capt1.nextInt();
        
        if (b==1) {
              DineroPorVentast = DineroPorVentast +  listaProductos.get(a-1).getPrecio();
             
          
        } 
        if (b==2) {
               System.out.println("a que precio al por mayor?");
               Scanner capt2 = new Scanner(System.in);
        int c = capt2.nextInt();
             DineroPorVentast = DineroPorVentast + c;
             
        }
        listaProductos.remove(a-1);
        fileManager.open("src/Persistence/Inventario.txt");
        for (int i = 0; i <listaProductos.size(); i++) {
            fileManager.write(listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n");
        }
        fileManager.close();
        
         System.out.println("Dinero por ventas nuevo :" + DineroPorVentast);
        DineroPorVentastotal = DineroPorVentast;
        return DineroPorVentastotal;
    }
    
    
        public double ModificarPrecio(){
            
            System.out.println("Productos Disponibles");  
            for (int i = 0; i <listaProductos.size(); i++) {
            System.out.println(( (i+1) + " "+ listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n"));
        }
        
        
        System.out.println("Seleccione producto a cambiar precio");
         Scanner capt8 = new Scanner(System.in);
        int t = capt8.nextInt();    
        
            System.out.println("Cual es el nuevo precio");
             Scanner capt5 = new Scanner(System.in);
        int u = capt5.nextInt();    
            
        listaProductos.get(t-1).setPrecio(u);
        
        fileManager.open("src/Persistence/Inventario.txt");
        for (int i = 0; i <listaProductos.size(); i++) {
            fileManager.write(listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n");
        }
        fileManager.close();
            System.out.println("Nuevos Precios!");
        for (int i = 0; i <listaProductos.size(); i++) {
            System.out.println(( (i+1) + " "+ listaProductos.get(i).getNombre()+","+listaProductos.get(i).getPrecio()+"\n"));
        }
        
            return u;
        }
   /* public void mostrarTodo(){
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(listaProductos.get(i).darInformacion());
        }    
    }
    */
}

