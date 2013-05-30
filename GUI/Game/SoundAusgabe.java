package GUI.Game;


import java.net.URL;
import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundAusgabe 
{
	

	private URL  audioFileURL;
	
	public void playSound()
	{

	  	 try { 
	  		 this.audioFileURL = getClass().getResource("/loading1.wav");
	  		 System.out.println("Playing: " + audioFileURL); 
	  		 InputStream inStream = audioFileURL.openStream(); 
	  		 BufferedInputStream bufStream = new BufferedInputStream(inStream);  
	  		 AudioInputStream audioInputStream = AudioSystem .getAudioInputStream(bufStream); 
	  		 AudioFormat af = audioInputStream.getFormat(); 
	  		 int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
	  		 byte[] audio = new byte[size];
	  		 DataLine.Info info = new DataLine.Info(Clip.class, af, size);
	  		 audioInputStream.read(audio, 0, size);
	  		 Clip clip = (Clip) AudioSystem.getLine(info);
	  		 clip.open(af, audio, 0, size); 
	  		clip.loop(Clip.LOOP_CONTINUOUSLY);
	  		 clip.start(); 
	  	}catch(Exception e)
	  	 {
	  		 System.out.println("Fail");
	  	 }

	}
	
	public void playWarning()
	{

	  	 try 
	  	 { 
	  		 this.audioFileURL = getClass().getResource("/warning.wav");
	  		 System.out.println("Playing: " + audioFileURL); 
	  		 InputStream inStream = audioFileURL.openStream(); 
	  		 BufferedInputStream bufStream = new BufferedInputStream(inStream);  
	  		 AudioInputStream audioInputStream = AudioSystem .getAudioInputStream(bufStream); 
	  		 AudioFormat af = audioInputStream.getFormat(); 
	  		 int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
	  		 byte[] audio = new byte[size];
	  		 DataLine.Info info = new DataLine.Info(Clip.class, af, size);
	  		 audioInputStream.read(audio, 0, size);
	  		 Clip clip = (Clip) AudioSystem.getLine(info);
	  		 clip.open(af, audio, 0, size); 
	  		 clip.start(); 
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Fail");
	  	}


	}
	
	public void playError()
	{
	  	 try 
	  	 { 
	  		 this.audioFileURL = getClass().getResource("/error.wav");
	  		 System.out.println("Playing: " + audioFileURL); 
	  		 InputStream inStream = audioFileURL.openStream(); 
	  		 BufferedInputStream bufStream = new BufferedInputStream(inStream);  
	  		 AudioInputStream audioInputStream = AudioSystem .getAudioInputStream(bufStream); 
	  		 AudioFormat af = audioInputStream.getFormat(); 
	  		 int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
	  		 byte[] audio = new byte[size];
	  		 DataLine.Info info = new DataLine.Info(Clip.class, af, size);
	  		 audioInputStream.read(audio, 0, size);
	  		 Clip clip = (Clip) AudioSystem.getLine(info);
	  		 clip.open(af, audio, 0, size); 
	  		 clip.start(); 
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println("Fail");
	  	}


	}
	
	public void playNeuZiehen()
	{	  	
		  	 try 
		  	 { 
		  		 this.audioFileURL = getClass().getResource("/neuziehen.wav");
		  		 System.out.println("Playing: " + audioFileURL); 
		  		 InputStream inStream = audioFileURL.openStream(); 
		  		 BufferedInputStream bufStream = new BufferedInputStream(inStream);  
		  		 AudioInputStream audioInputStream = AudioSystem .getAudioInputStream(bufStream); 
		  		 AudioFormat af = audioInputStream.getFormat(); 
		  		 int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
		  		 byte[] audio = new byte[size];
		  		 DataLine.Info info = new DataLine.Info(Clip.class, af, size);
		  		 audioInputStream.read(audio, 0, size);
		  		 Clip clip = (Clip) AudioSystem.getLine(info);
		  		 clip.open(af, audio, 0, size); 
		  		 clip.start();
			}
		  	catch(Exception e)
		  	{
		  		System.out.println("Fail");
		  	}
	}
	
}
