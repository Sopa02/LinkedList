import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i<=6; i++){
            nums.add(i);
        }
        OwnLinkedList<Integer> ownLinkedList = new OwnLinkedList<>(nums);
        System.out.println(ownLinkedList.toString());

        ownLinkedList.insertAt(100,1);
        ownLinkedList.insertLast(202);
        System.out.println(ownLinkedList.toString());

        ownLinkedList.deleteFirst();
        System.out.println(ownLinkedList.toString());

        ownLinkedList.deleteAt(7);
        System.out.println(ownLinkedList.toString());


        OwnLinkedList<Integer> emptyList = new OwnLinkedList<>();
        emptyList.deleteLast();
        emptyList.insertFirst(2);
        emptyList.deleteFirst();

    }
}
