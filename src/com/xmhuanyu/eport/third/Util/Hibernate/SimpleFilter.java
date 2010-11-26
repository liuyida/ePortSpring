package com.xmhuanyu.eport.third.Util.Hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * 为了简化分页查询的条件参数，写了一个工具类。
 * 前提是，页面的参数命名必须按照一定规则，这个规则是f_dataType_property以及s_sortType_property。
 * f_前缀代表这是一个过滤器(filter)，s_前缀代表这是一个排序器(Sort)。
 * dataType是数据类型，可以写一个枚举来定义这些类型，sortType是排序类型，也可以写一个枚举来定义。
 * 接下来，页面提交到类里面的时候，需要用一个类的静态方法来处理并解析提交的参数。
 * Map<String, String> parametersMap = org.springframework.web.util.WebUtils.getParametersStartingWith(request, prefix);
 * prefix就是前缀，根据f_前缀以及s_前缀，就可以拿到过滤器以及排序器的Map集合
 * 然后，
 * SimpleFilter simpleFilter = new SimpleFilter();
 * for (Map.Entry<String, String> entry : parametersMap.entrySet()) {
 *   // 添加过滤器，这行添加过滤器仅作为一个例子，实际上并不正确，还需要根据dataType来转换value的值类型
 *   // 并且key也有可能需要添加级联处理
 *   simpleFilter.addFilter(entry.getKey(), entry.getValue(), MatchType.EQ);
 * }
 * 最后，只需要xxxDao.findCount(simpleFilter); Collection<xxx> items = xxxDao.find(simpleFilter);
 * 这样就可以得到结果集的数目以及结果集数组
 * 然后可以方便的在页面展示出来。
 * 参考：http://www.javaeye.com/topic/605180
 */
public class SimpleFilter {
	private List<Filter> filters = new ArrayList<Filter>();   
    private Set<String> alias = new HashSet<String>(); // 防止重复添加alias用   
  
    public boolean hasFilters() {   
        return filters.size() > 0;   
    }   
  
    public void addFilter(final String property, final Object value, final MatchType matchType) {   
        if (matchType == MatchType.OR || matchType == MatchType.BETWEEN) {   
            throw new RuntimeException("匹配模式不正确");   
        } else {   
            filters.add(new Filter(property, value, matchType));   
        }   
    }   
  
    public void addFilter(final String property, final Object value) {   
        filters.add(new Filter(property, value));   
    }   
  
    public void addFilter(final String property, final Object lo, final Object hi) {   
        filters.add(new Filter(property, lo, hi));   
    }   
  
    public void addFilter(final Set<OrClausePair> set) {   
        filters.add(new Filter(set));   
    }   
  
    /**  
     * 清理过滤器  
     * 在具有级联条件的查询中，alias不能重复添加，只允许添加一次  
     * 在执行完一次count(*)查询后，之前添加的criteria全部失效  
     * 重新添加criteria的时候，需要清空alias的Set集合  
     * 以便正确执行createAlias语句  
     *   
     */  
    public void clearFilter() {   
        alias.clear();   
    }   
  
    /**  
     * 构建当前filter的Criteria对象  
     */  
    public Criteria buildCriteria(final Criteria criteria) {   
        for (Filter filter : filters) {   
            if (filter.getMatchType() == MatchType.BETWEEN) {   
                buildCriteria(criteria, filter.getProperty(), filter.getLo(), filter.getHi());   
            } else if (filter.getMatchType() == MatchType.OR) {   
                builCriteria(criteria, filter.getSet());   
            } else {   
                buildCriteria(criteria, filter.getProperty(), filter.getValue(), filter.getMatchType());   
            }   
        }   
        return criteria;   
    }   
  
