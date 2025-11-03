package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        WinningLottoManager winningLottoManager = new WinningLottoManager();

        machine.BuyLotto(); // 로또 구매
        winningLottoManager.saveWinningLotto(); // 당첨 번호 입력 받아 저장
        winningLottoManager.printLottoResult(machine); // 당첨 결과 출력
    }
}



