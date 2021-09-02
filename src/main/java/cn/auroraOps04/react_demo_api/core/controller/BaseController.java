package cn.auroraOps04.react_demo_api.core.controller;

import cn.auroraOps04.react_demo_api.core.page.PageDomain;
import cn.auroraOps04.react_demo_api.core.page.TableSupport;
import cn.auroraOps04.react_demo_api.entity.response.ApiPageResponse;
import cn.auroraOps04.react_demo_api.entity.response.ApiResponseCode;
import cn.auroraOps04.react_demo_api.utils.SqlUtil;
import cn.auroraOps04.react_demo_api.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-09-02 09:55:07
 * @description 基础Controller
 */

public class BaseController {
    protected final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected ApiPageResponse getPageData(List<?> data){
        return new ApiPageResponse(
                ApiResponseCode.SUCCESS.getCode(),
                true,
                ApiResponseCode.SUCCESS.getMessage(),
                data,
                new PageInfo<>(data).getTotal()
        );
    }
}
