package sample;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Controller
{
    public Button zvacsiBtn,zmensiBtn;
    public Label labelAhoj;

    public void decrease_font_size()
    {
        labelAhoj.setFont(new Font(labelAhoj.getFont().getSize() - 20));
    }
    public void increase_font_size()
    {
        labelAhoj.setFont(new Font(labelAhoj.getFont().getSize() + 20));
    }

}
