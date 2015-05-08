package envir;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;

public class MidiLis implements MetaEventListener{

  Sequencer sequencer;
  public MidiLis(Sequencer sequencer){
    this.sequencer = sequencer;
  }
  @Override
  public void meta(MetaMessage meta) {
    // TODO Auto-generated method stub
    if (meta.getType() == 47) {
      sequencer.close();
    }
  }

}
