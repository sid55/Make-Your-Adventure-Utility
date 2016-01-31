
// LinkedList.java   
// This java class funtions as a doubly linked list with one extra set 
// of pointers. This doubly linked list is a custom variation of an actual
// doubly linked list and thus has more nodes acting as pointers. Additionally,
// each node in this class holds four separate hashtables, each with
// their own functionalities.

/**
 *Shown below are the book(s) I have used as a reference to copy code or change existing code.
 *There are more and better descriptions of the book(s) right above each of the methods where I used 
 *these recourses. As a brief summary though, here are the book(s) I have used. In this program, I only copied
 *the display forward method.
 *1)Data Structures and Algorithms in Java Second Edition
 */
import java.io.*;    
import java.util.*;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//import LinkedList.node;

import java.util.Enumeration;

public class LinkedList {

	public enum position {
		FIRST, PREVIOUS, FOLLOWING, LAST
	};

	private class node { 
		int tagCount = 0;
		int descCount =0;
		int optCount = 0;
		LinkedHashMap<String, String> descHash = 
				new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> optHash= 
					new LinkedHashMap<String, String>();
		Hashtable<String, node> tagHash = 
				new Hashtable<String, node>();
		LinkedHashMap<String, String> lettersHash= 
				new LinkedHashMap<String, String>();
		String item;
		node prev;
		node prev2;
		node next;
		node next2;

		public node(String sent) {
			prev = null;
			next = null;
			item = sent;
		}

		public node() {
			// TODO Auto-generated constructor stub
		}

		public void showNode() {
			System.out.println(item + " ");
		}
	}

	private node first = null;
	private node current = null;
	private node last = null;
	private node veryTemp = null;
	private int currentPosition = 0;
	private String temp;
	private String temp2;
	private ArrayList<node> myArray = new ArrayList<node>();
	int top = -1;
	
	/**
	 * Source: Data Structures and Algorithms in Java Second Edition
	 * How I used the source: I copied this method from the book to display each of the
	 * 							nodes in the linked list. This also gave me a better 
	 * 							understanding of how to use nodes and in return helped
	 * 							me code the other methods.  
	 */
	public void displayForward() {
		System.out.println("node (first-->last): ");
		node current = first;
		while (current != null) {
			current.showNode();
			current = current.next;
		}
		System.out.println("");
	}
	
	public void setVeryTemp(){
		veryTemp = first;
	}
	
