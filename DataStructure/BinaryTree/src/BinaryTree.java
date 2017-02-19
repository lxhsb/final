/**
 * Created by wyy on 17-2-19.
 */
public class BinaryTree
{
	public int key ;//左小右大
	public BinaryTree parent;
	public BinaryTree left ;
	public BinaryTree right;
	public BinaryTree(int key,BinaryTree parent)
	{
		this.parent = parent;
		this.key = key ;
		left = right=null;
	}

}
