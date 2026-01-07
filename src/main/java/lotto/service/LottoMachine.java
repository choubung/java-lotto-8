package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoMaker maker;
    private LottoCalculator calculator;
    private List<Lotto> list = new ArrayList<>();
    private int amount = 0;

    public LottoMachine(LottoMaker lottoMaker) {
        this.maker = lottoMaker;
    }

    public void insertCash(int cash) {
        this.amount = cash / 1000;
    }

    public void setWinNumsAndBonus(List<Integer> winNums, int winBonus) {
        calculator = new LottoCalculator(winNums, winBonus);
    }

    public List<Lotto> releaseLotto() {
        for (int i = 0; i < amount; i++){
            list.add(new Lotto(maker.releaseLotto()));
        }

        return list;
    }

    public void calculateLotto() {

    }

    public int getAmount() {
        return amount;
    }
}
