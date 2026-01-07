package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCalculator {
    private final Lotto lotto;
    private final int bonus;
    private List<LottoInfo> winResult = new ArrayList<>();

    public LottoCalculator(List<Integer> numbers, int bonus) {
        this.lotto = new Lotto(numbers);
        validateDuplicate(numbers, bonus);
        validateInRange(bonus);
        this.bonus = bonus;
    }

    public void matchAndSave(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        winResult.add(LottoInfo.from(correctCount(numbers), numbers.contains(bonus)));
    }

    private int correctCount(List<Integer> numbers) {
        HashSet<Integer> winNumbers = new HashSet<>(lotto.getNumbers());
        HashSet<Integer> userNumbers = new HashSet<>(numbers);

        userNumbers.retainAll(winNumbers);

        return userNumbers.size();
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
