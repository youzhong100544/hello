package com.hello.thread;

public class DemoThreadTicketProblem {

    public static void main(String[] args) {
        System.out.printf("DemoThreadTicket");
    }

    private static class TicketThread extends Thread {
        // test1
        // private static int tickets = 200;

        // test2
        private int tickets = 200;

        @Override
        public void run() {

            while (true) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // System.out.println(getName() + "正在出售第" + (tickets--) + "张票");
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                }

            }
        }
    }

    /**
     * 窗口3正在出售第12张票
     * 窗口4正在出售第11张票
     * 窗口1正在出售第10张票
     * 窗口2正在出售第9张票
     * 窗口4正在出售第8张票
     * 窗口3正在出售第8张票
     * 窗口1正在出售第7张票
     * 窗口2正在出售第6张票
     * 窗口4正在出售第5张票
     * 窗口3正在出售第4张票
     * 窗口1正在出售第3张票
     * 窗口2正在出售第2张票
     * 窗口4正在出售第1张票
     * 窗口3正在出售第1张票
     * 窗口1正在出售第0张票
     * 窗口2正在出售第-1张票
     */
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
}
