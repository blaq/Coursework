import os
import re

def get_base_scene( scene ):
	fin = open( scene )
	sdl = fin.read()
	fin.close()
	return sdl

def get_vect_variables( vect ):
	x = re.search('(.+?),', vect).group(1)
	y = re.search(x+', (.+?),', vect).group(1)
	z = re.search(x+', '+y+', (.+)', vect).group(1)
	print(x,y,z)
	return float(x), float(y), float(z)

def create_frames( sdl_new, picNo ):
	outfile = 'tmp.pov'
	fout = open( outfile, 'w' )
	fout.write( sdl_new )
	fout.close()
	# '\POV-Ray\v3.7\bin' has to be put in the path
	pov_cmd = ' pvengine.exe -GA +I%s +O%s -D -V +A +H600 +W800 /EXIT'
	cmd = pov_cmd % ( 'tmp.pov', "tmp" + str(picNo).zfill(4) + ".png" )
	os.system( cmd )
	return sdl_new

def move_camera( sdl, num_of_frames ):
	for picNo in range( num_of_frames ):
		vect = re.search('location <(.+?)>', sdl).group(1)
		x, y, z = get_vect_variables( vect )
		if picNo < (num_of_frames / 2):
			x += 1
			z -= 1
		else:
			x -= 1
			z += 1
		edit = 'location <'+str(x)+', '+str(y)+', '+str(z)+'>'
		sdl_new = sdl.replace('location <'+vect+'>', edit)
		sdl = create_frames( sdl_new, picNo)

def create_movie():
	print( "Encoding movie..." )
	os.system( 'mencoder.exe mf://tmp*.png -mf type=png:fps=25 -ovc lavc \
		-lavcopts vcodec=msmpeg4:vbitrate=2160000:keyint=5:vhq -o movie.avi ' )

def erase_scenes( num_of_frames ):
	for picNo in range( num_of_frames ):
		os.remove( "tmp" + str(picNo).zfill(4) + ".png" )

def main():
	scene = 'base.pov'
	num_of_frames = 50

	sdl = get_base_scene(scene)

	move_camera( sdl, num_of_frames )
	#for picNo in range( num_of_frames ):
	#	sdl = create_frames( sdl, picNo )

	create_movie()
	erase_scenes(num_of_frames)

if __name__ == "__main__":
	main()