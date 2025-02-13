package MultiThreadness.PhaserPck;

import java.util.concurrent.Phaser;

public class PhaserExmpl
{
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Регистрируем главный поток (main)

        for (int i = 1; i <= 3; i++) {
            phaser.register(); // Регистрируем поток
            final int threadNum = i;
            new Thread(() -> {
                for (int phase = 0; phase < 3; phase++) {
                    System.out.println("Поток " + threadNum + " выполняет фазу " + phase);
                    phaser.arriveAndAwaitAdvance(); // Ожидание других
                }
                phaser.arriveAndDeregister(); // Поток завершает работу
            }).start();
        }

        // Главный поток тоже участвует в фазах
        for (int phase = 0; phase < 3; phase++) {
            phaser.arriveAndAwaitAdvance();
            System.out.println("=== Все потоки завершили фазу " + phase + " ===");
        }

        phaser.arriveAndDeregister(); // Убираем главный поток
    }
}

