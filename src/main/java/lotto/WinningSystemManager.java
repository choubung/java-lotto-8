package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class WinningSystemManager {
    private double profit;
    private WinningLotto winningLotto;
    private Map<LottoRank, Integer> rankCounts = new HashMap<LottoRank, Integer>();
    private LottoRank[] ranksToPrint = new LottoRank[]{
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD,
            LottoRank.SECOND, LottoRank.FIRST
    };

    public void saveWinningLotto() {
        readWinLottoNumbers();
        readBouns();
    }

    public void printLottoResult(LottoMachine lottoMachine) {
        calculateResult(lottoMachine.getLottos()); // 당첨 결과 계산
        calculateProfit(lottoMachine.getTotalAmount()); // 수익률 계산
        printWinningStatistics(); // 탕첨 통계 출력
    }

    private void readWinLottoNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String winningNumsStr = Console.readLine();
                List<Integer> winningNumbers = validatedWinningNumsStr(winningNumsStr.split(","));

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

                validateBonus(bonus);
                winningLotto.setBonusNumber(bonus);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 정수여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> targetNumbers = lotto.getNumbers();
            List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

            int matchCount = (int) targetNumbers.stream().filter(winningNumbers::contains).count();
            boolean hasBonus = targetNumbers.contains(winningLotto.getBonusNumber());

            LottoRank rank = LottoRank.valueOf(matchCount, hasBonus);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private void calculateProfit(int totalAmount) {
        double winningAmount = 0.0;

        for (LottoRank rank : ranksToPrint) {
            winningAmount += rankCounts.getOrDefault(rank, 0) * rank.getPrizeMoney();
        }

        profit = winningAmount / totalAmount * 100;
    }

    private void printWinningStatistics() {
        System.out.println("당첨 통계\n---");

        for (LottoRank rank : ranksToPrint) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
        }

        String profitRate = String.format("%.1f", profit);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private ArrayList<Integer> validatedWinningNumsStr(String[] winningNumbersStr) {
        for (String numberStr : winningNumbersStr) {
            try {
                int number = Integer.parseInt(numberStr.trim());

                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위의 번호여야 합니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] ,를 구분자로 가지는 숫자만 입력해야 합니다.");
            }
        }

        return (ArrayList<Integer>) Arrays.stream(winningNumbersStr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위의 번호여야 합니다.");
        }

        if (winningLotto.getLotto().getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 겹치지 않는 번호여야 합니다.");
        }
    }
}
