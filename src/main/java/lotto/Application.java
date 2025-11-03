package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        WinningLottoManager winningLottoManager = new WinningLottoManager();

        machine.BuyLotto();

        System.out.println("당첨번호를 입력해 주세요.");
        winningLottoManager.saveWinningLotto();

        winningLottoManager.printLottoResult(machine);
    }
}



