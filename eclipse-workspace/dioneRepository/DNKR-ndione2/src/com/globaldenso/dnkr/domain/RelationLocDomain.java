package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
/**
 * 
 */
public class RelationLocDomain extends RelationDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -8409442934802628024L;

    /**
    * [KR] 사업부 코드(상위)<br>
    */
    private String clsCode;

    /**
    * [KR] 사업부서 리스트(하위리스트)<br>
    */
    private List<RelationTeamDomain> teamList = new ArrayList<RelationTeamDomain>();


    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public RelationLocDomain () {
        //no process
    }
    

    /**
    * [KR] 사업부 코드(상위) getter method
    * @return the teamList
    */
    public String getClsCode() {
        return clsCode;
    }

    /**
    * [KR] 사업부 코드(상위) getter method
    * @param clsCode String
    */
    public void setClsCode(String clsCode) {
        this.clsCode = clsCode;
    }

    /**
    * [KR] 사업부서 리스트(하위) getter method
    * @return the teamList
    */
    public List<RelationTeamDomain> getTeamList() {
        return teamList;
    }

    /**
    * [KR] 사업부서 리스트(하위) getter method
    * @param teamList List<RelationTeamDomain>
    */
    public void setTeamList(List<RelationTeamDomain> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("relationCode", this.relationCode);
        jsonObj.put("rltnCode", this.rltnCode);
        jsonObj.put("relationName", this.relationName);
        jsonObj.put("cmcLangCode", this.cmcLangCode);
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("useYn", this.useYn);
        jsonObj.put("rowNumFrom", this.rowNumFrom);
        jsonObj.put("rowNumTo", this.rowNumTo);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
