package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Controller {

    public Label labelAhoj;
    public Circle circle;
    public Rectangle rectangle;

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
}
