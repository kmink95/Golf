
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

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
	private JButton stopB = new JButton("정지");
	private JButton clearB = new JButton("초기화");
	private JButton broadB = new JButton("*");
	int number;
	// private Thread t_thread = null;
	int hour = 0, min = 0, sec = 0, total_min = 0, check = 0;
	int old_time, now_time, total;
	int stop_start, stop_end, isItstop = 0;
	int isItstart = 0;
	int can_use_time = 0;
	private boolean stop = false;

	public CenterPanel(int num) {
		Font font = new Font("Serif", Font.BOLD, 40);

		number = num;
		t_thread = new Timer_thread();
		timer.setFont(font);

		startB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stop = false;
				startB.setEnabled(false);
				if(isItstart == 0 )//&& stop == false)
				{
				old_time = (int) System.currentTimeMillis() / 1000;
				System.out.println(old_time);
				t = new Thread(t_thread);
				t.start();
				timerPanel.setBackground(Color.green);
				isItstart++;
				}
				
				//can use time depends on start time 
				Calendar now_date = Calendar.getInstance();
				//hoilday
				if (ask_box.isIt == 1) {
					can_use_time = 100;
				} else {
					//weekend
					if (now_date.get(Calendar.DAY_OF_WEEK) == 1 || now_date.get(Calendar.DAY_OF_WEEK) == 7) {
						can_use_time = 100;
					} else {
						//after 5pm
						if (now_date.get(Calendar.HOUR_OF_DAY) >= 17) {
							can_use_time = 100;
						} else {
							//rb_120.setBackground(null);
							can_use_time = 120;
						}
					}
				}

				

			}
		});
		stopB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

			}
		});
		clearB.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				timerPanel.setBackground(null);
				check = 0;
				t = null;
				isItstart = 0;
				stop = true;
				startB.setEnabled(true);
				timer.setText("00:00:00");

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

	class Timer_thread implements Runnable {

		public void run() {

			System.out.println(stop);
			while (!stop) {
				now_time = (int) System.currentTimeMillis() / 1000;
				total = now_time - old_time;

				sec = total % 60;
				min = total / 60 % 60;
				hour = total / 3600;
				total_min = total / 60; 
				
				// when time run out, auto broad 
				if (can_use_time != 0 && total_min >= can_use_time) {
					try {
						timerPanel.setBackground(Color.RED);
						if(check == 0)
						{
							Broad b = new Broad(number);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
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
				// }
			}
		}
	}

}
