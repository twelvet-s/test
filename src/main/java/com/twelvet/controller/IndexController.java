package com.twelvet.controller;

import com.twelvet.domain.JsonResult;
import com.twelvet.domain.SysLoginInfo;
import com.twelvet.domain.TableDataInfo;
import com.twelvet.mapper.SysLoginInfoMapper;
import com.twelvet.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 增加数据
     * @return 操作结果
     */
    @PostMapping
    public JsonResult<String> add(@RequestBody SysLoginInfo sysLoginInfo) {
        sysLoginInfoMapper.insertLoginInfo(sysLoginInfo);
        return JsonResult.success();
    }

    /**
     * 批量删除日志
     * @param infoIds 日志Id list
     * @return 操作结果
     */
    @DeleteMapping("/{infoIds}")
    public JsonResult<String> remove(@PathVariable Long[] infoIds) {
        sysLoginInfoMapper.deleteLoginInfoByIds(infoIds);
        return JsonResult.success();
    }

    /**
     * 修改日志
     * @return 操作结果
     */
    @PutMapping
    public JsonResult<String> update(@RequestBody SysLoginInfo sysLoginInfo) {
        sysLoginInfoMapper.updateLoginInfo(sysLoginInfo);
        return JsonResult.success();
    }

    @GetMapping
    public JsonResult<TableDataInfo> index(SysLoginInfo sysLoginInfo) {
        PageUtils.startPage();
        List<SysLoginInfo> list = sysLoginInfoMapper.selectLoginInfoList(sysLoginInfo);
        return JsonResult.success(PageUtils.getDataTable(list));
    }

}
