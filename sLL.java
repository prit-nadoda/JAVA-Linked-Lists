import java.lang.Math;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class sLL {
    Node head;
    Node tail;
    int size;

    sLL() {
        size = 0;
    }

    public void insFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    public void insLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insMid(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        Node currNode = head;
        Node preNode = null;
        int i = 0;
        while (i != Math.round(Math.floor(size / 2)) && currNode != null) {
            preNode = currNode;
            currNode = currNode.next;
            i++;

        }
        if (preNode == null) {
            node.next = head;
            head = node;
        } else {
            node.next = currNode;
            preNode.next = node;
            size++;
        }
    }

    public void insAt(int data, int index) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        if (index == 0) {
            insFirst(data);
            return;
        }
        if (index == size - 1) {
            insLast(data);
            return;
        }
        if(index > size && index < 0){
            System.out.println("Invalid Index!");
        }
        Node preNode = null;
        Node currNode = head;
        int i = 0;
        while (i < index && currNode != null) {
            preNode = currNode;
            currNode= currNode.next;
            i++;
        }
        preNode.next = node;
        node.next = currNode;
        size++;
    }

    public void delFirst() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        head = head.next;
        size--;

    }

    public void delLast() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node currNode = head;
        while (currNode.next != tail) {
            currNode = currNode.next;
        }
        currNode.next = null;
        tail = currNode;
        size--;
    }

    public void delMid() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
        }
        Node preNode = null;
        Node currNode = head;
        int i = 0;
        while (i < Math.round(Math.ceil(size / 2)) && currNode != null) {
            preNode = currNode;
            currNode = currNode.next;
            i++;
        }
        preNode.next = currNode.next;
        size--;
    }

    public void delAt(int index) {
        if (index > size) {
            System.out.println("GIVEN INDEX OUT OF SIZE!!");
        }
        if (head == null) {
            System.out.println("List is Empty!");
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
        }
        if (index == 0) {
            delFirst();
            return;
        }
        if (index == size - 1) {
            delLast();
            return;
        }
        Node currNode = head;
        Node preNode = null;
        int i = 0;
        while (i != index && currNode != null) {
            preNode = currNode;
            currNode = currNode.next;
            i++;
        }
        preNode.next = currNode.next;
        size--;
    }

    public void display() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void find(int data){
        Node currNode = head;
        boolean isExist = false;
        int i = 0;
        while (currNode != null) {
            if(currNode.data == data){
                isExist = true;
                break;               
            }
            currNode = currNode.next;
            i++;
        }
        if(isExist){
            System.out.println(data +" EXISTS at index "+i);
        }else{
            System.out.println(data +" does NOT EXIST");
        }
    }

    public void sort() {
        if (head == null) {
            System.out.println("List Is Empty!");
            return;
        }
    
        Node currNode = head;
        while (currNode != null) {
            Node min = currNode;
            Node inner = currNode.next;
            while (inner != null) {
                if (inner.data < min.data) {
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
    
        System.out.print("Sorted List:");
        display(); 
    }
    

    public static void main(String[] args) {
        sLL sl = new sLL();

        // AddAtFirst
        sl.insFirst(101);
        sl.insFirst(20);
        sl.insFirst(30);
        // AddAtLAst
        sl.insLast(40);
        sl.insLast(100);
        // AddAtMid
        sl.insMid(444);
        // AddAt Index
        sl.insAt(111, 1);
        // display
        sl.display();
        // delete first
        sl.delFirst();
        sl.display();
        // delete Last
        sl.delLast();
        sl.display();
        // delete middle
        sl.delMid();
        sl.display();
        // delete At Index
        sl.delAt(0);
        sl.display();
        //search
        sl.find(101);
        //sort
        sl.sort();
        

    }

}