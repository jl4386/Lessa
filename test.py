from music import *
import time

a = note('C3w')

print "note: " + str(a.get_note())
print "pitch: " + str(a.get_pitch())
print "tone: " + str(a.get_tone())
print "duration: " + str(a.get_duration())

a.pitch_up()
print "after pitch_up: " + str(a.get_pitch())

a.pitch_down()
print "after pitch_down: " + str(a.get_pitch())

seq = sequence()

seq.set(['C3q', 'C3q', 'G3q', 'G3q', 'A3q', 'A3q', 'G3w', 'F3q', 'F3q', 'E3q', 'E3q', 'D3q', 'D3q', 'C3w'])

mySong = song()

mySong.add(seq)

mySong.play()

time.sleep(1)

seq.change_instrument('Violin')

print "changed instrument to " + str(seq.get_instrument())

mySong.add(seq)

mySong.play()