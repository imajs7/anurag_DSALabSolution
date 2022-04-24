package com.greatlearning.LowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	
	private Node root;
	
	LowestCommonAncestor(){
		this.root = null;
	}
	
	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private Node insert(Node node, int data) {
		
		if(node == null) {
			Node newNode = new Node(data);
			node = newNode;
		} else {
			
			if(data < node.data) {
				node.left = insert(node.left, data);
			} else if(data > node.data) {
				node.right = insert(node.right, data);
			} else {
				System.out.println("Duplicate Entry");
			}
			
		}
		
		return node;
	}
	
	public void lcaR(int data1, int data2) {
		boolean val1 = search(data1);
		boolean val2 = search(data2);
		if( ! val1  )
			System.out.printf("node{%d} is missing!", data1);
		if( ! val2 )
			System.out.printf("node{%d} is missing!", data2);
		if( val1 && val2 ) {
			Node lcaR = lcaRecursive(this.root, data1, data2);
			System.out.printf("\nLCA (by recursive method) for node{%d} & node{%d} is node{%d}", data1, data2, lcaR.data);			
		}
	}
	
	private Node lcaRecursive(Node node, int data1, int data2) {
		
		// if root node is null
		if(node == null)
			return null;
		
		// if lca is the root node
		if(node.data == data1 || node.data == data2)
			return node;
		
		// if both nodes are on one side
		Node left = lcaRecursive(node.left, data1, data2);
		Node right = lcaRecursive(node.right, data1, data2);
		
		if(left == null)
			return right;
		
		if(right == null)
			return left;
		
		// if one node is in one child sub tree
		//and other node is in other child sub tree
		return node;
		
	}
	
	public void lcaI(int data1, int data2) {
		int nodeValue = lcaIterative(this.root, data1, data2);
		
		if(nodeValue != -1)
			System.out.printf("\nLCA (by iterative method) for node{%d} & node{%d} is node{%d}", data1, data2, nodeValue);
		
	}
	
	private int lcaIterative(Node node, int data1, int data2) {
		
		List<Integer> path1 = new ArrayList<Integer>();
		List<Integer> path2 = new ArrayList<Integer>();
		
		boolean path1Exists = getPath(node, data1, path1);
		boolean path2Exists = getPath(node, data2, path2);
		
		if(!path1Exists) {
			System.out.printf("node{%d} is missing!", data1);
			return -1;
		}
		
		if(!path2Exists) {
			System.out.printf("node{%d} is missing!", data2);
			return -1;
		}
		
		int i;
		for(i = 0; i < path1.size() && i < path2.size(); i++) {
			if( ! path1.get(i).equals(path2.get(i)) ) {
				break;
			}
		}
		
		return path1.get(i-1);
	}
	
	private boolean getPath(Node node, int data, List<Integer> path) {
		
		if(node == null)
			return false;
		
		path.add(node.data);
		
		if(node.data == data)
			return true;
		
		if ( node.left != null && getPath(node.left, data, path) )
            return true;
		
		if ( node.right != null && getPath(node.right, data, path) )
            return true;
		
		path.remove( path.size() - 1 );
		
		return false;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		
		if(node == null)
			return;
		
		// print self
		String str = "";
		
		if(node.left == null) {
			str += "X";
		} else {
			str += node.left.data;
		}
		
		str += " <- " + node.data + " -> ";
		
		if(node.right == null) {
			str += "X";
		} else {
			str += node.right.data;
		}
		
		System.out.println(str);
		
		display(node.left);
		display(node.right);
		
	}
	
	/* search trigger */
	public boolean search(int data) {
		Node root = searchTree(this.root, data);
		if(root == null)
			return false;
		else
			return true;
		
	}
	
	/* binary search recursive */
	private Node searchTree(Node root, int data) {
		
		if(root == null || root.data == data) {
			return root;
		} else if(data < root.data) {
			return searchTree(root.left, data);
		} else {
			return searchTree(root.right, data);
		}
		
	}

}
