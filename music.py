#Import the library
from midiutil.MidiFile import MIDIFile
import pygame

pitch_dict = {'A0': 21, 'B0': 23, 'C1': 24, 'D1': 26, 'E1': 28, 'F1': 29, 'G1': 31, 'A1': 33, 'B1': 35, 
				'C2': 36, 'D2': 38, 'E2': 40, 'F2': 41, 'G2': 43, 'A2': 45, 'B2': 47,
				'C3': 48, 'D3': 50, 'E3': 52, 'F3': 53, 'G3': 55, 'A3': 57, 'B3': 59,
				'C4': 60, 'D4': 62, 'E4': 64, 'F4': 65, 'G4': 67, 'A4': 69, 'B4': 71,
				'C5': 72, 'D5': 74, 'E5': 76, 'F5': 77, 'G5': 79, 'A5': 81, 'B5': 83,
				'C6': 84, 'D6': 86, 'E6': 88, 'F6': 89, 'G6': 91, 'A6': 93, 'B6': 95,
				'C7': 96, 'D7': 98, 'E7': 100, 'F7': 101, 'G7': 103, 'A7': 105, 'B7': 107,
				'C8': 108}

pitch_list = ['A0', 'B0', 'C1', 'D1', 'E1', 'F1', 'G1', 'A1', 'B1',
				'C2', 'D2', 'E2', 'F2', 'G2', 'A2', 'B2',
				'C3', 'D3', 'E3', 'F3', 'G3', 'A3', 'B3',
				'C4', 'D4', 'E4', 'F4', 'G4', 'A4', 'B4',
				'C5', 'D5', 'E5', 'F5', 'G5', 'A5', 'B5',
				'C6', 'D6', 'E6', 'F6', 'G6', 'A6', 'B6',
				'C7', 'D7', 'E7', 'F7', 'G7', 'A7', 'B7', 'C8']

tone_list = ['C', 'D', 'E', 'F', 'G', 'A', 'B']

instrument_dict = {'Piano': 1, 'Guitar': 25, 'Bass': 33, 'Violin': 41, 'Cello': 43,
					'Music Box': 11, 'Trumpet': 57, 'Sax': 65, 'Tinkle Bell': 113}

duration_dict = {'w': 1, 'h': 0.5, 'q': 0.25, 'e': 0.125, 's': 0.0625}


class note:

	def __init__(self, str):
		self.pitch = str[:-1]
		self.duration = str[-1]
		self.note = str

	def get_note(self):
		return self.note

	def get_pitch(self):
		return self.pitch

	def get_tone(self):
		return self.pitch[0:1]

	def get_duration(self):
		return self.duration

	def pitch_up(self):
		index = pitch_list.index(self.pitch)
		index += 1
		if index > len(pitch_list):
			print "error"
		else:
			self.pitch = pitch_list[index]

	def pitch_down(self):
		index = pitch_list.index(self.pitch)
		index -= 1
		if index < 0:
			print "error"
		else:
			self.pitch = pitch_list[index]

	def tone_up(self):
		pass

	def tone_down(self):
		pass


class sequence:

	def __init__(self):
		self.stream = []
		self.instrument = 1

	def set(self, stream):
		self.stream = []
		for item in stream:
			tmp = note(item)
			self.stream.append(tmp)

	def get_instrument(self):
		for key, value in instrument_dict.iteritems():
			if value == self.instrument:
				return key

	def change_instrument(self, instrument):
		try:
			self.instrument = instrument_dict[instrument]
		except KeyError:
			print "instrument not in dictionary"

class song:

	def __init__(self):
		self.sequence_list = []
		self.instrument_list = []

	def construct_seq(self, seq, track, MIDI_obj):
		# Tracks are numbered from zero. Times are measured in beats.
		time = 0
		channel = 0
		volume = 100

		# Add track name and tempo.
		MIDI_obj.addTrackName(track, time, "Track" + str(track))
		MIDI_obj.addTempo(track, time, 60)

		for note in seq:
			pitch = pitch_dict[note.get_pitch().upper()]
			duration = duration_dict[note.get_duration().lower()]
			
			MIDI_obj.addNote(track, channel, pitch, time, duration, volume)
			time += duration

	def change_instrument(self, MIDI_obj, track, channel, time, instrument):
		MIDI_obj.addProgramChange(track, channel, time, instrument)

	def add(self, sequence):
		self.sequence_list.append(sequence)
		self.instrument_list.append(sequence.instrument)

	def play(self):
		# Create the MIDIFile Object with n track
		MyMIDI = MIDIFile(len(self.sequence_list))
		for i in range(len(self.sequence_list)):
			self.construct_seq(self.sequence_list[i].stream, i, MyMIDI)
			self.change_instrument(MyMIDI, i, 0, 0, self.sequence_list[i].instrument)

		# write MIDI file to disk.
		binfile = open("output.mid", 'wb')
		MyMIDI.writeFile(binfile)
		binfile.close()

		# play MIDI file
		freq = 44100    # audio CD quality
		bitsize = -16   # unsigned 16 bit
		channels = 2    # 1 is mono, 2 is stereo
		buffer = 1024    # number of samples
		pygame.mixer.init(freq, bitsize, channels, buffer)
		# optional volume 0 to 1.0
		pygame.mixer.music.set_volume(0.8)

		clock = pygame.time.Clock()
		try:
			pygame.mixer.music.load('output.mid')
			print "Music file %s loaded!" % 'output.mid'
		except pygame.error:
			print "File %s not found! (%s)" % ('output.mid', pygame.get_error())
			return

		pygame.mixer.music.play()
		while pygame.mixer.music.get_busy():
		# check if playback has finished
			clock.tick(30)