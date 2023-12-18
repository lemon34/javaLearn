package analysis.pattern.range.test;

import analysis.pattern.range.Range;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fuhailong
 * @Description TODO fhl
 * @Date 2023/12/17 17:01
 **/


public class TestService {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Range<Date> range_1 = new Range<>();
        range_1.setLower(sdf.parse("2023-12-17"));
        range_1.setUpper(sdf.parse("2023-12-19"));
        Range<Date> range_2 = new Range<>(sdf.parse("2023-12-25"), sdf.parse("2023-12-20"));
        final boolean lowerInclusive = range_1.isLowerInclusive(sdf.parse("2023-12-18"));
        System.out.println(lowerInclusive);


        Range<Long> range_3 = new Range<>(20L, 10L);
        final boolean lowerInclusive1 = range_3.isLowerInclusive(15L);
        System.out.println(lowerInclusive1);

        Range<Long> range_4 = new Range<>(20L, 10L);
    }


}
