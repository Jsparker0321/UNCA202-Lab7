import java.util.NoSuchElementException;

//Do not create a new node or change 
//Do not use set, remove, or add

public class LinkedLab07<E> {

    private class Node {
        
        private E data;
        private Node next;
        
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(E data) {
            this(data, null);
        }
        
        public Node() {
            this(null, null);
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedLab07() {
        head = new Node();
        tail = head;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    private Node getNodeBefore(int index) {
        Node current = head;
        for (int i=0; i<index; i++)
            current = current.next;
        return current;
    }

	public boolean contains(Object obj) {
	    Node current = head.next;
	    while (current != null) {
	        if (current.data.equals(obj))
	            return true;
	        current = current.next;
	    }
	    return false;
	}
    
    public int indexOf(Object obj) {
        Node current = head.next;
        int index = 0;
        while (current != null) {
            if (current.data.equals(obj))
                return index;
            current = current.next;
            index++;
        }
        throw new NoSuchElementException();
    }
    
    public E get(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
        return getNodeBefore(index).next.data;
    }

	public void add(E element) {
	    tail.next = new Node(element);
	    tail = tail.next;
	    size++;
	}

	public void add(int index, E element) {
	    if (index < 0 || index > size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    Node previous = getNodeBefore(index);
	    Node current = new Node(element, previous.next);
	    previous.next = current;
	    if (tail == previous)
	        tail = current;
	    size++;
	}

	public void remove(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    Node previous = getNodeBefore(index);
	    previous.next = previous.next.next;
	    if (previous.next == null)
	        tail = previous;
	    size--;
	}

	public void set(int index, E element) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException("index: " + index);
	    getNodeBefore(index).next.data = element;
	}
	
	public void clear() {
	    head.next = null;
	    tail = head;
	    size = 0;
	}
	
	public boolean isEmpty() {
	    return size == 0;
	}
	
	public void moveFirstToLast() {
	    //TO DO: fill in the body of this method
		
		if (isEmpty()) throw new NoSuchElementException("List is Empty.");
		if ( size > 1) {
			Node move = head.next;
			head.next = move.next;
			tail.next = move;
			tail = move;
			move.next = null;
		}
		
		
		
		
		
	}
	
	public void moveLastToFirst() {
	    //TO DO: fill in the body of this method
		
		if (isEmpty()) throw new NoSuchElementException("List is Empty.");
		if (size > 1) {
			
			Node anotherMove = tail;
			tail = getNodeBefore(size - 1);
			tail.next = null;
			anotherMove.next = head.next; 
			head.next = anotherMove;
			
		}
	}
	
	public void swap(int i, int j) {
	    //TO DO: fill in the body of this method
		
		if (isEmpty()) throw new IndexOutOfBoundsException("Properly caught bad arguments. ");
		if ( size > 1 ) {
			if ( i == j)
				return;
				Node before1 = getNodeBefore(i);
				Node temp1 = before1.next;
				Node before2 = getNodeBefore(j);
				Node temp2 = before2.next;
				if (temp1 != null || temp2 == null)
					return;
				before1.next = temp2;
				before2.next = temp1;
				Node temp3 = temp1.next;
				temp1 = temp2.next;
				temp2.next = temp3;
		}
	}
	
	public void reverse() {
		//TO DO: fill in the body of this method
		
		
		//find first and last node and use a pointer
		//call swap method and pass it 
		//swap ends first
		
		while (temp1 != temp2.next || temp1 != temp2) {
			int i = 1;
			//size - i
			Node temp2 = getNodeBefore(size-1).next;
		}
	}
	
	@Override
	public String toString() {
	    if (size == 0) return "[ ]";
	    StringBuilder sb = new StringBuilder("[");
	    Node current = head.next;
	    while (current != null) {
	        sb.append(current.data.toString() + ", ");
	        current = current.next;
	    }
	    sb.setLength(sb.length() - 2);
	    sb.append("]\t");
	    return sb.toString();
	}
}