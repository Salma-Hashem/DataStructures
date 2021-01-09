package arrayStack;
import java.util.ArrayList;

import java.io.Serializable;


public class Stack<T> implements Comparable<Stack>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public T[] stack;
	int top;
	
	transient int admin;
	//generic constructor 
	public Stack(int element) {
		stack= (T[]) new Object[element] ;
		top = -1;
		admin = 42;
	}
	
	public Stack() {
		this(5);
	}
	
	public void push(T element) {
		if(top == 4) {
			System.out.println("Stack Overflow");
			return;
		}
		
		stack[++top] = element; 
		System.out.println("Pushed " + element);
	}
	
	public Object pop() {
		if(top == -1)
			System.out.println("Stack Underflow");
		
		return stack[top--];
	}
	
	//public <T> void display() {
	public void display() {
		//for(int i = 0; i <= top; i++)
		//	System.out.print(stack[i] + " ");
		for(T b: stack)
			System.out.printf("%s ", b);
		System.out.println();
	}
	
	public  void display(int start, int end) {
		if(start > top)
			return;
		if(end > top)
			end = top;
		for(int i = start; i <= end; ++i)
			System.out.print(stack[i] + " ");
		
		System.out.println();
	}
	
	public void search(T element) {
		for(int i = 0; i <= top; i++)
			if(stack[i].equals(element)) {
				System.out.println("Found input " + element + " at index " + i);
				return;
			}
		
		System.out.println("Not found");
	}
	
	
	@Override
	public int compareTo(Stack o) {
		//if (this.top.compareTo(o.top)<0)
		//T value;
		
		if(this.top < o.top)
			return -1;
		else if(this.top == o.top)
			return 0;
		else
			return 1;
	}
		
		
	
}
