import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PizzaPriceFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JPanel pizzaPanel, centerPanel, pricePanel, checkBoxPanel, radioButtonPanel;
    private final int FRAME_WIDTH = 300;
    private final int FRAME_HEIGHT = 300;
    private ButtonGroup group;
    private JRadioButton smallButton, mediumButton, largeButton;
    private JCheckBox peppCheckBox, mushCheckBox;
    private JTextField priceTextField;
    private double price = 0.0;
    private double topPrice = 0.0;
    private double showPrice = 0.0;
    private ActionListener listener = new PriceListener();
    public PizzaPriceFrame() {
        pizzaPanel = new JPanel();
        //pizzaPanel.setLayout(new BorderLayout(10, 10));

        Pizza();
        PizzaButtons();
        PizzaBoxes();
        createPricePanel();
        createCenterPanel();

        pizzaPanel.add(centerPanel, BorderLayout.CENTER);
        pizzaPanel.add(pricePanel, BorderLayout.SOUTH);

        frame = new JFrame("Pizza Price GUI");
        frame.add(pizzaPanel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

	private Pizza()
	{
		centerPanel = new JPanel();
		centerPanel.add(radioButtonPanel);
        centerPanel.add(checkBoxPanel);
	}
    private void PizzaButtons()
    {
        radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(3, 1));
        radioButtonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        group = new ButtonGroup();
        smallButton = new JRadioButton(" Small ");
        group.add(smallButton);
        smallButton.addActionListener(listener);
        radioButtonPanel.add(smallButton);

        mediumButton = new JRadioButton(" Medium ");
        group.add(mediumButton);
        mediumButton.addActionListener(listener);
        radioButtonPanel.add(mediumButton);

        largeButton = new JRadioButton(" Large ");
        group.add(largeButton);
        largeButton.addActionListener(listener);
        radioButtonPanel.add(largeButton);
    }

    private void PizzaBoxes()
    {
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(2, 1));

        peppCheckBox = new JCheckBox(" Pepperoni ");
        peppCheckBox.addActionListener(listener);
        checkBoxPanel.add(peppCheckBox);

        mushCheckBox = new JCheckBox(" Mushrooms ");
        mushCheckBox.addActionListener(listener);
        checkBoxPanel.add(mushCheckBox);
    }

    private void createPricePanel()
    {
        pricePanel = new JPanel();
        pricePanel.add(new JLabel("Your Price:"));
        priceTextField = new JTextField(7);
        priceTextField.setFont(new Font("Serif", Font.BOLD, 12));
        priceTextField.setEditable(false);
        priceTextField.setForeground(Color.red);
        priceTextField.setBackground(pricePanel.getBackground());
        priceTextField.setDisabledTextColor(Color.red);
        priceTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pricePanel.add(priceTextField);
        priceTextField.setText(" n/a Price");
    }

   	private void createCenterPanel()
   	{
 	  	setLayout(new BorderLayout());

 	  	JTabbedPane tp = new JTabbedPane();
 	  	tp.add("Pizza", Pizza());

 	  	centerPanel = new JPanel();
        //centerPanel.add(radioButtonPanel);
        //centerPanel.add(checkBoxPanel);
    }
    private class PriceListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            topPrice = 0;
            if (smallButton.isSelected()) {
                price = 5.25;
            } else if (mediumButton.isSelected()) {
                price = 7.25;
            } else if (largeButton.isSelected()) {
                price = 9.25;
            }
            if (peppCheckBox.isSelected()) {
                topPrice = 1.25;
            } else if (mushCheckBox.isSelected()) {
                topPrice = 1.25;
            } else if (peppCheckBox.isSelected() && (mushCheckBox.isSelected())) {
                topPrice = 3.00;
            }
            EventQueue.invokeLater(new Runnable() {
                //@Override
                public void run() {
                    showPrice = price + topPrice;
                    priceTextField.setText(" $" + showPrice);
                    System.out.println("Price dispayed");
                }
            });
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                PizzaPriceFrame pPF = new PizzaPriceFrame();
                System.out.println("Run");
            }
        });
    }
}