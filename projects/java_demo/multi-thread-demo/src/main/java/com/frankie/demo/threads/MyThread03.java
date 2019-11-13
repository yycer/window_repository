package com.frankie.demo.threads;

/**
 * @author: Yao Frankie
 * @date: 2019/11/13 16:31
 */
public class MyThread03 extends Thread{

    /**
     * 首先需要明确什么时候触发MyThread03的构造函数? main函数中创建相应实例时。
     * 因此，Thread.currentThread()代表的是主线程，所以getId() = 1.
     * 同时，this代表的是新建的myThread03线程对象，所以getId() = 15.
     */
    public MyThread03(){
        System.out.println("MyThread03 constructor: Thread.currentThread().getName(): " + Thread.currentThread().getId()); // 1
        System.out.println("MyThread03 constructor: this.getName(): " + this.getId()); // 15
        System.out.println("MyThread03 constructor: Thread.currentThread == this: " + (Thread.currentThread() == this)); // false
    }

    /**
     * 首先需要明确什么时候触发run()方法？myThread03.start()后，
     * 先进入Ready状态，如果拥有相应CPU、锁资源，则进行Running状态，以上两个状态均属于Runnable状态.
     * 因此，Thread.currentThread()代表的就是新建的myThread03线程，所以getId() = 15.
     * 同时，this代表的仍是myThread03线程对象，因此getId() = 15.
     */
    @Override
    public void run(){
        System.out.println("run() method: Thread.currentThread().getName(): " + Thread.currentThread().getId()); // 15
        System.out.println("run() method: this.getName(): " + this.getId()); // 15
        System.out.println("run() method: Thread.currentThread == this: " + (Thread.currentThread() == this)); // true
    }
}
