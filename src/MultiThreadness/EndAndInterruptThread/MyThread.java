package MultiThreadness.EndAndInterruptThread;

public class MyThread implements Runnable
{
    private boolean isActive;

    public MyThread()
    {
        this.isActive = true;
    }

    public void disable()
    {
        this.isActive = false;
    }

    @Override
    public void run()
    {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(isActive){
            System.out.println("Loop " + counter++);
            try
            {
                Thread.sleep(400);
            }
            catch(InterruptedException e)
            {
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
