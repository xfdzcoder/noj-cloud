package io.github.xfdzcoder.noj.cloud.mini.community.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 帖子内容表(PostContent)表实体类
 *
 * @author makejava
 * @since 2024-09-10 11:03:37
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("post_content")
public class PostContent extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -43137498037343853L;

    /**
     * 帖子 ID
     */
    @Schema(description = "帖子 ID")
    @TableField("post_info_id")
    private Long postInfoId;
    /**
     * 内容，富文本
     */
    @Schema(description = "内容，富文本")
    @TableField("content")
    private String content;

}

