package analysis.pattern.range;

import lombok.Data;

import java.util.Date;

/**
 * @author fuhailong
 * @Description 年龄段
 * @Date 2023/12/12 20:02
 **/

@Data
public class AgeBand {

    private Date upper;

    private Date lower;

}
