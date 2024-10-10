public class DLinkedList {

	private class Node {
		private Object value;
		private Node nextNode;
		private Node prevNode;

		public Node(Object v) {
			value = v;
			nextNode = null;
			prevNode = null;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object v) {
			value = v;
		}
		
		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node n) {
			nextNode = n;
		}
		
		public Node getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(Node n) {
			prevNode = n;
		}
	
	}

	// Holds a reference to the head and tail of the list
	private Node headNode;
	private Node tailNode;

	public DLinkedList() {
		headNode = null;
		tailNode = null;
	}
	
	public Object getHeadValue(){
		if (headNode == null)
			return null;
		return headNode.value;
	}
	
	public Object getTailValue(){
		if (tailNode == null)
			return null;
		return tailNode.value;
	}
	
	public void addAtHead(Object o) {
		// step 1: create a new node
		Node newNode = new Node(o);
		
		// step 2: update the new node's next node
		newNode.setNextNode(headNode);
		
		// step 3: if headNode is not null, update its previous node
		if (headNode != null)
			headNode.setPrevNode(newNode);
		
		// step 3: update headNode
		headNode = newNode; 
		
		// step 5: special case: adding to empty list,
		//         what to do with tailNode (which will be null)?
		if (tailNode == null) {
		    tailNode = newNode;
		}

	}
	
	
	
	

	public void addAtTail(Object o) {
		// step 1: create a new node
		Node newNode = new Node(o);
		
		// step 2a: special case, adding to empty list
		//   check: is tailNode null?
		//   solution: update tailNode and headNode.
		if (tailNode == null) {
			tailNode = newNode;
		    headNode = newNode;
		}
		// step 2b: otherwise, adding to non-empty list
		else{
			// step 3: update new node's previous node
			newNode.setPrevNode(tailNode);

			// step 4: update the tailNode's next node
			tailNode.setNextNode(newNode);
			
			// step 5: update the tailNode
			tailNode = newNode;
		}
	}
		
	
	
	
	public Object deleteAtHead() {
		// step 1: if list is empty return null
		if(headNode == null){
			headNode = null;
			tailNode = null;
			return null;
		}
		
		// step 2: if one element in list
		else if(headNode == tailNode){
			// step 2a: get the value of the head node
			Object res = headNode.getValue();

			// step 2b: update headNode
			headNode = null;

			// step 2c: update tailNode
			tailNode = null;

			// step 2d: return the head node's value
			return res;
		}
		
		// step 3: for the multi element list case
		else {
			// step 3a: get the head node's value
			Object res = headNode.getValue();

			// step 3b: update headNode
			headNode = headNode.getNextNode();

			// step 3c: update headNode's previous value
			headNode.setPrevNode(null);
			return res;
		}
	}

	
	
	
	public Object deleteAtTail() {
		// if the list is empty, return null
		if(tailNode == null){
			headNode = null;
			tailNode = null;
			return null;
		}
		
		// for the one element list case
		if(headNode == tailNode){
			Object res = tailNode.getValue();
			headNode = null;
			tailNode = null;
			return res;
		}
		
		// for the multi element list case
		else {
			Object res = tailNode.getValue();
			tailNode = tailNode.getPrevNode();
			tailNode.setNextNode(null);
			return res;
		}
	}
}


