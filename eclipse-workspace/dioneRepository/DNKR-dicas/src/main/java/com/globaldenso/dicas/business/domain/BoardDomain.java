package com.globaldenso.dicas.business.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BoardDomain extends BaseDomain{

    private static final long serialVersionUID = 5837112092140000850L;

    private Long seq;

    private Long ref;

    private Long parentSeq;

    private Long lev;

    private Long step;

    private Long cntHit;

    private Long cntReply;

    private String hasAttach;

    private String userId;

    private String content;

    private String name;

    private String ipAddr;

    private String subject;

    private String dept;

    private String email;

    private String boardType;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    private String etc;

    private String delYn = "N";

    private String regDate;

    public String getRegDate() {

        if (EgovStringUtil.isEmpty(regDate)) {
            regDate = getRgstDe().substring(0, 10).replaceAll("-","");
        }

        return regDate;
    }

    private String regTime;

    public String getRegTime() {

        if (EgovStringUtil.isEmpty(regTime)) {
            regTime = getRgstDe().substring(11);
        }

        return regTime;
    }

    private String modDate;

    public String getModDate() {
        if (EgovStringUtil.isEmpty(modDate)) {
            modDate = getUpdtDe().substring(0, 10).replaceAll("-", "");
        }

        return modDate;
    }

    private String modTime;

    public String getModTime() {
        if (EgovStringUtil.isEmpty(modTime)) {
            modTime = getUpdtDe().substring(11);
        }

        return modTime;
    }

    private String noticeYn = "N";

    private Date startDate;

    private Date endDate;

    private String category;

    private String createDate;

    private String sdYn = "N";

    /** 모바일_서치키워드 */
    private String searchKeyword;

}
