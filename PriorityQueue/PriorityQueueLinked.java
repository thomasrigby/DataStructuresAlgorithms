package PriorityQueue;

import CITS2200.Iterator;
import CITS2200.OutOfBounds;
import CITS2200.PriorityQueue;
import CITS2200.Underflow;

//priority queue data structure implemented with linked list 
public class PriorityQueueLinked implements PriorityQueue<Object> {
  private Link front;

  public PriorityQueueLinked() {
    front = null;
  }

  private class Link {
    public Object element;
    public int priority;
    public Link next;

    public Link(Object element, int priority, Link next) {
      this.element = element;
      this.priority = priority;
      this.next = next;
    }
  }
  
  /** 
   * @return boolean
   */
  public boolean isEmpty() {
    return front == null;
  }

  /** 
   * @return Object
   * @throws Underflow
   */
  public Object examine() throws Underflow {
    if (isEmpty()) {
      throw new Underflow("Empty priority queue");
    }
    return front.element;
  }

  
  /** 
   * @return Object
   * @throws Underflow
   */
  public Object dequeue() throws Underflow {
    if (isEmpty()) {
      throw new Underflow("Empty priority queue");
    }

    Object temp = front.element;
    front = front.next;
    return temp;
  }
 
  /** 
   * @param element
   * @param priority
   */
  public void enqueue(Object element, int priority) {
    if (isEmpty() || priority > front.priority) {
      front = new Link(element, priority, front);
      return;
    }

    Link curr = front;
    while (curr.next != null && curr.next.priority >= priority) {
      curr = curr.next;
    }
    curr.next = new Link(element, priority, curr.next);
  }

    /** 
     * @return Iterator
     */
    public Iterator iterator() {
		return new PriorityIterator();
	}
	
	/**
     * Iterator class for PriorityQueueLinked 
     */
	public class PriorityIterator implements Iterator<Object>{
		
		Link present;
		
		public PriorityIterator(){
			present = new Link(null,0,front);
		}
		/**
         * Checks if next position is not null
         */
		@Override
		public boolean hasNext() {
			return present.next != null;
		}
		
		@Override
		public Object next() throws OutOfBounds {
			if(hasNext()){
				present = present.next;
				return present.element;
			}
			else{
				throw new OutOfBounds("There are no items left!");
			}
		}
	}
	
    /**
     * Class to make a link base structure
     * Holds an object 
     * Link references next item
     */
	public class L{
		Object elem;
		int p;
		Link after;
		
		public L(Object item, int p, Link n){
			this.elem = item;
			this.p = p;
			this.after = n;
		}
	}
  
}
