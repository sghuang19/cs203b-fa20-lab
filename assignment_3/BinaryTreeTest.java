
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
	@Test
	public void test01() {
		BinaryTree binaryTree = new BinaryTree();
		TreeNode node0 = new TreeNode(3);
		binaryTree.root = node0;

		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		BinaryTree.AddLeft(node0, node1);
		BinaryTree.AddRight(node0, node2);
		
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		BinaryTree.AddLeft(node1, node3);
		BinaryTree.AddRight(node1, node4);

		System.out.println("TraversalInOrder:" + binaryTree.TraversalInOrder());
		assertEquals("15 9 7 3 20 ", binaryTree.TraversalInOrder());

		System.out.println("TraversalPreOrder:" + binaryTree.TraversalPreOrder());
		assertEquals("3 9 15 7 20 ", binaryTree.TraversalPreOrder());

		System.out.println("TraversalPostOrder:" + binaryTree.TraversalPostOrder());
		assertEquals("15 7 9 20 3 ", binaryTree.TraversalPostOrder());

		System.out.println("TraversalLevelOrder:" + binaryTree.TraversalLevelOrder());
		assertEquals("[3 ][9 20 ][15 7 ]", binaryTree.TraversalLevelOrder());

		System.out.println(binaryTree.PreIn2Post(binaryTree.TraversalPreOrder(), binaryTree.TraversalInOrder()));
		assertEquals(binaryTree.PreIn2Post(binaryTree.TraversalPreOrder(), binaryTree.TraversalInOrder()),
				binaryTree.TraversalPostOrder());

		System.out.println(binaryTree.InPost2Pre(binaryTree.TraversalInOrder(), binaryTree.TraversalPostOrder()));
		assertEquals(binaryTree.InPost2Pre(binaryTree.TraversalInOrder(), binaryTree.TraversalPostOrder()),
				binaryTree.TraversalPreOrder());
	}
}
