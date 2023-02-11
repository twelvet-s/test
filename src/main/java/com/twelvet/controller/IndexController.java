package com.twelvet.controller;

import com.twelvet.domain.JsonResult;
import com.twelvet.domain.SysLoginInfo;
import com.twelvet.domain.TableDataInfo;
import com.twelvet.mapper.SysLoginInfoMapper;
import com.twelvet.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description:
 */
@RestController
public class IndexController {

    @Autowired
    private SysLoginInfoMapper sysLoginInfoMapper;

    @GetMapping
    public JsonResult<TableDataInfo> index(SysLoginInfo sysLoginInfo) {
        PageUtils.startPage();
        List<SysLoginInfo> list = sysLoginInfoMapper.selectLoginInfoList(sysLoginInfo);
        return JsonResult.success(PageUtils.getDataTable(list));
    }

}
