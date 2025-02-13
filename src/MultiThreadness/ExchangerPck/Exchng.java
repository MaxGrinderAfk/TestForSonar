package MultiThreadness.ExchangerPck;

import java.util.concurrent.Exchanger;

public class Exchng
{
    public static void main(String[] args)
    {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();
    }
}

class PutThread implements Runnable
{
    Exchanger<String> exch;
    String msg;

    PutThread(Exchanger<String> exch)
    {
        this.exch = exch;
        this.msg = "hello java";
    }

    @Override
    public void run()
    {
        try
        {
            this.msg = exch.exchange(msg);
            System.out.println("PutThread has received: " + msg);
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

class GetThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger<String> ex){

        this.exchanger=ex;
        message = "Hello World!";
    }

    @Override
    public void run(){

        try{
            message=exchanger.exchange(message);
            System.out.println("GetThread has received: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
