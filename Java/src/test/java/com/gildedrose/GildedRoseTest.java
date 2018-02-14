package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GildedRoseTest {

    @Test
    public void rename() {
        PrintStream oldOut = System.out;
        try {
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(byteArray);
            System.setOut(out);
            TexttestFixture.main(null);
            Files.write(Paths.get("result.txt"), byteArray.toByteArray(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setOut(oldOut);
        }
    }

}
