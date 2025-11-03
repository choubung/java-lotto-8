package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class WinningSystemManager {
    private final LottoCalculator calculator = new LottoCalculator();

    private final LottoRank[] ranksToPrint = new LottoRank[]{
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD,
            LottoRank.SECOND, LottoRank.FIRST
    };
    private WinningLotto winningLotto;


    public void saveWinningLotto() {
        readWinLottoNumbers();
        readBouns();
    }

    public void printLottoResult(LottoMachine lottoMachine) {
        calculator.calculateResult(lottoMachine.getLottos(), winningLotto); // 당첨 결과 계산
        calculator.calculateProfit(lottoMachine.getTotalAmount()); // 수익률 계산
        printWinningStatistics(); // 탕첨 통계 출력
    }

    private void readWinLottoNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String[] winningNumsStr = Console.readLine().split(",");

                validateWinningNumsStr(winningNumsStr);
                List<Integer> winningNumbers = convertStringsToNumbers(winningNumsStr);

                winningLotto = new WinningLotto(winningNumbers, 0);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readBouns() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonus = Integer.parseInt(Console.readLine());

                winningLotto.setBonusNumber(bonus);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 정수여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printWinningStatistics() {
        Map<LottoRank, Integer> rankCounts = calculator.getRankCounts();
        double profit = calculator.getProfitRate();

        System.out.println("당첨 통계\n---");

        for (LottoRank rank : ranksToPrint) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
        }

        String profitRate = String.format("%.1f", profit);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private void validateWinningNumsStr(String[] winningNumbersStr) {
        for (String numberStr : winningNumbersStr) {
            int number;
            try {
                number = Integer.parseInt(numberStr.trim());

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] ,를 구분자로 가지는 숫자만 입력해야 합니다.");
            }
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위의 번호여야 합니다.");
            }
        }
    }

    private ArrayList<Integer> convertStringsToNumbers(String[] numbersStr) {
        return (ArrayList<Integer>) Arrays.stream(numbersStr)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
