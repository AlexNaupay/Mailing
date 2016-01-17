package pe.com.devteam.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Helper {

    public static List<String> readFile(MultipartFile file){
        List<String> lines = new ArrayList<>();
        String line;

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while ((line = bufferedReader.readLine()) != null){
                line = line.trim();
                if (line.length()> 0)
                    lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
