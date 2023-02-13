package com.twelvet.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.twelvet.domain.SysLoginInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 系统操作/访问日志
 */
@Mapper
public interface SysLoginInfoMapper {

	/**
	 * 查询系统登录日志集合
	 * @param loginInfo 访问日志对象
	 * @return 登录记录集合
	 */
	@DS("shardingSphere")
	List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo);

	/**
	 * 查询系统登录日志集合
	 * @param loginInfo 访问日志对象
	 * @return 登录记录集合
	 */

	List<SysLoginInfo> selectLoginInfoList2(SysLoginInfo loginInfo);

	/**
	 * 批量删除系统登录日志
	 * @param infoIds 需要删除的登录日志ID
	 * @return 结果
	 */
	int deleteLoginInfoByIds(Long[] infoIds);

	/**
	 * 新增系统登录日志
	 * @param loginInfo SysLoginInfo
	 * @return 主键
	 */
	int insertLoginInfo(SysLoginInfo loginInfo);

	/**
	 * 修改系统登录日志
	 * @param loginInfo SysLoginInfo
	 * @return 结果
	 */
	int updateLoginInfo(SysLoginInfo loginInfo);

}
