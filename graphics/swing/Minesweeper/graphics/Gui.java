package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui {
  private JFrame frame;
  private JLabel label;

  public static void main(String[] args) {
    new Gui();
  }

  Gui() {
    frame = new JFrame("MineSweeper");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // TODO: Remove this.
    label = new JLabel("This is a test.");

    frame.pack();
    frame.setVisible(true);
  }

  private void update() {
    frame.pack();
  }

}
