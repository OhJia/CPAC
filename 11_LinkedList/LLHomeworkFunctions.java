/*************************************************
* Linked List Problem Set                             
*                                                
* Updates for equalLists() and terminates() 
* methods. Testing for part 1, part 2, and part 3 
* of the problem set.       
*                                                
* Written by Jiashan Wu                          
* Date: December 19, 2015                         
*************************************************/

//java.util.*;

public class LLHomeworkFunctions {

	public static void main(String [] args) {
        // TODO: Part of this assignment is to implement this correctly.

        /*****************************************
         PART 1 TEST
        *****************************************/
        ListNode<Integer> list1;
        ListNode<Integer> list1Node2;
        ListNode<Integer> list1Node3;

        ListNode<Integer> list2;
        ListNode<Integer> list2Node2;
        ListNode<Integer> list2Node3;
        ListNode<Integer> list2Node4; 

        // 2 -> 4 -> 5 -> null
        list1Node3 = new ListNode<Integer>(5, null); 
        list1Node2 = new ListNode<Integer>(4, list1Node3);
        list1 = new ListNode<Integer>(2, list1Node2);

        // 2 -> 4 -> 5 -> null
        // list2Node3 = new ListNode<Integer>(5, null);
        // list2Node2 = new ListNode<Integer>(4, list2Node3);
        // list2 = new ListNode<Integer>(2, list2Node2);

        // // 2 -> 5 -> 4 -> null
        // list2Node3 = new ListNode<Integer>(4, null);
        // list2Node2 = new ListNode<Integer>(5, list2Node3);
        // list2 = new ListNode<Integer>(2, list2Node2);
        
        //2 -> 4 -> 5 -> 1 -> null
        list2Node4 = new ListNode<Integer>(2, null); 
        list2Node3 = new ListNode<Integer>(5, list2Node4);
        list2Node2 = new ListNode<Integer>(4, list2Node3);
        list2 = new ListNode<Integer>(2, list2Node2);
        
        System.out.println("equal lists: " + equalLists(list1, list2));

        
        /*****************************************
         PART 2 TEST
        *****************************************/

        ListNode<Integer> last;
        ListNode<Integer> node1;
        ListNode<Integer> node2;

        //4 -> 2 -> 5 -> 4 -> 2 -> 5 -> 4 -> 2 -> 5 ...
        last = new ListNode<Integer>(5, null);
        node2 = new ListNode<Integer>(2, last);
        node1 = new ListNode<Integer>(4, node2);
        last.next = node1;

        System.out.println("terminates: " + terminates(node2));


        /*****************************************
         PART 3 TEST
        *****************************************/
        Integer int1 = new Integer(1);
        Integer int2 = new Integer(2);
        Integer int3 = new Integer(3);
        Integer max;
        final Maximizer<Integer> maximizer;

        FastMaxStack<Integer> fastMaxStack = new FastMaxStack<Integer>(maximizer);
        fastMaxStack.push(int1);
        fastMaxStack.push(int2);
        fastMaxStack.push(int3);

        max = fastMaxStack.getMaxSoFar();
        System.out.println("max: " + max);
     
	}
	
	/**
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return true if the lists are equal.  Assume both lists terminate.
	 */
    public static <T> boolean equalLists(ListNode<T> list1, ListNode<T> list2) {
		// TODO: Part of this assignment is to implement this correctly.

		while (list1 != null) {
			
			// If not the same number of nodes, return false
			if (list2 == null) return false;
			else {

				// If the two nodes are not the same, return false
				if (!list1.value.equals(list2.value)) return false;
				else {
					list1 = list1.next;
					list2 = list2.next;
				}
			}
		} 

		// If not the same number of nodes, return false
		if (list2 != null) return false;
		else return true;
	}
	
	/**
	 * @param <T>
	 * @param list
	 * @return true if the list eventually terminates, and false if the list points back at one of it's
	 *  previous nodes.
	 */
	public static <T> boolean terminates(ListNode<T> list) {
        // TODO: Part of this assignment is to implement this correctly.
        ListNode<T> head = list;
        while (list != null) {
        	if (list.next == head) return false;
	        else {
	        	list = list.next;
	        }
        }
        
        return true;
	}

}
