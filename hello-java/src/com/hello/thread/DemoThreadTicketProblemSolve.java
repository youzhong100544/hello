package com.hello.thread;

public class DemoThreadTicketProblemSolve {
    public static void main(String[] args) {
        System.out.printf("DemoThreadTicket");
    }

    private static class TicketThread extends Thread {

        private int tickets = 200;
        private Object obj = new Object();
        @Override
        public void run() {

            while (true) {
                synchronized (obj) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                    }
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
