package DSA.Basic.Thread;

class Main02 extends Thread {
    public void run(){
        for(;;)
        {
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Main02 main=new Main02();
        main.start();
        for(;;)
        {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