    /**  
     * 根据多个属性名、值和匹配类型构建Hibernate的Criteria的OR对象  
     */  
    private Criteria builCriteria(final Criteria criteria, final Set<OrClausePair> set) {   
        Disjunction disjunction = Restrictions.disjunction();   
        for (OrClausePair pair : set) {   
            String alias = createAlias(criteria, pair.getProperty());   
            if (StringUtils.isNotBlank(alias)) {   
                MatchType matchType = pair.getMatchType();   
                if (matchType == MatchType.BETWEEN) {   
                    if (pair.getLo() != null && pair.getHi() != null) {   
                        disjunction.add(Restrictions.between(alias, pair.getLo(), pair.getHi()));   
                    }   
                } else {   
                    switch (matchType) {   
                    case NULL:   
                        disjunction.add(Restrictions.isNull(alias));   
                        break;   
                    case NOTNULL:   
                        disjunction.add(Restrictions.isNotNull(alias));   
                        break;   
                    case EMPTY:   
                        disjunction.add(Restrictions.isEmpty(alias));   
                        break;   
                    case NOTEMPTY:   
                        disjunction.add(Restrictions.isNotEmpty(alias));   
                        break;   
                    }   
                    Object value = pair.getValue();   
                    if (value != null) {   
                        switch (matchType) {   
                        case EQ:   
                            disjunction.add(Restrictions.eq(alias, value));   
                            break;   
                        case LIKE:   
                            disjunction.add(Restrictions.like(alias, (String) value, MatchMode.ANYWHERE));   
                            break;   
                        case LIKESTART:   
                            disjunction.add(Restrictions.like(alias, (String) value, MatchMode.START));   
                            break;   
                        case LIKEND:   
                            disjunction.add(Restrictions.like(alias, (String) value, MatchMode.END));   
                            break;   
                        case LE:   
                            disjunction.add(Restrictions.le(alias, value));   
                            break;   
                        case LT:   
                            disjunction.add(Restrictions.lt(alias, value));   
                            break;   
                        case GE:   
                            disjunction.add(Restrictions.ge(alias, value));   
                            break;   
                        case GT:   
                            disjunction.add(Restrictions.gt(alias, value));   
                            break;   
                        case NE:   
                            disjunction.add(Restrictions.ne(alias, value));   
                            break;   
                        }   
                    }   
                }   
            }   
        }   
        criteria.add(disjunction);   
        return criteria;   
    }   
  
    /**  
     * 根据属性名、值和匹配类型构建Hibernate的Criteria对象  
     */  
    private Criteria buildCriteria(final Criteria criteria, final String property, final Object value,   
            final MatchType matchType) {   
        String alias = createAlias(criteria, property);   
        if (StringUtils.isNotBlank(alias)) {   
            switch (matchType) {   
            case NULL:   
                Restrictions.isNull(alias);   
                return criteria;   
            case NOTNULL:   
                Restrictions.isNotNull(alias);   
                return criteria;   
            case EMPTY:   
                Restrictions.isEmpty(alias);   
                return criteria;   
            case NOTEMPTY:   
                Restrictions.isNotEmpty(alias);   
                return criteria;   
            }   
            if (value != null) {   
                switch (matchType) {   
                case EQ:   
                    criteria.add(Restrictions.eq(alias, value));   
                    break;   
                case LIKE:   
                    criteria.add(Restrictions.like(alias, (String) value, MatchMode.ANYWHERE));   
                    break;   
                case LIKESTART:   
                    criteria.add(Restrictions.like(alias, (String) value, MatchMode.START));   
                    break;   
                case LIKEND:   
                    criteria.add(Restrictions.like(alias, (String) value, MatchMode.END));   
                    break;   
                case LE:   
                    criteria.add(Restrictions.le(alias, value));   
                    break;   
                case LT:   
                    criteria.add(Restrictions.lt(alias, value));   
                    break;   
                case GE:   
                    criteria.add(Restrictions.ge(alias, value));   
                    break;   
                case GT:   
                    criteria.add(Restrictions.gt(alias, value));   
                    break;   
                case NE:   
                    criteria.add(Restrictions.ne(alias, value));   
                    break;   
                }   
            }   
        }   
        return criteria;   
    }   
  
