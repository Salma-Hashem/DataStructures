package cs102_rec8;

//CLASS FOR SINGLY LINKEDLIST (GENERICS)
public class LinkedList<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(){
			this.data=null;
			this.next=null;
		}
		
		public Node(T data){
			this.data=data;
			this.next=null;
		}
		
		public Node(T data, Node<T> next){
			this.data=data;
			this.next=next;
		}

		public void setData(T data){this.data=data;}
		public void setNext(Node<T> next){ this.next=next;}
		
		public T getData(){ return this.data;}
		public Node<T> getNext(){return this.next;}
		
		public void display() {
			System.out.print("{" + getData() + "} ");
		}
	}
	private Node<T> head;
	
	
	public LinkedList(){
		this.head=null;
		
	}
	public LinkedList(Node<T> head){
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
	
	public T removeFirst() { // removes and returns the first element
	 if (isEmpty()) return null; // nothing to remove
	 T res = this.head.getData();
	 this.head = this.head.getNext(); // will become null if list had only one node
	 return res;
	}

	public void addFirst(T data){
		this.head= new Node<T>(data, this.head);
		
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
	public  Node<T> search(T key){
		Node<T> current= this.head;
		while(current.getData()!=key) {
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
	    Node<T> current = this.head;       // start at beginning of list
	    while(current != null)      // until end of list,
	       {
	       current.display();   // print data
	       current = current.next;  // move to next link
	       }
	    System.out.println("");
	}
	
	
	public static void main(String[] args) {
		LinkedList<String> List1 = new LinkedList<>();
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
			System.out.println("Size before deleting is "+size1+ " and size after deleting is "+ size2+ "! Thus, size updated correctly.");
		}
		System.out.println();
		//fourth test
		System.out.println("Fourth Test:");
		System.out.println("Before Updating: ");
		List1.displayList();
		List1.update("Salma","David");
		System.out.println("After Updating: ");
		List1.displayList();
		System.out.println();
		//fifthtest
		System.out.println("Fifth Test:");
		List1.addFirst("David");
		List1.displayList();
		System.out.println();
		//Sixth Test
		System.out.println("Sixth Test: ");
		size1=List1.countNodes();
		if(size2<size1) {
			System.out.println("Size before adding 'David' is "+size2+ " and size after adding 'David' is "+ size1+ "! Thus, size updated correctly.");
		}
	}

}
