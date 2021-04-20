// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {
    ListNode<Integer> slow = l,
                      fast = l;
    Stack<Integer> stack = new Stack<>();
    
    while(fast!=null && fast.next !=null){
        stack.add(slow.value);
        slow = slow.next;
        fast = fast.next.next;    
    }                  
    if(fast != null){
        slow = slow.next;
    }
    
    while(slow != null){
        int curPop = stack.pop();
        if(slow.value != curPop){
            System.out.println(slow.value+"    " + curPop);
            return false;
        }
        slow = slow.next;
    }
    
    return true;
}
