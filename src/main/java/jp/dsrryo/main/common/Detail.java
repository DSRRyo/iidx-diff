package jp.dsrryo.main.common;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Detail {

    private String version;
    private String title;
    private String junle;
    private String artist;
    private String times;
    private String difN;
    private String exscoreN;
    private String pgreatN;
    private String greatN;
    private String missCountN;
    private String clearTypeN;
    private String djLevelN;
    private String difH;
    private String exscoreH;
    private String pgreatH;
    private String greatH;
    private String missCountH;
    private String clearTypeH;
    private String djLevelH;
    private String difA;
    private String exscoreA;
    private String pgreatA;
    private String greatA;
    private String missCountA;
    private String clearTypeA;
    private String djLevelA;
    private String time;

    public Detail (Map<Integer,String> map) {
        // 曲データ
        version    = map.get(0);
        title      = map.get(1);
        junle      = map.get(2);
        artist     = map.get(3);
        times      = map.get(4);
        // NORMAL
        difN       = map.get(5);
        exscoreN   = map.get(6);
        pgreatN    = map.get(7);
        greatN     = map.get(8);
        missCountN = map.get(9);
        clearTypeN = map.get(10);
        djLevelN   = map.get(11);
        // HYPER
        difH       = map.get(12);
        exscoreH   = map.get(13);
        pgreatH    = map.get(14);
        greatH     = map.get(15);
        missCountH = map.get(16);
        clearTypeH = map.get(17);
        djLevelH   = map.get(18);
        // ANOTHER
        difA       = map.get(19);
        exscoreA   = map.get(20);
        pgreatA    = map.get(21);
        greatA     = map.get(22);
        missCountA = map.get(23);
        clearTypeA = map.get(24);
        djLevelA   = map.get(25);

        time       = map.get(26);
    }
}
