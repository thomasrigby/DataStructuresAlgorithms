package Lists;

import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

/*
*method ListLinked that declares field variables
*implements CITS2200 List
*/
public class ListLinked implements List {
  private Link before;
  private Link after;

/*
*initialises variables for outside ends of list
*/
  public ListLinked() {
    after = new Link(null, null);
    before = new Link(null, after);
  }

/**
* checks iff list is empty 
* @return true iff list is empty
* @return false otherwise
*/
  public boolean isEmpty() {
    return before.successor == after;
  }

/**
*@return true iff window is over before first position
*@return false otherwise
*@param w
*/
  public boolean isBeforeFirst(WindowLinked w) {
   
    if(w.link == before){
        return true;
    }
    else{return false;}
  }

/**
*@return true iff window is over after last position
*@return false otherwise
*@param w
*/
  public boolean isAfterLast(WindowLinked w) {
   
    if(w.link == after){
        return true;
    }
    else{return false;}
  }

/**
*places a window over before first position
*@param w
*/
  public void beforeFirst(WindowLinked w) {
    w.link = before;
  }

/**
*places a window over after last position
*@param w
*/
  public void afterLast(WindowLinked w) {
   w.link = after; 
  }

/**
 * moves window to next position 
 * checks if window is past end of list
 * @throws OutOfBounds  
 * @param w
 */
  public void next(WindowLinked w) throws OutOfBounds {
    if (isAfterLast(w)) {
      throw new OutOfBounds("Calling next after list end.");
    }
    w.link = w.link.successor;
  }

/**
 * moves window to previous position
 * checks if window is before start of list
 * @throws OutOfBounds 
 * @param w
 */
  public void previous(WindowLinked w) throws OutOfBounds {
    if (isBeforeFirst(w)) {
      throw new OutOfBounds("Calling previous before start of list.");
    }
    Link current = before.successor;
    Link previous = before;
    while (current != w.link) {
      previous = current;
      current = current.successor;
    }
    w.link = previous;
  }
  
/**
 * insert an item after a window
 * checks iff window is past end of list
 * @throws OutOfBounds 
 * @param w 
 * @param e
 */
  public void insertAfter(Object e, WindowLinked w) throws OutOfBounds {
    if(isAfterLast(w)){
        throw new OutOfBounds("Inserting at end of list");
    }
    else{
    w.link.successor = new Link(e, w.link.successor);
    }
  }

/**
 * insert an item before a window
 * checks iff window is before start of list
 * @throws OutOfBounds
 * @param w 
 * @param e
 */
  public void insertBefore(Object e, WindowLinked w) throws OutOfBounds {
    if (isBeforeFirst(w)) {
      throw new OutOfBounds("Inserting before start of list.");
    }
    w.link.successor = new Link(w.link.item, w.link.successor);
    if (isAfterLast(w)) {
      after = w.link.successor;
    }
    w.link.item = e;
    w.link = w.link.successor;
  }

/**
 * examines object under a window
 * checks iff list is empty or window is outside of the list
 * @return Object  
 * @throws OutOfBounds 
 * @param w
 */
  public Object examine(WindowLinked w) throws OutOfBounds {
    if(isEmpty() || isAfterLast(w) || isBeforeFirst(w)){
        throw new OutOfBounds("Examining an empty list or if window is outside of list");
    } 
      return w.link.item;
    }
  
/**
 * replaces and returns object under a window
 * check iff list is empty or window is outside of the list
 * @return Object 
 * @throws OutOfBounds 
 * @param w
 * @param e
 */
  public Object replace(Object e, WindowLinked w) throws OutOfBounds {
    if(isBeforeFirst(w) || isAfterLast(w) || isEmpty()){
      throw new OutOfBounds("Replacing an object in an empty list or where window is outside of the list");}
       else{
       Object temp = w.link.item;
       w.link.item = e;
       return temp;
    }
  }

/**
 * deletes and returns object under a window
 * checks iff list is empty or window is outside of the list
 * places window over next item
 * @return object 
 * @throws OutOfBounds 
 * @param w
 * @param e
 */
public Object delete(WindowLinked w) throws OutOfBounds
	{
		if (isBeforeFirst(w) || isAfterLast(w) || isEmpty()){
			throw new OutOfBounds("Deleting from illegal point of list");
		}
		else{
		Link succ = w.link.successor;
		Object deleted = w.link.item;
		w.link.item = succ.item;
		w.link.successor = succ.successor;
		if(after == succ)
		   after = w.link;
		return deleted;
	}
}
}
