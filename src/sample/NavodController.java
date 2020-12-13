package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NavodController implements Initializable
{
    public TextArea textAreaU14;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File file = new File("navod.txt");
        try (Scanner input = new Scanner(file))
        {
            while (input.hasNextLine())
            {
                textAreaU14.appendText(input.nextLine() + "\n");
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }
}
