package com.globaldenso.dnkr.presentation.form.basic;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
/**
 * @author $Author$
 * @version $Revision$
 */
public class WAC001BoardSearchForm extends BoardTextDomain implements Cloneable{

    /**
     * 
     */
    private static final long serialVersionUID = 6731630361939112358L;

    /**
     * Selected employee's number (comma separated) .
     */
    private String boardId;
    
    // for paging (start)
    
    /**
     * searchTotalCount.
     */
    private Integer searchTotalCount;
    
    /**
     * countPerPage.
     */
    private Integer countPerPage = 5;
    
    /**
     * pageNo.
     */
    private Integer pageNo;
    
    /**
     * pages.
     */
    private String pages = "search";
    
    /**
     * searchTotalCount.
     */
    private String sv;

    /**
     * searchTotalCount.
     */
    private String sw;
    
    // for paging (end)
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC001BoardSearchForm(){
        super();
    }
    
    /**
     * Getter method of selectedEmp.
     *
     * @return the selectedEmp
     */
    public String getBoardId() {
        return boardId;
    }
    
    /**
     * Setter method of selectedEmp.
     *
     * @param boardId String
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAC001BoardSearchForm clone() {
        WAC001BoardSearchForm clone = new WAC001BoardSearchForm();
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

    /**
     * @return sv
     */
    public String getSv() {
        return sv;
    }
    /**
     * @param sv String
     */
    public void setSv(String sv) {
        this.sv = sv;
    }
    /**
     * @return sw
     */
    public String getSw() {
        return sw;
    }
    /**
     * @param sw String
     */
    public void setSw(String sw) {
        this.sw = sw;
    }
    
    // for paging (end)
 
}
