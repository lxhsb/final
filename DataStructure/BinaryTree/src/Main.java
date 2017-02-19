import java.util.Scanner;

public class Main
{
	public static void insert(BinaryTree now, int key)
	{
		System.out.println(now.key);
		if (now.key == key)
		{
			return;
		}
		else if (key < now.key)
		{
			if (now.left == null)
				now.left = new BinaryTree(key, now);
			else
				insert(now.left, key);

		}
		else
		{
			if (now.right == null)
				now.right = new BinaryTree(key, now);
			else
				insert(now.right, key);

		}

	}

	public static void md_print(BinaryTree now)
	{
		if (now == null)
			return;
		md_print(now.left);
		System.out.print(now.key + " ");
		md_print(now.right);

	}

	public static BinaryTree find(BinaryTree now, int key)
	{
		if (now == null)
			return null;
		if (now.key == key)
			return now;
		return find(key < now.key ? now.left : now.right, key);

	}

	public static void delNode(BinaryTree now)
	{
		//BinaryTree parent = now.parent;
		boolean isLeft = now.parent.left == now;
		if (now.right == null && now.left == null)
		{
			System.out.println("status 1");
			if (isLeft)
			{
				now.parent.left = null;
			}
			else
			{
				now.parent.right = null;
			}

		}
		else if (now.left != null && now.right == null)
		{
			System.out.println("status 2");
			if (isLeft)
			{
				System.out.println("at left");
				now.parent.left = now.left;
				now.left.parent = now.parent;
			}
			else
			{
				System.out.println("at right");
				now.parent.right = now.left;
				now.left.parent = now.parent;
			}
		}
		else if (now.left == null && now.right != null)
		{
			System.out.println("status 3");
			if (isLeft)
			{
				System.out.println("at left");
				now.parent.left = now.right;
				now.right.parent = now.parent;
			}
			else
			{
				System.out.println("at right");
				now.parent.right = now.right;
				now.right.parent = now.parent;
			}
		}
		else
		{
			BinaryTree min = now.left;
			while (min.right != null)
			{
				min = min.right;
			}
			now.key = min.key;
			if (min.parent != now)
			{
				min.parent.right = min.left;
				if (min.left != null)
					min.left.parent = min.parent;
			}
			else
			{
				now.left = min.left;
				if (min.left != null)
					min.left.parent = min.parent;
			}

		}
	}

	public static void main(String[] args)//还有一个bug 删不掉根节点 好解决，自己去实现吧
	{
		BinaryTree super_node = new BinaryTree(0, null);
		BinaryTree root = null;
		int op, key;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			op = scanner.nextInt();
			if (op == 2)
			{
				md_print(root);
				System.out.println();
			}
			else
			{
				key = scanner.nextInt();
				if (op == 1)
				{
					if (root == null)
						root = new BinaryTree(key, super_node);
					else
						insert(root, key);
				}
				else if (op == 3)
				{
					BinaryTree loc = find(root, key);
					if (loc == null)
					{
						System.out.println("not exist");
						continue;
					}
					if (loc.parent != null)
						System.out.println("父亲节点是 " + loc.parent.key);
					if (loc.left != null)
						System.out.println("左儿子是 " + loc.left.key);
					if (loc.right != null)
						System.out.println("右儿子是 " + loc.right.key);
				}
				else
				{
					BinaryTree loc = find(root, key);
					delNode(loc);
				}
			}

		}

	}
}
