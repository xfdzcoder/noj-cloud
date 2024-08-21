package io.github.xfdzcoder.noj.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基本实体字段
 *
 * @author xfdzcoder
 */

@Data
public class BaseEntity {


    /**
     * 主键 ID，通过雪花算法生成
     */
    @Schema(description = "y主键 ID，通过雪花算法生成")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;


    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField("create_date_time")
    private LocalDateTime createDateTime;


    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField("update_date_time")
    private LocalDateTime updateDateTime;


    /**
     * 逻辑删除
     */
    @Schema(description = "逻辑删除")
    @TableField("deleted")
    private Integer deleted;

}
