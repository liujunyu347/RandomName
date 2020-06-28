package RandomStudentName;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class RandomName {
    public static void main(String[] args) {
        RandomName RN = new RandomName();
        String[] names = RN.readString("names.txt");
//        String[] names = new String[]{"Shakur Ahmed", "Prithvi Atani", "Diming Chu", "Sumid Dhungel", "Jason H"};
        RN.printName(names);
    }

    public String[] readString(String path){
        int count = 0;
        try{
            Scanner s1 = new Scanner(new File(path));
            while(s1.hasNextLine()){
                s1.nextLine();
                count++;
            }

            String[] names = new String[count];
            Scanner s2 = new Scanner(new File(path));
            for (int i = 0; i < count; i++){
                names[i] = s2.nextLine();
            }
            return names;
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        return null;
    }

    public void printName(String[] names){
        int index = getRandom(names.length);
        JOptionPane.showMessageDialog(null,
                names[index],
                "A Random Student Name",
                JOptionPane.PLAIN_MESSAGE);
    }

    private int getRandom(int len){
        return (int)(Math.random() * (len));
    }
}
