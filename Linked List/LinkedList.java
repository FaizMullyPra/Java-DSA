import java.util.*;
public class LinkedList{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;

        }
         int val=head.data;
            head=head.next;
            size--;
            return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;

        }
        Node prev=head;
        for(int i=0;i<size-2;i++)
             prev=prev.next;
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    void printLL(){
        if(head==null){
            System.out.print("LL is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
            System.out.println();

    }
    void addAtMiddle(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            i++;
           temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }
    void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;

    }
    void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    int itrSearch(int key){
         Node temp=head;
         int i=0;
         while(temp!=null){
            if(temp.data==key)
                return i;
            temp=temp.next;
            i++;
         }
         return -1;
    }
    int recSearch(int key){
        return helper(head,key);
    }
    int helper(Node head,int key){
        if(head==null)return -1;
        if(head.data==key)return 0;
        int idx=helper(head.next,key);
        if(idx==-1) return-1;
        return idx+1;
    }
    public static Node head,tail;
    public static int size=0;
    public static void main(String args[]){
        LinkedList l1=new LinkedList();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.printLL();
        l1.addAtMiddle(4,5);
        l1.printLL();
        // System.out.println(l1.size);
        // System.out.println(l1.removeFirst());
        // System.out.println(l1.size);
        // l1.printLL();
        
        //  System.out.println(l1.removeLast());
        // System.out.println(l1.size);
        // l1.printLL();
        System.out.println("key is found at index : "+l1.itrSearch(4));
        System.out.println("key is found at index : "+l1.recSearch(4));

    }
}