package exercises.chapter_4_stacks_and_queues.queue_in_shop;

import exercises.chapter_4_stacks_and_queues.queue.Queue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QueueInShopWithRandom implements QueueInShopLogic {
    /*
     * Запустить цикл
     * Изначально дано две очереди
     * Вывод меню
     * 1. Добавить покупателя в случайную очередь с рандомным количеством товаров
     * 2. Один тик (-1 товар у первого покупателя в каждой очереди)
     * Если первая очередь заполнена, добавить покупателя во вторую, если она не заполненна
     * Если обе очереди заполнены, пнукт 1 не даст вставить покупателя в очереди,
     * пока хотя бы один покупатель не освободит очередь
     * */
    private final Queue[] queues;
    private final int numOfQueues;
    private final Scanner scanner;

    public QueueInShopWithRandom() {
        scanner = new Scanner(System.in);
        System.out.print("Введите количество очередей: ");
        numOfQueues = scanner.nextInt();
        queues = new Queue[numOfQueues];
        for (int i = 0; i < numOfQueues; i++) {
            if ((i + 1) != 13 && (i + 1) % 10 == 3) {
                System.out.print("Введите размер " + (i + 1) + "-ей очереди: ");
            } else {
                System.out.print("Введите размер " + (i + 1) + "-ой очереди: ");
            }
            queues[i] = new Queue(scanner.nextInt());
        }
    }

    @Override
    public void start() {
        int input = 0;
        while (input != 3) {
            System.out.println("1. Add a customer to a random queue with a random number of items\n2. Wait");
            try {
                switch (input = scanner.nextInt()) {
                    case 1:
                        insertInQueue();
                    case 2:
                        insertInQueue();
                    case 3:
                        System.out.println("Exit");
                        break;
                    default:
                        displayQueues();
                }
            } catch (InputMismatchException err) {
                System.err.println("Type a number, not a text. Insert valid data!");
                scanner.next();
            }
        }
        scanner.close();
    }

    private void displayQueues() {
        for (Queue queue : queues)
            queue.display();
    }

    private void insertInQueue() {
        queues[(int) (Math.random() * numOfQueues)].insert((long) (Math.random() * 10));
    }
}