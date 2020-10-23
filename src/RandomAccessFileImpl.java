import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

public class RandomAccessFileImpl {
    StringBuilder stringBuilder = new StringBuilder();
    File file;

    RandomAccessFileImpl() {
        file = new File(new File("text.txt").getAbsolutePath());
    }

    private void readFile(RandomAccessFile randomAccessFile) throws IOException {
        writeFile(randomAccessFile);

        int b = randomAccessFile.read();

        while (b != -1) {
            stringBuilder.append((char) b);
            b = randomAccessFile.read();
        }

        System.out.println("Output after reading.");
        System.out.println(stringBuilder.toString());
    }

    private void writeFile(RandomAccessFile randomAccessFile) throws IOException {
        System.out.println("Input to the file.");

        String timeline = "I love Java";
        randomAccessFile.write(timeline.getBytes());
    }

    private void work() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            readFile(randomAccessFile);
        } catch (IOException e) {
            System.out.println("Something wrong!");
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        RandomAccessFileImpl work = new RandomAccessFileImpl();
        work.work();
    }
}
