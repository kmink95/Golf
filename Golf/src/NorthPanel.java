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

	String day[] = new String[] { "", " 일요일", " 월요일", " 화요일", " 수요일", " 목요일", " 금요일", " 토요일" };

	Info info;

	private JLabel timeLabel = new JLabel();





	private JButton rb_100 = new JButton("100분");

	private JButton rb_120 = new JButton("120분");

	private JButton broad = new JButton("♬");

	

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

		add(rb_100);

		add(rb_120);

		add(broad);

	}



	@Override
	public void run() {



		while (true) {

			Calendar date = Calendar.getInstance();

			long time = System.currentTimeMillis();

			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");

			String str = dayTime.format(new Date(time));



			timeLabel.setText(str + day[date.get(Calendar.DAY_OF_WEEK)]);

			timeLabel.setFont(font);

			

			//holyday

			if (ask_box.isIt == 1) {

				rb_100.setBackground(Color.blue);

				rb_120.setBackground(null);

				use_time = 100;

			} else {

				//weekend

				if (date.get(Calendar.DAY_OF_WEEK) == 1 || date.get(Calendar.DAY_OF_WEEK) == 7) {

					rb_100.setBackground(Color.blue);

					rb_120.setBackground(null);

					use_time = 100;

				} else {

					//after 5pm

					if (date.get(Calendar.HOUR_OF_DAY) >= 17) {

						rb_100.setBackground(Color.blue);

						rb_120.setBackground(null);

						use_time = 100;

					} else {

						//rb_120.setBackground(null);

						rb_120.setBackground(Color.blue);

						rb_100.setBackground(null);

						use_time = 120;

					}

				}

			}

			

			if(date.get(Calendar.MINUTE) == 30 && date.get(Calendar.SECOND) == 1 )

				try {

					info = new Info();

				} catch (Exception e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

				}

			

			/*

			if(ask_box.isIt == 1 || date.get(Calendar.DAY_OF_WEEK) == 1 || date.get(Calendar.DAY_OF_WEEK) == 7 )

			{

				//10시 종료

				if(date.get(Calendar.HOUR_OF_DAY) == 21 && date.get(Calendar.MINUTE) == 50 && end_time_check == 0)

				{

					try {

						EndMusic bye = new EndMusic();

					} catch (Exception e) {

						// TODO Auto-generated catch block

						e.printStackTrace();

					}				

					end_time_check++;

				}

				

			}

			else

			{

				if(date.get(Calendar.HOUR_OF_DAY) == 19 && date.get(Calendar.MINUTE)  == 50 && end_time_check == 0)

				{

					try {

						EndMusic bye = new EndMusic();

					} catch (Exception e) {

						// TODO Auto-generated catch block

						e.printStackTrace();

					}

					end_time_check++;

				}

			}



			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		*/

		}

	}

}
