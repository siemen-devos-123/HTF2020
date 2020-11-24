package domain;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ChallengeSolver {
    private Challenge challenge;

    public ChallengeSolver(Challenge challenge) {
        this.challenge = challenge;
    }

    public List<Integer> findAllPrimes(int begin, int end) {
        List<Integer> primes = new LinkedList<>();
        for (int i = begin; i <= end; i++) {
            if (i == 1 || i== 0) {
                continue;
            }

            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public String Convert2HexaDecimal(String string) {
        char[] chars = string.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            int i = (int) c;
            builder.append(Integer.toHexString(i)).append(" ");
        }

        return builder.toString().trim();
    }

    public String getElementOfHashmap(String index, HashMap hashMap) {
        return hashMap.get(index).toString();
    }

    public String  isDisariumNumber(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        int len = inputNumber.length();

        int numberCopy = number;

        int sum = 0;

        while (number > 0)
        {
            int lastDigit = number % 10;

            sum = sum + (int) Math.pow(lastDigit, len);

            number = number / 10;

            len--;
        }

        if (sum == numberCopy)
        {
            return "Y";
        }
        else
        {
            return "N";
        }
    }

    public String reverseString(String string) {
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        return builder.reverse().toString();
    }

    public String getFirstAndLastdayOfMonth(String month, String year) {
        int m = Integer.parseInt(month);
        int y = Integer.parseInt(year);

        YearMonth ym = YearMonth.of(y, m);

        return String.format("%s-%s", ym.atDay(1).getDayOfWeek().name(), ym.atEndOfMonth().getDayOfWeek().name());
    }

    public String isInAlphabeticOrder(String string) {
        for (int i = 0; i != string.length(); ++i) {
            if (!Character.isLetter(string.charAt(i))) {
                return "N";
            }
        }
        return "Y";
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
