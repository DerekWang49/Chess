public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 2
	public void addElement(int index, double value) {

		if (index < length) {
			Node ptr = head;
			if (ptr == null) {
				head = new Node(index, value);
				return;
			}
			while (ptr.getNext() != null) {

				ptr = ptr.getNext();
			}
			ptr.setNext(new Node(index, value));
//			Node new_node = new Node(ptr.getIndex(), ptr.getValue());//Do this
//			ptr.setNext(new_node);
		}
//			Node ptr = head.getNext();
//			Node trailer = head;
//			while (ptr != null) {
//				trailer = ptr;
//				ptr = ptr.getNext();
//			}
//			trailer.setNext(new Node(index, value));
//		}
//		else {
//			System.out.println("Index out of range");
//		}



	}

	// TODO: Implement me for milestone 4
	public static double dot( SparseVector x, SparseVector y ){
		double result = 0;
		Node ptrx = x.head;
		Node ptry = y.head;
		if (x.length == y.length) {
			while (ptrx != null && ptry != null) {
				if (ptrx.getIndex() == ptry.getIndex()) {
					result += ptrx.getValue() * ptry.getValue();
					ptrx = ptrx.getNext();
					ptry = ptry.getNext();
				}
				else if (ptrx.getIndex() < ptry.getIndex()) {
					ptrx = ptrx.getNext();
				}
				else if (ptrx.getIndex() > ptry.getIndex()) {
					ptry = ptry.getNext();
				}
//
//				if (ptrx.getNext() == null) {
//					ptry = ptry.getNext();
//				}
//				if (ptry.getNext() == null) {
//					ptrx = ptrx.getNext();
//				}

			}
			return result;
//				while (ptrx != null && ptry != null) {
//					result += ptrx.getValue() * ptry.getValue();
//				}
//				if (ptrx.getNext() != null && ptry.getNext() != null) {
//					ptrx = ptrx.getNext();
//					ptry = ptry.getNext();
//				}
//
//

		}

		return result;
	}


	// TODO: Test out your code here!
	public static void main(String[] args) {
//		SparseVector vec = new SparseVector(9);
//		vec.addElement(1, 25.0);
//		vec.addElement(7, -11.2);
//		vec.addElement(8, 32.0);
//		System.out.println(vec);
//		SparseVector x = new SparseVector(5);
//		x.addElement(0, 0);
//		x.addElement(1, 1);
//		SparseVector y = new SparseVector(5);
//		y.addElement(0, 1);
//		y.addElement(3, 67);
//		double result = dot(x, y);
//		System.out.println(result);
		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println(result);
	}
}


