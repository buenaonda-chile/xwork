package com.globaldenso.dnkr.presentation.form.basic;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.SurveyDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAG001SurveySearchForm extends SurveyDomain implements Cloneable {
    private static final long serialVersionUID = 6731630361939112359L;
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
    
    /**
     * 
     */
    private int rowNumFrom;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNumTo;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNum;
    /**
     * 
     */
    private String empNumber;
    
    // for paging (end)
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG001SurveySearchForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAG001SurveySearchForm clone() {
        WAG001SurveySearchForm clone = new WAG001SurveySearchForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }
    
    // for paging (start)
    
    /**
     * @return empNumber
     */
    public String getEmpNumber() {
        return empNumber;
    }

    /**
     * @param empNumber String
     */
    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    /**
     * Getter method of searchTotalCount.
     *
     * @return the searchTotalCount
     */
    public Integer getSearchTotalCount() {
        return searchTotalCount;
    }
    
    /**
     * 
     * {@inheritDoc}
     */
    public int getRowNumFrom() {
        return rowNumFrom;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void setRowNumFrom(int rowNumFrom) {
        this.rowNumFrom = rowNumFrom;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getRowNumTo() {
        return rowNumTo;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void setRowNumTo(int rowNumTo) {
        this.rowNumTo = rowNumTo;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
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