    /**  
     * 创建BETWEEN匹配类型的Criteria对象  
     */  
    private Criteria buildCriteria(final Criteria criteria, final String property, final Object lo, final Object hi) {   
        String alias = createAlias(criteria, property);   
        if (StringUtils.isNotBlank(alias) && lo != null && hi != null) {   
            criteria.add(Restrictions.between(alias, lo, hi));   
        }   
        return criteria;   
    }   
  
    /**  
     * 为Criteria对象添加别名  
     * 最多支持2级级联，例如animal.pet.cat  
     * @param criteria Criteria对象  
     * @param property 属性  
     * @return 别名  
     */  
    private String createAlias(final Criteria criteria, final String property) {   
        String[] names = StringUtils.split(property, ".");   
        if (names != null && names.length == 2) {   
            if (alias.add(names[0])) {   
                criteria.createAlias(names[0], names[0]);   
            }   
            return names[0] + "." + names[1];   
        } else if (names != null && names.length == 3) {   
            if (alias.add(names[0])) {   
                criteria.createAlias(names[0], names[0]);   
            }   
            if (alias.add(names[0] + "." + names[1])) {   
                criteria.createAlias(names[0] + "." + names[1], names[1]);   
            }   
            return names[1] + "." + names[2];   
        } else {   
            return property;   
        }   
    }   
    
    public enum MatchType {
		EQUAL, LIKE,OR, EQ, EMPTY, BETWEEN, GT, LT, LIKEND, LIKESTART, LE, GE, NE, NOTNULL, NULL, NOTEMPTY;
	}
    
    /**  
     * 过滤器  
     * 两个参数的构造方法，默认查询条件为LIKE  
     */  
    private static class Filter {   
        private String property;   
        private Object value;   
        private Object lo;   
        private Object hi;   
        private Set<OrClausePair> set;   
        private MatchType matchType;   
  
        /**  
         * 构造一个OR条件的过滤器，使用disjunction进行连接  
         * @param set OR条件参数集合  
         */  
        public Filter(Set<OrClausePair> set) {   
            this.set = set;   
            this.matchType = MatchType.OR;   
        }   
  
        /**  
         * 构造LIKE类型查询  
         * @param property 属性  
         * @param value 值  
         */  
        public Filter(String property, Object value) {   
            this.property = property;   
            this.value = value;   
            this.matchType = MatchType.LIKE;   
        }   
  
        /**  
         * 构造MatchType类型的查询  
         * @param property 属性  
         * @param value 值  
         * @param matchType 匹配类型  
         */  
        public Filter(String property, Object value, MatchType matchType) {   
            this.property = property;   
            this.value = value;   
            this.matchType = matchType;   
        }   
  
        /**  
         * 构造Between类型的查询  
         * @param property 属性  
         * @param lo lowValue  
         * @param hi hiValue  
         */  
        public Filter(String property, Object lo, Object hi) {   
            this.property = property;   
            this.lo = lo;   
            this.hi = hi;   
            this.matchType = MatchType.BETWEEN;   
        }   
  
        public String getProperty() {   
            return property;   
        }   
  
        public Object getValue() {   
            return value;   
        }   
  
        public Object getLo() {   
            return lo;   
        }   
  
        public Object getHi() {   
            return hi;   
        }   
  
        public Set<OrClausePair> getSet() {   
            return set;   
        }   
  
        public MatchType getMatchType() {   
            return matchType;   
        }   
    }   
    
    class OrClausePair {
    	private MatchType matchType;
    	private String property;
    	private Object value;
    	private Object lo;
    	private Object hi;
		public MatchType getMatchType() {
			return matchType;
		}
		public void setMatchType(MatchType matchType) {
			this.matchType = matchType;
		}
		public String getProperty() {
			return property;
		}
		public void setProperty(String property) {
			this.property = property;
		}
		public Object getLo() {
			return lo;
		}
		public void setLo(Object lo) {
			this.lo = lo;
		}
		public Object getHi() {
			return hi;
		}
		public void setHi(Object hi) {
			this.hi = hi;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
    	
    }
}