package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.utils.LottoFormatter;
import lotto.utils.ViewMessage;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println();
        printPurchaseCount(purchasedLottos.size());
        printLottoNumbers(purchasedLottos);
    }

    private static void printPurchaseCount(int count) {
        System.out.println(String.format(
                ViewMessage.PURCHASE_COUNT_OUTPUT.getMessage(), count));
    }

    private static void printLottoNumbers(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            List<Integer> sortedNumbers = lotto.getNumbers().stream()
                    .sorted()
                    .toList();
            System.out.println(sortedNumbers);
        }
    }

    public static void printStatistics(LottoResult lottoResult) {
        printResultHeader();
        printRankStatistics(lottoResult.getRankCounts());
        printProfitRate(lottoResult.calculateProfitRate());
    }

    private static void printResultHeader() {
        System.out.println();
        System.out.println(ViewMessage.RESULT_OUTPUT.getMessage());
        System.out.println(ViewMessage.RESULT_SEPARATOR.getMessage());
    }

    private static void printRankStatistics(Map<LottoRank, Integer> rankCounts) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NONE)
                .sorted((a, b) -> Integer.compare(a.getMatchCount(), b.getMatchCount()))
                .forEach(rank -> System.out.println(formatRankStatus(rank, rankCounts.get(rank))));
    }

    private static String formatRankStatus(LottoRank rank, int count) {
        String matchText = String.format(ViewMessage.MATCH_COUNT_OUTPUT.getMessage(), rank.getMatchCount());
        if (rank == LottoRank.SECOND) {
            matchText += ViewMessage.BONUS_MATCH.getMessage();
        }

        String prizeCountText = String.format(ViewMessage.PRIZE_COUNT_OUTPUT.getMessage(),
                String.format("%,d", rank.getPrize()),
                count);

        return matchText + prizeCountText;
    }

    private static void printProfitRate(double profitRate) {
        String formattedRate = LottoFormatter.PROFIT_FORMAT.format(profitRate);
        System.out.printf(ViewMessage.PROFITRATE_OUTPUT.getMessage() + "%n", formattedRate);
    }

}
