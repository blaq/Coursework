/* CS315 Lab 3: C data types */

#include <stdio.h>
#include <stdlib.h>
#define FAIL EXIT_FAILURE
#define SUCCESS EXIT_SUCCESS
const int ZERO = 0, ONE = 1, TWO = 2, THREE = 3, FOUR = 4, SQUARED = 16;
const int STABLE = 10, SYNC = 255, MEGA = 10485760;
FILE * fp;
const int rates[3][16] = { { 0,32,40,48,56,64,80,96,112,128,160,192,224,256,320,1000 },
													 { 0,8,16,24,32,40,48,56,64,80,96,112,128,144,160,1000 },
												 	 { 0,8,16,24,32,40,48,56,64,80,96,112,128,144,160,1000 } };
const float hertz[3][4] = { { 44.1,48.0,32.0,0 },
														{ 22.05,24.0,16.0,0 },
													 	{ 11.025,12.0,8.0,0}};


int origin( unsigned char* data, int start )
{
	int num = data[start+THREE], mask = FOUR;

	if( (num & mask) == mask )
		printf("\t      Original file\n");
	else
		printf("\t      Not original file\n");

	if( (num & (TWO*mask)) == (TWO*mask) )
		printf("\t      File is Copyright\n");
	else
		printf("\t      File is not Copyright\n");

	return ONE;
}

int frequency( unsigned char* data, int start, int version )
{
	int num = data[start+TWO], mask = FOUR, count = ZERO;

	for( int e = ZERO; e < TWO; e++ )
	{
		if( (num & mask) == mask)
			count += (mask/FOUR);
		mask *= TWO;
	}

	printf("   Frequency: %.3f khz\n", hertz[version][count]);

	return origin( data, start );
}

int bitRate( unsigned char* data, int start  )
{
	int version, num = data[start+TWO], mask = SQUARED, count = ZERO;

	for( int e = ZERO; e < FOUR; e++ )
	{
		if( (num & mask) == mask)
			count += (mask/SQUARED);
		mask *= TWO;
	}

	num = data[start+ONE];
	mask = FOUR * TWO;

	if( (num & mask) == mask )
	{
		if( (num & (TWO*mask)) == (TWO*mask) )
			version = ZERO;
		else
			version = ONE;
	}
	else
	{
		version = TWO;
	}

	printf("     Bitrate: %d kbps\n", rates[version][count] );

	return frequency( data, start, version);
}

int initilize( int argc, char *argv[] )
{
	if( argc != TWO )
	{
		printf( "Usage: %s filename.mp3\n", argv[ZERO] );
		return ZERO;
	}

	fp = fopen(argv[ONE], "rb");
	if( fp == NULL )
	{
		printf( "Can't open file %s\n", argv[ONE] );
		return ZERO;
	}
	return ONE;
}

int readFile()
{
	int num, start, mask;
	float size = ZERO;
	fseek( fp, ZERO, SEEK_END );
	size = ftell(fp);
	rewind(fp);

	unsigned char * data = (unsigned char *)malloc(size);

	if( size < ONE || size > MEGA )
	{
		printf( "File size is not within the allowed range\n" );
		return ZERO;
	}

	size_t bytesRead = fread( data, sizeof(unsigned char), size, fp );
	for( int e = ZERO; e < size; e++ )
	{
		if( data[e] == SYNC )
		{
			start = e;
			num = data[start+ONE], mask = TWO;

			if( ( (num & mask) == mask) && ( (num & TWO*mask) != TWO*mask) )
			{
				printf( "   File size: %.2f MB\n", STABLE*(size/MEGA) );
				printf( "First header: %x %x %x %x\n", data[e], data[e+ONE], data[e+TWO], data[e+THREE] );
			}
			else
			{
				printf("Non-layer 3 file's not permitted.\n");
				free(data);
				return ZERO;
			}
			e = size;
		}
	}

	if( bytesRead != size )
	{
		printf( "Error reading file. Unexpected number of bytes read: %d\n", bytesRead );
		free(data);
		return ZERO;
	}
	else
	{
		int status = bitRate( data, start );
		free(data);
		return status;
	}
}

int main( int argc, char ** argv )
{
	int status;
	printf("\n");

	if( initilize( argc, argv ) == ZERO )
		return FAIL;

	status = readFile();
	fclose( fp );

	if( status != ONE )
		return FAIL;

	return SUCCESS;
}
