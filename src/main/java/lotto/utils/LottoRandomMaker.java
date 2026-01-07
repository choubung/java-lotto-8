package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoRandomMaker implements LottoMaker{
    public List<Integer> releaseLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }
}
