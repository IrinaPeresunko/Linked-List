package linkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		SingleLinkedList sll=new SingleLinkedList();
		
		sll.add(new Integer(1));
		sll.add(new Integer(2));
		sll.add(new Integer(3));
		sll.add(new Integer(4));
		sll.add(new Integer(5));
		
		System.out.println(sll);
		System.out.println("Size:"+sll.size());
		
		sll.remove(3);
		System.out.println(sll);
		System.out.println("Size:"+sll.size());
		
		System.out.println("get Item - ["+sll.getItem(3)+"]");
		
		sll.add(new Integer(11), 3);
		System.out.println("Size:"+sll.size());
		System.out.println(sll);
	}
}
