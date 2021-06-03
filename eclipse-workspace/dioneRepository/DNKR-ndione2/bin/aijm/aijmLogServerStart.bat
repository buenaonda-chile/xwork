@echo off
REM ****************************************************************************
REM ** [JP]  ファイル名 : aijmLogServerStart.bat                                   **
REM ** [JP]  処理概要   : AijmLogServerの起動                                      **
REM ** [EN]  File name             : aijmLogServerStart.bat                        **
REM ** [EN]  Outline of processing : Starting AijmLogServer                        **
REM ** ---------------------------------------------------------------------- **
REM ** [JP]  変更履歴   : 2010/02/11 新規作成                                      **
REM ** [JP]             : 2010/11/11 exitでバッチを終了するように修正              **
REM ** [JP]             : 2011/02/22 標準フォルダ構成にあわせてパス等を対応        **
REM ** [JP]             : 2011/09/10 Version2系対応                                **
REM ** [JP]             : 2012/02/13 バッチの構成をLinux版に合わせて変更(KN-0816)  **
REM ** [JP]             : 2012/02/13 ヒープサイズ指定追加(KN-0827)                 **
REM ** [JP]             : 2012/12/04 プロセス名短縮対応(チケット136)               **
REM **                                                                        **
REM ** [EN]  Change history : 2010/02/11 Create new                                                              **
REM ** [EN]                 : 2010/11/11 Modified so that the batch ended by exit                                **
REM ** [EN]                 : 2011/02/22 According to the standard folder structure, the corresponding path etc. **
REM ** [EN]                 : 2011/09/10 Version2 type support                                                   **
REM ** [EN]                 : 2012/02/13 Modified to suit Linux version of the batch configuration (KN-0816)     **
REM ** [EN]                 : 2012/02/13 Add the specified heap size (KN-0827)                                   **
REM ** [EN]                 : 2012/12/04 Process name corresponding reduction (Ticket 136)                       **
REM **                                                                        **
REM **  $ aijmLogServerStart.bat 1495 2015-05-11 07:56:47Z 815372040074 $
REM **                                                                        **
REM ****************************************************************************
setlocal enabledelayedexpansion

REM [JP] ==== 環境に応じて各自で設定してください ================
REM [EN] ==== Depending on your environment, please set your own ================
REM [JP] ==== パラメータ設定 ====================================
REM [EN] ==== Setting Parameters ====================================
REM --------------------------------------------------------
REM [JP]  JAVA_XMX       ： AMCの最大ヒープサイズ(MB)
REM [JP]  JAVA_XMS       ： AMCの初期ヒープサイズ(MB)
REM [EN]  JAVA_XMX       ： Maximum heap size of AMC (MB)
REM [EN]  JAVA_XMS       ： Initial heap size of AMC (MB)
REM --------------------------------------------------------
set JAVA_XMX=256
set JAVA_XMS=128

REM [JP] ==== 起動クラスの設定 ==================================
REM [EN] ==== Setting the startup class ==================================
set EXECUTE_CLASS=com.globaldenso.ai.akatsuki.aijm.logserver.LogServer

REM [JP] ==== log4jの設定 =======================================
REM [EN] ==== Setting the log4j =======================================
set LOG_XML=log4j2-Server.xml

REM [JP] ==== 共通環境変数の設定 ================================
REM [EN] ==== Setting common environment variables ================================
call %~dp0\setenv.bat
if %errorlevel% == 0 (
    goto NREND
)

REM [JP] ==== 共通環境変数設定失敗 ログ出力 =====================
REM [EN] ==== Failure of common environment variables  Log output =====================
echo [boot] [%DATE% %TIME%] [ERROR] setenv.bat Execute Failed >> %~dp0\aijmLogServerStart.log

:NREND
REM [JP] ==== ログ出力先設定 ====================================
REM [EN] ==== Log output destination setting ====================================
set LOGFILE=%AIJM_DIR%\logs\aijmLogServerStart.log

REM [JP] ==== 処理開始ログ出力 ==================================
REM [EN] ==== Log output process starts ==================================
echo %DATE% %TIME% INFO :START AijmLogServer StartBatch >> %LOGFILE%

REM [JP] ==== 処理実行 ==========================================
REM [EN] ==== Process execution ==========================================
echo %DATE% %TIME% INFO :Start start command >> %LOGFILE%
set CLASSPATH=%CLASSPATH%
javaw -Xrs -Xmx%JAVA_XMX%m -Xms%JAVA_XMS%m -Dlog4j.configurationFile=%LOG_XML% %EXECUTE_CLASS% start >> %LOGFILE% 2>&1
echo %DATE% %TIME% INFO :End start command >> %LOGFILE%

REM [JP] ==== 処理終了ログ出力 ==================================
REM [EN] ==== End of processing logging output ==================================
echo %DATE% %TIME% INFO :END AijmLogServer StartBatch >> %LOGFILE%
echo -------------------------------------------------------------------------------- >> %LOGFILE%
exit
