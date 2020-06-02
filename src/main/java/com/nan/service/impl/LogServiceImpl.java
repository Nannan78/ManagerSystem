package com.nan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nan.log.Log;
import com.nan.log.LogDao;
import com.nan.log.LogDao;
import com.nan.service.LogService;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Log)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 18:06:18
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;




    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Log queryById(Integer id) {
        return this.logDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<Log> queryAllByLimit(int offset, int limit) {

        PageHelper.startPage(offset, limit);
        List<Log> logs = logDao.queryAll();
        PageInfo pageInfo = new PageInfo(logs);

        return pageInfo;
    }
    @Override
    public PageInfo<Log> queryAllByLimit(int count) {

        PageHelper.startPage(1, count);
        List<Log> logs = logDao.queryAll();
        PageInfo pageInfo = new PageInfo(logs);

        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log insert(Log log) {
        this.logDao.insert(log);
        return log;
    }

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log update(Log log) {
        this.logDao.update(log);
        return this.queryById(log.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.logDao.deleteById(id) > 0;
    }
}
