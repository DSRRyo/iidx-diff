package jp.dsrryo.main.common;

import jp.dsrryo.main.common.enums.Difficulty;

public class ScorePrinter {

    private static ScorePrinter instance = null;


    public ScorePrinter(){
    }

    public static ScorePrinter getInstance(){
        if(instance == null){
            instance = new ScorePrinter();
        }
        return instance;
    }

    public void printTilte(Detail d){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Version     [ " + d.getVersion() + " ]");
        System.out.println("Title       [ " + d.getTitle() + " ]");

    }

    public void printPlayDate(Detail newDetail){
        System.out.println("");
        System.out.println("PlayDate    [ " + newDetail.getTime() + " ]");
    }

    public void printDifficulty(Difficulty dif, Detail d){
        String difi = "";
        if(dif.equals(Difficulty.Normal)){
            difi = d.getDifN();
        }else if (dif.equals(Difficulty.Hyper)) {
            difi = d.getDifH();
        }else if (dif.equals(Difficulty.Another)) {
            difi = d.getDifA();
        }
        System.out.println("Difficulty  [ " + dif.toString() + " ☆" + difi + " ]");
    }

    public void printDetail(String oldClear, String newClear, String oldDjLevel, String newDjLevel, String oldScore, String newScore){
        System.out.println("ClearType   [ " + oldClear + " -> " + newClear+ " ]");
        System.out.println("DjLevel     [ " + oldDjLevel + " -> " + newDjLevel + " ]");
        System.out.println("ExScore     [ " + oldScore + " -> " + newScore + " ]");
    }
}
