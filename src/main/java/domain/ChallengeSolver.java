package domain;

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

    private boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
