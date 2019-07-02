package com.frankie.demo;

public class ArrayDequeUtils {

    /**
     * Stack
     * 1. push()
     * 2. pop() : Removes the object at the top of this stack and returns that object as the value of this function.
     * 3. peek(): Looks at the object at the top of this stack without removing it from the stack.
     */

    /**
     * Queue:
     * 1. add()     : 插入元素，若失败，异常。
     * 2. offer()   : 插入元素，若失败，false。
     * 3. remove()  : 删除元素，若失败, 异常。
     * 4. poll()    : 删除元素，若失败，null。
     * 5. element() : 获取头元素，若失败，异常。
     * 6. peek()    : 获取头元素，若失败，null。
     */


    /**
     * ArrayDeque
     * 一. Stack
     * 1. push()        - 也有这个方法，但本质是addFirst()
     * 2. pop()         - 也有这个方法，但本质是removeFirst()
     * 3. peek()        - 也有这个方法，但本质是peekFirst()
     *
     * 二. Queue
     * 1. add()         - 也有这个方法，但本质是addLast()
     * 2. offer()       - 也有这个方法，但本质是offerLast() -> addLast()
     * 3. remove()      - 也有这个方法，但本质是removeFirst()
     * 4. poll()        - 也有这个方法，但本质是pollFirst()
     * 5. element()     - 也有这个方法，但本质是getFirst()
     * 6. peek()        - 也有这个方法，但本质是peekFirst()
     *
     */

}
