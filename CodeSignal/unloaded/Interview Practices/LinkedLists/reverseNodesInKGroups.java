// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    ListNode<Integer> dummy = new ListNode<Integer>(0),
                      begin = dummy;
    dummy.next = l;
    
    int cnt = 0;
    while(l != null){
        cnt++;
        if(cnt % k == 0){
            begin = reverse(begin, l.next);
            l = begin.next;
        }else{
            l = l.next;       
        }
    }
    
    return dummy.next;
}
ListNode<Integer> reverse(ListNode<Integer> start, ListNode<Integer> end) {
    ListNode<Integer> prev = start,
                      cur = start.next,
                      first = cur;
    while(cur != end){
        ListNode<Integer> next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    
    start.next = prev;
    first.next = cur;
                      
    return first;
}