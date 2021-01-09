package cs102_rec8;
// CLASS FOR DOUBLY LINKED LIST (GENERICS)

public class doubleLinkedList<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		private Node<T> previous;
		
		public Node(){
			this.data=null;
			this.next=null;
			this.previous=null;
		}
		
		public Node(T data){
			this(data,null,null);
		}
		
		public Node(T data, Node<T> next, Node<T> previous){
			this.data=data;
			this.next=next;
			this.previous=previous;
		}

		public void setData(T data){this.data=data;}
		public void setNext(Node<T> next){ this.next=next;}
		
		public T getData(){ return this.data;}
		public Node<T> getNext(){return this.next;}
		
		public Node<T> getPrevious() {return this.previous;}

		public void setPrevious(Node<T> previous) {this.previous = previous;}

		public void display() {
			System.out.print("{" + getData() + "} ");
		}
	}
	private Node<T> head= null;
	
	
	public doubleLinkedList(){
		this.head= new Node<T>(null,null,null);
	
		
	}
	public doubleLinkedList(Node<T> head){
		this.head=head;
		
	}
	
	//public int size() { return this.size; }
	public boolean isEmpty() { 
		//return this.size == 0; 
		if(countNodes()!=0) {
			return false;
		}
		return true;
	}
	
	public T getFirst(){return this.head.getData(); }
	
	public Node<T> removeFirst() { // removes and returns the first element
	 if (isEmpty()) return null; // nothing to remove
	 Node<T> res = this.head;
	 res.getNext().previous= this.head;
	 this.head.next= res.getNext(); // will become null if list had only one node
	 return res;
	}

	public void addFirst(T data){
		Node<T> n= new Node<T>(data, this.head.getNext(), this.head);
		if (head.next != null) {
			head.getNext().previous = n;
		}
		head.next = n;
	}
	//size method 
	public int countNodes() {
		int count=0;
		Node<T> current= this.head;
		while(current!= null) {
			current=current.getNext();
			count+=1;
		}
		return count;
	}
	public  Node<T> search(T idnum){
		Node<T> current= this.head;
		while(current.getData()!=idnum) {
			if(current.getNext()==null)
				return null;
			else
				current = current.getNext();
		}
		return (Node<T>)current;
	}
	
	public  void update(T key, T data){
		Node<T> current=this.head;   
		current=search(data)	;// search for link
		current.setData(key);
		
	}
	
	
	public Node<T> delete(T key) {    // delete link with given key
                                         // (assumes non-empty list)
		Node<T> current= this.head;              // search for link
		Node<T> previous= this.head;
	    while(current.getData() != key){
	       if(current.getNext() == null)
	          return null;                 // didn't find it
	       else{
	   
	          previous = current;          // go to next link
	          current = current.getNext();
	       }
	    }                               // found it
	    if(current == this.head)               // if first link,
	       this.head = this.head.getNext();             //    change first
	    else                               // otherwise,
	       previous.next = current.getNext();   //    bypass it
	    
	    return current;
    }
	public void displayList() {     // display the list
		System.out.print("List (first-->last): ");
	    Node<T> current = this.head.next;       // start at beginning of list
	    while(current != null)      // until end of list,
	       {
	       current.display();   // print data
	       current = current.next; 
	      // System.out.println(current);// move to next link
	       }
	    System.out.println("");
	}
	
	
	public static void main(String[] args) {
		doubleLinkedList<String> List1 = new doubleLinkedList<>();
		// first test
		System.out.println("First Test: adding names to LinkedList...");
		List1.addFirst("Alice");
		List1.addFirst("Bob");
		List1.addFirst("Charlie");
		List1.addFirst("David");
		System.out.println();
		//second test
		System.out.println("Second Test:");
		List1.displayList();
		System.out.println();
		//third test
		System.out.println("Third Test:");
		int size1=List1.countNodes();
		List1.delete("Bob");
		int size2=List1.countNodes();
		if(size2<size1) {
			System.out.println("Size before deleting 'Bob' is "+size1+ " and size after deleting 'Bob' is "+ size2+ "! Thus, size updated correctly.");
		}
		System.out.println();
		//fourth test
		System.out.println("Fourth Test:");
		System.out.println("Before Updating: ");
		List1.displayList();
		List1.update("Salma","Charlie");
		System.out.println("After Updating: ");
		List1.displayList();
		System.out.println();
		//fifthtest
		System.out.println("Fifth Test:");
		List1.addFirst("Charlie");
		List1.displayList();
		System.out.println();
		//Sixth Test
		System.out.println("Sixth Test: ");
		size1=List1.countNodes();
		if(size2<size1) {
			System.out.println("Size before adding 'Charlie' is "+size2+ " and size after adding 'Charlie' is "+ size1+ "! Thus, size updated correctly.");
		}
	}

}
