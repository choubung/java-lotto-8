package lotto;

public class Application {
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        WinningSystemManager winningLottoManager = new WinningSystemManager();

        machine.BuyLotto(); // 로또 구매
        winningLottoManager.saveWinningLotto(); // 당첨 번호 입력 받아 저장
        winningLottoManager.printLottoResult(machine); // 당첨 결과 출력
    }
}



