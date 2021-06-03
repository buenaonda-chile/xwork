package com.globaldenso.dnkr.presentation.form.basic;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
/**
 * @author $Author$
 * @version $Revision$
 */
public class WAD011MenuSearchForm extends MenuDomain implements Cloneable{

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -6970847060478437068L;
    
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
    public WAD011MenuSearchForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAD011MenuSearchForm clone() {
        WAD011MenuSearchForm clone = new WAD011MenuSearchForm();
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
