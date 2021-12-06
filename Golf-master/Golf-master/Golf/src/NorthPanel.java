import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;



import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JPanel;



class NorthPanel extends JPanel implements ActionListener, Runnable {

	
	static int use_time = 0;

	int end_time_check = 0;

	Font font = new Font("Serif", Font.PLAIN, 30);

	private Thread t_thread;

	//0:sun
	String day[] = new String[] { "", " 일요일", " 월요일", " 화요일", " 수요일", " 목요일", " 금요일", " 토요일" };

	Info info;

	private JLabel timeLabel = new JLabel();





	private JButton short_time_button = new JButton(var_setting.shorter_time_limit + "분");
	private JButton long_time_button = new JButton(var_setting.longer_time_limit + "분");

	private JButton broad = new JButton("♪");

	

	public NorthPanel() {

		if (t_thread == null) {

			t_thread = new Thread(this);

			t_thread.start();

		}

		

		broad.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub

				try {

					info = new Info();

				} catch (Exception e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		});

		

		

		add(timeLabel);

		add(short_time_button);
		add(long_time_button);
		add(broad);
	}

	@Override
	public void run() {

		while (true) {
			Calendar date = Calendar.getInstance();
			long time = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy년 MM월 dd일  hh시  mm분 ss초");
			String str = dayTime.format(new Date(time));

			timeLabel.setText(str + day[date.get(Calendar.DAY_OF_WEEK)]);
			timeLabel.setFont(font);

			//0 is sunday
			//not holiday & not weekend & not busy hour
			//longer time
			if(ask_box.isIt == 0 && date.get(Calendar.DAY_OF_WEEK) != 1 && date.get(Calendar.DAY_OF_WEEK) != 7 && date.get(Calendar.HOUR_OF_DAY) < var_setting.weekday_time_limit_shorter_started_time )
			 {
				long_time_button.setBackground(Color.blue);
				short_time_button.setBackground(null);
						use_time = var_setting.longer_time_limit;
			 }
			//holiday & weekend & busy hour
			//shorter time
			 else
			 {
				 short_time_button.setBackground(Color.blue);
				 long_time_button.setBackground(null);
				use_time = var_setting.shorter_time_limit;
			 }

			if(date.get(Calendar.MINUTE) == 30 && date.get(Calendar.SECOND) == 1 )

				try {

					info = new Info();

				} catch (Exception e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}

		}

	}

}
