
def encode(input_string):

	# initialize compressed string
	output_string = ""
	
	# check for empty string	
	if input_string == "":
		return output_string
	
	# compression
	else:
		tmp = input_string[0]
		count = 0	

		# walk through every letter
		for i in input_string:
				
			# if current char is the same as the previous, add 1 to count
			# first char is also previous; adding 1 to count will bring it to 1
			if i == tmp:
				count += 1
			
			# if current char is different from previous, add char and count to final string
			# reset count to one so that the curr char is counted
			else:
				output_string += tmp + str(count)
				count = 1

			# current char becomes the previous char and loop restarts
			tmp = i

		# after the loop, final string will be created from previous char and its count 
		output_string += tmp + str(count)
		
		# compares size of input and compressed string; returns the smaller
		if len(output_string) < len(input_string):
			return output_string
		else:
			return input_string
