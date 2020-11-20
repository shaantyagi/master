package abc;

import java.io.IOException;

public class DoublyLList {
	static class DoublyLinkedList{
		int data;
		DoublyLinkedList prev;
		DoublyLinkedList next;
		public DoublyLinkedList(int data) {
			this.data=data;
			prev=null;
			next=null;
		}
	}
	//Printing all nodes
	static void display(DoublyLinkedList head){
		System.out.print("Linked list elements: ");
		DoublyLinkedList temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	//Inserting node at nth position
	static DoublyLinkedList insert(DoublyLinkedList head, int data, int position) {
		DoublyLinkedList temp1=new DoublyLinkedList(data);
		if(head==null) {
			head=temp1;
			return head;
		}
		if(position==1) {
			temp1.next=head;
			head=temp1;
			return head;
		}
		DoublyLinkedList temp2=head;
		for(int i=0;i<position-2;i++) {
			temp2=temp2.next;
		}
		temp1.next=temp2.next;
		temp1.prev=temp2;
		temp2.next=temp1;
		
	return head;
	}
	//Delete node at nth position
	static DoublyLinkedList delete(DoublyLinkedList head, int position) {
		if(head==null)
			return head;
		DoublyLinkedList temp1=head;
		if(position==1) {
			head=temp1.next;
			return head;
		}
		for(int i=0;i<position-2;i++) {
			temp1=temp1.next;
		}
		DoublyLinkedList temp2=temp1.next;
		if(temp2.next==null) {
			temp1.next=null;
			return head;
		}
		temp1.next=temp2.next;
		temp2=temp2.next;
		temp2.prev=temp1;
		return head;
	}
	//Search Node element in the list
	static int search(DoublyLinkedList head, int number) {
		if(head==null) {
			return -1;
		}
		int flag=0;
		DoublyLinkedList temp=head;
		while(temp.next!=null) {
			if(temp.data==number) {
				flag=1;
				break;
			}
			temp=temp.next;
		}
		if(flag==1)
			return 1;
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		DoublyLinkedList head=null;
		head=insert(head, 10, 1);
		head=insert(head, 20, 2);
		head=insert(head, 30, 3);
		head=insert(head, 40, 2);
		head=insert(head, 50, 5);
		head=insert(head, 60, 1);
		display(head);
		head=delete(head, 6);
		head=delete(head, 1);
		display(head);
		int res=search(head,10);
		String result=(res==1) ? "Pair exists" : "Does not exist";
		System.out.println(result);
	}

}
