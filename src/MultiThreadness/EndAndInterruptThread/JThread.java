package MultiThreadness.EndAndInterruptThread;

public class JThread extends Thread
{
    JThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " is running.");
        int counter = 1;
        while(!isInterrupted())
        {
            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
