package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author xfdzcoder
 */

@Data
public class Heatmap {

    private LocalDate date;

    private Integer count;

}
