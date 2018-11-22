import java.util.HashSet;

public class LinkedLists {
    static class Node {
        Node next = null;
        int data;
        Node (int d) {
            this.data = d;
        }
        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while(n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
    Node deleteNode(Node head, int d) {
        Node n = head;
        if(n.data == d){
            return n.next;
        }
        while(n.next != null) {
            n = n.next;
            if(n.data == d){
                n.next = n.next.next;
                return head;
            }
        }
        return head;
    }
    Node deleteDuplicates(Node head) {
        Node n = head;
        HashSet<Integer> linkedListValues = new HashSet<Integer>();
        while(n != null && n.next != null) {
            n = n.next;
            if(linkedListValues.contains(n.data)) {
                n.next = n.next.next;
            }
            else {
                linkedListValues.add(n.data);
            }
        }
        return head;
    }
    Node deleteDuplicatesNoBuffer(Node head){
        Node n = head;
        Node temp = null;
        while (n.next != null){
            temp = n;
            while (temp != null && temp.next != null) {
             if(temp.next.data == n.data) {
                 temp.next = temp.next.next;
             }
             temp = temp.next;
            }
            n = n.next;
        }
        return head;
    }
    Node Nth2LastElement(Node node, int N) {
        int len = 0;
        Node n = node;
        while (n != null) {
            len++;
            n = n.next;
        }
        if(N > len) {
            return null;
        }
        int req = len - N + 1;
        int temp = 1;
        n = node;
        while(temp < req){
            n = n.next;
        }
        return n;
    }

    static Node SumLinkedLists(Node num1, Node num2) {
        Node sumNode = null;
        Node finalSumNode = null;
        int sum=0;
        int val =0;
        int carry =0;
        if(num1 == null) {
            return num2;
        }
        if(num2 == null){
            return num1;
        }
        while(num1 != null && num2 != null) {
            sum = num1.data + num2.data + carry;
            val = sum % 10;
            carry = sum /10;
            Node node = new Node(val);
            if(sumNode != null) {
                sumNode.next = node;
                sumNode = node;
            }
            else {
                sumNode = node;
                finalSumNode = sumNode;
            }
            num1 = num1.next;
            num2 = num2.next;
        }
        if(num1 == null){
            if(carry == 0){
                sumNode.next = num2;
            }
            else {
                while (carry != 0 && num2 != null) {
                    sum = carry + num2.data;
                    val = sum % 10;
                    carry = sum / 10;
                    Node node = new Node(val);
                    sumNode.next = node;
                    sumNode = node;
                    num2 = num2.next;
                }
                sumNode.next = num2;
            }
        }
        else {
            if(carry ==0) {
                sumNode.next = num1;
            }
            else {
                while (carry !=0 && num1 != null) {
                    sum = carry + num1.data;
                    val = val % 10;
                    carry = carry /10;
                    Node node = new Node(val);
                    sumNode.next = node;
                    sumNode = node;
                    num1 = num1.next;
                }
                sumNode.next = num1;
            }
        }
        return finalSumNode;
    }

    static Node findStartLoop(Node node1) {
        Node ptr1 = node1;
        Node ptr2 = node1;
        if (node1 == null) {
            return null;
        }
        while (ptr1 != null && ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if (ptr1 == ptr2) {
                break;
            }
        }
        if (ptr1 == null) {
            return null;
        }
        int len = 1;
        ptr2 = ptr2.next;
        while (ptr1 != ptr2) {
            ptr2 = ptr2.next;
            len++;
        }
        for (int i = 0; i < len; i++) {
            ptr2 = ptr2.next;
        }
        ptr1 =node1;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {

        Node node1 = new Node(9);
        Node node2 = new Node(9);
        Node node3 = new Node(9);

        node1.next = node2;
        node2.next = node3;

        Node NODE1 = new Node(2);
        Node NODE2 = new Node(6);
        Node NODE3 = new Node(5);
        Node NODE4 = new Node(4);

        NODE1.next = NODE2;
        NODE2.next = NODE3;
        NODE3.next = NODE4;
        NODE4.next = NODE2;

//        Node SUM = SumLinkedLists(node1, NODE1);
//        while (SUM != null){
//            System.out.println(SUM.data);
//            SUM = SUM.next;
//        }
        System.out.println(findStartLoop(NODE1).data);
    }
}
