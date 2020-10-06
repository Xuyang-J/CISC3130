Project: Lab#3
The aim of this project is to produce a report of the names of the top artists on a Spotify weekly list. This is done by reformatting a compact and complexily formatted CSV file into an array. For this to be done, first the file will have to be read and implemented properly. Before I began, I set up a print stream so that I can output to a file, on top of many of the other instantiations of Scanners, Files, and arrays.

Utilizing my code for an earlier lab(Lab #2), which involves:
Once the above is done, I initialized a while + for loop and utilized the scanner's nextLine() function to read in
an entire line from the file, since the file is set up from row 1-200, with each row containing informations abou
that specific hit. The line of string read is then assigned to an array through the split function, with "," as the delimiter
since the input is in a CSV format. A for loop is then utilized to fill the 2D array.

Building on top of the code from Lab#2, an extra array was added as to remove the apostrophes and quotation marks to allow for 
an easier time comparing. Then an array is used to sort(bubble sort) the names of the artists in alphabetical order, which is then transferred over to a linked list and outputted to an output file. 

As a result, anyone who reads the report will be able to clearly identify the name of artist of the hits in alphabetical order.
The source code can be compiled into any IDE or compiler, with an input CSV file formatted like a SPOTIFY TOP 200 List.

