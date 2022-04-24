package com.greatlearning.LowestCommonAncestor;

public class LCAClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		
		tree.insert(20);
		tree.insert(23);
		tree.insert(10);
		tree.insert(34);
		tree.insert(4);
		tree.insert(22);
		tree.insert(21);
		
		tree.display();
		
		tree.lcaR(21, 4);

		tree.lcaI(20, 22);

	}

}
