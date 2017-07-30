
import sun.audio.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;

public class Broad {
	public Broad(int num) throws Exception {
		String SoundPath = "/C:/Users/»ð±³°ñÇÁÅ¬·´/git/Golf/Golf/src/";
		

		switch (num) {
		case 1:
			SoundPath += "1st.wav";
			break;
		case 2:
			SoundPath += "2nd.wav";
			break;
		case 3:
			SoundPath += "3rd.wav";
			break;
		case 4:
			SoundPath += "4th.wav";
			break;
		case 5:
			SoundPath += "5th.wav";
			break;
		case 6:
			SoundPath += "6th.wav";
			break;
		case 7:
			SoundPath += "7th.wav";
			break;
		case 8:
			SoundPath += "8th.wav";
			break;
		case 9:
			SoundPath += "9th.wav";
			break;
		case 10:
			SoundPath += "10th.wav";
			break;
		case 11:
			SoundPath += "11th.wav";
			break;
		case 12:
			SoundPath += "12th.wav";
			break;
		case 13:
			SoundPath += "13th.wav";
			break;
		case 14:
			SoundPath += "14th.wav";
			break;
		case 15:
			SoundPath += "15th.wav";
			break;
		case 16:
			SoundPath += "16th.wav";
			break;
		case 17:
			SoundPath += "17th.wav";
			break;
		case 18:
			SoundPath += "18th.wav";
			break;
		case 19:
			SoundPath += "19th.wav";
			break;
		case 20:
			SoundPath += "20th.wav";
			break;
		case 21:
			SoundPath += "21th.wav";
			break;
		case 22:
			SoundPath += "22th.wav";
			break;
		case 23:
			SoundPath += "23th.wav";
			break;
		case 24:
			SoundPath += "24th.wav";
			break;
		case 25:
			SoundPath += "25th.wav";
			break;
		case 26:
			SoundPath += "26th.wav";
			break;
		}
		Clip clip;
		File soundFile = new File(SoundPath);
		Line.Info linfo = new Line.Info(Clip.class);
		Line line = AudioSystem.getLine(linfo);
		clip = (Clip) line;
		AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
		clip.open(ais);
		clip.start();

		Thread.sleep(1000);
	}
}
