package treedemo;

class Node {

    public int iDate;
    public double dDate;
    public Node leftChild;
    public Node rightChild;

    public Node(int iDate, double dDate) {
	super();
	this.iDate = iDate;
	this.dDate = dDate;
    }

    public void displayNode() {
	System.out.println("{ " + iDate + " , " + dDate + " }");
    }
}
