## Nông Quốc Lĩnh - SE141095

### Some note about LAB1:
- At first, when i see the topics of LAB1, i think it's too difficult for me because i don't know where i should start.
- So luckily, finally, i completed it but i still think it's too difficult for me.
- I hope the next LAB not too difficult like this LAB.

### Problem 1:
- Firstly, i don't know how to solve it.
- After many days of finding solutions and got suggest by the teacher, so finally, i found the way to solve it
- Mostly, the problem 1 has been implemented by the teacher at class time.
- So i solved it.
#### Somethings about Problem 1: 
**I implemented this problem with 4 class:**
1. Player class:
- This is used to store player's informantion (email, point).
- Create constructor, getter and setter to get and set player's information.

2. Node class:
- Create a node to store player's information and the info next node and previous node of it.
- Create constructor, getter and setter to get and set node's information.

3. SortedPriorityQueue class:
- I implemented it with doubly linked list structure.
- Create some functions such as:
  + addNewPlayer with 2 parameters are email and point then create a node to store this info.
  + sortPlayerBasedOnPoint: i based on the point of each player then i sort them in descending order.
  + getMaxPoint: get the highest point in the list.
  + getMinPoint: get the smallest point in the list.
  + search: find the node in list based on user-entered email then return this node.
  + getPointOfPlayer: get the point of the any player in list with a parameter is email.
  + removePlayerHasBiggestPoint: remove the player has the highest point in the list.
  + removePlayer: remove one any player in the list with a parameter is email.
  + updateNewPoint: my idea, i update by firstly i find and remove this player then i re-add this player into the list with new point.
  + addToList: i add all players's info into the arraylist for print out to file.
  
4. Program1 class:
- This class is implemented with 3 functions and 1 constructor no-parameter:
  + getPlayerFromFile: read the file and add all players in the file to sorted priority queue (SortedPriorityQueue class).
  + printToFile: get all players by addToList in SortedPriorityQueue class then print them to file.
  + parsingArgs: parse the argument and execute it.
  
### Problem 2:
- I don't know how to should start either.
- And I found a way to solve it somewhere on the internet.
- Fortunately, that solution helped me solve this problem.
#### Somethings about Problem 2: 
**I implemented this problem with 5 class:**
1. TagHTML class:
- It is understood as a node.
- Each TagHTML stores 1 tag html and the info next node and previous node of it.
- Create constructor, getter and setter.

2. Stack class:
- I implemented it with doubly linked list structure.
- Create some functions such as:
  + push: push the tag into the stack. It is understood as addLast function of doubly linked list structure.
  + pop: pop the tag out of the stack.  It is understood as removeLast function of doubly linked list structure.
  + getTop: in my idea, the head of the list as the bottom of stack and tail is the top of stack. So getTop is get the tag is stored in the tail.
  + print: display the list of stack on the screen.
  
3. GetContentFromWebsite class:
- Open a connection to the URL.
- Read a content from the url line by line and insert this content to "content" variable.

4. Program2 class:
- This class is implemented with 2 functions and 1 constructor parameter:
  + Constructor with parameters: it solve the problem 2 by call functions of this program. Firstly, it checks the url, if the url not include "https://" it will automatically insert "https://" into the url. Then it call functions to solve problem 2.
  + analyzeHTMLTag: this function parsing the content get from the GetContentFromWebsite class.
  + processingHTMLTag: process the the tag. If this is a single tag, count it without push into the stack. If this is a open tag of pairs tag, push this tag into the stack. If this is a close tag, compare it with the top tag of stack and pop the top tag out of the stack then count it.
  
5. CSV class:
- I use hashtable to stores the tag and the frequencies of it
- countingFrequenceAppearance: it receive the from the processingHTMLTag. Check the hastable, if this tag existed in it then increasing the frequence up 1 unit, if this tag not exist then put this tag into the hastable and Initialization frequency is 1.
- print: display the hashtable with sorting on the screen.
- sortAndWriteToFile: sort the hashtable base on the frequency, display the hastable after sorted on the screen and write the sorted hashtable to the file.

*- But i think my program still not working very well.*
*- Lastly, i hope that my program can run exactly :v*
