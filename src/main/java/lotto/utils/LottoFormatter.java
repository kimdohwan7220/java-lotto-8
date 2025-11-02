package lotto.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class LottoFormatter {
    private static final String PROFIT_PATTERN = "#,###.0";
    public static final NumberFormat PROFIT_FORMAT = new DecimalFormat(PROFIT_PATTERN);

    private LottoFormatter() {}
}
