package lotto.service;

import lotto.domain.LottoBill;
import lotto.utils.LottoMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoMaker maker;
    private final LottoCalculator calculator;
    private List<LottoBill> bill = new ArrayList<>();
    private int cnt = 0;

    public LottoMachine(LottoCalculator calculator, LottoMaker lottoMaker) {
        this.maker = lottoMaker;
        this.calculator = calculator;
    }

    public void insertCash(int cash) {

    }

    public void setWinNums(List<Integer> winNums) {

    }

    public void setWinBonusNum (int num) {

    }

    public void releaseLotto() {
        maker.releaseLotto();
    }

    public void calculateLotto() {

    }
}
