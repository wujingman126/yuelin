package co.yixiang.modules.shop.web.param;

import co.yixiang.common.web.param.QueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商家管理表 添加参数对象
 * </p>
 *
 * @author wuyun
 * @date 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MerchantSaveParam对象", description = "商家管理表添加参数")
public class YxSystemStoreSaveParam extends QueryParam {
    private static final long serialVersionUID = 1L;

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称", required = true)
    private String name;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介", required = true)
    private String introduction;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址", required = true)
    private String address;

    /**
     * 商家logo
     */
    @ApiModelProperty(value = "门店logo", required = true)
    private String image;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度", required = true)
    private String latitude;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度", required = true)
    private String longitude;

}
