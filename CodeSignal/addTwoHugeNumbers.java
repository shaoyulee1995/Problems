// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    a = reverse(a);
    
    b = reverse(b);
    
    ListNode<Integer> ans = new ListNode<Integer>(0),
                      ptr = ans;
    int carry = 0;
    while(a!=null || b != null){
        int val_a = (a!=null)?a.value:0,
            val_b = (b!=null)?b.value:0;
        int sum = val_a+val_b +carry;
        carry = sum / 10000;
        
        ptr.next = new ListNode(sum%10000);
        ptr = ptr.next;
        
        if(a!=null){
            a = a.next;
        }
        if(b!=null){
            b = b.next;
        }
    }
    
    if(carry > 0){
        ptr.next = new ListNode(carry);
    }
    ans = reverse(ans.next);
    return ans;
}

ListNode<Integer> reverse(ListNode<Integer> current){
    
    ListNode prev = null,
             next = prev;
             
    while(current != null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}