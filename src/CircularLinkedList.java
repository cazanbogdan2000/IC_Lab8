/**
 * <h1>Circular Linked List!</h1>
 * Class that creates a circular linked list data
 * structure, where we can find methods such as adding
 * in the list, removing node from list and also check
 * if an element already exists in the list.
 * <p>
 * <b>Note:</b> Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author  Anica Nebunu
 * @version 1.0
 * @since   2014-03-31
 */

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Function that add a node
     * @param value : the value to be added
     * */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /***
     * Function that checks if element is in list
     * @param searchValue: value to be searched
     * @return : True if element is found
     *           False otherwise
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Function that deletes an element
     * @param valueToDelete : value to be deleted
     * */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Function that gets the next node of a current node
     * @param currentNode : the current node used
     * @return the next node
     * */
    public Node getNode(Node currentNode) {
        return currentNode.nextNode;
    }

}