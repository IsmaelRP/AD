package boletin1;

import teclado.Teclado;

import java.io.*;

public class Ejercicio05 {

    public static void main(String[] args) {

        String path = "C:\\Users\\pc\\IdeaProjects\\AD\\src\\boletin1\\";
        String folderDestin;
        String fileOrigin;
        String directory;
        boolean flag;
        File file1;
        File file2;
        BufferedReader reader;
        FileWriter writer;
        PrintWriter print;
        String printScreen;

        do{     //Comprobamos que el archivo origen exista
            flag = false;
            System.out.printf("Introduzca un archivo origen: ");
            fileOrigin = Teclado.leerString();

            file1 = new File(path, fileOrigin);

            if (!file1.exists() || !file1.isFile()){
                flag = true;
                System.out.printf("El fichero %s no es válido\n",fileOrigin);
            }
        }while(flag);

        do{     //Comprobamos que el directorio destino exista
            flag = false;
            System.out.printf("Introduzca un directorio destino: ");
            directory = Teclado.leerString();
            folderDestin = path + directory;

            file2 = new File(folderDestin);

            if (!file2.exists() || !file2.isDirectory()){
                flag = true;
                System.out.printf("El directorio %s no es válido\n",folderDestin);
            }
        }while(flag);

        if (file2.isDirectory()){       //Primer apartado, si el destino es un directorio, se creará un archivo con el mismo nombre
            file2 = new File(folderDestin, directory + ".txt");
            if (file2.exists()){        //Aqui comprobamos que no haya un archivo con el mismo nombre anteriormente
                System.out.printf("Se ha borrado el archivo \"%s.txt\"\n", directory);
                file2.delete();
            }
            try {
                file2.createNewFile();      //Creamos el archivo
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader = new BufferedReader(new FileReader(file1));     //Inicializamos el Reader
                print = new PrintWriter(new FileWriter(file2, true));   //Inicializamos el PrintWriter junto con su FileWriter anónimo
                while((printScreen = reader.readLine()) != null){
                    print.println(printScreen);                          //Empieza a escribir línea por línea hasta que no haya más
                }
                reader.close();
                print.close();
            } catch (FileNotFoundException e) {
                System.out.printf("No se ha encontrado el fichero");
            } catch (IOException e) {
                System.out.printf("Error de E/S");
            }


        }else if(file2.isFile()){







        }




    }
}
