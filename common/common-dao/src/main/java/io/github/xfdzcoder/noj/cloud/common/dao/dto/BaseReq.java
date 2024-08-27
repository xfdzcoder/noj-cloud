package io.github.xfdzcoder.noj.cloud.common.dao.dto;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author xfdzcoder
 */
public interface BaseReq<Entity> {

    default Entity toEntity() {
        return BeanUtil.copyProperties(this, getEntityClass());
    }

    Class<Entity> getEntityClass();

    interface Save {

    }

    interface Update {

    }

    interface Condition {

    }

    interface Delete {

    }
}
