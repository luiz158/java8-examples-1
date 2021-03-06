package tk.hadeslee.Lambda_Expressions.Working_with_Resources;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Project: java8-examples
 * FileName: FileWriterExample
 * Date: 2015-11-18
 * Time: 오전 9:59
 * Author: Hades Lee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class FileWriterExample {
    private final FileWriter writer;

    public FileWriterExample(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void finalize() throws IOException {
        writer.close();
    }

    public void close() throws IOException {
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");

        try {
            writerExample.writeStuff("peek-a-boo");
        } finally {
            writerExample.close();
        }

    }


}
