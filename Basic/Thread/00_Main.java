package DSA.Basic.Thread;

class Main {
    public static void main(String [] args)
    {
        Process t1=new Process();
        t1.start();
        for(;;)
        {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
