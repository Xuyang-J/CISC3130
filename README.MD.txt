Project: Lab#2
The aim of this project is to reformat a compact and hard to read file into an easy to read report, which involves
taking an input file(in this case the Top 200 hit in the US from Spotify) and turn it into an organized 
report where anyone can see clearly: the aritsts, the song name, the numbers of streams
and ranking. In this case, it will be shown to the executives of some record label.

For this to be done, first the file will have to be read and implemented properly. Before I began, I set up
a print stream so that I can output to a file, on top of many of the other initializations of Scanners, Files, and arrays.

Once the above is done, I initialized a while + for loop and utilized the scanner's nextLine() function to read in
an entire line from the file, since the file is set up from row 1-200, with each row containing informations abou
that specific hit. The line of string read is then assigned to an array through the split function, with "," as the delimiter
since the input is in a CSV format. A for loop is then utilized to fill the 2D array, of which the data stored within it will 
be outputted to a report.

*In the process, a few tracks were removed as they were unable to fit properly into the files and would produce inconsistencies 
in the report*

As a result, anyone who reads the report will be able to clearly identify the ranking, name, number of streams, as well as the artist of the hits.