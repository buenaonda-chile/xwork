<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="changeUrl" value="/popup/password/change"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%-- popup_container --%>
<div class="popup_container">
	<div id="form_container">
		<h2>비밀번호 변경</h2>
		<form id="frm_input" method="post" data-bind="events: {submit: submit}">
			<table class="bWrite">
				<colgroup>
					<col style="width:120px" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row"><label>변경 비밀번호</label></th>
						<td>
							<input type="password" name="acctPw" class="w100" data-bind="value: data.acctPw" />
						</td>
					</tr>
					<tr>
						<th scope="row"><label>비밀번호 확인</label></th>
						<td>
							<input type="password" id="cfmAcctPw" class="w100" data-bind="value: data.cfmAcctPw" />
						</td>
					</tr>
				</tbody>
			</table>
			<p class="explain text-info">* 6자 이상 20자 이하. 영문자,숫자, 특수문자[!@#$*] 혼용</p>
			<div class="btns">
				<button type="submit" class="button"><i class="w_save"></i>변경하기</button>&nbsp;
				<button type="button" class="button bg1" data-bind="click: close"><i class="w_x"></i>닫기</button>&nbsp;
			</div>
		</form>
	</div>
</div>
<%--// popup_container --%>


<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  var inputView = kendo.observable({
    data: {
      username: "${username}",
      acctPw: null,
      cfmAcctPw: null,
    },
		submit: function(e) {
      e.preventDefault();

      if (!this.check()) return;

      _dicasPage.maskOpen();

      $.ajax({
				method: 'POST',
				url:'${changeUrl}',
				data: JSON.stringify(this.data.toJSON()),
        contentType: 'application/json;charset=UTF-8'
			}).done(function(data, status, jqXHR) {
			  alert('새로운 비밀번호로 변경을 하였습니다.');
			  setTimeout(function () {
          window.close();
        }, 200);
      }).fail(function(data, status, jqXHR) {
        try {
          var message = JSON.parse(data.responseText).message;
          alert(message);
				} catch (e) {
          alert('비밀번호 변경 중 오류가 발생하였습니다.');
        }
			}).always(function() {
        _dicasPage.maskClose();
			});

		},
		close: function(e) {
      window.close();
		},
		check: function() {

      var newpassword1 = this.get('data.acctPw');
      var newpassword2 = this.get('data.cfmAcctPw');
      var username = this.get('data.username');
      var passed = false;

      if (newpassword1.length == 0 || newpassword2.length == 0) {

        if (newpassword1.length == 0) {
          alert('새 비밀번호를 입력해주세요.');
          return false;
        } else if (newpassword2.length == 0) {
          alert('새 비밀번호 확인을 입력해주세요.');
          return false;
        }
      }

      if (newpassword1 != newpassword2) {
        alert('새 비밀번호가 일치 하지 않습니다. 다시 한번 입력해주세요.');
        return false;
      }

      var pattern1 = /[0-9]/;
      var pattern2 = /[a-zA-Z]/;
      var pattern3 = /[!@#$*]/;

      if(!pattern1.test(newpassword1)
					||!pattern2.test(newpassword1)
						||!pattern3.test(newpassword1)
							||newpassword1.length < 6
								||newpassword1.length > 21){
        alert("영문+숫자+특수기호[!@#$*] 6자리 이상 20자리 이하로 등록하십시오.");
        return false;
      }

      if(newpassword1.indexOf(username) > -1) {
        alert("비밀번호는 사용자ID를 포함할 수 없습니다.");
        return false;
      }

      // var SamePass_0 = 0; //동일문자 카운트
      // var SamePass_1 = 0; //연속성(+) 카운드
      // var SamePass_2 = 0; //연속성(-) 카운드
			//
      // for(var i=0; i < newpassword1.length; i++) {
			//
      //   var chr_pass_0;
      //   var chr_pass_1;
      //   var chr_pass_2;
			//
      //   if(i >= 2) {
			//
      //     chr_pass_0 = newpassword1.charCodeAt(i-2);
      //     chr_pass_1 = newpassword1.charCodeAt(i-1);
      //     chr_pass_2 = newpassword1.charCodeAt(i);
			//
      //     //동일문자 카운트
      //     if((chr_pass_0 == chr_pass_1) && (chr_pass_1 == chr_pass_2)) {
      //       SamePass_0++;
      //     } else {
      //       SamePass_0 = 0;
      //     }
			//
      //     //연속성(+) 카운드
      //     if(chr_pass_0 - chr_pass_1 == 1 && chr_pass_1 - chr_pass_2 == 1) {
      //       SamePass_1++;
      //     } else {
      //       SamePass_1 = 0;
      //     }
			//
      //     //연속성(-) 카운드
      //     if(chr_pass_0 - chr_pass_1 == -1 && chr_pass_1 - chr_pass_2 == -1) {
      //       SamePass_2++;
      //     } else {
      //       SamePass_2 = 0;
      //     }
      //   }
			//
      //   if(SamePass_0 > 0) {
      //     alert("동일문자를 3자 이상 연속 입력할 수 없습니다.");
      //     passed = false;
      //   }
			//
      //   if(SamePass_1 > 0 || SamePass_2 > 0 ) {
      //     alert("영문, 숫자는 3자 이상 연속 입력할 수 없습니다.");
      //     passed=false;
      //   }
			//
      //   if(!passed) {
      //     return false;
      //     break;
      //   }
      // }

      return true;
    }
  });
  kendo.bind($("#form_container"), inputView);
</script>