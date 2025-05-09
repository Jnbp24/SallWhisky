package gui.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Billeder {

    public ImageView opretBillede(String imagePath, double width, double height) {
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        return imageView;

    }

}
