import java.util.ArrayList;
import java.util.Stack;

public class GenericTree{
    private static class Node{
        private int data;
        private ArrayList<Node> children;

        public Node(){
            data = 0;
            children = new ArrayList<Node>();
        }

        public Node(int data){
            this.data = data;
            children = new ArrayList<Node>();
        }

        public int getData(){
            return data;
        }

        public ArrayList<Node> getChildren(){
            return children;
        }
    }

    private static Node construct(Integer[] arr){
        Node root = null;
        Stack<Node> stack = new Stack<Node>();

        for(int i=0; i< arr.length; i++){
            Integer data = arr[i];
            if(data!=null){
                Node nn = new Node(data);
                if(stack.size() == 0){
                    root = nn;
                    stack.push(nn);
                }else{
                    stack.peek().getChildren().add(nn);
                    stack.push(nn);
                }
            }else{
                stack.pop();
            }
        }

        return root;
    }

    private static void display(Node node){
        System.out.print("[" + node.data + "] -> ");
        for(Node child: node.getChildren()){
            System.out.print(child.data + ", ");
        }
        System.out.println(".");

        for(Node child: node.getChildren()){
            display(child);
        }
    }

    private static void buildTree(Integer[] arr){
        Node root = construct(arr);
        display(root);
    }

    public static void main(String[] args){
        Integer[] data = {10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null, null, 40, 100, null, null, null};
        buildTree(data);
    }
}