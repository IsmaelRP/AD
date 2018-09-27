package boletin1;

import teclado.Teclado;

import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class ejercicio04 {

    public static void main (String [ ] args) {

        String dir;
        String ext;
        File file;
        File[] files;
        FilenameFilter filter;

        System.out.printf("Introduzca el nombre de un directorio: ");
        dir = Teclado.leerString();
        dir = "C:\\Users\\Usuario\\IdeaProjects\\AD\\src\\boletin1\\" + dir;

        file = new File(dir);

        System.out.printf("Introduzca una extensión: ");
        ext = Teclado.leerString();


        filter = new FilenameFilter() {
            @Override
            public boolean accept(File directory, String name) {
                boolean result = false;
                if (name.toLowerCase().endsWith(ext)) {
                    result = true;
                }
                return result;
            }
        };

        files = file.listFiles(filter);

        for (File aux : files){
            System.out.printf("%s\n",aux.getAbsolutePath());
        }

    }


}
