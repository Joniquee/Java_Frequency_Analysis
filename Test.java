package Homework;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
            String filename1;
            String filename2;

            System.out.println("Enter the path to the file to read: ");
            Scanner input1 = new Scanner(System.in);
            filename1 = input1.nextLine();

            try{
                FileInputStream fis = new FileInputStream(filename1);
                int symbol;
                try {
                    while ((symbol = fis.read()) != -1) {
                        if (frequencyAnalysis.inAlphabet(symbol)) {
                            frequencyAnalysis.addSymbol((char)symbol);
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Not possible to read from file");
                    return;
                }finally {
                    try{
                        fis.close();
                    } catch (IOException e) {
                        System.out.println("Not possible to close file");
                    }
                }
            }catch (FileNotFoundException e) {
                System.out.println("File does not exist");
                return;
            }


            System.out.println("Enter the path to the result file: ");
            Scanner input2 = new Scanner(System.in);
            filename2 = input2.nextLine();

            File file = new File(filename2);
            if (!file.exists()){
                System.out.println("File does not exist, but we will try to fix it");
                try{
                    if(file.createNewFile()) System.out.println("File was created");
                    else{
                        System.out.println("File did not created");
                        return;
                    }
                } catch (IOException e) {
                    System.out.println("Not possible to create a new file");
                    return;
                }
            }
            try{
                FileOutputStream fos = new FileOutputStream(file.getPath());
                try {
                    if (frequencyAnalysis.getTable().length == 0) {
                        System.out.println("The process have finished correct");
                        return;
                    }
                    for (int i = 0; i<frequencyAnalysis.getTable().length; i++) {
                        fos.write(frequencyAnalysis.getTable()[i].getBytes());
                        fos.write("\n".getBytes());
                    }
                } catch (IOException e) {
                    System.out.println("Not possible to fill the file");
                    return;
                }
                finally {
                    try{
                        fos.close();
                    } catch (IOException e1) {
                        System.out.println("Not possible to close the file");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist, and I don`t know why....");
            }

            System.out.println("The process have finished correct");
        }
}
