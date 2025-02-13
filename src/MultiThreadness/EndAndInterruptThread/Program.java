package MultiThreadness.EndAndInterruptThread;

//import MultiThreadness.EndAndInterruptThread.JThread;

public class Program
{
    public static void main(String[] args)
    {
//        System.out.println("Main thread Started");
//        MyThread myThread = new MyThread();
//        new Thread(myThread, "MyThread").start();
//
//        try
//        {
//            Thread.sleep(1100);
//
//            myThread.disable();
//
//            Thread.sleep(1000);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Main thread Stopped");

        System.out.println("Main thread started...");
        JThread t = new JThread("JThread");
        t.start();
        try
        {
            Thread.sleep(150);
            t.interrupt();

            Thread.sleep(150);
        }
        catch(InterruptedException e)
        {
            System.out.println("Thread has been interrupted");
        }

        System.out.println("Main thread finished...");
    }
}
