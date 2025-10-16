package DSA.Basic.Thread;

 class InterFace implements Runnable {
    public void run()
    {
        for(;;)
            System.out.println(Thread.currentThread().getName());
    }
}
