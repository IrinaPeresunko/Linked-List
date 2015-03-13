package linkedList;

public class DoublyLinkedList {
	private Node first;
	private Node current;
	private Node last;
	private int N;

	private class Node {
		private Node next;
		private Node prev;
		private Object item;
		
		public Node(Object item){
			next=null;
			this.item=item;
		}
		public Object getItem(){
			return item;
		}
		public Node getNext(){
			return next;
		}
		public Node getPrev(){
			return prev;
		}
	}

	public DoublyLinkedList(){
		first=current=last=null;
		N=0;
	}
	public void addAtTheTop(Object item){
		Node newItem = new Node(item);
		
		if(first==null){
			first=last=newItem;
		}
		else{
			newItem.next=first;
			first=newItem;
			newItem.next.prev=first;
		}
		N++;
	}
	public void addAtTheEnd(Object item){
		Node newItem = new Node(item);
		
		if(first==null){
			first=last=newItem;
		}
		else{
			last.next=newItem;
			newItem.prev=last;
			last=newItem;
		}
		N++;	
	}
	public void add(Object item,int index){
		if(index<1 || index>size()){
			System.out.println("index<1 || index>size()");
		}
		else if(index==1){
			addAtTheTop(item);
		}
		else if(index==N){
			addAtTheEnd(item);
		}
		else{
			current=first;
			int i=1;
			while(i<index && current !=null){
				current=current.getNext();
				i++;
			}
			Node newItem = new Node(item);
			current.prev.next=newItem;
			newItem.prev=current.prev;
			current.prev=newItem;
			newItem.next=current;
			
			N++;			
		}	
	}
	public int size(){
		return N;
	}
	public Node removeAtTheTop(){
		 if(first == null){
			 System.out.println("first == null");
			 return null;
         }
		 else{
			 Node elem = first;
			 if(first.getNext()!=null){
				 first.next.prev=null;
			 }
			 first=first.next;
			 N--;
			 return elem;
		 }
	}
	public Node removeAtTheEnd(){
		 if(last == null){
			 System.out.println("last == null");
			 return null;
        }
		 else{
			 Node elem = last;
			 if(last.getPrev()!=null){
				 last.prev.next=null;
			 }
			 last=last.prev;
			 N--;
			 return elem;
		 }
	}
	public void remove(int index){
		if(index<1 || index>N){
			System.out.println("index<1 || index>N");
		}
		else if(index==1){
			removeAtTheTop();
		}
		else if(index==N){
			removeAtTheEnd();
		}
		else{
			current=first;
			int i=1;
			while(current!=null && i<index){
				if(current.getNext()==null){
					System.out.println("current.getNext()==null");
					break;
				}
				else{
					current=current.getNext();					
					i++;
				}
			}
			current.prev.next=current.next;
			current.next.prev=current.prev;
			N--;
		}
	}
	public Object getItem(int index){
		if(index<=0){
			System.out.println("index<=0");
			return null;
		}
		else{
			current=first;
			int i=1;
			while(i<index){
				if(current.getNext()==null){
					return null;
				}
				else{
					current=current.getNext();
					i++;
				}			
			}
			return current.getItem();
		}
	}
	public String toString(){
		if(first==null){
			System.out.println("Doubly Linked List is empty");
		}
		String output="";
		current=first;
		while(current!=null){
			output+="["+current.getItem().toString()+"]";
			current=current.getNext();		
		}
		return output;
	}
}