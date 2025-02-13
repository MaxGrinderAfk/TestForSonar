package MultiThreadness.RunAndThread;

import MultiThreadness.RunAndThread.MyThreadWthRunInt.MyThread;

public class Program
{
    public static void main(String[] args)
    {
//        System.out.println("Main thread started...");
//        JThread t = new JThread("JThread");
//        t.start();
//        try
//        {
//            t.join();
//        }
//        catch (InterruptedException e)
//        {
//            System.out.printf("%s has been interrupted", t.getName());
//        }
//        System.out.println("Main thread finished...");

        System.out.println("Main thread started...");
//        Runnable r = ()->{
//            System.out.printf("%s started... \n", Thread.currentThread().getName());
//            try{
//                Thread.sleep(500);
//            }
//            catch(InterruptedException e){
//                System.out.println("Thread has been interrupted");
//            }
//            System.out.printf("%s finished... \n", Thread.currentThread().getName());
//        };
        Thread myThread = new Thread(new MyThread(),"MyThread");
        myThread.start();
        System.out.println("Main thread finished...");
    }
}
