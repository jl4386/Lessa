package envir;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MidiPlay extends Thread{
  public Sequencer sequencer;
  public String filename;
  public MidiPlay(){
    try {
      sequencer= MidiSystem.getSequencer();
      filename = Envir.defaultMidiFileName;
    } catch (MidiUnavailableException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public MidiPlay(String name){
    try {
      sequencer= MidiSystem.getSequencer();
      filename = name;
    } catch (MidiUnavailableException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void run(){
    try {
      sequencer.open();
      // create a stream from a file
      InputStream is = new BufferedInputStream(new FileInputStream(new File(filename)));    // Sets the current sequence on which the sequencer operates.
      // The stream must point to MIDI file data.
      sequencer.setSequence(is);
      // Starts playback of the MIDI data in the currently loaded sequence.
      
      sequencer.start();
      
    } catch (MidiUnavailableException e ) {
      // TODO Auto-generated catch block
      System.err.println("MidiUnavailableException\n");
    } catch ( IOException ie){
      
    } catch(InvalidMidiDataException ime){
      System.err.println("InvalidMidiDataException\n");
    }
    
    
    
  }
  /** test program*/
  public static void main(String[] args) throws Exception {
    MidiPlay m = new MidiPlay();
    m.run();
    MidiLis ml = new MidiLis(m.sequencer);
    m.sequencer.addMetaEventListener(ml);
    System.out.println("hw");
  }
  /**/
}
