package lotto;

import lotto.controller.MainController;
import lotto.service.LottoMachine;
import lotto.utils.LottoRandomMaker;

public class Application {
    public static void main(String[] args) {
        LottoRandomMaker lottoRandomMaker = new LottoRandomMaker();
        LottoMachine lottoMachine = new LottoMachine(lottoRandomMaker);
        MainController controller = new MainController(lottoMachine);

        controller.run();
    }
}