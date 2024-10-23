/**************************
 * @file BST.java
 * @brief This program implements a Comparable interface within a generic Binary Search Tree class
 * @author John Kaelber
 * @date September 26, 2024
 **************************/
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST <E extends Comparable<E>> implements Iterable<E> {
    private Node<E> root;
    private int nodecount;

    // Implement the constructor
    public BST() {
        root = null;
        nodecount = 0;
    }

    // Implement the clear method
    public void clear() {
        root = null;
        nodecount = 0;
    }

    // Implement the size method
    public int size() {return nodecount;}

    // Implement the insert method
    public void insert(E element) {
        root = insertHelp(root, element);
        nodecount++;
    }
    //help functions recursive for finding, inserting, and removing nodes in desired locations
    private Node<E> insertHelp(Node<E> rt, E key) {//modeled from in class slides
        if (rt == null) {return new Node<>(key);}
        if (key.compareTo(rt.getElement()) < 0) {rt.setLeft(insertHelp(rt.getLeft(), key));}
        else {rt.setRight(insertHelp(rt.getRight(), key));}
        return rt;
    }

    // Implement the remove method
    public E remove(E key) {
        E temp = findHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key);
            nodecount--;
        }
        return temp;
    }

    private Node<E> removeHelp(Node<E> rt, E key) {//modeled from in class slides
        if (rt == null) {return null;}
        if (key.compareTo(rt.getElement()) < 0) {rt.setLeft(removeHelp(rt.getLeft(), key));}
        else if (key.compareTo(rt.getElement()) > 0) {rt.setRight(removeHelp(rt.getRight(), key));}
        else {//found it, remove it
            if (rt.getLeft() == null) {
                return rt.getRight();
            } else if (rt.getRight() == null) {
                return rt.getLeft();
            } else {//two children
                Node<E> temp = getMax(rt.getLeft());
                rt.setElement(temp.getElement());
                rt.setLeft(deleteMax(rt.getLeft()));
            }
        }
        return rt;
    }

    //getMax method
    private Node<E> getMax(Node<E> rt) {
        while (rt.getRight() != null) {
            rt = rt.getRight();
        }
        return rt;
    }
    //deleteMax method
    private Node<E> deleteMax(Node<E> rt) {//going along the tree, if no right node (i.e. ==null) then get the left then we are recursively calling this until it gets to the max
        if (rt == null) {return null;} //preventing infinite recursion
        if (rt.getRight() == null) {
            return rt.getLeft();
        }
        rt.setRight(deleteMax(rt.getRight()));
        return rt;
    }

    // Implement the search method
    public E find (E key){return findHelp(root, key);}

    private E findHelp (Node <E> rt, E key){
        if (rt == null) {return null;}
        if (rt.getElement().compareTo(key) > 0) {return findHelp(rt.getLeft(), key);}
        else if (rt.getElement().compareTo(key) == 0) {return rt.getElement();}
        else {return findHelp(rt.getRight(), key);}
    }

    // Implement the iterator method - changing this to inorder (reread proj 1 part 1 needed ascending order so inorder traversal makes more sense)
    public Iterator<E> iterator() {
        return new BSTIterator();
    }
    // Implement the BSTIterator class
    private class BSTIterator implements Iterator<E> {
        private Stack<Node<E>> stack;
        BSTIterator() {
            stack = new Stack<>();
            pushLeft(root); //goes to the farthest left node by calling the pushLeft method
        }
        //pushLeft method for getting all left nodes and pushing into the stack
        public void pushLeft(Node<E> rt) {
            while(rt != null) {
                stack.push(rt);
                rt = rt.getLeft();
            }
        }
        @Override
        public boolean hasNext() {//seeing if stack is empty or has nodes
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {//error checking if there is a next node otherwise throw the exception
                throw new NoSuchElementException();
            }

            Node<E> mynode = stack.pop(); //pop current node from stack, then push the children if there are any
            pushLeft(mynode.getRight()); //now we get the right nodes and push them onto the stack
            return mynode.getElement();
        }
    }
}

