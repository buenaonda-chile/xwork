<%--
 * PROJECT：アプリ基盤 サンプルアプリケーション
 *
 * dnkrBody.jsp
 *
 * [EN] It is a JSP-body screen layout for warning exception.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] 警告例外を使用する画面レイアウトのボディ部となるJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、コンテンツ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 *
 * Copyright (c) 2015 DENSO CORPORATION. All rights reserved.
--%>
<body id="main">

	<div id="wrap">
		<%-- [EN] (Including the message area) header area --%>
        <%-- [JP] ヘッダーエリア(メッセージエリアを含む) --%>
        <tiles:insertAttribute name="headerM" flush="false">
            <tiles:putAttribute name="type">
                <tiles:getAsString name="type" />
            </tiles:putAttribute>
        </tiles:insertAttribute>

        
		<tiles:insertAttribute name="contentsM" flush="false" />
		
       	<%-- [EN] Footer --%>
        <%-- [JP] フッター --%>
        <tiles:insertAttribute name="footerM" flush="false" />
	</div>
	
</body>
