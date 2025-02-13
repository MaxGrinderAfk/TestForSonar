package MultiThreadness.RunAndThread.JTheradPcl;

public class JThread extends Thread
{
    public JThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        System.out.println("Running " + Thread.currentThread().getName());
        try
        {
            Thread.sleep(900);
        }
        catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Finished " + Thread.currentThread().getName());
    }
}
