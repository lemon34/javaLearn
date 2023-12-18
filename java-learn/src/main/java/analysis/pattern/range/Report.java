package analysis.pattern.range;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author fuhailong
 * @Description  报告类，其中报告中存在年龄段，用于介绍不同年龄段相关的调查结果
 * @Date 2023/12/12 20:03
 **/

@Data
public class Report {

    private List<AgeBand> ageBandList;

    private List<Range<Date>> rangeList;
}
