<%--
 * Project : 
 *
 * [EN] System error screen (For production environment)
 * [JP] システムエラー画面 (本番環境用)
 *
 * $ error_pro.jsp 2609 2016-09-08 04:14:01Z 10088DS00879 $
 *
 * Copyright (c) 2011 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%@ page isErrorPage="true" %>

<%-- [EN] Custom tag dedicated Application Development Infrastructure --%>
<%-- [EN] Do not use this ai:aiErrorTag for your application without permission. --%>
<%-- [JP] アプリ基盤専用のカスタムタグ --%>
<%-- [JP] このai:aiErrorTagをアプリ側で勝手に利用しないで下さい。 --%>
<ai:aiErrorTag />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible"  content="IE=Edge" />
    <meta http-equiv="Pragma"           content="no-cache" />
    <meta http-equiv="Cache-Control"    content="no-cache, no-store" />
    <meta http-equiv="Expires"          content="-1" />
    <title>Error Page</title>
</head>
<body>
    <b>Unexpected exception occurred.</b><br/>
    <b>予期しないエラーが発生しました。</b><br/>
    <br/>
    <ul style="list-style-type: square">
        <li>System Name (システム名) : XXX</li>
        <li>ID : ${ID}</li>
        <li>Exception Occurred Date (例外発生日時) : <fmt:formatDate value="${DATE}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/></li>
    </ul>
    <br/>
    システム担当者へ通知済みです。
    <br/><br/>
    以下の処置でシステムを再利用できる可能性があります。
    <br/>
    &nbsp;&nbsp;・システムと正しく再接続するため，開いている全てのブラウザを閉じ，新たなブラウザを用いてシステムへ接続してください。
    <br/><br/>
    ご迷惑をおかけしました。
    <br/>
</body>
</html>
