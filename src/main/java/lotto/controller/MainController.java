package lotto.controller;

import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {
    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // 1. 로또 구입 (금액, 당첨번호, 보너스 번호)
        retryUntilValid(this::buyLotto);

        // 2. 로또 정보 계산
        retryUntilValid(this::matchLotto);

        // 결과 출력
        retryUntilValid(this::printResult);
    }

    private void buyLotto() {
        int cash = inputView.readCash();
        lottoMachine.insertCash(cash);

        List<Integer> winNum = inputView.readWinLottoNum();
        int winBonus = inputView.readWinBonusNum();
        lottoMachine.setWinNumsAndBonus(winNum, winBonus);

        outputView.printLotto(lottoMachine.getAmount(), lottoMachine.releaseLotto());
    }

    private void matchLotto() {
        lottoMachine.matchLotto();
    }

    private void printResult(){
        outputView.printWin(lottoMachine.calculateWinCount());
        outputView.printProfit(lottoMachine.calculateProfit());
    }

    // 1. 반환값이 있는 경우 (Supplier)
    private <T> T retryUntilValid(java.util.function.Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    // 2. 반환값이 없는 경우 (Runnable) - ★ 이거 필수 추가
    private void retryUntilValid(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}