	public void setOptionsToUserEnter(node m){
		Set<Map.Entry<String, String>> set = m.optHash.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry)iterator.next();
			temp = (String) me.getKey();
			temp2 = (String) me.getValue();
			if (temp.compareTo("o1")==0){	
				m.lettersHash.put("a",temp2);
			}else if(temp.compareTo("o2")==0){
				m.lettersHash.put("b",temp2);
			}else if(temp.compareTo("o3")==0){
				m.lettersHash.put("c",temp2);
			}else if(temp.compareTo("o4")==0){
				m.lettersHash.put("d",temp2);
			}else if(temp.compareTo("o5")==0){
				m.lettersHash.put("e",temp2);
			}else if(temp.compareTo("o6")==0){
				m.lettersHash.put("f",temp2);
			}else if(temp.compareTo("o7")==0){
				m.lettersHash.put("g",temp2);
			}else if(temp.compareTo("o8")==0){
				m.lettersHash.put("h",temp2);	
			}else if(temp.compareTo("o9")==0){
				m.lettersHash.put("i",temp2);
			}else if(temp.compareTo("o10")==0){
				m.lettersHash.put("j",temp2);
			}else if(temp.compareTo("o11")==0){
				m.lettersHash.put("k",temp2);
			}else if(temp.compareTo("o12")==0){
				m.lettersHash.put("l",temp2);
			}else if(temp.compareTo("o13")==0){
				m.lettersHash.put("m",temp2);
			}else if(temp.compareTo("o14")==0){
				m.lettersHash.put("n",temp2);
			}else if(temp.compareTo("o15")==0){
				m.lettersHash.put("o",temp2);
			}else if(temp.compareTo("o16")==0){
				m.lettersHash.put("p",temp2);
			}else if(temp.compareTo("o17")==0){
				m.lettersHash.put("q",temp2);
			}else if(temp.compareTo("o18")==0){
				m.lettersHash.put("r",temp2);
			}else if(temp.compareTo("o19")==0){
				m.lettersHash.put("s",temp2);
			}else if(temp.compareTo("o20")==0){
				m.lettersHash.put("t",temp2);
			}else if(temp.compareTo("o21")==0){
				m.lettersHash.put("u",temp2);
			}else if(temp.compareTo("o22")==0){
				m.lettersHash.put("v",temp2);
			}else if(temp.compareTo("o23")==0){
				m.lettersHash.put("w",temp2);
			}else if(temp.compareTo("o24")==0){
				m.lettersHash.put("x",temp2);
			}else if(temp.compareTo("o25")==0){
				m.lettersHash.put("y",temp2);
			}else if(temp.compareTo("o26")==0){
				m.lettersHash.put("z",temp2);
			}
	}
	}
	
	public void myLetterEnumer(node m){ 
		Set<Map.Entry<String, String>> set = m.lettersHash.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry)iterator.next();
			System.out.println(me.getKey() + "" + me.getValue());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void myDescEnumer(node m){ 
		Set<Map.Entry<String, String>> set = m.descHash.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		Map.Entry me = (Map.Entry)iterator.next();
		System.out.println(me.getValue());
		System.out.println();
		while(iterator.hasNext()){
			me = (Map.Entry)iterator.next();
			System.out.println(me.getValue());
		}
	}
	
	public void myOptEnumer(node m){ 
		Set<Map.Entry<String, String>> set = m.optHash.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry)iterator.next();
			System.out.println(me.getValue());
		}
	}
	
	public void myTagEnumer(node m){ 
		Enumeration<String> theList2;
		theList2 = m.tagHash.keys();
		while(theList2.hasMoreElements()){
			temp = theList2.nextElement();
			node temp2 = m.tagHash.get(temp);
			String tempere = temp2.item;
			System.out.println(temp + " " + tempere);
		}
	}
	
	public String printsEndOfOptionDesc(node m, String myOpt){
		if(myOpt.compareTo("null")==0){
			System.out.println("CAME INTO HERE");
			return null;
		}else{
			Set<Map.Entry<String, String>> set = m.optHash.entrySet();
			Iterator<Entry<String, String>> iterator = set.iterator();
			while(iterator.hasNext()){
				@SuppressWarnings("rawtypes")
				Map.Entry me = (Map.Entry)iterator.next();
				String supahTemp = (String)me.getKey();
				if(supahTemp.compareTo(myOpt)==0){
					String veryNew = ((String)me.getValue());
					String supahveryNew = veryNew.substring(3,veryNew.length());
					String newVal = "[".concat(supahveryNew).concat("]");
					return newVal;
				}
			}
		}
		System.out.println("CAME INTO HERE2");
		return null;
	}
	
	public String lookForOptionNumber(node m, String rando){
		Set<Map.Entry<String, String>> set = m.lettersHash.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry)iterator.next();
			temp = (String)me.getKey();
			if(temp.compareTo(rando)==0){
				temp2 = (String)me.getValue();

				Set<Map.Entry<String, String>> set2 = m.optHash.entrySet();
				Iterator<Entry<String, String>> iterator2 = set2.iterator();
				while(iterator2.hasNext()){
					@SuppressWarnings("rawtypes")
					Map.Entry me2 = (Map.Entry)iterator2.next();
					String nextTemp = (String)me2.getValue();
					if(nextTemp.compareTo(temp2)==0){
						String crazyTemp = (String)me2.getKey();
						return crazyTemp;
					}
				}
				
			}
		}
		return null;
	}
	
	public node lookForTagObjectNode(node m, String rando){
			node temp2 = m.tagHash.get(rando);
			return temp2;
	}
	
	public String lookForTagObjectNodeItem(node m, String rando){
		node temp2 = m.tagHash.get(rando);
		return temp2.item;
	}
	
	public void setNewPointerTwoNodes2(node m, node n){
		m.next2 = n;
		n.prev2 = m;
		//node crazy = n.prev;
		//crazy.next2 = m;
		//m.prev2 = crazy;
		veryTemp = m;
	}
	
	public String getVeryTempItem(){
		return veryTemp.item;
	}
	
	public String hashOptGetterValue(){
		Set<Map.Entry<String, String>> set = last.optHash.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		if(iterator.hasNext()){
		@SuppressWarnings("rawtypes")
		Map.Entry me = (Map.Entry)iterator.next();
		String tempe = (String)me.getKey();
		return tempe;
		}
		else{
			return "NO ELEMENTS IN LIST";
		}
	}
	
	public node lookForNode(String nameOfRoom){
		node current = first;
		while (current!=null){
			if(current.item.compareTo(nameOfRoom)==0){
				return current;
			}else{
			current = current.next;
			}
		}
		System.out.println("NOT SUPPOSED TO GO HERE FORREAL");
		return null;
	}
	
	public void setNewNodeForTagHash(node m){
		Enumeration<String> theList4;
		theList4 = m.tagHash.keys();
		while(theList4.hasMoreElements()){
			temp = theList4.nextElement();
			node temp23 = m.tagHash.get(temp);
			veryTemp = temp23.next;
		}
	}
	
	public void addNewNodeToTagHash(String value, node theCurrent){
		node m = new node(); 
		m.next2 = theCurrent;
		theCurrent.prev2 = m;
		last.tagCount++;
		String myCount = String.valueOf(last.tagCount);
		String newValue = value.concat(myCount);
		last.tagHash.put(newValue, m);
	}
	
	
	public void insertHashDesc(String value, String object){
		last.descCount++;
		String myCount = String.valueOf(last.descCount);
		String newValue = value.concat(myCount);
		last.descHash.put(newValue, object);
	}
	
	public void insertHashOpt(String value, String object){
		last.optCount++;
		String myCount = String.valueOf(last.optCount);
		String newValue = value.concat(myCount);
		String newObject = " - ".concat(object);
		last.optHash.put(newValue, newObject);
	}
	
	public void insertHashTag(String value, String object){
		node m = new node();
		m.item = object;
		last.tagCount++;
		String myCount = String.valueOf(last.tagCount);
		String newValue = value.concat(myCount);
		last.tagHash.put(newValue, m);
	}
	
	public void moveCurrent(){
		current = current.next;
		setPosition(position.FOLLOWING);
	}
	
	public node getCurrent(){
		return current;
	}
	
	public node getFirst(){
		return first;
	}
	
	public node getLast(){
		return last;
	}
	
	public node getVeryTemp(){
		return veryTemp;
	}
	
	public void changeVeryTemp(){
		veryTemp = veryTemp.next2;
	}
	
	public void push(){
		myArray.add(++top, veryTemp);
	}
	
	public void resetTop(){
		while (top>0){
			top--;
		}
		top--;
	}
	
	public node pop(){
		top--;
		if(top<0){
			top++;
			System.out.println("[You cannot go back.]");
			System.out.println();
			return myArray.get(top);
		}
		return myArray.get(top);
	}
	
	public void changeVeryTempPrev(){
		veryTemp = veryTemp.prev2;
	}
	
	public void changeVeryTempToDiff(node n){
		veryTemp = n;
	}

	
	public void setPosition(position pos) throws UnsupportedOperationException {
		switch (pos) {
		case FIRST: 
			if(isEmpty() == true){
				throw new UnsupportedOperationException();
			}
			currentPosition = 0;
			current = first;
			if (first == null)
				currentPosition = -1;
			else
				break;
			return;
		case PREVIOUS:
			if (current.prev == null || isEmpty()==true){
				throw new UnsupportedOperationException();
			}
			if (current != null) {
				currentPosition -= 1;
				current = current.prev;
			} else
				break;
			return;
		case FOLLOWING:
			if (current.next == null || isEmpty()==true){
				throw new UnsupportedOperationException();
			}
			else if (current != null) {
				currentPosition += 1;
				current = current.next;
			} else
				break;
			return;
		case LAST:
			if(isEmpty() ==true){
				throw new UnsupportedOperationException();
			}
			node temp = first;
			currentPosition = 0;
			if (temp != null)
				while (temp.next != null) {
					temp = temp.next;
					currentPosition += 1;
				}
			else {
				currentPosition = -1;
				break;
			}
			current = temp;
			return;
		default:
			throw new UnsupportedOperationException();
		}
	}
	

	public boolean isEmpty() {
		return first == null;
	}

	public String getItem() throws UnsupportedOperationException { 
		if(isEmpty() == true){
		throw new UnsupportedOperationException();
		}
		else{
		return current.item;
		}
		}
	
	  public int getPosition () throws UnsupportedOperationException { 
		  if(isEmpty() == true){
		  throw new UnsupportedOperationException();
		  }
		  else{
			  return currentPosition;
		  }
		  }
	 
	  
	 public void delete () throws UnsupportedOperationException{ 
		 if(isEmpty() == true){
			 throw new UnsupportedOperationException();
		 }
		 else if (current.next == null){
			 last = last.prev;
			 current = current.prev;
			 current.next = null;
			 last.next = null;
		 }
		 else if(current.next != null){
		 node after = current.next;
		 node previous = current.prev;
		 previous.next = after;
		 after.prev = previous;
		 current = after;
		 }  
		 }
	 

	public void insert(String item, position pos) throws UnsupportedOperationException {
		node newNode = new node(item);
		if (isEmpty()) {
			first = newNode;
			last = first;
			currentPosition = 0;
			current = first;
			newNode.prev = null;
			newNode.next = null;
		} else {
			if (pos == position.FIRST) {
				newNode.next = first;
				newNode.prev = null;
				first.prev = newNode;
				first = newNode;
				currentPosition++;
			} else if (pos == position.PREVIOUS) {
				if (current.prev == null) {
					insert(item, position.FIRST);
				} else {
					current.prev.next = newNode;
					newNode.prev = current.prev;
					newNode.next = current;
					current.prev = newNode;
					currentPosition++;
				}
			} else if (pos == position.FOLLOWING) {
				if (current.next == null) {
					insert(item, position.LAST);
				} else {
					current.next.prev = newNode;
					newNode.next = current.next;
					newNode.prev = current;
					current.next = newNode;
				}
			} else if (pos == position.LAST) {
				newNode.prev = last;
				newNode.next = null;
				last.next = newNode;
				last = newNode;
			} else {
				throw new UnsupportedOperationException();	
			}
		}
	}
}
