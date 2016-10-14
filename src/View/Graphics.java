package View;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

/**
 * Graphics library
 */
/**
 * @author Lucy Zhang
 *
 */
public class Graphics {
	
	public Image createImage(String imageLocation) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageLocation));
		return image;
	}

	public ImageView createImageView(Image image) {
		return new ImageView(image);
	}

	public void setBackgroundImage(Group root, String imageLocation) {
		Image image = createImage(imageLocation);
		ImageView background = createImageView(image);
		root.getChildren().add(background);
		setImageViewParams(background, 0, 0, Screen.getPrimary().getVisualBounds().getWidth(),
				Screen.getPrimary().getVisualBounds().getHeight());
	}

	public void setBackgroundImage(Group root, String imageLocation, double width, double height) {
		Image image = createImage(imageLocation);
		ImageView background = createImageView(image);
		root.getChildren().add(background);
		setImageViewParams(background, 0, 0, width, height);
	}

	public void setImageViewParams(ImageView image, double x, double y, double width, double height) {
		image.setX(x);
		image.setY(y);
		image.setFitHeight(height);
		image.setFitWidth(width);
	}

	public void setImageViewParams(ImageView image, double x, double y) {
		image.setX(x);
		image.setY(y);
	}

	public Button createButton(String label) {
		Button button = new Button(label);
		return button;
	}

	public Button createButton(String label, int x, int y) {
		Button button = new Button(label);
		button.setLayoutX(x);
		button.setLayoutY(y);
		return button;
	}
	
	public VBox createVBoxPane(int width, int height) {
		VBox vbox = new VBox(10);
		vbox.setMaxWidth(width);
		vbox.setMinWidth(width);
		vbox.setMinHeight(height - 30);
		vbox.setPadding(new Insets(15));
		return vbox;
	}
	
	public VBox createVBoxPane(int width, int height, Insets insets) {
		VBox vbox = createVBoxPane(width, height);
		vbox.setPadding(insets);
		return vbox;
	}
	public Text createText(Group root, double x, double y, String text) {
		Text t = new Text(x, y, text);
		root.getChildren().add(t);
		return t;
	}

	public void setTextAttributes(Text text, Color color, Font font, String id) {
		text.setFill(color);
		text.setFont(font);
		text.setId(id);
	}

	public BorderPane createBorderPane(Group root, int width, int height) {
		BorderPane border = new BorderPane();
		border.setPrefWidth(width * 1.95);
		border.setPrefHeight(height);
		root.getChildren().add(border);
		return border;
	}

	public Rectangle createRectCell(double x, double y, double width, double height, Color stroke, Color fill) {
		Rectangle r = new Rectangle();
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);
		r.setFill(fill);
		r.setStroke(stroke);
		return r;
	}

	public TextArea createConsoleTextArea(double width, double height) {
		TextArea consoleArea = new TextArea();
		consoleArea.setPrefHeight(height);
		consoleArea.setPrefWidth(width);
		return consoleArea;
	}
	
	public ComboBox<String> createComboBox(String[] languages){
		ComboBox<String> combo = new ComboBox<>();
		combo.getItems().addAll(languages);
		return combo;
		
	}

}
