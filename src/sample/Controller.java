package sample;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Controller {

    public Button zvacsiBtn,zmensiBtn;
    public Label labelAhoj;
    public void zmensiButtony()
    {
        labelAhoj.setFont(new Font(+20));

    }

    public void zvacsiButtony()
    {
        System.out.println(labelAhoj.getFont());
        labelAhoj.setFont(new Font(+40));

    }


}
