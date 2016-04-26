package treedemo;

import java.util.Stack;

class Tree {

    private Node root;

    public Tree() {
	root = null;
    }

    /*
     * ���ҹؼ���Ϊkey�Ľڵ�
     */
    public Node find(int key) {
	Node current = root;
	while (current.iDate != key) {
	    if (key < current.iDate)
		current = current.leftChild;
	    else
		current = current.rightChild;
	    if (current == null)
		return null;
	}
	return current;
    }

    /*
     * ����һ���ڵ㣬���Ƕ������Ƿ�Ϊ�գ�
     */
    public void insert(int id, double dd) {

	Node newNode = new Node(id, dd);
	if (root == null)
	    root = newNode;
	else {
	    Node current = root;
	    Node parent;
	    while (true) {
		parent = current;
		if (id < current.iDate) {
		    current = current.leftChild;
		    if (current == null) {
			parent.leftChild = newNode;
			return;
		    }
		} else {
		    current = current.rightChild;
		    if (current == null) {
			parent.rightChild = newNode;
			return;
		    }
		}
	    }
	}
    }

    /*
     * ɾ��һ���ڵ㣬���Ǹýڵ���ӽڵ�����0��1��2���Ƿ�Ϊroot��
     */
    public boolean delete(int key) {

	Node current = root;
	Node parent = root;
	boolean isLeftChild = true;

	// ���Ҵ�ɾ�ڵ㣬����current��
	while (current.iDate != key) {
	    parent = current;
	    if (key < current.iDate) {
		isLeftChild = true;
		current = current.leftChild;
	    } else {
		isLeftChild = false;
		current = current.rightChild;
	    }
	    if (current == null)
		return false;
	}

	if (current.leftChild == null && current.rightChild == null) {// ��ɾ���û���ӽڵ�
	    if (current == root)
		root = null;
	    else if (isLeftChild)
		parent.leftChild = null;
	    else
		parent.rightChild = null;
	} else if (current.rightChild == null) {// ��ɾ�ڵ�ֻ��һ�����ӽڵ�
	    if (current == root)
		root = current.leftChild;
	    else if (isLeftChild)
		parent.leftChild = current.leftChild;
	    else
		parent.rightChild = current.leftChild;
	} else if (current.leftChild == null) {// ��ɾ�ڵ�ֻ��һ�����ӽڵ�
	    if (current == root)
		root = current.rightChild;
	    else if (isLeftChild)
		parent.leftChild = current.rightChild;
	    else
		parent.rightChild = current.rightChild;
	} else {// ��ɾ�ڵ��������ӽڵ㣬���ҵ����ĺ�̽ڵ�successor
	    Node successor = getSuccessor(current);

	    if (current == root)
		root = successor;
	    else if (isLeftChild)
		parent.leftChild = successor;
	    else
		parent.rightChild = successor;
	    successor.leftChild = current.leftChild;
	}
	return true;
    }

    /*
     * ���ش�ɾ�ڵ�ĺ�̽ڵ�
     */
    private Node getSuccessor(Node delNode) {

	Node successorParent = delNode;
	Node successor = delNode;
	Node current = delNode.rightChild;

	while (current != null) {
	    successorParent = successor;
	    successor = current;
	    current = current.leftChild;
	}

	if (successor != delNode.rightChild) {
	    successorParent.leftChild = successor.rightChild;
	    successor.rightChild = delNode.rightChild;
	}
	return successor;
    }

    /*
     * ���������������ַ�ʽ��ǰ���������
     */
    public void traverse(int traverseType) {
	switch (traverseType) {
	case 1:
	    System.out.print("\nPreorder traversal: ");
	    preOrder(root);
	    break;
	case 2:
	    System.out.print("\nInorder traversal: ");
	    inOrder(root);
	    break;
	case 3:
	    System.out.print("\nPostorder traversal: ");
	    postOrder(root);
	    break;
	default:
	    break;
	}
    }

    /*
     * ǰ�����
     */
    private void preOrder(Node localRoot) {
	if (localRoot != null) {
	    System.out.print(localRoot.iDate + " ");
	    preOrder(localRoot.leftChild);
	    preOrder(localRoot.rightChild);
	}
    }

    /*
     * �������
     */
    private void inOrder(Node localRoot) {
	if (localRoot != null) {
	    inOrder(localRoot.leftChild);
	    System.out.print(localRoot.iDate + " ");
	    inOrder(localRoot.rightChild);
	}
    }

    /*
     * �������
     */
    private void postOrder(Node localRoot) {
	if (localRoot != null) {
	    postOrder(localRoot.leftChild);
	    postOrder(localRoot.rightChild);
	    System.out.print(localRoot.iDate + " ");
	}
    }

    public void displayTree() {
	Stack globalStack = new Stack();
	globalStack.push(root);
	int nBlanks = 32;
	boolean isRowEmpty = false;
	System.out
		.println(".......................................................................................");
	while (isRowEmpty == false) {
	    Stack localStack = new Stack();
	    isRowEmpty = true;

	    for (int j = 0; j < nBlanks; j++)
		System.out.print(" ");
	    while (globalStack.isEmpty() == false) {
		Node temp = (Node) globalStack.pop();
		if (temp != null) {
		    System.out.print(temp.iDate);
		    localStack.push(temp.leftChild);
		    localStack.push(temp.rightChild);
		    if (temp.leftChild != null || temp.rightChild != null)
			isRowEmpty = false;
		} else {
		    System.out.print("--");
		    localStack.push(null);
		    localStack.push(null);
		}
		for (int j = 0; j < nBlanks * 2 - 2; j++)
		    System.out.print(" ");
	    }
	    System.out.println();
	    nBlanks /= 2;
	    while (localStack.isEmpty() == false)
		globalStack.push(localStack.pop());
	}
	System.out
		.println(".......................................................................................");
    }

}
