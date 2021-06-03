package com.globaldenso.dnkr.presentation.form.basic;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.DataWareHouseDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAE001StandardCostSearchForm extends DataWareHouseDomain implements Cloneable{

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 6731630361939112358L;
    
    // for paging (start)
    
    /**
     * searchTotalCount.
     */
    private Integer searchTotalCount;
    
    /**
     * countPerPage.
     */
    private Integer countPerPage = 10;
    
    /**
     * pageNo.
     */
    private Integer pageNo;
    
    /**
     * pages.
     */
    private String pages = "search";
    
    // for paging (end)
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAE001StandardCostSearchForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAE001StandardCostSearchForm clone() {
        WAE001StandardCostSearchForm clone = new WAE001StandardCostSearchForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }
    
    // for paging (start)
    
    /**
     * Getter method of searchTotalCount.
     *
     * @return the searchTotalCount
     */
    public Integer getSearchTotalCount() {
        return searchTotalCount;
    }
    
    /**
     * Setter method of searchTotalCount.
     *
     * @param searchTotalCount searchTotalCount
     */
    public void setSearchTotalCount(Integer searchTotalCount) {
        this.searchTotalCount = searchTotalCount;
    }
    
    /**
     * Getter method of countPerPage.
     *
     * @return the countPerPage
     */
    public Integer getCountPerPage() {
        return countPerPage;
    }
    
    /**
     * Setter method of countPerPage.
     *
     * @param countPerPage countPerPage
     */
    public void setCountPerPage(Integer countPerPage) {
        this.countPerPage = countPerPage;
    }
    
    /**
     * Getter method of pageNo.
     *
     * @return the pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }
    
    /**
     * Setter method of pageNo.
     *
     * @param pageNo pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    
    /**
     * Getter method of pages.
     *
     * @return the pages
     */
    public String getPages() {
        return pages;
    }
    
    /**
     * Setter method of pages.
     *
     * @param pages pages
     */
    public void setPages(String pages) {
        this.pages = pages;
    }
    
    // for paging (end)
 
}
