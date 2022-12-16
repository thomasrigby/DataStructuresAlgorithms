import java.util.LinkedList;
import java.util.Queue;
import CITS2200.BinaryTree;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;

/**
 * Author Thomas Rigby
 * Class of Binary Tree implementing a binary tree of Generic type
 */
@SuppressWarnings("unchecked")
public class BinTree<E> extends BinaryTree<E> {
  public BinTree() {
    super();
  }

  public BinTree(E item, BinaryTree<E> ltree, BinaryTree<E> rtree) {
    super(item, ltree, rtree);
  }
 
  /** 
   * checks if the specified object. if so it returns true
   * @param o
   * @return boolean
   */
  public boolean equals(Object o)
    {
        if(!(o instanceof CITS2200.BinaryTree) || o == null)
            return false; 
            
        if(this.isEmpty() && ((BinaryTree)o).isEmpty()) 
            return true;
            
        if(this.isEmpty() || ((BinaryTree)o).isEmpty())
            return false;
            
        if(this.getItem().equals( ((BinaryTree)o).getItem() )) 
              return this.getLeft().equals(((BinaryTree)o).getLeft()) && this.getRight().equals(((BinaryTree)o).getRight());
        return false;
    }
  
    
    /** 
     * @return Iterator<E>
     */
    public Iterator<E> iterator() {
		return new TreeIterator(this);
	}
	
    /**
     * creates private variable queue of type E
     */
	class TreeIterator implements Iterator<E> {
		private Queue<E> queue = new LinkedList<E>();
	/**
     * Calls inOrder method that orders tree in a queue
     * @param t
     */
		public TreeIterator(BinTree t){
		inOrder(t); 
		}
	/**
     * checks if queue is there is an item next
     * @return true
     */
        public boolean hasNext() {
          
            return !queue.isEmpty();
        }
        
        /**
         * Method that checks if tree is not empty 
         * adds item from tree to queue if true, nothing if false
         * @param tree
         */
        public void inOrder(BinaryTree<E> tree){
            if(!tree.isEmpty()){
                inOrder(tree.getLeft());
                queue.add(tree.getItem());
                inOrder(tree.getRight());
            }
        }
	/**
     * Checks if queue is empty, removes item from queue if true
     * @throws OutOfBounds if else
     *  */	
		public E next () {
			if(hasNext()) {
		    return queue.remove();
 			}
 			else{throw new OutOfBounds("Empty tree");
		    }
	    }
    }
}