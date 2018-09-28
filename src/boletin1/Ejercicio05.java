package boletin1;

import teclado.Teclado;

import java.io.*;

public class Ejercicio05 {

    public static void main(String[] args) {

        String path = "C:\\Users\\Usuario\\IdeaProjects\\AD\\src\\boletin1\\";
        String destin;
        String fileOrigin;
        String directory;
        boolean flag;
        File file1;
        File file2;
        BufferedReader reader;
        PrintWriter print;
        String printScreen;
        boolean options;
        int intValueOfChar;
        char buffer[];
        int bufferDim = 0;

        options = false;             //Se modifica este boolean para ver en que apartado de los boolean entra

        do {     //Comprobamos que el archivo origen exista
            flag = false;
            System.out.printf("Introduzca un archivo origen: ");
            fileOrigin = Teclado.leerString();

            file1 = new File(path, fileOrigin);

            if (!file1.exists() || !file1.isFile()) {
                flag = true;
                System.out.printf("El fichero %s no es válido\n", fileOrigin);
            }
        } while (flag);

        System.out.printf("Introduzca un destino (fichero o directorio): ");
        directory = Teclado.leerString();
        destin = path + directory;

        file2 = new File(destin);

        if (file2.isDirectory()) {       //Primer apartado, si el destino es un directorio, se creará un archivo con el mismo nombre
            file2 = new File(destin, directory + ".txt");
            if (file2.exists()) {        //Aqui comprobamos que no haya un archivo con el mismo nombre anteriormente
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
                while ((printScreen = reader.readLine()) != null) {
                    print.println(printScreen);                          //Empieza a escribir línea por línea hasta que no haya más
                }
                reader.close();
                print.close();
            } catch (FileNotFoundException e) {
                System.out.printf("No se ha encontrado el fichero");
            } catch (IOException e) {
                System.out.printf("Error de E/S");
            }

        } else if (options && file2.exists()) {     //Segundo apartado, si el destino es un archivo, el boolean es True y existe

            try {
                reader = new BufferedReader(new FileReader(file1));     //Volvemos a inicializar el Reader para que comience desde el principio
                print = new PrintWriter(new FileWriter(file2));         //Esta vez no ponemos el parámetro "true" para que nos borre si hay algo escrito en el fichero
                printScreen = "";
                while ((intValueOfChar = reader.read()) != -1) {
                    printScreen += (char) intValueOfChar;               //Va leyendo carácteres uno a uno (en su valor numérico) y los va convertiendo en Char
                }
                print.print(printScreen);
                reader.close();
                print.close();
            } catch (FileNotFoundException e) {
                System.out.printf("No se ha encontrado el fichero");
            } catch (IOException e) {
                System.out.printf("Error de E/S");
            }

        } else if (options && !file2.exists()) {        //Tercer apartado, si el destino es un archivo, el boolean es True y no existe
            try {
                throw new Exception("No existe el fichero");
            } catch (Exception e) {
                System.out.printf("Exception Error, no existe el fichero");
            }
        }else if(!options && file2.exists()){                 //Cuarto apartado, si el destino es un archivo, el boolean es False y existe

            try {
                reader = new BufferedReader(new FileReader(file1));
                print = new PrintWriter(new FileWriter(file2));

                buffer = new char[10];

                while((reader.read(buffer)) != -1){
                    print.write(buffer);
                }

                reader.close();
                print.close();

            } catch (FileNotFoundException e) {
                System.out.printf("No se ha encontrado el fichero");
            } catch (IOException e) {
                System.out.printf("Error de E/S");
            }


        }else if(!options && !file2.exists()){             //Quinto apartado, si el destino es un archivo, el boolean es False y no existe
            System.out.printf("El archivo \"%s\" es inexistente, no se ha podido realizar la copia",file2.getName());
        }

    }
}
