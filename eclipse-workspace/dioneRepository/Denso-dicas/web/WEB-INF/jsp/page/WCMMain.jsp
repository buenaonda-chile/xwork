<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018-11-05
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<!-- 메인의 경우만 보여지게 -->
<!-- main_body -->
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysYear">
    <fmt:formatDate value="${now}" pattern="yyyy년 MM월" />
</c:set>

<div class="main_body">
    <div class="top_bg1"></div>
    <!-- 클레임 접수 상황 -->
    <div class="m1">
        <h2>클레임 접수 상황</h2>
        <div class="btns"><a href="javascript:load();" class="button"><i class="w_refresh"></i>새로고침</a></div>
        <c:set var="SdType" value="0" />
        <c:choose>
            <c:when test="${userStore.getEgovUserVO().getOfficeCd() != null}">
                    <c:if test="${userStore.getEgovUserVO().getDeptCd() eq 'SDCRS'}">
                        <c:set var="SdType" value="81" />
                    </c:if>
                    <c:if test="${userStore.getEgovUserVO().getDeptCd() eq 'SDAC'}">
                        <c:set var="SdType" value="6" />
                    </c:if>
            </c:when>
            <c:otherwise>
                <c:set var="SdType" value="6" />
            </c:otherwise>
        </c:choose>
           <!-- 그래프 형  -->
           <div id="tab1" class="tab-cont m1bg1">
               <div class="clearfix">
                   <div class="col-left">
                       <div class="m1c1">
                           <!-- m1c1_tit -->
                           <div class="m1c1_tit">
                               <span class="txt1">
                                   <c:out value="${sysYear}" />
                               </span>
                               <h3></h3>
                           </div>
                           <!-- /m1c1_tit -->
                           <!-- m1c1_bbs -->
                           <div class="m1c1_bbs">
                               <table class="bList">
                                   <col />
                                   <thead>
                                   <tr>
                                       <th scope="col">접수일</th>
                                       <th scope="col">상태</th>
                                       <th scope="col">정비소명</th>
                                       <th scope="col">차종</th>
                                       <th scope="col">VINNO</th>
                                       <th scope="col">진행</th>
                                   </tr>
                                   </thead>
                                   <tbody>
                                    <c:forEach var="result2" items="${claimList}" varStatus="status">
                                        <fmt:parseDate value="${result2.receiptDate}" var="receiptDtSub" pattern="yyyyMMdd"/>
                                   <tr>
                                       <td><fmt:formatDate value="${receiptDtSub}" pattern="yyyy.MM.dd"/></td>
                                       <td>${result2.callStatus}</td>
                                       <td><a href="/service/init" data-menu-id = "<c:out value="${SdType}" />" data-name="클레임접수" onclick="javascript: return loadTab(this,{manageNo:'${result2.manageNo}',vinno:'${result2.vinno}'});">${result2.officeNm}</a></td>
                                       <td>${result2.model}</td>
                                       <td><a href="/service/init" data-menu-id = "<c:out value="${SdType}" />" data-name="클레임접수" onclick="javascript: return loadTab(this,{manageNo:'${result2.manageNo}',vinno:'${result2.vinno}'});">${result2.vinno}</a></td>
                                       <td>${result2.status}</td>
                                   </tr>
                                   </c:forEach>
                                   </tbody>
                               </table>
                           </div>
                       </div>
                   </div>
                   <div class="col-right">
                       <div class="m1c2">
                           <a href="/claimVehicle/init" class="item2" data-menu-id ="122" data-name="클레임현황" onclick="javascript: return loadTab(this,{statusType:'01'});"><span class="txt1"><i></i> 상담진행</span><span class="txt2"><span class="num">${cntIng}</span> 건</span></a>
                           <a href="/claimVehicle/init" class="item2" data-menu-id ="122" data-name="클레임현황" onclick="javascript: return loadTab(this,{statusType:'02'});"><span class="txt1"><i></i> 처리결과</span><span class="txt2"><span class="num">${cntRs}</span> 건</span></a>
                       </div>
                       <div class="m1c3">
                           <h3>처리율</h3>
                           <div class="bar">
                               <div class="note" style="left:calc(${cntPer}% / 2);">${cntPer}%</div><!-- 숫자(15%)를 고쳐주세요 -->
                               <div class="bg"><div class="ing" style="width:${cntPer}%"><!-- 숫자(15%)를 고쳐주세요 --></div></div>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
           <!-- / 그래프 형 -->
       </div>
       <!-- / 클레임 접수 상황 -->
       <div class="clearfix">
           <!-- 고품회수관리 -->
           <div class="m2 col-left">
               <h2>고품회수관리</h2>
               <i class="arrow"></i>
               <div class="m2list">
                   <a href="/claimVehicle/init" class="item1" data-menu-id = "122" data-name="클레임현황" onclick="javascript: return loadTab(this,{inquiryGubun:'01'});"><i></i><span class="txt1">커먼레일<br /></span><span class="txt2"><span class="num">
                       <c:choose>
                            <c:when test="${mainPart01 == null}">
                                0
                            </c:when>
                            <c:otherwise>
                                ${mainPart01.cnt}
                            </c:otherwise>
                        </c:choose></span>건</span></a>
                   <a href="/claimVehicle/init" class="item2" data-menu-id = "122" data-name="클레임현황" onclick="javascript: return loadTab(this,{inquiryGubun:'02'});"><i></i><span class="txt1">에어컨<br /></span><span class="txt2"><span class="num">
                       <c:choose>
                           <c:when test="${mainPart02 == null}">
                               0
                           </c:when>
                           <c:otherwise>
                               ${mainPart02.cnt}
                           </c:otherwise>
                       </c:choose></span>건</span></a>
                   <a href="/claimVehicle/init" class="item3" data-menu-id = "122" data-name="클레임현황" onclick="javascript: return loadTab(this,{inquiryGubun:'03'});"><i></i><span class="txt1">단품<br /></span><span class="txt2"><span class="num">
                       <c:choose>
                           <c:when test="${mainPart03 == null}">
                               0
                           </c:when>
                           <c:otherwise>
                               ${mainPart03.cnt}
                           </c:otherwise>
                       </c:choose></span>건</span></a>
               </div>
           </div>
           <!-- / 고품회수관리 -->

           <!-- 비용처리관리 -->
           <div class="m3 col-right">
               <h2>비용처리관리</h2>
               <a href="/sub/46" class="ic_more">더보기</a>
               <div class="m3tit">
                   <table>
                       <tr>
                           <td>결과 등록일</td>
                           <td>정비소</td>
                           <td>클레임번호</td>
                           <td>결재상태</td>
                       </tr>
                   </table>
               </div>
               <div class="m3list">
                   <!--
                      상태 값에 따라 class 달라짐
                   1. SUBMISSION : status01 (파랑)
                   2. APPROVAL : status02 (빨강)
                   3. 미정 : status03 (초록)
                   4. 미정 : status04 (보라)
                   5. 미정 : status05 (검정)
                   -->
               <c:forEach var="rsMst" items="${rsMstList}" varStatus="status">
                   <table class="status01">
                       <tr>
                           <td>${rsMst.resultDate}</td>
                           <td>${rsMst.officeNm}</td>
                           <td><a href="/resultMaster/init" data-menu-id = '45' data-name="비용승인" onclick="javascript: return loadTab(this,{manageNo:'${rsMst.manageNo}', vinno:'${rsMst.vinno}'});">${rsMst.manageNo}</a></td>
                           <%--<td>${rsMst.manageNo}</td>--%>
                           <td class="status">${rsMst.approvalStatus}<i class="ic1"></i></td>
                       </tr>
                   </table>
               </c:forEach>
               </div>
           </div>
           <!-- / 비용처리관리 -->
       </div>

       <div class="clearfix">
           <!-- 공지사항 -->
           <div class="m4 col-left">
               <h2>공지사항</h2>
               <a href="/sub/86" class="ic_more">더보기</a>
               <table class="bList">
                   <col style="width:80px" />
                   <col style="width:100px" />
                   <col style="width:100px" />
                   <col />
                   <thead>
                   <tr>
                       <th scope="col">번호</th>
                       <th scope="col">날짜</th>
                       <th scope="col">작성자</th>
                       <th scope="col">제목</th>
                   </tr>
                   </thead>
                   <tbody>
                   <c:forEach var="rsNotice" items="${rsNoticeBoardList}" varStatus="status">
                   <tr>
                       <td>${rsNotice.rn}</td>
                       <td>${rsNotice.regDate}</td>
                       <td>${rsNotice.name}</td>
                       <td class="tal"><a hef="/board/notice/view/${rsNotice.seq}" data-menu-id="86" data-name="공지사항" onclick="javascript: return loadTab(this,{seq:'${rsNotice.seq}'});"  class="subject">${rsNotice.subject}</a><%-- <i class="ic1 new">새 글</i>--%></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- / 공지사항 -->

        <!-- 게시판 -->
        <div class="m5 col-right">
            <h2>자료실</h2>
            <a href="/sub/87" class="ic_more">더보기</a>
            <table class="bList">
                <col style="width:80px" />
                <col style="width:100px" />
                <col style="width:100px" />
                <col />
                <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">날짜</th>
                    <th scope="col">작성자</th>
                    <th scope="col">제목</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rsFile" items="${rsFileBoardList}" varStatus="status">
                <tr>
                    <td>${rsFile.rn}</td>
                    <td>${rsFile.regDate}</td>
                    <td>${rsFile.name}</td>
                    <td class="tal"><a hef="/board/file/view/${rsFile.seq}" data-menu-id="87" data-name="자료실" onclick="javascript: return loadTab(this,{seq:'${rsFile.seq}'});"  class="subject">${rsFile.subject}</a><%-- <i class="ic1 new">새 글</i>--%></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- / 게시판 -->
    </div>
