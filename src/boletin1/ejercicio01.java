package boletin1;

import teclado.Teclado;

import java.io.File;

public class ejercicio01 {

    public static void main (String [ ] args) {

        File file;
        String aux;

        System.out.printf("Introduzca el archivo: ");

        aux = Teclado.leerString();
        file = new File(".",aux);

        if (file.exists()){
            System.out.printf("\n\nNombre: %s\n%s es ejecutable\n%s está oculto\nRuta relativa: %s\nRuta absoluta: %s\nTamaño %d",file.getName(),file.canExecute()?"Si":"No",file.isHidden()?"Si":"No",file.getPath(),file.getAbsolutePath(),file.length());
        }else{
            System.out.printf("El archivo \"%s\" no existe ",aux);
        }


    }

}
