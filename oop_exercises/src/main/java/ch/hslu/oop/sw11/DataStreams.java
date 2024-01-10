package ch.hslu.oop.sw11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class DataStreams {
    private static final Logger LOG = LoggerFactory.getLogger(DataStreams.class);

    public static void main(String[] args) {
        DataStreams demo = new DataStreams();
        demo.writeTextFileByte("src/main/resources/dataStreamsTest.txt");
        demo.readTextFileByte("src/main/resources/dataStreamsTest.txt");
    }

    private void writeTextFileByte(final String file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             DataOutputStream dos = new DataOutputStream(fos)) {

            dos.writeInt(10);
            dos.writeUTF("Hello");
            dos.writeUTF("World");
            dos.writeBoolean(true);

        } catch (IOException ioe) {
            LOG.error("Error writing to file: {}", ioe.getMessage(), ioe);
        }
    }

    private void readTextFileByte(final String file) {
        try (FileInputStream fis = new FileInputStream(file);
             DataInputStream dis = new DataInputStream(fis)) {

            System.out.println("Read value from file: " + dis.readInt() + dis.readUTF() + dis.readUTF() + dis.readBoolean());

        } catch (IOException ioe) {
            LOG.error("Error reading from file: {}", ioe.getMessage(), ioe);
        }
    }
}
