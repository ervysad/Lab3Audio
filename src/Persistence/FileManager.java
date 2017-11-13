/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author ERVYSAD
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    public FileManager() {
    }
        private FileWriter fileWriter;
       
     public List<String> readFileInventario() throws IOException {
            List<String> listLines;
            listLines = Files.readAllLines(Paths.get("src/Persistence/Inventario.txt"));
            return listLines;		
	}
     
     public File open(String path){
	    File file = new File(path);
	        try {
	            fileWriter = new FileWriter(file);
	        } catch (IOException ex) {
	        }
	        return file;
	    }
     
     public void close(){
	    	try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void write(String cad){
	    	try {
				fileWriter.write(cad);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
}
}

