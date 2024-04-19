import java.lang.Math;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class cLL {
    Node head;
    Node tail;
    int size;

    cLL() {
        size = 0;
    }

    public void insFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }
        node.next = head;
        head = node;
        tail.next = head;
        size++;

    }

    public void insLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;

    }

    public void insMid(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }
        int i = 0;
        Node currNode = head;
        Node preNode = null;

        while (i < Math.round(Math.ceil(size - 1)) && currNode != null) {
            preNode = currNode;
            currNode = preNode.next;
            i++;

        }

        if (preNode == null) {
            node.next = head;
            head = node;
            tail.next = head;
        } else {
            preNode.next = node;
            node.next = currNode;
        }
    }

    public void insAt(int data, int index){
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }
        if(head == tail){
            insLast(data);
            return;
        }
        if(index == 0){
            insFirst(data);
            return;
        }
        if(index == size){
            insLast(data);
            return;
        }
        if(index>size && index<0){
            System.out.println("Invalid Index");
            return;
        }

        int i = 0;
        Node currNode = head;
        Node preNode = null;
        while (i < index && currNode != null) {
            preNode =currNode;
            currNode = currNode.next;
            i++;
        }
        
        preNode.next = node;
        node.next = currNode;
        size++;

    }

    public void delFirst(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size--;
        }
        head = head.next;
        tail.next = head;
        size--;

    }

    public void delLast(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }
        Node preNode = null;
        Node curNode = head;
        while (curNode.next != head) {
            preNode = curNode;
            curNode = curNode.next;
        }
        tail = preNode;
        tail.next = head;

    }

    public void delMid(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }
        Node preNode = null;
        Node curNode = head;
        int i = 0;
        while (i < Math.round(Math.ceil(size/2)) && curNode != null) {
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        preNode.next = curNode.next;
        size--;
    }

    public void delAt(int index){
        if(head==null){
            System.out.println("List is Empty!");
            return;
        }
        if(head==tail){
            head = null;
            tail = null;
            size--;
            return;
        }
        if(index == 0){
            delFirst();
            return;
        }
        if(index == size){
            delLast();
            return;
        }
        if(index < 0 && index > size){
            System.out.println("Invalid Index!");
            return;
        }
        Node curNode = head;
        Node preNode = null;
        int i = 0;
        while (i < index && curNode!= null) {
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        preNode.next = curNode.next;
        size--;
    }

    public void display() {
        Node currNode = head;
        System.out.print("-> HEAD -> ");
        do {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;

        } while (currNode != head);
        System.out.println("TAIL ->");

    }

    public void find(int data){
        if(head == null)
        {
            System.out.println("List is Empty;");
            return;
        }
        Node curNode = head;
        boolean isExist = false;
        int index = 0;
        do {
            if(curNode.data == data){
                isExist = true;
                break;
            }
            index++;
            curNode = curNode.next;

        } while (curNode != head);
        if(isExist){
            System.out.println(data+" IS EXIST at index "+index);
        }else{
            System.out.println(data+" does NOT EXIST in the List!");
        }
    }

    public void sort() {
        if (head == null) {
            System.out.println("List is Empty;");
            return;
        }
        Node currNode = head;
        while (currNode.next != head) {
            Node min = currNode;
            Node inner = currNode.next;
            while (inner != head) {
                if (min.data > inner.data) {
                    min = inner;
                }
                inner = inner.next;
            }
    
            if (min != currNode) {
                int temp = currNode.data;
                currNode.data = min.data;
                min.data = temp;
            }
            currNode = currNode.next;
        }
        System.out.print("Sorted List : ");
        display();
    }
    

    public static void main(String[] args) {
        cLL cl = new cLL();
        // AtFirst
        cl.insFirst(10);
        cl.insFirst(20);
        // AtLast
        cl.insLast(44);
        cl.insLast(444);
        //AtMid
        cl.insMid(2424);
        //AtIndex
        cl.insAt(1000, 3);
        // display
        cl.display();
        //sort
        cl.sort();;
        //delete first
        cl.delFirst();
        cl.display();
        //delete last
        cl.delLast();
        cl.display();
        //delete Mid
        cl.delMid();
        cl.display();
        //delete at INdex
        cl.delAt(0);
        cl.display();
        //find
        cl.find(242);

    }
}