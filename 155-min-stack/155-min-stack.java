class MinStack {
    class Node {
        int value;
        Node next;
        int min;
        
        public Node(int value,int min) {
            this.value=value;
            this.next=null;
            this.min=min;
        }
    }
    
    Node head;

    public MinStack() {
        head=null;
    }
    
    public void push(int val) {
        if(head==null) {
            head=new Node(val, val);
        }
        else {
            Node node=new Node(val, Math.min(head.min, val));
            node.next=head;
            head=node;
        }
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */