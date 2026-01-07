package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern LOTTO_NUM_PATTERN = Pattern.compile("([0-9]+)\\,([0-9]+)\\,([0-9]+)\\,([0-9]+)\\,([0-9]+)\\,([0-9]+)");

    public static List<Integer> parse(String input) {
        List<Integer> nums = new ArrayList<>();
        Matcher matcher = LOTTO_NUM_PATTERN.matcher(input);

        if (matcher.matches()) {
            try {
                for (int i = 1; i < 7; i++ ){
                    nums.add(Integer.parseInt(matcher.group(i).trim()));
                }

                return nums;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
            }
        }
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }
}