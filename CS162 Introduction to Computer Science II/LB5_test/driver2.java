import javax.swing.*;
import java.awt.*;

public class driver2
{
	public static void main(String[] args)
	{

        JFrame frame = new JFrame("driver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new pizzaPanel(), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
	}

}
