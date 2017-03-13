package com.makervt.core.service;

import java.util.ArrayList;
import java.util.List;

import com.makervt.core.domain.Page;
import com.makervt.core.util.GenericsUtils;

/**
 * Service层的父类，需要进行分页需要继承该类，并且传入相应的实体类，在一般系统中service曾作为spring事务处理类，
 * 其中对特殊命名的方法进行不同级别的事务处理
 * <p>
 * example:
 * <pre>
 * public class SyscodeService extends BaseService{@code<}Syscode>{
 * 	{@code @}Override
 * 	public Integer count(Syscode entity) {
 * 		return syscodeDao.count(entity);
 * 	}
 * 	{@code @}Override
 * 	public List{@code <}Syscode> select(Syscode entity) {
 * 		return syscodeDao.listConfSyscode(entity);
 * 	}
 * }
 * </pre>
 * @since JDK1.6
 * @version 1.0.0
 * @author core 2013-10-18 上午9:11:40
 * @see Page
 */
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public abstract class BaseService<T extends Page> {

	protected Class<T> entityClass;

	public BaseService() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 获取实体类对象实例
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 上午9:32:35
	 * @return {@link Class}
	 */
	protected Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * 数据库分页查询，其中默认进行{@link #count(Page)}处理，并遵循{@link Page}计算页数等信息，
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 上午9:20:15
	 * @see #count(Page)
	 * @see #select(Page)
	 * @param entity
	 *            数据库需要分页的实体
	 * @return {@link Page}
	 */
	public Page queryPage(T entity) {
		List list = new ArrayList();
		int pageSize = entity.getPageSize();
		int pageNo = entity.getPageNo()-1;
		Page page = new Page();
		// 计算总数
		Integer totalCount = this.count(entity); // 待修改
		if (totalCount.intValue() == 0) {
			page.setResult(list);
			page.setTotalCount(0);
			return page;
		}
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setPageNo(entity.getPageNo());
		int totalPageCount = 0;
		int startIndex = 0;
		// 如果pageSize小于0,则返回所有数据,等同于getAll
		if (pageSize > 0) {

			// 计算页数
			totalPageCount = (totalCount / pageSize);
			totalPageCount += ((totalCount % pageSize) > 0) ? 1 : 0;

			// 计算skip数量
			startIndex = (pageNo) * pageSize;
			entity.setStart(startIndex);
			//entity.setPageNo(pageNo);
			entity.setPageSize(pageSize);
			list = this.selectPage(entity);

		} else {
			list = this.selectPage(entity);
		}
		page.setTotalCount(totalCount);
		page.setPageTotal(totalPageCount);
		page.setResult(list);
		return page;
	}
	
	/**
	 * 数据库分页查询，其中默认进行{@link #count(Page)}处理，并遵循{@link Page}计算页数等信息，
	 * @param count  
	 * @param data
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page getPage(Integer count,List data,int pageSize,int pageNo) {
		List list = new ArrayList();
		Page page = new Page();
		// 计算总数
		Integer totalCount = count; // 待修改
		if (totalCount.intValue() == 0) {
			page.setResult(list);
			page.setTotalCount(0);
			return page;
		}
		page.setTotalCount(totalCount);
		page.setPageNo(pageNo);
		int totalPageCount = 0;
		int startIndex = 0;
		// 如果pageSize小于0,则返回所有数据,等同于getAll
		if (pageSize > 0) {

			// 计算页数
			totalPageCount = (totalCount / pageSize);
			totalPageCount += ((totalCount % pageSize) > 0) ? 1 : 0;

			// 计算skip数量
			if (totalPageCount > (pageNo)) {
				startIndex = (pageNo) * pageSize;
			} else {
				startIndex = (totalPageCount - 1) * pageSize;
			}
		}
		
		page.setPageTotal(totalPageCount);
		page.setResult(data);
		return page;
	}


	/**
	 * 查询数据库表数量抽象方法,当继承了{@link BaseService}类后必须实现此方法
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 上午9:19:05
	 * @param entity
	 *            实体类对象（泛型）
	 * @return {@link Integer}
	 */
	public abstract Integer count(T entity);

	/**
	 * 查询数据库表记录集抽象方法，当继承了{@link BaseService}类后必须实现此方法
	 * 
	 * @version 1.0.0
	 * @author core 2013-10-18 上午9:19:05
	 * @param entity
	 *            实体类对象（泛型）
	 * @return {@link List}
	 */
	public abstract List<T> selectPage(T entity);

}
