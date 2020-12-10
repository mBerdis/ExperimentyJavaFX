package sample;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

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

    public AnchorPane anchorPaneBullet;
    Rectangle bullet;
    AnimationTimer timer;

    public boolean check_duha =true;
    public Pane duha;
    public boolean check_kruh =true;
    public Pane Kruh;

    public Slider slider;
    public TextField text_slider;

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

            login.setText("");
            password.setText("");
        }
    }

    public void bullet_start()
    {
        bullet=new Rectangle(20,5,Color.BLACK);
        bullet.setY(50);
        bullet.setX(0);
        anchorPaneBullet.getChildren().add(bullet);
        timer.start();

        
    }

    //úloha9
    public void Duha_hide()
    {
          if (check_duha)
          {
              duha.setVisible(false);
              check_duha =false;
          }
          else
          {
              duha.setVisible(true);
              check_duha =true;
          }
    }


    public void Kruh_hide()
    {
        if (check_kruh)
        {
            Kruh.setVisible(false);
            check_kruh =false;
        }
        else
        {
            Kruh.setVisible(true);
            check_kruh=true;
        }
    }



    //úloha10

   public void slider_change()
   {
   hide.setPrefWidth(50*slider.getValue());
   text_slider.setText(String.valueOf(50*slider.getValue()));
   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        timer=new AnimationTimer()
        {
            int speed = 5;
            @Override
            public void handle(long l)
            {
                bullet.setX(bullet.getX() + speed);
                if (bullet.getX()>=anchorPaneBullet.getPrefWidth()||
                        bullet.getX()<=0) speed=-speed;

            }
        };

    }


}
