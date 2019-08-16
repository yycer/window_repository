package com.frankie.demo;

import org.springframework.core.annotation.SynthesizedAnnotation;

public class SingletonTest {

    private static volatile SingletonTest instance;


    // 第一版，会导致线程安全问题。
    public SingletonTest createInstance1(){
        if (instance == null){
            // 当线程A执行到这，就在此时，线程B来了，就会重新新建一个实例。
            instance = new SingletonTest();
        }
        return instance;
    }

    // 第二版，性能消耗太大(线程的挂起与唤醒，设计用户态与核心态的相互切换)。
    public synchronized SingletonTest createInstance2(){
        if (instance == null){
            instance = new SingletonTest();
        }
        return instance;
    }

    /**
     * 第三版，块级锁优化。
     * 问题: 当线程A、B同时执行到同步块，线程A先获得锁，创建实例，接着线程B获得锁，又创建了一次实例！！！
     */
    public SingletonTest createInstance3(){
        if (instance == null){
            synchronized (SingletonTest.class){
                instance = new SingletonTest();
            }
        }
        return instance;
    }

    /**
     * 第四版优化
     * 问题: 线程C执行至同步块后，线程A、B均还为生成实例，还是会导致实例的重新创建。
     * 涉及内容: 重排序(编译器优化重排序、指令集并行重排序、内存系统重排序。)
     */
    private static SingletonTest instance4;
    public SingletonTest createInstance4(){
        if (instance4 == null){
            synchronized (SingletonTest.class){
                if (instance4 == null){
                    /**
                     * 从指令集角度分为三步(2、3之间因为没有依赖关系，所以可能会导致指令重排序)。
                     * 1. memory = allocate()  // 分配内存
                     * 2. ctorInstance(memory) // 初始化
                     * 3. instance = memory    // 引用指向分配内存
                     */
                    instance4 = new SingletonTest();
                }
            }
        }
        return instance4;
    }

    /**
     * 创建单例(终极版)
     * volatile作用: 防止创建实例时，指令重排。
     */
    public static volatile SingletonTest instance5;
    public SingletonTest createInstance5(){

        if (instance5 == null){
            synchronized (SingletonTest.class){
                if (instance5 == null){
                    instance5 = new SingletonTest();
                }
            }
        }

        return instance5;
    }
}
