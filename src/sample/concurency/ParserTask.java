package sample.concurency;

import javafx.scene.Parent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 24.04.2016.
 */
public class ParserTask implements Runnable {
    private File file;
    private String encoding,predicate;
    private List<String> results;


    public ParserTask(String filePath, String encoding,String predicate) {
        this.file = new File(filePath);
        this.encoding = encoding;
        this.predicate = predicate;
        this.results = new ArrayList<>();
    }

    @Override
    public void run() {
        parseFiles(file, encoding);
    }


    private void parseFiles(File file, String encoding) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));


            long start = System.currentTimeMillis();
            int counter = 0;
            for (String line = ""; line != null; line = reader.readLine()) {
                counter++;

                if (contains(line)){
                        results.add(line);
                }
                if(Thread.interrupted()){
                    reader.close();
                    break;
                }

            }


            System.out.printf("Lines read %d \n", counter);

            System.out.printf("Time spent %s seconds.\n" , TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()- start) );

            System.out.printf("Found %d matches %s \n" ,results.size(),results );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean contains(String line){
        return line.contains(predicate);




//        if(uri.contains("/br/fab") || uri.contains("/br/err") || uri.contains("/br/sts")
//
//        Or something like :
//        if(uri.matches(".*/br/(fab|err|sts).*"))

    }


}
