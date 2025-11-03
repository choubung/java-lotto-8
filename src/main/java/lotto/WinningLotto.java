package lotto;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto() {
    }

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위의 번호여야 합니다.");
        }

        if (lotto != null && lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 겹치지 않는 번호여야 합니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
