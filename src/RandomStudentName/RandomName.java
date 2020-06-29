package RandomStudentName;

import javax.swing.JOptionPane;
import javax.xml.soap.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RandomName extends Application{

    Button button;
    Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Get Random Name");
        String[] names = new String[]{"Shakur Ahmed", "Prithvi Atani", "Diming Chu", "Sumid Dhungel", "Jason H"
                , "Yan Huang", "Honorine icyitegetse", "Scott Jhou", "Shahriar Kabir", "dongshuo li", "Kun Li",
                "Kelly Liu", "Junyu Liu", "Louisss", "Shahbaz Mansahia", "Ahmed Mujtaba", "Ola Temitope Olanrewaju",
                "shrina Patel", "Siyu Qiu", "TAO TAO", "Abby Truong", "Muhammed Rabiu Umar", "Peiqi Wang", "Samuel Yang"
                , "Richard Zhou"};
//        String[] names = readString("names.txt");
//        System.out.println(Arrays.toString(names));
        button = new Button();
        label = new Label();
        button.setText("Get one");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = getName(names);
                label.setText(name);
            }
        });

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        grid.add(label, 2, 1);
        grid.add(button, 1,1);

        Scene scene = new Scene(grid, 240, 80);
        primaryStage.setScene(scene);
        primaryStage.show();
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

    public String getName(String[] names){
        int index = getRandom(names.length);
        return names[index];
//        JOptionPane.showMessageDialog(null,
//                names[index],
//                "A Random Student Name",
//                JOptionPane.PLAIN_MESSAGE);
    }

    private int getRandom(int len){
        return (int)(Math.random() * (len));
    }
}
