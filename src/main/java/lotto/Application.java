package lotto;

import lotto.controller.MainController;
import lotto.service.LottoCalculator;
import lotto.service.LottoMachine;
import lotto.utils.LottoMaker;

public class Application {
    public static void main(String[] args) {
        LottoMaker lottoMaker = new LottoMaker();
        LottoMachine lottoMachine = new LottoMachine(lottoMaker);
        MainController controller = new MainController(lottoMachine);

        controller.run();
    }
}