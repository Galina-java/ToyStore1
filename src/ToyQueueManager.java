import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

class ToyQueueManager {
    private Queue<Toy> toyQueue;

    public ToyQueueManager() {
        toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getFrequency(), t1.getFrequency()));
    }

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public Toy getToy() {
        return toyQueue.poll();
    }

    public void processToys(String fileName, int times) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < times; i++) {
                Toy toy = getToy();
                if (toy != null) {
                    writer.write(toy.toString());
                    writer.newLine();
                } else {
                    writer.write("Queue is empty");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
