import java.util.Collection;

public class OwnLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int length;

    public OwnLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public OwnLinkedList(Collection<T> data){
        Node<T> prev = null;
        for(T x : data){
            Node<T> node = new Node<T>();
            node.data = x;
            if (prev != null){
                prev.next = node;
            }else{
                head = node;
            }
            prev = node;
            length++;
        }
        tail = prev;
    }
    public void insertLast(T value){
        Node<T> node = new Node<>();
        node.data = value;
        tail.next = node;
        tail = node;
        length++;
    }
    public void insertFirst(T value){
        Node<T> node = new Node<>();
        node.data = value;
        node.next = head;
        head = node;
        length++;
    }
    public void insertAt(T value, int index){
        if (index == 0){insertFirst(value);}
        else if (index == length-1) {insertLast(value);}
        else{
            Node<T> newNode = new Node<T>();
            newNode.data = value;
            Node<T> referenceNode = head;
            for(int i = 1; i<index; i++){
                referenceNode = referenceNode.next;
        }
            newNode.next = referenceNode.next;
            referenceNode.next = newNode;
            length ++;
        }
    }
    public void deleteList(){
        if (length == 0) {return;}
        head = null;
        tail = null;
        length = 0;
    }
    public void deleteFirst(){
        if (length == 0){return;}
        head = head.next;
        length--;

    }
    public void deleteLast(){
        if (length == 1 || length == 0){
            deleteList();
            return;
        }
        Node<T> node = head;
        while (node.next.next != null){
            node = node.next;
        }
        tail = node;
        tail.next = null;
        length--;
    }
    public void deleteAt(int index){
        if (index == 0){deleteFirst();}
        else if (index == length-1) {deleteLast();}
        else{
            Node<T> referenceNode = head;
            for(int i = 1; i<index; i++){
                referenceNode = referenceNode.next;
            }
            referenceNode.next = referenceNode.next.next;
            length --;
        }
    }
    public T getHeadAsValue(){
        return head.data;
    }
    public T getTailAsValue(){
        return tail.data;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        Node<T> node = head;
        while (node.next != null){
            sb.append(node.data).append(", ");
            node = node.next;
        }
        sb.append(node.data).append(" }");
        sb.append("\nLength: ").append(length);
        return sb.toString();
    }
}
