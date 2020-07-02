import javax.swing.JFrame;
public class PizzaPriceViewer {
	public static void main(String[] args)
	   {  
	      JFrame frame = new PizzaPriceFrame();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setTitle("Pizza Price GUI");
	      frame.setVisible(true);
	   }
	}