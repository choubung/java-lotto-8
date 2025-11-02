package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();
    private int lottoCount; // 구매 개수

    public LottoMachine() {
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void BuyLotto() {
        try {
            int amount = Integer.parseInt(Console.readLine());

            validatePurchaseAmount(amount);

            setLottoCount(amount / LOTTO_PRICE);
            System.out.println(getLottoCount() + "개를 구매했습니다.");
            ReleaseLotto(getLottoCount());

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
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);

            String lottoStr = lotto.toString();
            System.out.println(lottoStr);
        }
    }
}
