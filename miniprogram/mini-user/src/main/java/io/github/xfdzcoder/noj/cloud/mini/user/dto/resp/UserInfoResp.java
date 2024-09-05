package io.github.xfdzcoder.noj.cloud.mini.user.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResp {

    private Long id;

    @Schema(description = "微信小程序的 openid")
    private String openid;

    @Schema(description = "微信开放平台的 unionid")
    private String unionid;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "社群信息 ID，可以绑定多个，用英文逗号分隔")
    private String communityInfoIds;


    public static IPage<UserInfoResp> toResp(IPage<UserInfo> page) {
        List<UserInfoResp> respList = BeanUtil.copyToList(page.getRecords(), UserInfoResp.class);
        IPage<UserInfoResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }

    public static UserInfoResp toResp(UserInfo userInfo) {
        return BeanUtil.copyProperties(userInfo, UserInfoResp.class);
    }
}
