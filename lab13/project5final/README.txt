Project 5: Derek Wang, wan00923@umn.edu

The hash function generates its key by calculating the value of each character and taking the sum of all
the values for each item. It then returns the key modulus the length of the hash table. The add function creates a new
NGen object if one does not already exist for the index returned by the hash function. If it does exist, it will check
to ensure that the item does not already exist within the NGen object. It will append the item to the end of the chain
if the item is not a duplicate.

Canterbury.txt Statistics:
# unique words: 205
# empty indices: 113
# nonempty indices: 137
average collision length: 1.4963503649635037
length of longest chain: 2

Gettysburg.txt Statistics:
# unique words: 161
# empty indices: 144
# nonempty indices: 106
average collision length: 1.5188679245283019
length of longest chain: 2

Keywords.txt Statistics:
# unique words: 50
# empty indices: 203
# nonempty indices: 47
average collision length: 1.0638297872340425
length of longest chain: 2

"I certify that the information contained in this README
file is complete and accurate. I have both read and followed the course
policies in the ’Academic Integrity - Course Policy’ section of the course
syllabus.”
