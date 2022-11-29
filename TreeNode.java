/**
*@author Chris Duong
*/

public class TreeNode<T> {
	
	protected T data;
	protected TreeNode<T> leftC;
	protected TreeNode<T> rightC;
	

	public TreeNode(T dataNode) {
		leftC = rightC = null;
		data = dataNode;
	}
	
	public TreeNode (TreeNode<T> node) {
		new TreeNode<T>(node);
	}
	
	public T getData() {
		
		return data;
	}
}