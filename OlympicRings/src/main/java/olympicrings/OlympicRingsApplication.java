package olympicrings;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OlympicRingsApplication extends Application {

  //Stroke width for the rings
  public static final double STROKE_WIDTH = 10.0d;

  //radius of the rings
  public static final int RING_RADIUS = 70;

  //diameter of the rings
  public static final int RING_DIAMETER = RING_RADIUS * 2;

  //Window width
  public static final int WINDOW_WIDTH = 600;

  //Window height
  public static final int WINDOW_HEIGHT = 400;

  //space between the rings
  public static final int RING_SPACING = 30;

  //First row of rings Y pos
  //calculated as the center of the window minus the Diameter of the first ring
  public static final int FIRST_ROW_Y = WINDOW_WIDTH / 2 - RING_DIAMETER;

  //second row of rings Y pos
  public static final int SECOND_ROW_Y = FIRST_ROW_Y + RING_RADIUS;

  //Text height from the bottom of the screen
  public static final int TEXT_Y_POSITION = 30;

  /**
   * Generate a ring segment given a radius and a start and end angle.
   *
   * @param center the x,y point at the the center of the ring
   * @param start  the start angle of the ring
   * @param length the length of the ring in degrees
   * @param colour the color of the ring
   * @return Arc the arc segment of the ring
   */
  private static Arc generateRingSegment(Point2D center, int start,
      int length,
      Color colour) {
    Arc arc = new Arc(center.getX(), center.getY(), OlympicRingsApplication.RING_RADIUS,
        OlympicRingsApplication.RING_RADIUS, start, length);
    arc.setFill(null);
    arc.setStroke(colour);
    arc.setStrokeWidth(STROKE_WIDTH);
    return arc;
  }

  /**
   * Generates a 2d array, contains X/Y coordinates of each of the rings centers
   *
   * @return Point2d[] an array of ring centers [1....]
   */
  private static Point2D[] generateRingPositions() {
    //xy position of each ring
    //Stored as point2D[1...]

    Point2D[] ringPositions = new Point2D[5];

    //ROW 1
    //ring 0
    ringPositions[0] = new Point2D(
        RING_RADIUS + ((WINDOW_WIDTH - (3 * RING_DIAMETER) - (2 * RING_SPACING)) / 2), FIRST_ROW_Y);

    //ring 1
    ringPositions[1] = new Point2D(ringPositions[0].getX() + RING_DIAMETER + RING_SPACING,
        FIRST_ROW_Y);

    //ring 2
    ringPositions[2] = new Point2D(ringPositions[1].getX() + RING_DIAMETER + RING_SPACING,
        FIRST_ROW_Y);

    //ROW 2
    //ring 3
    ringPositions[3] = new Point2D((ringPositions[0].getX() + ringPositions[1].getX()) / 2,
        SECOND_ROW_Y);

    //ring 4
    ringPositions[4] = new Point2D((ringPositions[1].getX() + ringPositions[2].getX()) / 2,
        SECOND_ROW_Y);

    return ringPositions;
  }


  public static void main(String[] args) {
    launch();
  }


  @Override
  public void start(Stage stage) {

    // generate the center of each of the rings
    Point2D[] ringPositions = generateRingPositions();

    //initialize the pane
    Pane pane = new Pane();

    //generate the rings
    Scene scene = new Scene(pane, WINDOW_WIDTH, WINDOW_HEIGHT);

    //set the scene to the stage
    stage.setScene(scene);

    //set the title of the stage
    stage.setTitle("Olympic Rings");

    //Draw first red segment
    pane.getChildren()
        .add(generateRingSegment(ringPositions[2], -70, 290,
            Color.RED));

    //draw first green
    pane.getChildren()
        .add(generateRingSegment(ringPositions[4], 40, 100,
            Color.GREEN));

    //draw first black segment
    pane.getChildren()
        .add(generateRingSegment(ringPositions[1], -70, 290, Color.BLACK));

    //draw first gold segment goes in-front of black segment
    pane.getChildren()
        .add(generateRingSegment(ringPositions[3], 40, 100,
            Color.GOLD));

    //draw first blue segment goes in-front of gold segment
    pane.getChildren()
        .add(generateRingSegment(ringPositions[0], 0, 360,
            Color.BLUE));

    //close the gold ring going in-front of blue
    pane.getChildren()
        .add(generateRingSegment(ringPositions[3], 40, -260,
            Color.GOLD));

    //close the black ring, going in-front of gold
    pane.getChildren()
        .add(generateRingSegment(ringPositions[1], -70, -70,
            Color.BLACK));

    //close the green ring, going in-front of black
    pane.getChildren()
        .add(generateRingSegment(ringPositions[4], 40, -260,
            Color.GREEN));

    //close the black ring, going in-front of gold
    pane.getChildren()
        .add(generateRingSegment(ringPositions[2], -70, -70,
            Color.RED));

    //add text to the center of the screen
    Text text = new Text("Olympic Rings");
    text.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.ITALIC, 16));
    text.setX(WINDOW_WIDTH / 2d - text.getLayoutBounds().getWidth() / 2);
    text.setY(WINDOW_HEIGHT - TEXT_Y_POSITION);

    //add the text to the pane
    pane.getChildren().add(text);

    //disable the resize of the window
    stage.setResizable(false);

    //show the stage
    stage.show();
  }


}