public class CustomLinkedList{
    public static void main(String[] args){
        testLinkedList();
    }

    private static void testLinkedList(){
        CstLinkedList linkedList = new CstLinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.display();
        linkedList.addLast(30);
        linkedList.addFirst(9);
        linkedList.display();
        linkedList.addFirst(7);
        linkedList.addLast(40);
        linkedList.display();
        
        System.out.println(linkedList.size());
        
        System.out.println(linkedList.removeFirst());
        linkedList.addAt(40, 2);
        linkedList.display();
        System.out.println(linkedList.removeAt(3));
        System.out.println(linkedList.getAt(3));
        linkedList.addLast(90);
        linkedList.addLast(85);
        linkedList.addLast(40);
        linkedList.addLast(70);
        linkedList.addLast(60);
        linkedList.display();
        System.out.println(linkedList.size());
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeAt(3);
        linkedList.display();
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.display();
    }
}

class CstLinkedList{
    private class Node{
        private int data;
        private Node next;

        public Node(){
            this.data = 0;
            this.next = null;
        }

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node nextNode){
            this.data = data;
            this.next = nextNode;
        }

        public int getData() {
            return data;
        }

        public Node getNextNode() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CstLinkedList(){
        this.head = this.tail = null;
        this.size = 0;
    }

    public int getFirst(){
        if(this.size == 0){
            System.out.println("Exception: Empty List");
            return -1;
        }
        
        return this.head.data;
    }

    public int getLast(){
        if(this.size == 0){
            System.out.println("Exception: Empty List");
            return -1;
        }
        
        return this.tail.data;
    }

    public int getAt(int index){
        if(index < 0 || index >= this.size){
            System.out.println("Exception: IndexOutOfBound");
            return -1;
        }
        return getNodeAt(index).data;
    }

    public void addFirst(int data){
        if(this.size == 0){
            handleAddForEmptyList(data);
        }else{
            Node nn = new Node(data);
            nn.next = this.head;
            this.head = nn;

            this.size++;
        }
    }

    public void addLast(int data){
        if(this.size == 0){
            handleAddForEmptyList(data);
        }else{
            Node nn = new Node(data);
            this.tail.next = nn;
            this.tail = nn;

            this.size++;
        }
    }

    public void addAt(int data, int index){
        if(index < 0 || index > this.size){
            System.out.println("Exception: IndexOutOfBound, can not add at " + index);
        }else if(index==0){
            addFirst(data);
        }else if(index == this.size){
            addLast(data);
        }else{
            Node prevnode = getNodeAt(index-1); 
            Node nn = new Node(data);

            nn.next = prevnode.next;
            prevnode.next = nn;

            this.size++;
        }
    }

    private Node getNodeAt(int index){
        Node nn = this.head;

        while(index > 0){
            nn = nn.next;
            index--;
        }

        return nn;
    }

    private void handleAddForEmptyList(int data){
        Node nn = new Node(data);
        this.head = this.tail = nn;

        this.size++;
    }

    public int removeFirst(){
        if(this.size == 0){
            System.out.println("Exception: Empty List");
            return -1;
        }else if(this.size == 1){
            return handleRemoveForSize1();
        }else{
            int val = this.head.data;
            this.head = this.head.next;

            this.size--;

            return val;
        }
    }

    public int removeLast(){
        if(this.size == 0){
            System.out.println("Exception: Empty List");
            return -1;
        }else if(this.size == 1){
            return handleRemoveForSize1();
        }else{
            int val = this.tail.data;
            
            this.tail = getNodeAt(this.size - 2);
            this.tail.next = null;

            this.size--;

            return val;
        }
    }

    public int removeAt(int index){
        if(index < 0 || index >= this.size){
            System.out.println("Exception: IndexOutOfBound");
            return -1;
        }else if(index == 0){
            return removeFirst();
        }else if(index == this.size-1){
            return removeLast();
        }else{
            Node prevNode = getNodeAt(index-1);
    
            int val = prevNode.next.data;

            prevNode.next = prevNode.next.next;
            
            this.size--;
            return val;
        }
    }

    private int handleRemoveForSize1(){
        int val = this.head.data;
        this.head = this.tail = null;

        this.size = 0;

        return val;
    }

    public void display(){
        Node nn = this.head;
        while(nn != null){
            System.out.print(nn.data + "->");

            nn = nn.next;
        }
        System.out.println(null+"");
    }

    public int size(){
        return this.size;
    }
}