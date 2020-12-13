package sample;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private boolean check_if_clicked = false;
    AnimationTimer timer;
    private int speed;

    private boolean check_duha = true;
    public Pane duha;
    private boolean check_kruh = true;
    public Pane Kruh;

    public Slider slider;
    public TextField text_slider;

    public SplitPane splitPaneU11;
    public TextField textFieldUloha11;

    public ImageView imageU12;

    public ComboBox<Shape> comboBox;
    public BorderPane borderPane_U13;


    //uloha 2

    public void decrease_font_size()
    {
        labelAhoj.setFont(new Font(labelAhoj.getFont().getSize() - 20));
    }

    public void increase_font_size()
    {
        labelAhoj.setFont(new Font(labelAhoj.getFont().getSize() + 20));
    }

    //uloha 3

    public void circle_to_left()
    {
        circle.setCenterX(circle.getCenterX() - 20);
    }

    public void circle_to_right()
    {
        circle.setCenterX(circle.getCenterX() + 20);
    }

    //uloha 4

    public void rectangle_rainbow()
    {
        Stop[] stops = new Stop[]{new Stop(0, Color.RED), new Stop(1, Color.YELLOW)};
        LinearGradient linear = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        rectangle.setFill(linear);
    }

    //uloha 5

    public void change_outer_color()
    {
        uloha5_circle.setStroke(outer_color.getValue());
    }

    public void change_inner_color()
    {
        uloha5_circle.setFill(inner_color.getValue());
    }

    //uloha 6

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

    //uloha 7

    public void bullet_start()
    {
        if (check_if_clicked)
        {
            bullet.setFill(null);
        }
        speed = 5;
        bullet = new Rectangle(20, 5, Color.BLACK);
        bullet.setY(50);
        bullet.setX(0);
        anchorPaneBullet.getChildren().add(bullet);
        check_if_clicked = true;
        timer.start();
    }

    //úloha 9
    public void Duha_hide()
    {
          if (check_duha)
          {
              duha.setVisible(false);
              check_duha = false;
          }
          else
          {
              duha.setVisible(true);
              check_duha = true;
          }
    }


    public void Kruh_hide()
    {
        if (check_kruh)
        {
            Kruh.setVisible(false);
            check_kruh = false;
        }
        else
        {
            Kruh.setVisible(true);
            check_kruh = true;
        }
    }


    //úloha10

    public void slider_change()
    {
        hide.setPrefWidth(50 * slider.getValue());
        text_slider.setText(String.valueOf(50 * slider.getValue()));
    }

    //uloha 12
    public void image_change()
    {
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(imageFilter);
        File file = fc.showOpenDialog(new Stage());
        if (file != null)
        {
            Image image = new Image(file.toURI().toString());
            imageU12.setImage(image);
        }
    }
    //uloha 13

    public void shapeShow(ActionEvent actionEvent)
    {
        borderPane_U13.setCenter(comboBox.getValue());
    }

    //uloha 14

    public void showNavod(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("navod.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
            Stage stage = new Stage();
            stage.setTitle("Navod");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
        catch (IOException e)
        {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //casovac pre ulohu 7

        timer = new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {
                bullet.setLayoutX(bullet.getLayoutX() + speed);
                if (bullet.getLayoutX() >= anchorPaneBullet.getPrefWidth() ||
                        bullet.getLayoutX() <= 0) speed = -speed;

            }
        };

        // uloha11

        splitPaneU11.getDividers().get(0).positionProperty().addListener((obs, oldVal, newVal) ->
        {
            textFieldUloha11.setText("L: " + Math.round(newVal.doubleValue() * 100) + "% R: " + (100 - Math.round(newVal.doubleValue() * 100)) + "%");
        });

        // uloha13

        Circle circle_13 = new Circle(20, 5, 10, Color.BLACK);
        Rectangle rectangle_13 = new Rectangle(20, 5, Color.BLACK);
        Ellipse ellipse_13 = new Ellipse(20, 5, 10, 5);
        ObservableList<Shape> options = FXCollections.observableArrayList(circle_13, rectangle_13, ellipse_13);
        comboBox.setItems(options);


    }
}
