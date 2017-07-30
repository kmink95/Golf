
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CenterPanel extends JPanel implements ActionListener, Runnable {

	private JLabel numLabel = new JLabel();
	private JPanel buttonPanel = new JPanel();
	private JPanel timerPanel = new JPanel();
	private JLabel timer = new JLabel("00:00:00");

	Runnable t_thread = null;
	Thread t = null;

	private JButton startB = new JButton("시작");
	private JButton clearB = new JButton("초기화");
	private JButton broadB = new JButton("*");
	int number;
	int hour = 0, min = 0, sec = 0, total_min = 0, check = 0;
	int old_time, now_time, total;

	//indivisual_panel
	public CenterPanel(int num) {
		Font font = new Font("Serif", Font.BOLD, 40);

		number = num;
		t_thread = new Timer_thread();
		timer.setFont(font);

		startB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// t_thread = new Thread();
				old_time = (int) System.currentTimeMillis() / 1000;
				t = new Thread(t_thread);
				t.start();
				timerPanel.setBackground(Color.green);

			}
		});
		clearB.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				timer.setText("00:00:00");
				timerPanel.setBackground(null);
				check = 0;
				t.stop();
				t = null;

			}
		});
		broadB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Broad b = new Broad(num);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		numLabel.setText("<" + num + ">");

		timerPanel.add(timer);
		buttonPanel.add(startB);
		buttonPanel.add(clearB);
		buttonPanel.add(broadB);
		numLabel.setFont(font);

		add(numLabel, BorderLayout.NORTH);
		add(timerPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	//timer_thread
	class Timer_thread implements Runnable {

		public void run() {
			while (true) {

				now_time = (int) System.currentTimeMillis() / 1000;
				total = now_time - old_time;

				sec = total % 60;
				min = total / 60 % 60;
				hour = total / 3600;

				total_min = total / 60; 
				
				if (NorthPanel.use_time != 0 && total_min >= NorthPanel.use_time && check == 0) {
					try {
						Broad b = new Broad(number);
						timerPanel.setBackground(Color.RED);
					} catch (Exception e) {
						e.printStackTrace();
					}
					check++;
				}

				timer.setText(String.format("%02d:%02d:%02d", hour, min, sec));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
