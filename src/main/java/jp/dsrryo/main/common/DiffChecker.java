package jp.dsrryo.main.common;

import jp.dsrryo.main.common.enums.Difficulty;

public class DiffChecker {


    private static DiffChecker instance = null;


    public DiffChecker(){
    }

    public static DiffChecker getInstance(){
        if(instance == null){
            instance = new DiffChecker();
        }
        return instance;
    }


    private static final ScorePrinter printer = ScorePrinter.getInstance();


    public void check(Detail oldDetail, Detail newDetail){
        checkDetail(oldDetail, newDetail, Difficulty.Normal);
        checkDetail(oldDetail, newDetail, Difficulty.Hyper);
        checkDetail(oldDetail, newDetail, Difficulty.Another);
    }

    public void checkDetail(Detail oldDetail, Detail newDetail, Difficulty dif){

        if(this.checkUpdate(oldDetail, newDetail, dif)) {
            printer.printTilte(oldDetail);
            printer.printDifficulty(dif, oldDetail);
            System.out.println("");

            if(dif.equals(Difficulty.Normal)){
                printer.printDetail(oldDetail.getClearTypeN(), newDetail.getClearTypeN(),
                                    oldDetail.getDjLevelN()  , newDetail.getDjLevelN(),
                                    oldDetail.getExscoreN()  , newDetail.getExscoreN());

            }else if (dif.equals(Difficulty.Hyper)) {
                printer.printDetail(oldDetail.getClearTypeH(), newDetail.getClearTypeH(),
                                    oldDetail.getDjLevelH()  , newDetail.getDjLevelH(),
                                    oldDetail.getExscoreH()  , newDetail.getExscoreH());

            }else if (dif.equals(Difficulty.Another)) {
                printer.printDetail(oldDetail.getClearTypeA(), newDetail.getClearTypeA(),
                                    oldDetail.getDjLevelA()  , newDetail.getDjLevelA(),
                                    oldDetail.getExscoreA()  , newDetail.getExscoreA());
            }

            printer.printPlayDate(newDetail);
            System.out.println("");
        }
    }

    private Boolean checkUpdate(Detail oldDetail, Detail newDetail, Difficulty dif){
        Boolean clear   = Boolean.FALSE;
        Boolean djLevel = Boolean.FALSE;
        Boolean score   = Boolean.FALSE;


        if(dif.equals(Difficulty.Normal)){
            clear   = oldDetail.getClearTypeN().equals(newDetail.getClearTypeN());
            djLevel = oldDetail.getDjLevelN().equals(newDetail.getDjLevelN());
            score   = oldDetail.getExscoreN().equals(newDetail.getExscoreN());

        }else if (dif.equals(Difficulty.Hyper)) {
            clear   = oldDetail.getClearTypeH().equals(newDetail.getClearTypeH());
            djLevel = oldDetail.getDjLevelH().equals(newDetail.getDjLevelH());
            score   = oldDetail.getExscoreH().equals(newDetail.getExscoreH());

        }else if (dif.equals(Difficulty.Another)) {
            clear   = oldDetail.getClearTypeA().equals(newDetail.getClearTypeA());
            djLevel = oldDetail.getDjLevelA().equals(newDetail.getDjLevelA());
            score   = oldDetail.getExscoreA().equals(newDetail.getExscoreA());

        }
        if(!clear || !djLevel || !score) return Boolean.TRUE;

        return Boolean.FALSE;

    }

}
