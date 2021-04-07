package Prepare;

class LockTest {
    public static void main(String[] args) {
        Object o = new Object();
        
        Thread tOne = new Thread() {
            @Override
            public void run() {
                synchronized(o) {
                    for (int i = 1; i < 27; i++) {
                        System.out.print(i);
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    o.notify();
                }
            }
        };

        Thread tTwo = new Thread() {
            public void run() {
                synchronized (o) {
                    for (int i = 65; i < 91; i++) {
                        System.out.print((char)i);
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    o.notify();
                }
            }
        };

        tOne.start();
        tTwo.start();
    }
}