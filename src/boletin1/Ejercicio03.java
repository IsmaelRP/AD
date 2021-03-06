package boletin1;

import teclado.Teclado;

import java.io.File;

public class Ejercicio03 {

    public static void main(String[] args) {

        String path;
        File folder;

        System.out.printf("Introduzca un directorio para mostrar el contenido recursivamente: ");
        path = Teclado.leerString();
        folder = new File("C:\\Users\\Usuario\\IdeaProjects\\AD\\src\\boletin1\\" + path);
        System.out.printf("\n");

        listDirectories(folder, path);

    }

    public static void listDirectories(File directory, String separator){

        File[] files = directory.listFiles();
        boolean flag = false;
        String new_Separator;

        for (int x=0;x<files.length;x++){
            if (flag){
                System.out.printf("%s\n   %s - %s\n",separator, files[x].getName(), files[x].isFile()?"Es un fichero":"Es un directorio");
                flag = false;
            }else{
                System.out.printf("%s\n      %s - %s\n",separator, files[x].getName(), files[x].isFile()?"Es un fichero":"Es un directorio");
            }

            if (files[x].isDirectory()){
                new_Separator = "";
                new_Separator = separator + "\n   " +  files[x].getName();
                listDirectories(files[x],new_Separator);
                flag = true;
            }
        }
    }

}
