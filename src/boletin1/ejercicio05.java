package boletin1;

import teclado.Teclado;

import java.io.File;

public class ejercicio05 {

    public static void main(String[] args) {

        String path = "C:\\Users\\Usuario\\IdeaProjects\\AD\\src\\boletin1\\";
        String folder1;
        String folder2;
        String directory1;
        String directory2;
        boolean flag = false;
        File file1;
        File file2;

        do{     //Comprobamos que el primer directorio exista
            flag = false;
            System.out.printf("Introduzca un directorio: ");
            directory1 = Teclado.leerString();
            folder1 = path + directory1;

            file1 = new File(folder1);

            if (!file1.exists() || !file1.isDirectory()){
                flag = true;
                System.out.printf("El directorio %s no es válido\n",folder1);
            }
        }while(flag);

        do{     //Comprobamos que el segundo directorio exista
            flag = false;
            System.out.printf("Introduzca otro directorio: ");
            directory2 = Teclado.leerString();
            folder2 = path + directory2;

            file2 = new File(folder2);

            if (!file1.exists() || !file2.isDirectory()){
                flag = true;
                System.out.printf("El directorio %s no es válido\n",folder2);
            }
        }while(flag);

        if (file2.isDirectory()){       //Primer apartado, si el destino es un directorio, se creará un archivo con el mismo nombre
            flag = false;
            do{
                file2 = new File(folder2, directory1);
                if (file2.exists()){        //Aqui comprobamos que no haya un archivo con el mismo nombre anteriormente
                    System.out.printf("El archivo %s ya existe, elija otro\n", directory1);
                }
            }while(flag);
            file2.createNewFile();      //Creamos el archivo



        }




    }
}
