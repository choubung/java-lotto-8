package lotto.service;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCalculator {
    private Lotto lotto;
    private int bonus;

    public LottoCalculator(List<Integer> numbers, int bonus) {
        this.lotto = new Lotto(numbers);
        validateDuplicate(numbers, bonus);
        validateInRange(bonus);
        this.bonus = bonus;
    }

    public void calculate() {

    }

    private void validateDuplicate(List<Integer> numbers, int num) {
        numbers.add(num);

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
    }

    private void validateInRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }
}
