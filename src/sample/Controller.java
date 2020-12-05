package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Controller {

    public BorderPane borderpane_uloha2;
    public Label labelAhoj;
    public Circle circle;
    public Rectangle rectangle;

    public Circle uloha5_circle;
    public ColorPicker outer_color;
    public ColorPicker inner_color;

    public TextField login;
    public PasswordField password;
    public Button hide;

    public void decrease_font_size()
    {
        labelAhoj.setFont(new Font(labelAhoj.getFont().getSize() - 20));
    }

    public void increase_font_size()
    {
        labelAhoj.setFont(new Font(labelAhoj.getFont().getSize() + 20));
    }

    public void circle_to_left()
    {
        circle.setCenterX(circle.getCenterX()-20);
    }

    public void circle_to_right()
    {
        circle.setCenterX(circle.getCenterX()+20);
    }

    public void rectangle_rainbow()
    {
        Stop[] stops = new Stop[] { new Stop(0, Color.RED), new Stop(1, Color.YELLOW)};
        LinearGradient linear = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        rectangle.setFill(linear);
    }

    public void change_outer_color()
    {
        uloha5_circle.setStroke(outer_color.getValue());
    }

    public void change_inner_color()
    {
        uloha5_circle.setFill(inner_color.getValue());
    }

    public void submit()
    {
        if (login.getText().equals("admin") && password.getText().equals("password"))
        {
            if (hide.getText().equals("Skry"))
            {
                hide.setText("Odkry");
                borderpane_uloha2.setVisible(false);
            }
            else
            {
                hide.setText("Skry");
                borderpane_uloha2.setVisible(true);
            }

            login.setText(null);
            password.setText(null);
        }
    }
}
