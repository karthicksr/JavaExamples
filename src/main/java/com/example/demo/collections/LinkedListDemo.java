package com.example.demo.collections;

public class LinkedListDemo {
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void pushData(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next == null) {
				temp = temp.next;
				temp.next = newNode;
				newNode.next = null;
			}
		}
	}
	
	//public void printList()
	
	public static void main(String[] args) {
		LinkedListDemo linkedList = new LinkedListDemo();
		linkedList.pushData(1);
	}

}
