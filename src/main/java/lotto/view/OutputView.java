package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printLotto(int cnt, List<Lotto> lotto){

    }

    public void printWin(List<Integer> win) {

    }

    public void printProfit(float profit) {

    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

//    public void printResult(String message) {
//        System.out.println(message);
//    }
//
//    // 리스트 출력 예시
//    public void printList(List<String> results) {
//        results.forEach(System.out::println);
//    }
}
