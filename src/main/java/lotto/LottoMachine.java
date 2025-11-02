package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public void BuyLotto() {
        try {
            int amount = Integer.parseInt(Console.readLine());

            validatePurchaseAmount(amount);

            int lottoCount = amount / LOTTO_PRICE;
            System.out.println(lottoCount + "개를 구매했습니다.");
            ReleaseLotto(lottoCount);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수여야 합니다.");
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000의 배수여야 합니다.");
        }
    }

    public void ReleaseLotto(int lottoCount) {
        while (lottoCount-- > 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));

            String lottoStr = lottos.toString();
            System.out.println(lottoStr);
        }
    }
}
