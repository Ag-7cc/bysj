package com.vic.bysj.core.mall.dal.bean;


import com.vic.bysj.core.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 分页对象
 * Created by vic
 * Create time : 2017/2/5 下午2:52
 */

public class Page<T> {

    /**
     * 默认每页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 排序 - 升序
     */
    public static final String ASC = "asc";
    /**
     * 排序 - 升序
     */
    public static final String DESC = "desc";

    /**
     * 第几页.默认从第一页开始
     */
    private int pageNo = 1;
    /**
     * 每页条数
     */
    private int size = DEFAULT_PAGE_SIZE;
    /**
     * 排序的顺序
     */
    private String orderBy;
    /**
     * 排序的属性
     */
    private String order = null;
    /**
     * 当前页从第几条开始
     */
    private int index = -1;
    /**
     * 结果集
     */
    private List<T> result = Collections.emptyList();
    /**
     * 总条数
     */
    private long total = -1;
    /**
     * 过滤条件集合
     */
    protected LinkedHashMap<String, Object> filter = new LinkedHashMap<>();

    //-- 构造函数 --//

    /**
     * 分页对象
     */
    public Page() {
    }

    /**
     * 分页对象
     *
     * @param pageSize 每页条数
     */
    public Page(int pageSize) {
        this.size = pageSize;
    }

    //-- 分页参数访问函数 --//

    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    /**
     * 返回Page对象自身的setPageNo函数,可用于连续设置。
     */
    public Page<T> pageNo(final int thePageNo) {
        setPageNo(thePageNo);
        return this;
    }

    /**
     * 获得每页的记录数量, 默认为-1.
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置每页的记录数量.
     */
    public void setSize(final int size) {
        this.size = size;
    }

    /**
     * 返回Page对象自身的setPageSize函数,可用于连续设置。
     */
    public Page<T> pageSize(final int thePageSize) {
        setSize(thePageSize);
        return this;
    }

    /**
     * @return 当前页记录开始位置
     */
    public int getIndex() {
        return index == -1 ? (pageNo - 1) * size : index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 获得排序字段,无默认值. 多个排序字段时用','分隔.
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置排序字段,多个排序字段时用','分隔.
     */
    public void setOrderBy(final String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 返回Page对象自身的setOrderBy函数,可用于连续设置。
     */
    public Page<T> orderBy(final String theOrderBy) {
        setOrderBy(theOrderBy);
        return this;
    }

    //-- 访问查询结果函数 --//

    /**
     * 获得页内的记录列表.
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * 设置页内的记录列表.
     */
    public void setResult(final List<T> result) {
        this.result = result;
    }

    /**
     * 获得总记录数, 默认值为-1.
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置总记录数.
     */
    public void setTotal(final long total) {
        this.total = total;
    }

    /**
     * 根据pageSize与totalCount计算总页数, 默认值为-1.
     */
    public long getTotalPages() {
        if (total < 0) {
            return -1;
        }

        long count = total / size;
        if (total % size > 0) {
            count++;
        }
        return count;
    }

    /**
     * 是否还有下一页.
     */
    public boolean isHasNext() {
        return (pageNo + 1 <= getTotalPages());
    }

    /**
     * 取得下页的页号, 序号从1开始.
     * 当前页为尾页时仍返回尾页序号.
     */
    public int getNextPage() {
        if (isHasNext()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
    }

    /**
     * 是否还有上一页.
     */
    public boolean isHasPre() {
        return (pageNo - 1 >= 1);
    }

    /**
     * 取得上页的页号, 序号从1开始.
     * 当前页为首页时返回首页序号.
     */
    public int getPrePage() {
        if (isHasPre()) {
            return pageNo - 1;
        } else {
            return pageNo;
        }
    }

    /**
     * @return 过滤条件集合
     */
    public LinkedHashMap<String, Object> getFilter() {
        return filter;
    }

    /**
     * 设置过滤条件集合
     *
     * @param filter 过滤条件集合
     */
    public void setFilter(LinkedHashMap<String, Object> filter) {
        this.filter = filter;
    }


    public String getOrder() {
        return order;
    }

    public void setOrder(final String order) {
        this.order = order;
    }

    /**
     * 将过滤条件里的对应的key转换成int型。若无法转换，则移除
     *
     * @param key 过滤条件里的key
     */
    public void convertInt(String key) {
        Object valueObj = filter.get(key);
        if (valueObj == null) {
            return;
        }
        if (valueObj instanceof Integer) {
            return;
        }
        String value = (String) valueObj;
        if (NumberUtils.isNumber(value)) {
            filter.put(key, Integer.valueOf(value));
        } else {
            filter.remove(key);
        }
    }

    /**
     * 将过滤条件里的对应的key转换成int型。若无法转换，则移除
     *
     * @param keys 过滤条件里的key数组
     */
    public void convertInt(String... keys) {
        if (keys.length > 0) {
            for (String key : keys) {
                convertInt(key);
            }
        }
    }

    /**
     * 将字符串转换成int数组
     *
     * @param key
     */
    public void convertIntArray(String key) {
        Object valueObj = filter.get(key);
        if (valueObj == null || "".equals(valueObj) || "null".equals(valueObj)) {
            filter.remove(key);
            return;
        }
        String value = (String) valueObj;
        value = value.trim();
        String str[] = value.split(",");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            set.add(Integer.parseInt(str[i]));
        }
        if (set.size() > 0) {
            filter.put(key, set);
        } else {
            filter.remove(key);
        }
    }

    /**
     * 将过滤条件里的对应的key转换成long型。若无法转换，则移除
     *
     * @param key 过滤条件里的key
     */
    public void convertLong(String key) {
        String value = (String) filter.remove(key);
        if (NumberUtils.isNumber(value)) {
            filter.put(key, Long.valueOf(value));
        }
    }

    public void convertDate(String... keys) {
        if (keys.length > 0) {
            for (String key : keys) {
                convertDate(key);
            }
        }
    }

    /**
     * 将过滤条件里的对应的key转换成Date型。若无法转换，则移除
     * format: yyyy-MM-dd HH:mm:ss
     *
     * @param key 过滤条件里的key
     */
    public void convertDate(String key) {
        String value = (String) filter.remove(key);
        if (value == null) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            filter.put(key, sdf.parse(value));
        } catch (Exception ignore) {

        }
    }

    /**
     * 将过滤条件里的对应的key转换成Date型。若无法转换，则移除
     * format: yyyy-MM-dd
     *
     * @param key 过滤条件里的key
     */
    public void convertDate2(String key) {
        String value = (String) filter.remove(key);
        if (value == null) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            filter.put(key, sdf.parse(value));
        } catch (Exception ignore) {
        }
    }

