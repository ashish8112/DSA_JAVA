package DSA.Basic.Thread;

class Main01 {
    public static void main(String[] args) {
        InterFace execute = new InterFace();
        Thread t1 = new Thread(execute); // To use Runnable Interface we need send object of class where Runnable is implements in Thread Class.
        t1.start();
        for(;;)
        System.out.println(Thread.currentThread().getName()+" Ashish");
    }
}
