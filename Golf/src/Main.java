
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ask_box();
		new main_Frame();

	}

}

class ask_box {
	static int isIt;

	public ask_box() {
		if (JOptionPane.showConfirmDialog(null, "ø¿¥√¿Ã ∞¯»ﬁ¿œ ¿‘¥œ±Ó?", "", JOptionPane.YES_NO_OPTION) == 0)
			isIt = 1;
		else
			isIt = 0;
	}
}

class main_Frame {
	private JFrame f = new JFrame("ª±≥∞Ò«¡≈¨∑¥");
	private JPanel nPanel = new NorthPanel();
	private JPanel cPanel = new JPanel();
	private JPanel cPanel_1 = new CenterPanel(1);
	private JPanel cPanel_2 = new CenterPanel(2);
	private JPanel cPanel_3 = new CenterPanel(3);
	private JPanel cPanel_4 = new CenterPanel(4);
	private JPanel cPanel_5 = new CenterPanel(5);
	private JPanel cPanel_6 = new CenterPanel(6);
	private JPanel cPanel_7 = new CenterPanel(7);
	private JPanel cPanel_8 = new CenterPanel(8);
	private JPanel cPanel_9 = new CenterPanel(9);
	private JPanel cPanel_10 = new CenterPanel(10);
	private JPanel cPanel_11 = new CenterPanel(11);
	private JPanel cPanel_12 = new CenterPanel(12);
	private JPanel cPanel_13 = new CenterPanel(13);
	private JPanel cPanel_14 = new CenterPanel(14);
	private JPanel cPanel_15 = new CenterPanel(15);
	private JPanel cPanel_16 = new CenterPanel(16);
	private JPanel cPanel_17 = new CenterPanel(17);
	private JPanel cPanel_18 = new CenterPanel(18);
	private JPanel cPanel_19 = new CenterPanel(19);
	private JPanel cPanel_20 = new CenterPanel(20);
	private JPanel cPanel_21 = new CenterPanel(21);
	private JPanel cPanel_22 = new CenterPanel(22);
	private JPanel cPanel_23 = new CenterPanel(23);
	private JPanel cPanel_24 = new CenterPanel(24);
	private JPanel cPanel_25 = new CenterPanel(25);
	private JPanel cPanel_26 = new CenterPanel(26);

	public main_Frame() {

		Container container = f.getContentPane();

		GridLayout grid = new GridLayout(6, 5);
		cPanel.setLayout(grid);
		cPanel.add(cPanel_1);
		cPanel.add(cPanel_2);
		cPanel.add(cPanel_3);
		cPanel.add(cPanel_4);
		cPanel.add(cPanel_5);
		cPanel.add(cPanel_6);
		cPanel.add(cPanel_7);
		cPanel.add(cPanel_8);
		cPanel.add(cPanel_9);
		cPanel.add(cPanel_10);
		cPanel.add(cPanel_11);
		cPanel.add(cPanel_12);
		cPanel.add(cPanel_13);
		cPanel.add(cPanel_14);
		cPanel.add(cPanel_15);
		cPanel.add(cPanel_16);
		cPanel.add(cPanel_17);
		cPanel.add(cPanel_18);
		cPanel.add(cPanel_19);
		cPanel.add(cPanel_20);
		cPanel.add(cPanel_21);
		cPanel.add(cPanel_22);
		cPanel.add(cPanel_23);
		cPanel.add(cPanel_24);
		cPanel.add(cPanel_25);
		cPanel.add(cPanel_26);

		cPanel_1.setBorder(new LineBorder(Color.BLACK));
		cPanel_2.setBorder(new LineBorder(Color.BLACK));
		cPanel_3.setBorder(new LineBorder(Color.BLACK));
		cPanel_4.setBorder(new LineBorder(Color.BLACK));
		cPanel_5.setBorder(new LineBorder(Color.BLACK));
		cPanel_6.setBorder(new LineBorder(Color.BLACK));
		cPanel_7.setBorder(new LineBorder(Color.BLACK));
		cPanel_8.setBorder(new LineBorder(Color.BLACK));
		cPanel_9.setBorder(new LineBorder(Color.BLACK));
		cPanel_10.setBorder(new LineBorder(Color.BLACK));
		cPanel_11.setBorder(new LineBorder(Color.BLACK));
		cPanel_12.setBorder(new LineBorder(Color.BLACK));
		cPanel_13.setBorder(new LineBorder(Color.BLACK));
		cPanel_14.setBorder(new LineBorder(Color.BLACK));
		cPanel_15.setBorder(new LineBorder(Color.BLACK));
		cPanel_16.setBorder(new LineBorder(Color.BLACK));
		cPanel_17.setBorder(new LineBorder(Color.BLACK));
		cPanel_18.setBorder(new LineBorder(Color.BLACK));
		cPanel_19.setBorder(new LineBorder(Color.BLACK));
		cPanel_20.setBorder(new LineBorder(Color.BLACK));
		cPanel_21.setBorder(new LineBorder(Color.BLACK));
		cPanel_22.setBorder(new LineBorder(Color.BLACK));
		cPanel_23.setBorder(new LineBorder(Color.BLACK));
		cPanel_24.setBorder(new LineBorder(Color.BLACK));
		cPanel_25.setBorder(new LineBorder(Color.BLACK));
		cPanel_26.setBorder(new LineBorder(Color.BLACK));

		container.add(nPanel, BorderLayout.NORTH);
		container.add(cPanel, BorderLayout.CENTER);

		f.setSize(1500, 800);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

	}
}
