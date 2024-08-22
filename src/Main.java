public class Main {
    public static void main(String[] args) {
        // Пример строк
        String[] toyData = {
                "1,Car,50",
                "2,Doll,30",
                "3,Robot,70"
        };

        // Массивы для хранения данных
        String[] ids = new String[toyData.length];
        String[] names = new String[toyData.length];
        int[] frequencies = new int[toyData.length];

        // Обработка строк и заполнение массивов
        ToyQueueManager toyQueueManager = new ToyQueueManager();

        for (int i = 0; i < toyData.length; i++) {
            String[] parts = toyData[i].split(",");
            ids[i] = parts[0];
            names[i] = parts[1];
            frequencies[i] = Integer.parseInt(parts[2]);

            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toyQueueManager.addToy(toy);
        }

        // Процесс получения игрушек и запись в файл
        toyQueueManager.processToys("toys_output.txt", 10);
    }
}