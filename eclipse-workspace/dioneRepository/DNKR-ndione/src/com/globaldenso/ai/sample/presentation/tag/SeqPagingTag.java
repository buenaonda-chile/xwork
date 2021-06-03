/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.ai.sample.presentation.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.BeanUtils;

import com.globaldenso.ai.library.presentation.paging.constant.PagingConstants;
import com.globaldenso.ai.library.presentation.paging.exception.PagingJspException;

/**
 * Implement class of the Paging Library.
 * <p>
 * This class inherits the class of "javax.servlet.jsp.tagext.TagSupport".
 * If you evaluate the Tag Body, This class need to inherit the class of "javax.servlet.jsp.tagext.BodyTagSupport".
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
public class SeqPagingTag extends TagSupport {
    
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 2956160427356590900L;
    
    /**
     * pageContext.
     */
    private PageContext pageContext;
    
    /**
     * The number of displayed page No.
     */
    private int maxSeq;
    
    /**
     * Action Path.
     */
    private String action;
    
    /**
     * Form Identifier.
     */
    private String formId;
    
    
    
    /**
     * Default constructer.
     */
    public SeqPagingTag() {
        // no process
    }
    
    
    
    /**
     * Setter method of pageContext.
     *
     * @param pageContext Set pageContext
     */
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }
    
    /**
     * Setter method of maxSeq.
     *
     * @param maxSeq Set maxSeq
     */
    public void setMaxSeq(int maxSeq) {
        this.maxSeq = maxSeq;
    }
    
    /**
     * Setter method of action.
     *
     * @param action Set action
     */
    public void setAction(String action) {
        this.action = action;
    }
    
    /**
     * Setter method of formId.
     *
     * @param formId Set formId
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }
    
    
    /**
     * This method is started when start tag is called.
     * 
     * @throws PagingJspException The exception for Paging Tag
     * @return int skip_body
     */
    public int doStartTag() throws PagingJspException {
        JspWriter out = pageContext.getOut();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        // Setting of modelAttribute
        String modelAttribute = (String) request.getAttribute("org.springframework.web.servlet.tags.form.AbstractFormTag.modelAttribute");
        Object form = (Object) request.getAttribute(modelAttribute);
        try {
            
            // These code is active if results of search is exist.
            if (Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_SEARCHTOTALCOUNT)) != 0
                    && Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_ROWNUMFROM)) <= Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_ROWNUMTO))) {
                
                // When "maxSeq" is not defined, the value is 10. Here's default settings.
                if (maxSeq == 0) {
                    maxSeq = 10;
                }
                
                // Get values of Form
                int pageNo = Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_PAGENO)); // Page No.
                int from = Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_ROWNUMFROM)); // Start of the search
                int to = Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_ROWNUMTO)); // End of the search
                int searchTotalCount = Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_SEARCHTOTALCOUNT)); // The number of the searches
                int countPerPage = Integer.parseInt(BeanUtils.getProperty(form, PagingConstants.FORM_COUNTPERPAGE)); // The number of the searches per 1 page
                int width = maxSeq / 2; // Length of between center of the page No. to left or right 
                int pageMax = 0; // Maximum Page No.
                
                pageMax = (int) Math.ceil((double) searchTotalCount / countPerPage);
                
                // When previous page is exist, this link is displayed
                if (action == null) {
                    action = "";
                }
                
             // The number of the searches is shown
                out.println("<div class=\"recordcount fl\">");
                out.println("<h6>");
                out.print("Results&nbsp;&nbsp;");
                out.print(pageNo);
