package treedemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub

	int value;
	Tree theTree = new Tree();

	theTree.insert(50, 1.5);
	theTree.insert(25, 1.2);
	theTree.insert(75, 1.7);
	theTree.insert(12, 1.5);
	theTree.insert(37, 1.2);
	theTree.insert(43, 1.7);
	theTree.insert(30, 1.5);
	theTree.insert(33, 1.2);
	theTree.insert(87, 1.7);
	theTree.insert(93, 1.5);
	theTree.insert(97, 1.5);

	while (true) {
	    System.out.print("Enter first letter of show: ");
	    System.out.print("show, insert, find, delete, or traverse: ");
	    char choice = getChar();
	    switch (choice) {
	    case 's':
		theTree.displayTree();
		System.out.println();
		break;
	    case 'i':
		System.out.print("Enter value to insert: ");
		value = getInt();
		theTree.insert(value, value + 0.9);
		break;
	    case 'f':
		System.out.print("Enter value to found: ");
		value = getInt();
		Node found = theTree.find(value);
		if (found != null) {
		    System.out.print("Found: ");
		    found.displayNode();
		    System.out.print("\n");
		} else {
		    System.out.println("Could not found " + value);
		}
		break;
	    case 'd':
		System.out.print("Enter value to delete: ");
		value = getInt();
		boolean didDelete = theTree.delete(value);
		if (didDelete) {
		    System.out.print("Deleted " + value + "\n");
		} else {
		    System.out.println("Could not delete " + value);
		}
		break;
	    case 't':
		System.out.print("Enter type 1 ,2 or 3: ");
		value = getInt();
		theTree.traverse(value);
		System.out.println();
		break;
	    default:
		System.out.print("Invalid entry\n");
	    }
	}
    }

    public static String getString() throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = br.readLine();
	return s;
    }

    private static char getChar() throws IOException {
	// TODO Auto-generated method stub
	String s = getString();
	return s.charAt(0);
    }

    private static int getInt() throws IOException {
	// TODO Auto-generated method stub
	String s = getString();
	return Integer.parseInt(s);
    }

}
