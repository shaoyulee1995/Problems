// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    if(l == null){
        return null;
    }
    ListNode<Integer> node = new ListNode<Integer>(0),
                      temp = node;
    node.next = l;
    
    while(node.next != null){
        if(node.next.value!= k){
            node = node.next;
            continue;
        }
        node.next = node.next.next;
    }
    return temp.next;
}
