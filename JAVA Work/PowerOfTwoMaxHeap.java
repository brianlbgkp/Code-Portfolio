/**
 * This file contains an implementation of a Power of Two Max Heap. It is currently implemented with
 * the assumption that integer values are all that are being added but this can easily be changed so
 * to accept any comparable data (numbers, strings, comparable Objects, etc...) with modifications
 * to the Array List and extending the Comparable interface. The Node class implemented has a variety
 * of getters and setters. The methods implemented for the heap include an insert method and a pop max
 * method. The helper methods heapsort, createNodes, sink, swim, swap, and printTree are used to heapify
 * the array list of values, manipulate the array list, turn the data into nodes and set the parent - children relationships.
 *
 * PowerOfTwoMaxHeap.java - Brian Salinas - 01/26/2023
 * ~For the Forage Virtual Internship - Walmart USA Advanced Software Engineering Virtual Experience Program~
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PowerOfTwoMaxHeap {
    /**
     * Uses a Hash Map to keep track of the children a node has. The amount of leaves is a variable.
     */
    HashMap<Integer, Node> nodeMap = new HashMap<>();

    private int nodeCount = 0;

    /**
     * The largest value of the tree
     */
    private Node root = null;

    private class Node {
        int data;

        /**
         * Keeps track of the children connected to the node in an array list
         */
        List<Node> children = new ArrayList<>();

        Node parent = null;

        public Node(int elem) {
            this.data = elem;
        }

        /**
        * A variety of methods to add a child for a node
        */
        public void addChild(Node child) {
            child.setParent(this);
            this.children.add(child);
        }

        public Node addChild(int data) {
            Node newChild = new Node(data);
            newChild.setParent(this);
            this.children.add(newChild);
            return newChild;
        }

        public void addChildren(List<Node> children) {
            for (Node t : children) {
                t.setParent(this);
            }
            this.children.addAll(children);
        }

        public List<Node> getChildren() {
            return this.children;
        }

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        private void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return this.parent;
        }

        @Override
        public String toString() {
            return "Data = [" + this.data + "]";
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return nodeCount;
        }

    }

    /**
     * This method creates the Power of Two Max Heap Tree out of an Array List.
     * It keeps track of all the parent - children connections using a hash map.
     */
    private void createNodes(List heapArray, int powerOfTwoChildren, int length){
        Node parentNode, childNode;
        nodeMap.clear();
        nodeCount = 0;

        childNode = new Node((Integer) heapArray.get(0));
        root = nodeMap.get(0);
        nodeMap.put(nodeCount, childNode);
        nodeCount++;

        for (int i = 0; i < (length - ((length - 1)%powerOfTwoChildren)); i++){
            for (int j = 1; j <= powerOfTwoChildren && (powerOfTwoChildren*i)+j < length; j++){
                if ((powerOfTwoChildren*i)+j == length){
                    break;
                }
                parentNode = nodeMap.get(i);
                childNode = parentNode.addChild((Integer) heapArray.get((powerOfTwoChildren*i)+j));

                nodeMap.put(nodeCount, childNode);
                nodeCount++;
            }
        }
    }

    private void printTree() {
        for (Node node : nodeMap.values()) {
            if (node.getParent() == null) {
                System.out.print("Root node: ");
            }
            System.out.println(node.getData() + "; children=" + node.getChildren());
        }
    }

    /**
     * Heapify that builds a heap with the number of children specified
     * First it arranges the array in the correct order for the heap and then it creates the node connections using createNodes()
     */
    private void heapsort(List array, int powerOfTwoChildren){
        if (array.isEmpty()) return;
        int length = array.size();
        powerOfTwoChildren = powerOfTwoChildren * powerOfTwoChildren;

        //heapify
        for (int i = ((length - 1) / powerOfTwoChildren); i >= 0; i--){
            sink(array, length, i, powerOfTwoChildren);
        }

        createNodes(array, powerOfTwoChildren, length);
    }

    private static void sink(List array, int length, int index, int powerOfTwoChildren){
        int[] child = new int[powerOfTwoChildren+1];

        while (true){
            for (int i = 1; i <= powerOfTwoChildren; i++){
                if ((powerOfTwoChildren*index + i) < length){
                    child[i] = (powerOfTwoChildren*index + i);
                } else {
                    child[i] = -1;
                }
            }

            int maxChild = -1;
            int maxChildIndex = 0;

            if (child[1] != -1 && maxChild != (Integer)array.get(child[1])){
                maxChild = (Integer)array.get(child[1]);
                maxChildIndex = child[1];
            }

            for (int i = 1; i <= powerOfTwoChildren; i++){
                if (child[i] != -1 && (Integer)array.get(child[i]) > maxChild){
                    maxChildIndex = child[i];
                    maxChild = (Integer)array.get(child[i]);
                }
            }

            if (maxChild == -1){
                break;
            }

            if ((Integer)array.get(index) < (Integer)array.get(maxChildIndex)){
                swap(array, index, maxChildIndex);
            }

            index = maxChildIndex;

        }

    }

    private static void swim(List array, int index, int powerOfTwoChildren){
        int parent = (index - 1)/ powerOfTwoChildren;

        while (parent >= 0){
            if ((Integer)array.get(index) > (Integer)array.get(parent)){
                swap(array, index, parent);
                index = parent;
                parent = (index - 1) / powerOfTwoChildren;
            } else {
                break;
            }
        }
    }

    private static void swap(List array, int i, int j){
        int temp = (Integer)array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /**
     * Insert method for adding an element into the heap.
     * Inserts at the end of the array list and uses swim to move the element into the correct position.
     */
    private void insert(List array, int powerOfTwoChildren, int newElement){
        array.add(newElement);

        swim(array, array.size() - 1, powerOfTwoChildren);

        heapsort(array, powerOfTwoChildren);

    }

    /**
     * Pop Max method that removes the root node and redoes the connections
     */
    private int popMax(List array, int powerOfTwoChildren){
        int max = nodeMap.get(0).data;

        array.remove(0);
        sink(array, array.size(), 0, powerOfTwoChildren);
        heapsort(array, powerOfTwoChildren);

        return max;

    }

    /**
     * Testing the creation of the Max Heap Tree and the insert and popMax methods
     */
    public static void main(String[] args) {
        PowerOfTwoMaxHeap sorter = new PowerOfTwoMaxHeap();

        //List<Integer> array = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24));

        List<Integer> array = new ArrayList<>();

        for (int i = -100; i < 100; i++){
            array.add(i);
        }

        /**
         * This int is the number that will be raised to the power of two.
         */
        int powerOfTwoChildren = 2;

        int maxValue;
        int insertElement;

        System.out.println("Initial Heapify");
        sorter.heapsort(array, powerOfTwoChildren);
        //sorter.printTree();

        insertElement = 3;
        System.out.println("Heap Insert");
        sorter.insert(array, powerOfTwoChildren, insertElement);
        System.out.println("Element that was inserted: " + insertElement);
        //sorter.printTree();

        System.out.println("Heap Pop Max");
        maxValue = sorter.popMax(array, powerOfTwoChildren);
        System.out.println("Popped Max Value: " + maxValue);
        //sorter.printTree();

        insertElement = 55;
        System.out.println("Heap Insert");
        sorter.insert(array, powerOfTwoChildren, insertElement);
        System.out.println("Element that was inserted: " + insertElement);
        sorter.printTree();

        System.out.println("Heap Pop Max");
        maxValue = sorter.popMax(array, powerOfTwoChildren);
        System.out.println("Popped Max Value: " + maxValue);
        //sorter.printTree();
    }
}