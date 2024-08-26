package io.github.xfdzcoder.noj.cloud.common.dao.dto.condition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.entity.BaseEntity;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public abstract class BaseCondition<Entity extends BaseEntity> {

    /**
     * 当前页码
     */
    private Integer current = 1;

    /**
     * 页面大小
     */
    private Integer size = 10;

    public Page<Entity> getPage() {
        return Page.of(current, size);
    }

    public LambdaQueryWrapper<Entity> getLambdaQueryWrapper() {
        return new LambdaQueryWrapper<>();
    }

    public QueryWrapper<Entity> getQueryWrapper() {
        return new QueryWrapper<>();
    }
}
