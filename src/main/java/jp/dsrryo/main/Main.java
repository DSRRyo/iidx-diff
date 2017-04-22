package jp.dsrryo.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.ColumnPositionMapListHandler;

import jp.dsrryo.main.common.Detail;
import jp.dsrryo.main.common.DiffChecker;
import jp.dsrryo.main.common.ScorePrinter;

public class Main {
    private static final ScorePrinter printer = ScorePrinter.getInstance();
    private static final DiffChecker checker  = DiffChecker.getInstance();

    private static List<Map<Integer, String>> oldScoreMap;
    private static List<Map<Integer, String>> newScoreMap;

    private static HashMap<String,Detail> oldScore = new HashMap<String,Detail>();
    private static List<Detail> newScore = new ArrayList<Detail>();


    public static void main(String[] args) throws Exception{

        String oldFileName = args[0];
        String newFileName = args[1];

        readCsv(oldFileName, newFileName);

        oldScoreMap.stream().parallel().forEach(o -> oldScore.put(o.get(1),new Detail(o)));
        newScoreMap.stream().forEachOrdered(n -> newScore.add(new Detail(n)));
        newScore.stream().forEachOrdered(d -> execute(d));
        System.out.println("---------------------------------------------------------------------");
    }


    private static void readCsv(String oldFileName, String newFileName) throws IOException{
        System.out.println("======= Read Old CSV =======");
        System.out.println("FileName [" + oldFileName + "]");
        System.out.println("======= Read New CSV =======");
        System.out.println("FileName [" + newFileName + "]");
        System.out.println("");
        System.out.println("");

        oldScoreMap = Csv.load(new File(oldFileName), new CsvConfig(),new ColumnPositionMapListHandler());
        newScoreMap = Csv.load(new File(newFileName), new CsvConfig(),new ColumnPositionMapListHandler());
    }


    private static void execute(Detail newDetail){
        Optional<Detail> oldDetail = Optional.ofNullable(oldScore.get(newDetail.getTitle()));
        if(newDetail.getTime()!=null){
            oldDetail.ifPresent(d -> checker.check(d,newDetail));
        }
    }

}
