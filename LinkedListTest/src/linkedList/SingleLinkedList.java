package linkedList;

public class SingleLinkedList {
	private Node head;
	private int N;

	private class Node {
		private Node next;
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
		public void setNext(Node next){
			this.next=next;
		}
	}

	public SingleLinkedList(){
		head=new Node(null);
		N=0;
	}
	public void add(Object item){
		Node newItem=new Node(item);
		Node current=head;
		while(current.getNext()!=null){
			current=current.getNext();
		}
		current.setNext(newItem);
		N++;
	}
	public void add(Object item,int index){
		Node newItem=new Node(item);
		Node current=head;
		int i=1;
		while(i<index && current.getNext()!=null){
			current=current.getNext();
			i++;
		}
		newItem.setNext(current.getNext());
		current.setNext(newItem);
		N++;
	}
	public Object getItem(int index){
		if(index<=0){
			System.out.println("index<=0");
			return null;
		}
		else{
			Node current=head.getNext();
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
	public int size(){
		return N;
	}
	public void remove(int index){
		if(index<1 || index>size()){
			System.out.println("index<1 || index>size()");
		}
		else{
			Node current=head;
			int i=0;
			while(i<index){
				if(current.getNext()==null){
					System.out.println("current.getNext()==null");
					break;
				}
				else{
					current=current.getNext();					
					i++;
				}
			}
			if(current.getNext()!=null){
				current.setNext(current.getNext().getNext());
			}
			N--;
		}
	}
	public String toString(){
		String output="";
		Node current=head.getNext();
		while(current!=null){
			output+="["+current.getItem().toString()+"]";
			current=current.getNext();
			
		}
		return output;
	}
}