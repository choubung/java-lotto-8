package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printLotto(int cnt, List<Lotto> lottos){
        System.out.println(""+cnt+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" +
                    lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", ")) +
                    "]"
            );

        }
        System.out.println();
    }

    public void printWin(Map<LottoInfo, Integer> win) {
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + win.get(LottoInfo.FIFTH) + "개\n" +
                "4개 일치 (50,000원) - " + win.get(LottoInfo.FOURTH) + "개\n" +
                "5개 일치 (1,500,000원) - "+ win.get(LottoInfo.THIRD) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+ win.get(LottoInfo.SECOND) +"개\n" +
                "6개 일치 (2,000,000,000원) - "+ win.get(LottoInfo.FIRST) +"개");

    }

    public void printProfit(Double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) +"%입니다.");
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
