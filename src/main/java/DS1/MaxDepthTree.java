package DS1;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class MaxDepthTree {
	public static int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if(leftDepth > rightDepth)
			return leftDepth+1;
		else
			return rightDepth+1;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(6);
		t.left = t1;
		t.right = t2;
		t2.left = t3;
		t2.right = t4;
		t3.left = t5;
		System.out.println(maxDepth(t));
	}
}
