@echo off
REM ****************************************************************************
REM ** [JP]  ファイル名 : aijmResidentJobLauncher_with_wily.bat
REM ** [JP]  処理概要   : 常駐ジョブを起動する共通のバッチです。(wily起動オプションつき)
REM ** [JP]
REM ** [JP]    AijmMainControllerから起動する全ての常駐ジョブは
REM ** [JP]    このバッチから起動させます。
REM ** [JP]
REM ** [JP]   【引数】
REM ** [JP]      %1 : ジョブで使用する Spring 設定ファイル(フルパス)
REM ** [JP]          例) /com/globaldenso/ai/akatsuki/aijm/job/queuecreate/jobcontrol/applicationContext-queuecreate.xml
REM ** [JP]
REM ** [JP]      %2 : 実行するジョブID
REM ** [JP]
REM ** [JP]      %3 : 実行するキューID
REM **
REM ** [EN]  File name             : aijmResidentJobLauncher_with_wily.bat
REM ** [EN]  Outline of processing : It is common batch resident job to start. (with startup options wily)
REM ** [EN]
REM ** [EN]    All resident job to boot from AijmMainController is to boot from this batch.
REM ** [EN]
REM ** [EN]   【Argument】
REM ** [EN]      %1 : Spring configuration file for the job (Full path)
REM ** [EN]          Example) /com/globaldenso/ai/akatsuki/aijm/job/queuecreate/jobcontrol/applicationContext-queuecreate.xml
REM ** [EN]
REM ** [EN]      %2 : Job ID to execute
REM ** [EN]
REM ** [EN]      %3 : Queue ID to execute
REM **
REM ** ----------------------------------------------------------------------
REM ** [JP]  変更履歴   : 2011/10/28 新規作成
REM ** [JP]             : 2012/12/04 プロセス名短縮対応(チケット136)
REM ** [JP]             : 2013/01/31 ジョブ起動時のOutOfMemoryエラー対応(チケット188)
REM ** [JP]             : 2015/06/12 PermSizeをMetaspaceSizeに変更
REM **
REM ** [EN]  Change history : 2011/10/28 Create new
REM ** [EN]                 : 2012/12/04 Process name corresponding reduction (Ticket 136)
REM ** [EN]                 : 2013/01/31 Corresponding OutOfMemory Error When Starting Job (Ticket 188)
REM ** [EN]                 : 2015/06/12 Change PermSize to MetaspaceSize
REM **
REM **  $ aijmResidentJobLauncher_with_wily.bat 1706 2015-06-12 02:40:40Z 815372040074 $
REM **
REM ****************************************************************************
setlocal enabledelayedexpansion

REM [JP] ==== 環境に応じて各自で設定してください ================
REM [EN] ==== Depending on your environment, please set your own ================
REM [JP] ==== パラメータ設定 ====================================
REM [EN] ==== Setting Parameters ====================================
REM --------------------------------------------------------
REM [JP]  JAVA_XMX      ： ジョブの最大ヒープサイズ(MB)
REM [JP]  JAVA_XMS      ： ジョブの初期ヒープサイズ(MB)
REM [JP]  JAVA_METASIZE ： ジョブのMetaspace領域サイズ(MB)
REM [JP]  EXECUTE_CLASS ： ジョブを起動するクラス
REM [JP]  LOG_XML       ： ログ出力設定ファイル
REM [EN]  JAVA_XMX      ： Maximum heap size of the job (MB)
REM [EN]  JAVA_XMS      ： Initial heap size of the job (MB)
REM [EN]  JAVA_METASIZE ： Metaspace region size of the job (MB)
REM [EN]  EXECUTE_CLASS ： Class to start the job
REM [EN]  LOG_XML       ： Logging configuration file
REM --------------------------------------------------------
set JAVA_XMX=192
set JAVA_XMS=192
set JAVA_METASIZE=84

REM [JP] ==== ジョブ起動クラスの設定 ============================
REM [EN] ==== Setting classes starting job ============================
set EXECUTE_CLASS=com.globaldenso.ai.akatsuki.aijm.job.control.ResidentProcMain

REM [JP] ==== log4jの設定 =======================================
REM [EN] ==== Setting the log4j =======================================
set LOG_XML=log4j2-Job.xml

REM [JP] ==== 共通環境変数の設定 ================================
REM [EN] ==== Setting common environment variables ================================
call %~dp0\setenv.bat
if %errorlevel% == 0 (
    goto NREND
)

REM [JP] ==== 共通環境変数設定失敗 ログ出力 =====================
REM [EN] ==== Failure of common environment variables  Log output =====================
echo [boot] [%DATE% %TIME%] [ERROR] setenv.bat Execute Failed >> %~dp0\%2.log

:NREND
REM [JP] ==== ログ出力先フォルダ確認/作成 =======================
REM [EN] ==== Create / Confirmation log output destination folder =======================
if not exist %BATCH_LOG_DIR%\%2 (
    mkdir %BATCH_LOG_DIR%\%2
)

REM [JP] ==== ジョブ起動 ========================================
REM [EN] ==== Starting job ========================================
set CLASSPATH=%CLASSPATH%
javaw -Xrs -Xmx%JAVA_XMX%m -Xms%JAVA_XMS%m -XX:MetaspaceSize=%JAVA_METASIZE%m -XX:MaxMetaspaceSize=%JAVA_METASIZE%m -Dlog4j.configurationFile=%LOG_XML% -Dcom.wily.introscope.agentProfile=D:\WilyAgent9.1\wily\core\config\IntroscopeAgent.profile -javaagent:D:\WilyAgent9.1\wily\Agent.jar %EXECUTE_CLASS% %1 %3 >> %BATCH_LOG_DIR%\%2\%3.log
exit
