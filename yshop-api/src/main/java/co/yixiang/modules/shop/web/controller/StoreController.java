/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.yixiang.co
 * 注意：
 * 本软件为www.yixiang.co开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package co.yixiang.modules.shop.web.controller;

import co.yixiang.annotation.AnonymousAccess;
import co.yixiang.aop.log.Log;
import co.yixiang.common.api.ApiResult;
import co.yixiang.common.web.controller.BaseController;
import co.yixiang.common.web.vo.Paging;
import co.yixiang.modules.shop.service.YxSystemStoreService;
import co.yixiang.modules.shop.web.param.YxSystemStoreQueryParam;
import co.yixiang.modules.shop.web.param.YxSystemStoreSaveParam;
import co.yixiang.modules.shop.web.vo.YxSystemStoreQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商家 前端控制器
 * </p>
 *
 * @author wuyun
 * @since 2020-04-03
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/merchant")
@Api(value = "商家模块", tags = "商家:商家模块", description = "商家模块")
public class StoreController extends BaseController {

    private final YxSystemStoreService yxSystemStoreService;


    /**
     * 获取商家详情
     */
    @AnonymousAccess
    @GetMapping("/details/{id}")
    @ApiOperation(value = "商家详情", notes = "商家详情", response = YxSystemStoreQueryVo.class)
    public ApiResult<YxSystemStoreQueryVo> getMerchant(@PathVariable Integer id) throws Exception {
        YxSystemStoreQueryVo yxSystemStoreQueryVo = yxSystemStoreService.getYxSystemStoreById(id);
        return ApiResult.ok(yxSystemStoreQueryVo);
    }

    /**
     * 商家列表
     */
    @AnonymousAccess
    @GetMapping("/list")
    @ApiOperation(value = "商家列表", notes = "商家列表", response = YxSystemStoreQueryVo.class)
    public ApiResult<Paging<YxSystemStoreQueryVo>> getMerchantPageList(YxSystemStoreQueryParam queryParam) throws Exception {
        Paging<YxSystemStoreQueryVo> paging = yxSystemStoreService.getYxSystemStorePageList(queryParam);
        return ApiResult.ok(paging.getRecords());
    }

    /**
     * 添加商家（商家入驻）
     */
    @Log(value = "添加商家", type = 1)
    @PostMapping("/save")
    @ApiOperation(value = "添加商家", notes = "添加商家")
    public ApiResult<Object> MerchantsSave(@Validated @RequestBody YxSystemStoreSaveParam param) {
        if (yxSystemStoreService.merchantsSave(param) > 0) {
            return ApiResult.ok("success");
        }
        return ApiResult.fail("添加失败");
    }

}

