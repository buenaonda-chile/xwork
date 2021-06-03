package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 업무분류 관리 정도 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class WorkSortDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -8968823300509105199L;
    
    /**
    * [KO] 업무 분류 코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String workCode;

    /**
    * [KO] 업무 분류 코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String teamCode;
    
    /**
    * [KO] 업무 분류 명칭(한국어).<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String workTypeNm;
    
    /**
    * [KO] 업무 분류 명칭(영어).<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String workTypeEnNm;
    
    /**
    * [KO] 업무 분류 명칭(일어).<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String workTypeJaNm;
    
    /**
    * [KO] 상위 업무 분류 코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String uppWorkCode;
    
    /**
    * [KO] 업무분류(중) 승인 사원번호.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String aprvEmpNum;
    
    /**
    * [KR] 업무 분류 레벨<br>
    * [EN] <br>
    * [JP] <br>
    */
    private int workLv;
    
    /**
    * [KR] 업무 분류 정렬<br>
    * [EN] <br>
    * [JP] <br>
    */
    private int workSort;
    
    /**
    * [KR] <br>
    * [EN] <br>
    * [JP] <br>
    */
    private int rowNum;

    /**
    * [KR] 업무 분류 사용여부<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String useYn;

    /**
    * [KR] 언어코드<br>
    */
    private String langCmc;

    /**
    * [EN] Paging(From).<br>
    * [JP] ページング(From)。<br>
    */
    private int rowNumFrom;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNumTo;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WorkSortDomain(){
        // no process
    }
    
    /**
    * [KR] 업무 분류 코드의 getter method
    * @return the workCode
    */
    public String getWorkCode() {
        return workCode;
    }

    /**
    * [KR] 업무 분류 코드의 setter method
    * @param workCode to set
    */
    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    /**
    * [KR] 업무 분류 코드의 getter method
    * @return the workCode
    */
    public String getTeamCode() {
        return teamCode;
    }

    /**
    * [KR] 업무 분류 코드의 setter method
    * @param teamCode String
    */
    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    /**
    * [EN] It is a getter method of deptName.<br>
    * [JP] deptName のゲッターメソッドです。<br>
    * 
    * @return the deptName
    */
    public String getWorkTypeNm() {
        return workTypeNm;
    }

    /**
     * [EN] It is a setter method of deptName.<br>
     * [JP] deptName のセッターメソッドです。<br>
     * 
     * @param workTypeNm String
     */
    public void setWorkTypeNm(String workTypeNm) {
        this.workTypeNm = workTypeNm;
    }


    /**
    * [KR] 업무 분류 명칭(영어) getter method
    * @return the name
    */
    public String getWorkTypeEnNm() {
        return workTypeEnNm;
    }

    /**
    * [KR] 업무 분류 명칭(영어) setter method
    * @param workTypeEnNm String
    */
    public void setWorkTypeEnNm(String workTypeEnNm) {
        this.workTypeEnNm = workTypeEnNm;
    }
    
    /**
    * [KR] 업무 분류 명칭(일어) getter method
    * @return the name
    */
    public String getWorkTypeJaNm() {
        return workTypeJaNm;
    }

    /**
    * [KR] 업무 분류 명칭(일어) setter method
    * @param workTypeJaNm String
    */
    public void setWorkTypeJaNm(String workTypeJaNm) {
        this.workTypeJaNm = workTypeJaNm;
    }

    /**
    * [KR] 업무 분류 상위 코드 getter method
    * @return the uppWorkCode
    */
    public String getUppWorkCode() {
        return uppWorkCode;
    }

    /**
    * [KR] 업무 분류 상위 코드 setter method
    * @param uppWorkCode to set
    */
    public void setUppWorkCode(String uppWorkCode) {
        this.uppWorkCode = uppWorkCode;
    }

    /**
    * [KR] 업무 분류(중) 승인사원 getter method
    * @return the aprvEmpNum
    */
    public String getAprvEmpNum() {
        return aprvEmpNum;
    }

    /**
    * [KR] 업무 분류(중) 승인사원 setter method
    * @param aprvEmpNum to set
    */
    public void setAprvEmpNum(String aprvEmpNum) {
        this.aprvEmpNum = aprvEmpNum;
    }

    /**
    * @return workLv
    */
    public int getWorkLv() {
        return workLv;
    }
    /**
    * @param workLv int
    */
    public void setWorkLv(int workLv) {
        this.workLv = workLv;
    }

    /**
    * [KR] 업무 분류 정렬순서 getter method
    * @return the sort
    */
    public int getWorkSort() {
        return workSort;
    }

    /**
    * [KR] 업무 분류 정렬순서 setter method
    * @param workSort int
    */
    public void setWorkSort(int workSort) {
        this.workSort = workSort;
    }
    
    /**
    * [KR] 업무 분류 정렬순서 getter method
    * @return the sort
    */
    public int getRowNum() {
        return rowNum;
    }

    /**
    * [KR] 업무 분류 정렬순서 setter method
    * @param rowNum int
    */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    /**
    * [KR] 메뉴사용여부 getter method
    * @return the use
    */
    public String getUseYn() {
        return useYn;
    }

    /**
    * [KR] 메뉴사용여부 setter method
    * @param useYn String
    */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
    * [KR] 언어코드 getter method
    * @return the langCmc
    */
    public String getLangCmc() {
        return langCmc;
    }

    /**
    * [KR] 언어코드 setter method (언어별 명칭 컬럼이 다름)
    * @param langCmc the langCmc to set
    */
    public void setLangCmc(String langCmc) {
        this.langCmc = langCmc;
    }

    /**
     * [EN] It is a getter method of rowNumFrom.<br>
     * [JP] rowNumFrom のゲッターメソッドです。<br>
     * 
     * @return the rowNumFrom
     */
    public int getRowNumFrom() {
        return rowNumFrom;
    }

    /**
     * [EN] It is a setter method of rowNumFrom.<br>
     * [JP] rowNumFrom のセッターメソッドです。<br>
     * 
     * @param rowNumFrom rowNumFrom に設定する
     */
    public void setRowNumFrom(int rowNumFrom) {
        this.rowNumFrom = rowNumFrom;
    }

    /**
     * [EN] It is a getter method of rowNumTo.<br>
     * [JP] rowNumTo のゲッターメソッドです。<br>
     * 
     * @return the rowNumTo
     */
    public int getRowNumTo() {
        return rowNumTo;
    }

    /**
     * [EN] It is a setter method of rowNumTo.<br>
     * [JP] rowNumTo のセッターメソッドです。<br>
     * 
     * @param rowNumTo rowNumTo に設定する
     */
    public void setRowNumTo(int rowNumTo) {
        this.rowNumTo = rowNumTo;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("workCode", this.workCode);
        jsonObj.put("workTypeNm", this.workTypeNm);
        jsonObj.put("workTypeEnNm", this.workTypeEnNm);
        jsonObj.put("workTypeJaNm", this.workTypeJaNm);
        jsonObj.put("uppWorkCode", this.uppWorkCode);
        jsonObj.put("workLv", this.workLv);
        jsonObj.put("workSort", this.workSort);
        jsonObj.put("useYn", this.useYn);
        jsonObj.put("rowNumFrom", this.rowNumFrom);
        jsonObj.put("rowNumTo", this.rowNumTo);
        jsonObj.put("langCmc", this.langCmc);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
