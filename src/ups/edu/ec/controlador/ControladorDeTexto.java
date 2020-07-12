/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ControladorDeTexto {

    private File fichero;

    public ControladorDeTexto() {

    }

    public boolean comprobarRuta(String ruta) {
        fichero = new File(ruta);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobar(String ruta, String nombre) {
        nombre = nombre.concat(".txt");
        fichero = new File(ruta + File.separator + nombre);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String crearFichero(String ruta, String nombre) {

        nombre = nombre.concat(".txt");
        fichero = new File(ruta + File.separator + nombre);

        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fichero.getAbsolutePath();
    }

    public void encriptar(String rutaAbsoluta, String texto) {

        char arrayD[] = texto.toCharArray();
        for (int i = 0; i < arrayD.length; i++) {
            arrayD[i] = (char) (arrayD[i] - (char) 5);
        }
        String desencriptado = String.valueOf(arrayD);
        System.out.println(desencriptado);
        try {

            FileReader archivoLectura = new FileReader(rutaAbsoluta);
            BufferedReader lectura = new BufferedReader(archivoLectura);

            archivoLectura.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ruta no encontrada");
        } catch (IOException ex1) {
            System.out.println("Error de escritura");
        } catch (Exception ex2) {
            System.out.println("Error ");
        }
    }

    public String desencriptar(String rutaAbsoluta) throws IOException {
        String var = "";
        try {

            FileReader ficheroOrigen = new FileReader(rutaAbsoluta);
            BufferedReader archivoLectura = new BufferedReader(ficheroOrigen);

            int valor = archivoLectura.read();

            while (valor != -1) {
                char aux = (char) valor;
                var = var.concat(Character.toString(aux));
                valor = archivoLectura.read();
            }

            archivoLectura.close();

        } catch (FileNotFoundException ex2) {
            System.out.println("File noencontrado");
        }

        char arrayD[] = var.toCharArray();
        for (int i = 0; i < arrayD.length; i++) {
            arrayD[i] = (char) (arrayD[i] - (char) 5);
        }
        String desencriptado = String.valueOf(arrayD);
        System.out.println(desencriptado);

        return desencriptado;
    }
}
