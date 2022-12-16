package Queues;

/*class that creates variables 
 *creates empty deque of objects 
 *creates placeholder for first and last of deque
 */
@SuppressWarnings("unchecked")
public class DequeCyclic<E>{

    private int right;
    private int left;
    private E item;
    private E [] Deque;
    private int size;
    
    
/*initialises variables 
 *Deque is initialised with generic type <E>
 */
  public DequeCyclic(int size) {
    this.size = size;
   
    right = -1;
    left = 0; 
    Deque = (E[]) new Object[this.size];
  }
/*returns true iff deque contains no values 
 *returns false otherwise
 */
  public boolean isEmpty() {
   
    if(right == -1){
        return true;
        }
        else{
            return false;
        }
    }
  
/*returns true iff deque is full
 *returns false otherwise
 */
  public boolean isFull() {

    if(right == left+1 || left == size-1 && right == 0){
    return true;
    }
    else{
        return false;
    }
  }

/*method to place generic type item at far left position
 *@throws Exception iff deque is full
 *Iff deque is not full, add item to left placeholder
 */
  public void pushLeft(E item) throws Exception {
    //check iff deque is full
    if(isFull()){
        throw new Exception("full queue");
    }
    //Empty deque
    if(left == size-1){
       left=0;
    }
    else if(right == -1){
    right = 0;
    left = 0;
    }
    else {left = left+1;}
  
    Deque[left]=item;
  }

/*method that places item at right placeholder
 *@throws Overflow iff deque is full 
 */
  public void pushRight(E item) throws Exception {
  //Check iff deque is full, throw Exception if true
    if(isFull()){
        throw new Exception("Deque is Full!");
    }
    //Iff deque is empty 
    if(right == -1){
        right = 0;
        left = 0;
    }
    else 
        if(right == 0){
        right = size -1;
        }
    else {right = right -1;}
    Deque[right] = item;
    }
    

/*method that retrieves value at left position
 *@throws ExceptionException iff deque is empty
 */
  public E peekLeft() throws Exception {
   //Iff deque is empty 
    if(isEmpty()){
        throw new Exception("Deque Empty");
    }
    else {return Deque[left];}
  
  }
  
/*method that retrieves value at right positioniff deque is empty 
 *@throws ExceptionException iff deque is empty
 */
  public E peekRight() throws Exception {
 
    if(isEmpty()){
        throw new Exception("Deque Empty");
    }
    else {return Deque[right];}
   
  }
  
/*method that removes value at left position
 *creates temporary value to hold removed item
 * @throws Exception iff deque is empty 
 */
  public E popLeft() throws Exception {
   E lTemp = null;
    if(isEmpty()){
        throw new Exception("Deque is empty!");
    }
    //iff only one value in deque
    if (left == right){
       lTemp = Deque[left];
        left = 0;
        right = -1;
       
    }
    else 
        if(left == 0){
            lTemp = Deque[left];
            
        left = size-1;
        
        }
    
    else {
        lTemp = Deque[left];
        left = left-1;
        
    }
    return lTemp;
  }
  
/*method that removes value at right position
 *creates temporary value to hold removed item
 *@throws Exception iff deque is empty
 */
  public E popRight() throws Exception {
    E rTemp = null;
    if(isEmpty()){
        throw new Exception("Deque is empty");
    }
    //iff deque has one value
    if(right == left){
     rTemp = Deque[right];
        right = -1;
        left = -1;
    }
    
    else if(right == size-1){
        rTemp = Deque[right];
        right = 0; 
    }
    
    else 
        {
            rTemp = Deque[right];
            right = right+1;
        }
    
    return rTemp;
    }
}