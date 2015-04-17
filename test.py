
i = 13
l = ['d',2,'123']
dirtyfile = open ('dirty.txt', 'w')

dirtyfile.write('i = '+str(i))
dirtyfile.write('l='+str(l))
dirtyfile.close()
