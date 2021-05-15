class CustomStack{
    private int[] arr;

    private int size = 0;

    public CustomStack(int capacity){
        arr = new int[capacity];
    }

    public void push(int val){
        if(size == arr.length){
            System.out.println("Stack overflow");
            return;
        }
        arr[size] = val;
        size++;
    }

    public int pop(){
        if(size == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        int removedData = arr[size-1];
        size--;
        return removedData;    
    }

    public int peek(){
        if(size == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[size-1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void display(){
        System.out.print("[");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]);
            if(i!=size-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public String toString(){
        StringBuilder stackprint = new StringBuilder();;
        stackprint.append("[");
        for(int i=0;i<size;i++){
            stackprint.append(arr[i]);
            if(i!=size-1){
                stackprint.append(", ");
            }
        }
        stackprint.append("]");

        return stackprint.toString();
    }
}

public class Stack{
    public static void main(String[] args){
        CustomStack stack = new CustomStack(5);
        stack.push(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(50);

        System.out.println(stack.size());
        //stack.display();
        System.out.println(stack);

        while(!stack.isEmpty()){
            int data = stack.peek();
            stack.pop();

            System.out.println(data);
        }

        stack.peek();
    }
}
