package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();
    private int totalAmount = 0; // 구매 금액

    public LottoMachine() {
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        if (totalAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000의 배수여야 합니다.");
        }

        this.totalAmount = totalAmount;
    }

    public void BuyLotto() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine());

                setTotalAmount(amount);
                ReleaseLotto();

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구매 금액은 정수여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void ReleaseLotto() {
        int lottoCount = getTotalAmount() / LOTTO_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");

        while (lottoCount-- > 0) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);

            String lottoStr = lotto.toString();
            System.out.println(lottoStr);
        }
    }
}
