package com.globaldenso.dnkr.presentation.form.basic;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.globaldenso.ai.core.validation.annotation.AlphaNumerics;
import com.globaldenso.dnkr.domain.LinkDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAC019SsoManagementForm extends LinkDomain/* implements Cloneable*/{

    /**
     * 
     */
    private static final long serialVersionUID = 1384723015420960047L;

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
    public WAC019SsoManagementForm() {
        //no process
    	super();
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
    

	@Override
    @AlphaNumerics
    @Size(max = 4)
	public String getSysSeq() {
		// TODO Auto-generated method stub
		return super.getSysSeq();
	}

	/*
	@Override
	@URL
	public String getSysUrl() {
		// TODO Auto-generated method stub
		return super.getSysUrl();
	}

	@Override
	@URL
	public String getSysUrl2() {
		// TODO Auto-generated method stub
		return super.getSysUrl2();
	}
*/
	@Override
    @AlphaNumerics
    @Size(max = 4)
	public String getPopupW() {
		// TODO Auto-generated method stub
		return super.getPopupW();
	}

	@Override
    @AlphaNumerics
    @Size(max = 4)
	public String getPopupH() {
		// TODO Auto-generated method stub
		return super.getPopupH();
	}
    
}
