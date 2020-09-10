package neolab.handler.workWithData;

import neolab.handler.Rules;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTXT implements IManager {

    public String[] getFileData(final Rules rules) {
        return getData(rules.getUrl()).split("\n");
    }

    private String getData(final String url){
        String line = "";
        try {
            line = readUsingFiles(url);
        } catch (IOException e) {
            System.err.println("ERROR: CONNECT FILE FAILED");
        }
        return line;
    }

    private String readUsingFiles(final String fileName) throws IOException {
        return Files.readString(Paths.get(fileName));
    }

}
