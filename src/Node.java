/**************************
 * @file Node.java
 * @brief This program implements a Comparable interface within a Node class for BST
 * @author John Kaelber
 * @date September 26, 2024
 **************************/
public class Node <E extends Comparable<E>> {
    private E element;
    private Node<E> left;
    private Node<E> right;

    // Implement the constructor
    public Node(E element) {
        this.element = element;
        left = right = null;
    }
    // Implement the setElement method
    public void setElement(E element) {
        this.element = element;
    }

    // Implement the setLeft method
    public void setLeft(Node<E> left) {
        this.left = left;
    }
    // Implement the setRight method
    public void setRight(Node<E> right) {
        this.right = right;
    }

    // Implement the getLeft method
    public Node<E> getLeft() {
        return left;
    }

    // Implement the getRight method
    public Node<E> getRight() {
        return right;
    }

    // Implement the getElement method
    public E getElement() {
        return element;
    }

    // Implement the isLeaf method
    public boolean isLeaf(){
        if(left == null && right == null){
            return true;
        }
        return false;
    }
}
