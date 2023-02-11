package com.twelvet.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.twelvet.domain.PageDomain;
import com.twelvet.domain.TableDataInfo;
import com.twelvet.domain.TableSupport;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 分页基础控制器
 */
public class PageUtils {

    /**
     * 注入分页信息
     */
    public static void startPage() {
        // 清除分页bug
        PageHelper.clearPage();
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer page = pageDomain.getCurrent();
        Integer pageSize = pageDomain.getPageSize();
        if (page != null && pageSize != null) {
            String orderBy = SqlUtils.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(page, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     *
     * @param list 数据列表
     * @return 适应Json
     */
    public static TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRecords(list);
        PageInfo<?> pageInfo = new PageInfo<>(list);
        rspData.setTotal(pageInfo.getTotal());
        return rspData;
    }

}
