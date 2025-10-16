package DSA.Basic.Thread;

class Main03 implements Runnable{
    public void run()
    {
        for(;;)
            System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Main03 main = new Main03();
        Thread t1= new Thread(main);
        t1.start();
        for(;;)
            System.out.println(Thread.currentThread().getName());
    }
}

