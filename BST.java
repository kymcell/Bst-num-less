//Kyle McElligott
import java.util.*;
import java.io.*;

public class BST {
//Implements a binary search tree of ints
//There are no duplicates in the tree
	private class Node {
		private Node left;
		private int data;
		private Node right;
		private Node(Node L, int d, Node R) {
			left = L;
			data = d;
			right = R;
		}
	}

	private Node root;
	public BST() {
		root = null;
	}

    //Do not change the insert methods
    public void insert(int d) {
        root = insert(root, d);
    }

    private Node insert(Node r, int d) {
        if (r == null) return new Node(null, d, null);
        if (d < r.data) r.left = insert(r.left, d);
        else if (d > r.data) r.right = insert(r.right, d);
        //else duplicate so do nothing
        return r;
    }

	public int numLessThan(int d) {
	//return the number of items in the tree that are less than d
		return numLessThan(root,d);
	}

    private int numLessThan(Node r,int d) {
    //return the number of items in the subtree rooted at r that are less than d
    //the method must be recursive and it must make use of the structure of
    //the binary search tree
    //DO NOT JUST SEARCH THE WHOLE TREE
			if(r == null) return 0;
			if(r.data < d)
			{
				return 1 + numLessThan(r.left, d) + numLessThan(r.right, d);
			}
			return numLessThan(r.left, d);
    }

    public static void main(String args[]) throws IOException {
    //Simple test driver
    //Do not change
        BST b = new BST();
        Scanner s = new Scanner(new File(args[0]));
        while (s.hasNextInt()) {
            int i = s.nextInt();
            b.insert(i);
        }
        System.out.println(b.numLessThan(Integer.parseInt(args[1])));

    }

}