    /**
     * 将过滤条件里的对应的key转换成Date型。若无法转换，则移除
     * format: yyyy-MM-dd
     *
     * @param keys 过滤条件里的key
     */
    public void convertDate3(String... keys) {
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                String value = (String) filter.remove(key);
                if (value == null) {
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    filter.put(key, sdf.parse(value));
                } catch (Exception ignore) {
                }
            }
        }
    }

    /**
     * 将过滤条件里的对应的key转换成Date型。若无法转换，则移除
     * format: yyyy/MM/dd HH:mm:ss
     *
     * @param keys 过滤条件里的key
     */
    public void convertDate4(String... keys) {
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                String value = (String) filter.remove(key);
                if (value == null) {
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                try {
                    filter.put(key, sdf.parse(value));
                } catch (Exception ignore) {
                }
            }
        }
    }

    /**
     * 将过滤条件里的对应的key转换成Boolean型。若无法转换，则移除
     */
    public void convertBoolean(String key) {
        String value = (String) filter.remove(key);
        if (!StringUtils.isBlank(value)) {
            return;
        }
        try {
            Boolean bool = Boolean.valueOf(value);
            filter.put(key, bool);
        } catch (Exception ignore) {
        }
    }

    public void convertBoolean(String... keys) {
        if (keys.length > 0) {
            for (String key : keys) {
                convertBoolean(key);
            }
        }
    }

    /**
     * 转换数据为double
     *
     * @param keys
     */
    public void convertDouble(String... keys) {
        if (keys.length > 0) {
            for (String key : keys) {
                convertDouble(key);
            }
        }
    }

    public void convertDouble(String key) {
        String value = (String) filter.remove(key);
        if (!StringUtils.isBlank(value)) {
            return;
        }
        try {
            if (NumberUtils.isNumber(value)) {
                Double d = Double.valueOf(value);
                filter.put(key, d);
            }
        } catch (Exception ignore) {
        }
    }

    public void convertDateStr(String pattern, String... keys) {
        for (String key : keys) {
            if (filter.containsKey(key)) {
                filter.put(key, DateUtil.format((Date) filter.get(key), pattern));
            }
        }
    }

    /**
     * 手动分页
     *
     * @param list
     */
    public void manualPaging(List<T> list) {
        //分页
        this.setTotal(list.size());
        List<T> list1 = new ArrayList<>();
        for (int i = 1; i <= this.getSize(); i++) {
            if (this.getIndex() + i > this.getTotal()) {
                break;
            }
            list1.add(list.get(this.getIndex() + i - 1));
        }
        this.setResult(list1);
    }

    /**
     * 将过滤条件里的对应的key转换成Date型。若无法转换，则按Date.toString方法的值转换
     * format: yyyy-MM-dd HH:mm:ss
     */
    public void convertDateNew(String... keys) {
        if (keys.length > 0) {
            for (String key : keys) {
                String value = (String) filter.remove(key);
                if (value == null) {
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    filter.put(key, sdf.parse(value));
                } catch (Exception ignore) {
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                    try {
                        filter.put(key, formatter.parse(value));
                    } catch (ParseException e) {
                    }
                }
            }
        }
    }

    /**
     * 将过滤条件里的对应的key转换成Date型。若无法转换，则按Date.toString方法的值转换
     * format: yyyy-MM-dd
     *
     * @param keys 过滤条件里的key
     */
    public void convertDateNew3(String... keys) {
        if (keys != null && keys.length > 0) {
            for (String key : keys) {
                String value = (String) filter.remove(key);
                if (value == null) {
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    filter.put(key, sdf.parse(value));
                } catch (Exception ignore) {
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                    try {
                        filter.put(key, formatter.parse(value));
                    } catch (ParseException e) {
                    }
                }
            }
        }
    }

}
