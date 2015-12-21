/*************************************************
* FastMaxStack Class                         
*                                                
* Implementation of MaxStack with constant
* run time for push(), pop() and getMaxSoFar().     
*                                                
* Written by Jiashan Wu                          
* Date: December 19, 2015                         
*************************************************/

public class FastMaxStack<T> implements MaxStack<T> {

	private final Maximizer<T> maximizer;
	private ListNode<T> top;
	private FastMaxStack<T> holderStack;
	
	public FastMaxStack(Maximizer<T> maximizer) {
		this.maximizer = maximizer;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
    public void push(T value)
    {
        if (top == null) {
            top = new ListNode<T>(value, null);
            // Set top of holderStack to top.value
            holderStack.push(value);
        } else {
        	// If new value is bigger than top of stack
        	if (value.equals(maximizer.getMax(value, holderStack.top.value))) {
	        	holderStack.push(value);
        	}
            top = top.setValue(value);
        }
    }

	@Override
	public T pop() {
		T value = top.value;
		top = top.next;
		return value;
	}

	@Override
	public T getMaxSoFar() {		
		return holderStack.top.value;
	}

}


