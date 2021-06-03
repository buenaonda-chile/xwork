/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * [KO] 사업부 정보 도메인 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class RelationClsDomain extends RelationDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 3177333350890827658L;
    

    /**
    * [KR] 사업장 리스트(하위리스트)<br>
    */
    private List<RelationLocDomain> locList = new ArrayList<RelationLocDomain>();


    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationClsDomain () {
        //no process
    }
    
    
    /**
    * [KR] 사업장 리스트(하위) getter method
    * @return the locList
    */
    public List<RelationLocDomain> getLocList() {
        return locList;
    }

    /**
    * [KR] 사업장 리스트(하위) getter method
    * @param locList List<RelationLocDomain>
    */
    public void setLocList(List<RelationLocDomain> locList) {
        this.locList = locList;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("relationCode", this.relationCode);
        jsonObj.put("rltnCode", this.rltnCode);
        jsonObj.put("relationName", this.relationName);
        jsonObj.put("cmcLangCode", this.cmcLangCode);
        jsonObj.put("useYn", this.useYn);
        jsonObj.put("rowNumFrom", this.rowNumFrom);
        jsonObj.put("rowNumTo", this.rowNumTo);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
