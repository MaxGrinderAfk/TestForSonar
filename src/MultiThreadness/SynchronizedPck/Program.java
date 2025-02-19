package MultiThreadness.SynchronizedPck;

public class Program
{
    public static void main(String[] args)
    {
        CommonResource commonResource = new CommonResource();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class CommonResource
{
    int x;
    synchronized void increment()
    {
        x = 1;
        for (int i = 1; i < 5; i++)
        {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}

class CountThread implements Runnable
{
    CommonResource res;
    CountThread(CommonResource res)
    {
        this.res=res;
    }

    @Override
    public void run()
    {
        res.increment();
    }
}


