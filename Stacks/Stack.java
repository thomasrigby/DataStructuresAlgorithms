package Stacks;

/* 
StackBlock creates variables
data[] is created to store Objects
*/
public class Stack{
    private int top;
    private int size;
    private Object data[];
    private int length;
  
/*
Initialises variable length to equal size
data[] is created with size of length
*/
  public Stack(int size) {
	  length = size;
	  data = new Object[length];
	  top = -1;
  }

/*
Returns true iff the starting index is less than zero
*/
  public boolean isEmpty() {
	  return(top < 0);
  }
  
/*
Returns true iff top's index is equal to 
the stacks length decremented by 1.
Returns false iff not.
*/
  public boolean isFull() {
	 if (top == length-1){
	     return true;
	 }
	 else {
	     return false;
	 }
  }

/*
Method check that array is not full.
Replaces placeholder variable value 
with next element's value.
Places an placeholders value into stack.
If stack is full 
@throws OverflowException
*/
  public void push(Object item) throws Exception {
   
	  if(!isFull()) {
	  top = top+1;
	  data[top]=item;
	  }
	else {
	    throw new Exception("full");
	}
  }
  
/*
Returns value at placeholder if stack 
is not empty
If stack is empty 
@throw UnderflowException
*/
  public Object examine() throws Exception {
	  if(!isEmpty()) {
	      return data[top];
	  }
	 else {
	     throw new Exception("empty");
	 }
  }

/*
Creates variable item of type Object
If stack is not empty, item holds the 
value of the stacks placeholder variable
Placeholder value is set to null
Placeholder is decremented and value of
item is returned
If stack is empty, 
@throw UnderflowException
*/
  public Object pop() throws Exception {
	  Object item;
	  if(!isEmpty()){ 
	  item = data[top];
	  data[top] = null;
	  top = top-1;
	  }
	 else{ 
	     throw new Exception("empty");
   }
   return item; 
  } 
}
