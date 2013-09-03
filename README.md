JavaSportResults
================

Task – Sport results from XML 
-----------------------------
###Description 
Create a program that reads an XML file which contains sport results. 
3 extracted files shall be generated from the XML-file. 
- The data files contains both Swedish and English names – use the English ones. 
- The data files sometimes contains several “Score” elements use “current” one 
- If “Score” is missing - do not use them i.e the game has not yet started. 
 
File 1: Match list – alphabetically ordering (big-matchlist-alphasort.txt) 
--------------------------------------------------------------------------
File 1 shall include a list of all matches specified in the XML. One row for each match according to:  
Sport | Category | Tournament | Team1Name - Team2Name : Team1Score - Team2Score   
The rows in the file must be sorted alphabetically (A-Ö).   
###Example:  
> Soccer | Australia | Hyundai A-League | Wellington Phoenix FC - Melbourne Victory : 2 - 0  
> Soccer | England | Premier League | Blackpool FC - Birmingham City : 5 - 1  
> Soccer | England | Premier League | Fulham FC - West Bromwich Albion : 4 - 1   
 
File 2: Match list – Sorted on number of goals (big-matchlist-goalsort.txt)
---------------------------------------------------------------------------
This file shall include the same information as in “Match list” – alphabetically, but must also be sorted on number 
of goals in each game, greatest number first and so on. I.e a closing result of 5-2 is a total of 7 goals.   
###Example:   
> Soccer | England | Premier League | Blackpool FC - Birmingham City : 5 - 1  
> Soccer | England | Premier League | Fulham FC - West Bromwich Albion : 4 - 1  
> Soccer | Australia | Hyundai A-League | Wellington Phoenix FC - Melbourne Victory : 2 - 0  

Fil 3: Top list (big-toplist.txt) 
---------------------------------
This file shall include a “Top list” – the most common starting letter in the goal scoring teams name. All letters with 
1 or more goals shall be listed, sorted greatest to least.  
###Example:  
Taken the matches from above example: 
> B: 6  
> F: 4   
> W: 3  


Execution:
----------
- You must use Java  
- Any use of 3rd party libraries is OK 
- Not neccesary to package the software, the importat thing is that it can be run in the dev environment.

Resources 
---------
big-data.xml - XML file with results, content is matches and goal scorers. 
small-data.xml - XML file including results, not so many matches nor goal scorers. 
small-toplist.txt - the correct top list for small-data.xml file 
small-matchlist-alphasort.txt - Correctly formated match list in alphabetic order for small-data.xml. 
small-matchlist-goalsort.txt - Match list; sorted in number of goals scored for small-data.xml. 
 
The files are ziped and you get them from:  
http://dl.dropbox.com/u/896494/data.zip 

