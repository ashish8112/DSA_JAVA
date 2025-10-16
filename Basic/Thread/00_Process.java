package DSA.Basic.Thread;

class Process extends Thread {
    @Override
    public void run()
    {
        for(;;)
            System.out.println("Another Thread");
    }
}
