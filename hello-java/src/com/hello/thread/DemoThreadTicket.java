package com.hello.thread;

public class DemoThreadTicket {
    public static void main(String[] args) {
        System.out.printf("DemoThreadTicket");
    }

    /*
     * 多线程程序的场景：
     * 		窗口卖火车票
     *
     * 有一趟火车：k261(北京西-十堰)，票不多了，还剩200张。有4个窗口卖票。
     * 使用多线程，模拟窗口卖票。
     *
     * 两种方式实现：
     * 方式1：继承Thread类
     * 方式2：实现Runnable接口
     */
    private static class TicketThread extends Thread {
        private static int tickets = 200;

        @Override
        public void run() {
            while (true) {
                if (tickets > 0) {
                    // System.out.println(getName() + "正在出售第" + (tickets--) + "张票");
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }
            }
        }
    }


    private static class ThreadTest {
        public static void main(String[] args) {
            // test_1();

            test_2();
        }

        public static void test_1() {
            TicketThread tt1 = new TicketThread();
            TicketThread tt2 = new TicketThread();
            TicketThread tt3 = new TicketThread();
            TicketThread tt4 = new TicketThread();

            tt1.setName("窗口1");
            tt2.setName("窗口2");
            tt3.setName("窗口3");
            tt4.setName("窗口4");

            tt1.start();
            tt2.start();
            tt3.start();
            tt4.start();
        }
        public static void test_2() {
            TicketThread tt = new TicketThread();
            Thread t1 = new Thread(tt, "窗口1");
            Thread t2 = new Thread(tt, "窗口2");
            Thread t3 = new Thread(tt);
            Thread t4 = new Thread(tt);

            t3.setName("窗口3");
            t4.setName("窗口4");

            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
    }


    private static class TicketRunnable implements Runnable {
        private int tickets = 200;

        @Override
        public void run() {
            while (true) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }
            }
        }

    }

    private static class RunnableTest {
        public static void main(String[] args) {
            TicketRunnable tr = new TicketRunnable();

            Thread t1 = new Thread(tr, "窗口1");
            Thread t2 = new Thread(tr, "窗口2");
            Thread t3 = new Thread(tr);
            Thread t4 = new Thread(tr);

            t3.setName("窗口3");
            t4.setName("窗口4");

            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
    }
}
