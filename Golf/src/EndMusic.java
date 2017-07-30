
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;

public class EndMusic {
	public EndMusic() throws Exception {
		String SoundPath = "/C:/Users/»ð±³°ñÇÁÅ¬·´/git/workspace/Golf/Golf/src/end.wav";
		

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