//                out.print("&nbsp;-&nbsp;");
//                out.print(to);
                out.print("&nbsp;&nbsp;of&nbsp;&nbsp;");
                out.print(pageMax);
                out.print("&nbsp;pages&nbsp;");
                out.println("</h6>");
                out.println("</div>");
                
                out.println("<div class=\"page2\">");
                out.println("<ul class=\"pagination pagination-sm paging-wrap\">");
                
                // When previous page is exist, this link is displayed
                if (2 <= pageNo) {
                    out.println("<li><a href=\"#\" class=\"ai-paging_pl_link first BdBg\" onclick=\"pageClick('" + formId + "'," + 1 + ",'" + action + "')\">" + "&lt;&lt;" + "</a></li>");
                    out.println("<li class=\"margin\"><a href=\"#\" class=\"ai-paging_pl_link prev BdBg\" onclick=\"pageClick('" + formId + "'," + (pageNo - 1) + ",'" + action + "')\">" + "&lt;" + "</a></li>");
                } else {
                    out.println("<li class=\"disabled visibleHidden\"><a href=\"#\">&lt;</a></li>");
                }
                
                // When current page No. is at under the width, the page No. is diplayed 1 to the value of maxseq (Display setting of left end)
                if (pageNo <= width) {
                    for (int i = 1; i <= maxSeq; i++) {
                        if (1 <= i && i <= pageMax) {
                            if (i == pageNo) {
                                out.println("<li ><a href=\"#\" class=\"active\">" + i + "</a></li>");
                                out.println("");
                            } else {
                                out.println("<li><a href=\"#\" class=\"ai-paging_pl_link\" onclick=\"pageClick('" + formId + "'," + i + ",'" + action + "')\">" + i + "</a></li>");
                                out.println("");
                            }
                        }
                    }
                // When difference between maximum page No. to current No. is smaller than width (Display setting of right end)
                } else if ((pageMax - pageNo) < width) {
                    for (int i = (pageMax - maxSeq) + 1; i <= pageMax; i++) {
                        if (1 <= i && i <= pageMax) {
                            if (i == pageNo) {
                                out.println("<li ><a href=\"#\" class=\"active\">" + i + "</a></li>");
                                out.println("");
                            } else {
                                out.println("<li><a href=\"#\" class=\"ai-paging_pl_link\" onclick=\"pageClick('" + formId + "'," + i + ",'" + action + "')\">" + i + "</a></li>");
                                out.println("");
                            }
                        }
                    }
                } else {
                    // The number of displayed page No. is even
                    if (maxSeq % 2 == 0) {
                        for (int i = pageNo - width; i <= pageNo + width - 1; i++) {
                            if (1 <= i && i <= pageMax) {
                                if (i == pageNo) {
                                    out.println("<li ><a href=\"#\" class=\"active\">" + i + "</a></li>");
                                    out.println("");
                                } else {
                                    out.println("<li><a href=\"#\" class=\"ai-paging_pl_link\" onclick=\"pageClick('" + formId + "'," + i + ",'" + action + "')\">" + i + "</a></li>");
                                    out.println("");
                                }
                            }
                        }
                    // The number of displayed page No. is odd
                    } else {
                        for (int i = pageNo - width; i <= pageNo + width; i++) {
                            if (1 <= i && i <= pageMax) {
                                if (i == pageNo) {
                                    out.println("<li><a href=\"#\"  class=\"active\">" + i + "</a></li>");
                                    out.println("");
                                } else {
                                    out.println("<li><a href=\"#\" class=\"ai-paging_pl_link\" onclick=\"pageClick('" + formId + "'," + i + ",'" + action + "')\">" + i + "</a></li>");
                                    out.println("");
                                }
                            }
                        }
                    }
                }
                
                // When next page is exist, this link is displayed
                if (pageMax != pageNo) {
                    out.println("");
                    out.println("<li><a href=\"#\" class=\"ai-paging_pl_link next BdBg\" onclick=\"pageClick('" + formId + "'," + (pageNo + 1) + ",'" + action + "')\">" + "&gt;" + "</a></li>");
                    out.println("<li><a href=\"#\" class=\"ai-paging_pl_link last BdBg\" onclick=\"pageClick('" + formId + "'," + pageMax + ",'" + action + "')\">" + "&gt;" + "</a></li>");
                } else {
                    out.println("");
                    out.println("<li class=\"disabled visibleHidden\"><a href=\"#\">&gt;</a></li>");
                }
                out.println("</ul>");
                out.println("</div>");
                
            }
            
        } catch (Exception e) {
            // Unexpected exception
            throw new PagingJspException(PagingJspException.ERR_UNEXCEPTED, e);
        }
        
        return SKIP_BODY;
        
    }
}