</div>
<!-- //main_body -->

<script type="text/javascript">/*<![CDATA[*/

function load(){
    location.reload();
}

function claim(mngNo, vNo) {

    var viewUrl = window.location.protocol + "//"
        + window.location.host
        + "/service/init?mmanageNo="+mngNo+"&vinno="+vNo
        //+ "/sub/6?manageNo="+mngNo+"&vinno="+vNo; // 테스트
       document.location.href = viewUrl;
}

$(function(){
    /*
     $("a.b1.tab").on("click",function(e){
         e.preventDefault();
         var $obj = $(this).attr('href');
         var $that = $($obj);

         if($obj == "#tab2"){
             $(".m1 h2").text("클래임 접수");
             $(".m1 .ic_more").attr("href","/sub/48");
         }else if($obj == "#tab1"){
             $(".m1 h2").text("진행상황");
             $(".m1 .ic_more").attr("href","#");
         }

         $("a.b1.tab").removeClass("on");
         $(this).addClass("on");
         $(".tab-cont").hide();
         $that.show();
     });
    */
     $("a.b1.toggle").on("click",function(e){
         e.preventDefault();
         var $that = $($(this).attr('href'));
         if($(this).hasClass("on")){
             $(this).removeClass("on");
             $that.hide();
         }else{
             $(this).addClass("on");
             $that.show();
         }
     });
});
/*]]>*/</script>