import java.util.ArrayList;
import java.util.Stack;

public class Stacks {
    public class StackWithMin extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value,min());
            super.push(new NodeWithMin(value,newMin));
        }
        public int min() {
            if(this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }
    }
    class NodeWithMin {
        int value;
        int min;
        NodeWithMin(int v, int m) {
            value = v;
            min = m;
        }
    }

    public class StackWithMin2 extends Stack<Integer> {
        Stack<Integer> s2;
        public StackWithMin2() {
            s2 = new Stack<Integer>();
        }
        void push(int value) {
            if(value <= min()){
                s2.push(value);
            }
            super.push(value);
        }
        public Integer pop() {
            int value = super.pop();
            if(value == min()){
                s2.pop();
            }
            return value;
        }
        public int min() {
            if(s2.isEmpty()){
                return Integer.MAX_VALUE;
            }
            else {
                return s2.peek();
            }
        }
    }

    public class SetOfStacks {
        ArrayList<Stack> stacks = new ArrayList<Stack>();
        int capacity;
        public void push(int value) {
            Stack<Integer> lastStack = getLastStack();
            if(lastStack != null ) {
                lastStack.push(value);
            }
            else {

                Stack<Integer> newStack = new Stack<Integer>();
                newStack.push(value);
                stacks.add(newStack);
            }
        }

        public Integer pop(){
            Stack<Integer> lastStack = getLastStack();
            Integer v= lastStack.pop();
            if(lastStack.size() == 0) {
                stacks.remove(stacks.size() - 1);
            }
            return v;
        }

        Stack<Integer> getLastStack() {
            if(stacks.size() == 0){
                return null;
            }
            return stacks.get(stacks.size()-1);
        }
    }

    public static class Tower {
        private int index;
        private Stack<Integer> disks;
        public Tower(int i){
            index = i;
            disks = new Stack<Integer>();
        }
        public int getIndex() {
            return index;
        }
        public void addToTower(int d) {
            if(!disks.isEmpty() && disks.peek() <=d) {
                System.out.println("error adding to the tower");
            }
            else {
                disks.push(d);
            }
        }
        public void moveTopTopTo(Tower t) {
            int top = disks.pop();
            t.addToTower(top);
            System.out.println("Moving"+top+"from the tower"+getIndex()+"to the tower"+t.getIndex());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if(n > 0) {

                moveDisks(n-1,buffer,destination);
                moveTopTopTo(destination);
                buffer.moveDisks(n-1,destination,this);

            }
        }
        public void printTower(){
            Stack<Integer> temp = new Stack<Integer>();
            while(!disks.isEmpty()) {
                int val = disks.pop();
                System.out.println(val);
                temp.push(val);
            }
            while (!temp.isEmpty()) {
                disks.push(temp.pop());
            }
        }
    }

    public static void main(String[] args) {
//        ArrayList<Tower> towers = new ArrayList<Tower>();
//        int n=30;
//        for(int i=0;i<3;i++){
//            Tower tower = new Tower(i);
//            towers.add(tower);
//        }
//        for(int i=n-1;i>=0;i--){
//            towers.get(0).addToTower(i);
//        }
//       // towers.get(0).moveDisks(n,towers.get(2),towers.get(1));
//       // towers.get(2).printTower();
        Stack<Integer> randomStack = new Stack<Integer>();
        randomStack.push(45);
        randomStack.push(2);
        randomStack.push(-1);
        randomStack.push(200);
        randomStack.push(4);
        randomStack.push(14);
        Stack<Integer> sortedStack = sort(randomStack);
        while (!sortedStack.isEmpty()){
            System.out.println(sortedStack.pop());
        }
    }

    public class MyQueue<T> {
        Stack<T> s1, s2;

        public MyQueue() {
            s1 = new Stack<T>();
            s2 = new Stack<T>();
        }

        public void queue(T v) {
            s1.push(v);
        }

        public T peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        public T dequeue() {
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                return s1.pop();
            }
        }
    }
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if(sortedStack.isEmpty()) {
                sortedStack.push(val);
            }
            else {
                if(val <= sortedStack.peek()) {
                    sortedStack.push(val);
                }
                else {
                    while (!sortedStack.isEmpty() && sortedStack.peek() < val) {
                        stack.push(sortedStack.pop());
                    }
                    sortedStack.push(val);
                }
            }
        }
        return sortedStack;
    }
}
