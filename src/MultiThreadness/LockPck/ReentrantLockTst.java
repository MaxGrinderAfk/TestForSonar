package MultiThreadness.LockPck;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTst
{
    public static void main(String[] args)
    {
        CommonResource cr = new CommonResource();
        ReentrantLock rl = new ReentrantLock();
        for (int i = 0; i < 6; i++)
        {
            Thread t = new Thread(new CountThread(cr, rl));
            t.setName("Thread" + i);
            t.start();
        }
    }
}

class CommonResource{

    int x=0;
}

class CountThread implements Runnable{

    CommonResource res;
    ReentrantLock locker;
    CountThread(CommonResource res, ReentrantLock lock){
        this.res=res;
        locker = lock;
    }
    public void run(){

        locker.lock(); // устанавливаем блокировку
        try{
            res.x=1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock(); // снимаем блокировку
        }
    }
}
