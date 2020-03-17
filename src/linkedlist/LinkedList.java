
package linkedlist;

import java.util.Scanner;

public class LinkedList {
    Node head =null;//Head Of The List
    Node tail = null;
    //The Node Class
    public class Node{
        int data;
        Node next;
        
        Node(int d){data = d;next=null;}//New Node
    }
    public static LinkedList llist =new LinkedList();
    //The Main Method
    public static void main(String[] args) {
        llist.PushFront(1);
        llist.PushBack(6);
        llist.PushBack(2);
        llist.PushBack(3);
        llist.PushBack(10);
        llist.AddAfter(6, 15);
        llist.AddBefore(6, 55);
        System.out.println("Your List Now Is: \n");
        llist.Print();
        llist.ask();

    }
    //Ask User
    public void ask(){
        int x , k;
        String z;
        Scanner ss =new Scanner(System.in);
        System.out.println("choose number for operation: \n"
                + "1 for add number in front of the list \n"
                + "2 for add number in last of the list \n"
                + "3 for add number before number \n"
                + "4 for add number after number \n"
                + "5 for return front number \n"
                + "6 for return last number \n"
                + "7 for remove front number \n"
                + "8 for remove last number \n"
                + "9 for remove number from the list \n"
                + "10 for search for number in the list \n"
                + "11 for Check list is Empty or Not \n"
                + "12 for print the list\n");
        k = ss.nextInt();
        switch(k)
        {
            case 1:
                System.out.println("Enter The Number In The Front: ");
                x = ss.nextInt();
                PushFront(x);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 2:
                System.out.println("Enter The Number In The Last: ");
                x = ss.nextInt();
                PushBack(x);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 3:
                System.out.println("Enter The Number In The Before The Number You want to add: ");
                x = ss.nextInt();
                System.out.println("Enter The Number You want to add: ");
                int y = ss.nextInt();
                AddBefore(x,y);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 4:
                System.out.println("Enter The Number In The After The Number You want to add: ");
                x = ss.nextInt();
                System.out.println("Enter The Number You Need To Add: ");
                y = ss.nextInt();
                AddAfter(x,y);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 5:
                System.out.println("The Front Number Is:  "+ llist.head.data);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 6:
                System.out.println("The Last Number Is:  " + llist.tail.data);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 7:
                System.out.println("The Front Number Now Removed!");
                PopFront();
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 8:
                System.out.println("The Last Number Now Removed!");
                PopBack();
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 9:
                System.out.println("Enter The Number You Need To Remover: \n");
                x =ss.nextInt();
                Erase(x);
                System.out.println("You Item Now Remover! \n"+"Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 10:
                System.out.println("Enter The Number You Need To Search For It: \n");
                x =ss.nextInt();
                Boolean_Find_key(x);
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 11:
                Boolean_empty();
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                break;
            case 12:
                Print();
                System.out.println("Do You Need Any Operation ");
                z = ss.next();
                if("y".equals(z)||"Y".equals(z)||"yes".equals(z)||"YES".equals(z))
                    ask();
                
                
        }
                
    }
    //Add To Front
    public void PushFront(int key){
        Node new_node =new Node(key);
        new_node.next=head;
        head=new_node;
    }
    //Remove Front Item
    public void PopFront(){
        if (head == null){
            System.out.println("The LinkedList Is Empty ");
            return;}
        head = head.next;
    }
    //Add To Back
    public void PushBack(int key){
        Node new_node =new Node(key);
        if(head == null)
        {
            head = new Node(key);
            return;
        }
        new_node.next=null;
        tail = head;
        while(tail.next!=null)
            tail = tail.next;
        tail.next=new_node;
        tail=new_node;
    }
    //Remove Last Item
    public void PopBack(){
        if (head == null){
            System.out.println("The LinkedList Is Empty ");
            return ;}
        if (head == tail){
            head = tail;
            head = null;
        }
        Node Second_Last =head;
        while(Second_Last.next.next!=null)
            Second_Last = Second_Last.next;
        Second_Last.next=null;
        tail= Second_Last;
        
       
    }
    //Search In LinkedList
    public void Boolean_Find_key(int key){
        if(head==null)
            return;
        Node k = head;
        while (k.next != null){
            if (k.data == key){
                System.out.println("The Item Is Found: "+key);
                return;
            }
            k = k.next;
        }
        System.out.println("Item Not Found");
    }
    //Adds key After Node
    public void AddAfter(int pre_node, int key){
        
        Node new_node = new Node(key);
        Node k = head;
        while (k.data != pre_node){
            k = k.next;
        }
        Node pre = k;
        new_node.next =pre.next;
        pre.next= new_node;
        if (tail == pre)
            tail =new_node;
        
        
    }
    //Adds key Before Node
    public void AddBefore(int after_node, int key){
        Node j ;
        if (head == null || head.data==after_node)
            PushFront(key);
        else{
            Node parent= null;
            Node curr = head;
            while (curr!= null&&curr.data!=after_node){
                parent = curr;
                curr = curr.next;
            }   
            if (curr!= null){
                Node k = new Node(key);
                
                parent.next = k;
                k.next = curr;
            }
            else
                PushBack(key);
                
            
        }    
    } 
    //Remove A Key From list
    public void Erase(int key){
        Node temp = head, pre_temp=null ;
        if(temp!= null&&temp.data==key){
            head = temp.next;
            return;
        }
        while (temp != null&&temp.data!= key){
            pre_temp = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;
        pre_temp.next = temp.next;
        
        
    }
    //Empty List? 
    public void Boolean_empty(){
        if(head==null){
            System.out.println("Empty List!");
            return;
        }
        System.out.println("List Not Empty!");
    }
    //Print The LinkedList
    public void Print(){
        System.out.println("Elements In LinkedList:");
        Node Pnode = head;
        while(Pnode !=null)
        {
            System.out.println(Pnode.data+"");
            Pnode =Pnode.next;
        }
    } 
    
}
