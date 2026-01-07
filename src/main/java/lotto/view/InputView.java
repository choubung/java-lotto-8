package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.utils.Validator;

import java.util.List;

public class InputView {
    public int readCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int cash = Validator.validateAndParseCash(input);
        return cash;
    }

    public List<Integer> readWinLottoNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winLottoNums = Parser.parse(input);

        return winLottoNums;
    }

    public int readWinBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonus = Validator.parseToInt(input);
        return bonus;
    }

//    // 1. 기본 문자열 입력
//    public String readString() {
//        System.out.println("문자열을 입력해 주세요.");
//        String input = Console.readLine();
//        Validator.validateHasText(input);
//        return input;
//    }
//
//    // 2. 숫자 입력 (자동 형변환)
//    public int readNumber() {
//        System.out.println("숫자를 입력해 주세요.");
//        String input = Console.readLine();
//        Validator.validateIsNumeric(input);
//        return Integer.parseInt(input);
//    }
//
//    // 3. 쉼표 구분 입력 (리스트 반환)
//    public List<String> readList() {
//        System.out.println("쉼표로 구분하여 입력해 주세요.");
//        String input = Console.readLine();
//        Validator.validateHasText(input);
//
//        return Arrays.stream(input.split(","))
//                .map(String::trim)
//                .collect(Collectors.toList());
//    }
}
