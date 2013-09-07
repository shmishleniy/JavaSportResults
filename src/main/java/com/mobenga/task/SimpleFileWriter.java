package com.mobenga.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter implements StringDataWriter {
    private String fileName;

    public SimpleFileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        //try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){}
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
