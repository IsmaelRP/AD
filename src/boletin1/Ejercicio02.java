package boletin1;

import teclado.Teclado;

import java.io.File;
import java.io.IOException;

public class Ejercicio02 {

    public static void main(String[] args) {

        File fileFolder;
        File file1;
        File file2;
        File file3;
        File delete;
        File rename;
        File renameAux;
        File subFolder;
        File subFile;
        String folder;
        String aux;
        Boolean flag;
        String content[];

        System.out.printf("Introduzca el nombre del directorio: ");

        folder = Teclado.leerString();
        folder = "C:\\Users\\Usuario\\IdeaProjects\\AD\\src\\boletin1\\" + folder;

        fileFolder = new File(folder);

        if (!fileFolder.mkdir()) {
            System.out.printf("Ya existe un directorio %s", folder);
        } else {

            for (int i = 1; i < 4; i++) {

                do {
                    flag = false;
                    System.out.printf("Introduzca el nombre del %d fichero: ", i);
                    aux = Teclado.leerString();
                    file1 = new File(folder, aux);

                    if (file1.exists()) {
                        flag = true;
                        System.out.printf("Ya existe el fichero \"%s\"\n", aux);
                    }

                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        flag = true;
                    }
                } while (flag);

            }

            do {
                flag = false;
                System.out.printf("Elija un archivo anteriormente creado para borrar: ");
                aux = Teclado.leerString();
                delete = new File(folder, aux);
                if (delete.exists()) {
                    delete.delete();
                } else {
                    System.out.printf("El fichero \"%s\" no existe\n", aux);
                    flag = true;
                }
            } while (flag);

            do {
                flag = false;
                System.out.printf("Elija un archivo anteriormente creado para renombrar: ");
                aux = Teclado.leerString();
                rename = new File(folder, aux);
                if (rename.exists()) {
                    do {
                        System.out.printf("Elija el nuevo nombre de \"%s\": ", aux);
                        aux = Teclado.leerString();

                        renameAux = new File(folder, aux);


                        flag = false;

                        if (renameAux.exists()) {
                            flag = true;
                            System.out.printf("El nombre, \"%s\" ya existe, elija otro: ", aux);
                        } else {
                            rename.renameTo(renameAux);

                            do{
                                flag = false;
                                System.out.printf("Elija el nombre para un subdirectorio dentro de \"%s\": ",fileFolder.getName());
                                aux = Teclado.leerString();
                                subFolder = new File(folder + "\\" + aux);

                                if (subFolder.exists()){
                                    flag = true;
                                    System.out.printf("El subdirectorio, \"%s\" ya existe, elija otro: ", aux);
                                }else{
                                    subFolder.mkdir();

                                    do{
                                        flag = false;
                                        System.out.printf("Elija el nombre para un fichero dentro de \"%s\": ",subFolder.getName());
                                        aux = Teclado.leerString();

                                        subFile = new File(subFolder.getAbsolutePath(), aux);

                                        if (subFile.exists()){
                                            flag = true;
                                            System.out.printf("El fichero, \"%s\" ya existe, elija otro: ", aux);
                                        }else{
                                            try {
                                                subFile.createNewFile();
                                            } catch (IOException e) {
                                                System.out.printf("ERROR CREANDO EL SUBFICHERO");
                                            }
                                            System.out.printf("\nRuta absoluta primer directorio: %s\nRuta absoluta segundo directorio: %s\n",fileFolder.getAbsolutePath(),subFolder.getAbsolutePath());

                                            content = fileFolder.list();

                                            for (int i = 0;i< content.length;i++){
                                                System.out.printf("%dº Archivo dentro de %s: %s\n",i+1,fileFolder.getName(),content[i]);
                                            }
                                            content = subFolder.list();
                                            for (int i = 0;i< content.length;i++){
                                                System.out.printf("%dº Archivo dentro de %s: %s\n",i+1,subFolder.getName(),content[i]);
                                            }
                                        }

                                    }while(flag);
                                }

                            }while(flag);

                        }

                    } while (flag);

                } else {
                    System.out.printf("El fichero \"%s\" no existe\n", aux);
                    flag = true;
                }
            } while (flag);


        }


    }


}
