
PART 1
ListInterface.java
	Linked List ADT
	add(T data) 		- adds item to the Linked List by priority(lowest number is highest priority)
	
	contains(T data)	- sees if the list has the entered element

	size() 			- returns the size of the list
	
	isEmpty()		-Checks whether the list is empty

	get(int position)	-returns element at entered position
	
	delete(int position)	-deletes node at position

Node.java
	Creates the T data and newNode elements for the implementation of the linked list.

ProcessInfo.java
	element ProcessInfo which contains
		float time
		int priority
		String name

	Has getters and setters for all elements, implements teh compareTo method for help with ordered insertion into the LinedList

SinglyLinkedListClass.java
Implements the ListInterface.java 

RoundRobin.java
The Main program starts execution by displaying a user option to enter the Time Quantum. 
2. Next Display the following User Menu: 	a. Enter a process 
						b. Start Execution 
3. For option a: Enter the process name, process time and process priority, create an object of the ProcessInfo class.
 4. Enter the node with ProcessInfo Object according to priority into the Circular Singly Linked List. 
5. FIFO rules apply for processes with the same priority.
 6. Loop the Main user menu option till all the processes needed are entered. 
7. For option b: Traverse the Circular Process List and decrement the Process Time for each object by Time Quantum 
	– Simulating running of process. 
8. Once the running process Time becomes 0 or less than 0, it is removed from the Circular Process List and 
	a message is displayed to the user that the process is complete.
 9. Display the updated Circular Process List for every cycle, till the List becomes empty. 
Once all processes are deleted from the list you may either end the program or repeat the user menu.

-----------------------------------------------------------------------------------------------------------------------

PART 2 

ProcessInfo.java
	Exactly the same as processInfo.java from part one.

HeapClass.java
	
	Has a generic heap array T[]
	has size and maxelements

	get(int position)		-returns element at position

	add(T value)			-adds value to array

	remove()			-removes the first/top element

	isEmpty()			-checks wheather the arrayheap is empty

	peek()				-returns but not removes the first/top element

	size()				-returns size of arrayheap

	heapUp()			-on insert balances teh heap into a minheap

	heapDown()			-on remove of highest element rebalances heap into a minheap

	hasParent(int i)		-checks if heap has nodes outside of th parent node

	leftIndex(int i)		-returns the index of left node

	rightIndex(int i)		-returns the index of right node

	hasLeftChild(int i)		-cheak if entered position has left child   returns index of child

	hasRightChild(int i)		-cheak if entered position has right child   returns index of child
	
	parentIndex(int i)		-returns parent index

	parent(int i)			-returns heap of parent index

	swap(int index1, int index2)	-swaps index at position index1 and position index2

	toString()			-retuns heap as a string



MainProgram.java
	1. Displays the following User Menu: 
		1. Enter a process 
		2. Build Heap 
		3. Delete Highest Priority 
		4. Check Highest Priority Item 
		5. Check Highest Priority 
		6. Display Heap 
		7. End 
	2. For option 	
		1: Enter the process name, process time and process priority, create an object of the ProcessInfo class. 	
	3. For option 
		2: Call the Heapify function to build a heap of ProcessInfo Objects and display the updated Heap Array. 
	4. For Option 
		3: Display the highest priority process and delete the process from the node. 
		   Perform Down Heap after the array is altered.
	 5. For Option 
		4: Display the highest priority process, but do not delete from the heap. 
	6. For Option 
		5: Display the highest priority in the heap 
	7. Option 6 prints the heap.
	8. Option 7 Terminates the program. 


	
	

	




	
	


