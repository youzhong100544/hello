package com.hello.thread;

public class DemoThread {

    public static void main(String[] args) {
        System.out.printf("DemoThread");
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int x = 0; x < 100; x++) {
                // getName()方法是Thread类的，而MyRunnable只实现了Runnable接口，本身没有getName(),所以不能使用。
                System.out.println(Thread.currentThread().getName() + "---hello" + x);
            }
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int x = 0; x < 100; x++) {
                System.out.println(getName() + "---hello" + x);
            }
        }
    }


    /**
     * 多线程：就是指应用程序有多条执行路径。
     * 		进程：正在运行的应用程序。
     * 		线程：进程的执行单元，一条执行路径。
     *
     * 举例：
     * 		迅雷下载，360管理界面。
     *
     * 我们如何实现多线程程序呢?
     * 由于线程是依赖于进程存在，而进程是由操作系统创建的，并且java语言是不能直接调用操作系统的功能。
     * 所以，为了方便对多线程程序的时候，java就提供了线程的API对应的类。
     *
     * 线程类：Thread
     *
     * 通过查看API，我们到创建线程的方式有2种。
     * 方式1：继承Thread类。
     * 		A:定义一个类继承Thread类。
     * 		B:子类要重写Thread类的run()方法。
     * 		C:让线程启动并执行。
     * 			注意：启动线程并执行，是不能使用run()方法的。这个时候，必须使用另外的一个方法。
     * 			            这个方法名是start()。这个方法其实做了两件事情，第一，让线程启动。第二，自动调用run()方法。
     *
     * 为什么要使用线程?以及什么时候使用?
     * 为了提高效率才使用。
     * 只有当要操作的代码的内容比较多(耗时),循环次数较多这样的情况才使用。
     *
     *
     * 方式2：
     * 		A:创建一个类实现Runnable接口
     * 		B:重写run()方法
     * 		C:创建类的实例
     * 		D:把类的实现作为Thread的构造参数传递，创建Thread对象
     *
     * 既然有了继承Thread类的方式，为什么还要有实现Runnable接口的方式?
     * A:避免的单继承的局限性
     * B:实现接口的方式，只创建了一个资源对象，更好的实现了数据和操作的分离。
     * 一般我们选择第二种方式。
     *
     */
    private static class MyThreadDemo{
        public static void main(String[] args) {
            MyThread my1 = new MyThread();
            MyThread my2 = new MyThread();

            my1.setName("小明");
            my2.setName("小红");

            // my.run();
            // my.run();

            // 同一个线程对象连续两次start，报错：IllegalThreadStateException
            // 表示该线程的状态有问题。
            // my.start();
            // my.start();
            my1.start();
            my2.start();
        }
    }

    private static class MyRunnableDemo {
        public static void main(String[] args) {
            MyRunnable my = new MyRunnable();
            // my.start();
            // 实现了Runnable接口的类没有start()方法，而我们启动线程必须调用start()方法。
            // 又由于，start()方法只有Thread类有。所以，我们就考虑这个把该类转换成Thread类。
            Thread t1 = new Thread(my);
            Thread t2 = new Thread(my);

            t1.setName("乔峰");
            t2.setName("慕容复");

            t1.start();
            t2.start();
        }
    }


}
