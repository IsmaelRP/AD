package boletin1;

import teclado.Teclado;

import java.io.File;

public class ejercicio03 {

    public static void main(String[] args) {

        String path;
        File folder;
        String aux[];

        do{
            System.out.printf("Introduzca el nombre de un directorio: ");
            path = Teclado.leerString();

            folder = new File(path);

        }while (!folder.exists() || !folder.isDirectory());

        aux = folder.list();

        System.out.printf("\n%s",folder.getAbsolutePath());

        for (int i=0; i<aux.length;i++){

        }







    }

}
