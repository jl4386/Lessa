from music import *
import time


# define note and operations on note

a = note('C3w')

print "print note:"

print a

print "pitch: " + a.get_pitch()
print "tone: " + a.get_tone()
print "duration: " + a.get_duration()

a = a + 1

print "after a = a + 1:"

print a

a = a - 1

print "after a = a - 1:"

print a

a += 1

print "after a += 1:"

print a

a -= 1

print "after a -= 1:"

print a

a.pitch_up()

print "after pitch_up:"

print a

a.pitch_up()

print "after pitch_up:"

print a

a.pitch_down()

print "after pitch_down:"

print a

a.pitch_down()

print "after pitch_down:"

print a

b = note('D3w')

print "compare two notes:"

if a < b:
	print 'a < b'
elif a == b:
	print 'a = b'
elif a > b:
	print 'a > b'
	

# define sequence and operations on sequence

seq1 = sequence()

# seq1.set(['C3q', 'C3q', 'G3q', 'G3q', 'A3q', 'A3q', 'G3w', 'F3q', 'F3q', 'E3q', 'E3q', 'D3q', 'D3q', 'C3w'])

seq1.set(['C3q', 'C3q', 'C3q'])

print "print sequence:"

print seq1

print "iterate over a sequence:"

for note in seq1:
	print note

print "get length of a sequence:"

print len(seq1)

print "get note by index of a sequence"

print seq1[1]

seq1[1] = 'G3q'

print "after modifing the second note:"

print seq1

print "after pitch_up the second note:"

seq1[1].pitch_up()

print seq1

print "after deleting the second note:"

del(seq1[1])

print seq1

print "instrument: " + seq1.get_instrument()

list1 = seq1.to_list()

print list1

converted = list_to_seq(list1)

print converted


# define song and operations on song

mySong = song()

mySong.add(seq1, "seq1")

# mySong.play()

time.sleep(1)

seq2 = sequence()

seq2.set(['G4q', 'G4q'])

seq1 = seq1 + seq2

print "after adding seq2 to seq1:"

print seq1

# seq2.set(['C3q', 'C3q', 'G3q', 'G3q', 'A3q', 'A3q', 'G3w', 'F3q', 'F3q', 'E3q', 'E3q', 'D3q', 'D3q', 'C3w'])

seq2.change_instrument("Violin")

print "changed instrument to " + seq2.get_instrument()

mySong.add(seq2, "seq2")

print "print song:"

print mySong

mySong.subtract("seq1")

print "after subtracting seq1:"

print mySong

# mySong.play()