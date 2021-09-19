// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    if(n == 0 || l == null){
        return l;
    }
    
    //1, 2, 3, 4, 5
    //s
    //f
    ListNode<Integer> s = l,
                      f = l;
    //1, 2, 3, 4, 5
    //s
    //         f                  
    while(n > 0 && f != null){
        f = f.next;
        n--;
    }
    if(f == null && n >= 0){
        return l;
    }
    //1, 2, 3, 4, 5
    //   s
    //            f
    while(f.next != null){
        f = f.next;
        s = s.next;
    }
    //1, 2, 3, 4, 5
    //   s
    //            f
    //      new
    //      head
    ListNode<Integer> newHead = s.next;
    s.next = null;
    f.next = l;
    
    return newHead;
    
}
