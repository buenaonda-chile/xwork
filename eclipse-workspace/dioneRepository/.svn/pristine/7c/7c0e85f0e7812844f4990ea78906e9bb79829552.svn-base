@echo off
REM ****************************************************************************
REM ** [JP]  ファイル名 : aijmLogServerStop.bat                                    **
REM ** [JP]  処理概要   : AijmLogServerの停止                                      **
REM ** [JP]                                                                       **
REM ** [JP]    netstatコマンドを使用してAijmLogServerのサービス停止確認を行います。**
REM ** [JP]    taskkillコマンドを使用してAijmLogServerのプロセスを強制終了します。 **
REM ** [JP]                                                                       **
REM ** [JP]  引数       : なし                                                     **
REM ** [JP]  戻り値     : 0(正常終了)/16(異常終了)                                 **
REM ** [JP]  備考       : バッチ内でシステム毎に変更する箇所があります。           **
REM **                                                                        **
REM ** [EN]  File name             : aijmLogServerStop.bat                         **
REM ** [EN]  Outline of processing : Stop AijmLogServer                            **
REM ** [EN]                                                                       **
REM ** [EN]    We stop to confirm AijmLogServer service using netstat command.     **
REM ** [EN]    We kill the process of AijmLogServer using taskkill command.        **
REM ** [EN]                                                                       **
REM ** [EN]  Argument     : None                                                   **
REM ** [EN]  Return value : 0(Stopping services)/16(Exit Warning)                  **
REM ** [EN]  Remarks      : There is a place to change the system in each batch.   **
REM ** ---------------------------------------------------------------------- **
REM ** [JP]  変更履歴   : 2010/02/11 新規作成                                      **
REM ** [JP]             : 2010/11/11 exitでバッチを終了するように修正              **
REM ** [JP]             : 2011/01/26 戻り値を戻すように修正                        **
REM ** [JP]                         ログの出力量を修正                             **
REM ** [JP]             : 2011/02/22 標準フォルダ構成にあわせてパス等を対応        **
REM ** [JP]             : 2012/02/13 ADD_SERVERの定義が2行あるため1行削除(KN-0761) **
REM ** [JP]             : 2012/02/13 バッチの構成をLinux版に合わせて変更(KN-0816)  **
REM ** [JP]             : 2012/02/13 ヒープサイズ指定追加(KN-0827)                 **
REM ** [JP]             : 2012/12/04 プロセス名短縮対応(チケット136)               **
REM **                                                                         **
REM ** [EN]  Change history : 2010/02/11 Create new                                                              **
REM ** [EN]                 : 2010/11/11 Modified so that the batch ended by exit                                **
REM ** [EN]                 : 2011/01/26 Modified to return a return value                                       **
REM ** [EN]                              Modify the amount of log output                                         **
REM ** [EN]                 : 2011/02/22 According to the standard folder structure, the corresponding path etc. **
REM ** [EN]                 : 2012/02/13 Delete 1 line for 2 lines of the definition of ADD_SERVER (KN-0761)     **
REM ** [EN]                 : 2012/02/13 Modified to suit Linux version of the batch configuration (KN-0816)     **
REM ** [EN]                 : 2012/02/13 Add the specified heap size (KN-0827)                                   **
REM ** [EN]                 : 2012/12/04 Process name corresponding reduction (Ticket 136)                       **
REM **                                                                        **
REM **  $ aijmLogServerStop.bat 1495 2015-05-11 07:56:47Z 815372040074 $
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
REM [JP]  PORT_NUMBER    ： AijmLogServerの通信ポート番号
REM [JP]  SLEEP_TIMER    ： taskkillコマンド終了の待ち時間(ミリ秒)
REM [JP]  MAX_LOOP_CNT   ： 確認処理回数(最大)
REM [EN]  JAVA_XMX       ： Maximum heap size of AMC (MB)
REM [EN]  JAVA_XMS       ： Initial heap size of AMC (MB)
REM [EN]  PORT_NUMBER    ： Transmission port number of AijmLogServer
REM [EN]  SLEEP_TIMER    ： End wait taskkill command (In milliseconds)
REM [EN]  MAX_LOOP_CNT   ： Number of confirmation process (max)
REM --------------------------------------------------------
set JAVA_XMX=32
set JAVA_XMS=32
set PORT_NUMBER=5150
set MAX_LOOP_CNT=30
set SLEEP_TIME=1000

REM [JP] ==== 起動クラスの設定 ==================================
REM [EN] ==== Setting the startup class ==================================
set EXECUTE_CLASS=com.globaldenso.ai.akatsuki.aijm.logserver.LogServer

REM [JP] ==== log4jの設定 =======================================
REM [EN] ==== Setting the log4j =======================================
set LOG_XML=log4j2-Server.xml

REM [JP] ==== netstatで検索するAijmLogServerのLocal Address =====
REM [EN] ==== Local Address of AijmLogServer to search by netstat =====
set ADD_SERVER=0.0.0.0:%PORT_NUMBER%

REM [JP] ==== 共通環境変数の設定 ================================
REM [EN] ==== Setting common environment variables ================================
call %~dp0\setenv.bat
if %errorlevel% == 0 (
    goto NREND
)

REM [JP] ==== 共通環境変数設定失敗 ログ出力 =====================
REM [EN] ==== Failure of common environment variables  Log output =====================
echo [boot] [%DATE% %TIME%] [ERROR] setenv.bat Execute Failed >> %~dp0\aijmLogServerStop.log

:NREND
REM [JP] ==== ログ出力先設定 ====================================
REM [EN] ==== Log output destination setting ====================================
set LOGFILE=%AIJM_DIR%\logs\aijmLogServerStop.log

REM [JP] ==== 処理開始ログ出力 ==================================
REM [EN] ==== Log output process starts ==================================
echo %DATE% %TIME% INFO :START AijmLogServer StopBatch >> %LOGFILE%
echo %DATE% %TIME% INFO :netstat Local Address %ADD_SERVER% >> %LOGFILE%

REM [JP] ==== netstatコマンドによるサービス停止確認 =============
REM [EN] ==== Confirm the stopping of the service by the netstat command =============
echo %DATE% %TIME% INFO :Start CheckProcess >> %LOGFILE%
netstat -aon -p TCP | findstr %ADD_SERVER% > nul
echo %DATE% %TIME% INFO :End   CheckProcess >> %LOGFILE%

REM [JP] ==== 既にサービスが停止している場合、ログに出力し処理終了 ===
REM [EN] ==== If the service is already stopped, the end of processing the log ===
if not %errorlevel% == 0 (
    echo %DATE% %TIME% WARN :AijmLogServer has already stopped >> %LOGFILE%
    echo %DATE% %TIME% INFO :END AijmLogServer StopBatch >> %LOGFILE%
    echo -------------------------------------------------------------------------------- >> %LOGFILE%
    exit /b 0
)

REM [JP] ==== サービス停止ログ出力。この処理でサービスは停止しない) ==
REM [EN] ==== Stop logging service. This process does not stop service) ==
echo %DATE% %TIME% INFO :Start logoutput command >> %LOGFILE%
set CLASSPATH=%CLASSPATH%
javaw -Xrs -Xmx%JAVA_XMX%m -Xms%JAVA_XMS%m -Dlog4j.configurationFile=%LOG_XML% %EXECUTE_CLASS% stop >> %LOGFILE% 2>&1
REM [JP] ==== サービス停止ログ出力が異常終了の場合 ==============
REM [EN] ==== If exit warning is stop logging of service ==============================================
if not %errorlevel% == 0 (
    echo %DATE% %TIME% ERROR :Error occurred during AijmLogServer logoutput >> %LOGFILE%
    echo %DATE% %TIME% INFO :Continue AijmLogServer StopBatch >> %LOGFILE%
)
echo %DATE% %TIME% INFO :End logoutput command >> %LOGFILE%

REM [JP] ==== 処理実行 ==========================================
REM [EN] ==== Process execution ==========================================
echo %DATE% %TIME% INFO :Start stop command >> %LOGFILE%
for /f "tokens=2,5" %%a in ('netstat -aon -p TCP') do ( 

    IF %%a EQU %ADD_SERVER% (

        REM [JP] AijmLogServerを停止します。
        REM [EN] I will stop AijmLogServer.
        taskkill /F /PID %%b >> %LOGFILE% > nul

        REM [JP] taskkillしたAijmLogServerのPIDが存在しなくなるとfor文を抜けます。
        REM [EN] AijmLogServer PID of the taskkill is no longer present, I leave the for sentence.
        for /L %%i in (1,1,%MAX_LOOP_CNT%) do (

            REM [JP] SLEEP_TIMEの時間だけスリープする。
            REM [EN] Amount of time to sleep SLEEP_TIME.
            if not %%i == 1 (
                call %AIJM_DIR%\module\bin\aijm\aijmSleep.vbs %SLEEP_TIME%
            )

REM [JP] ==== サービス停止確認 ==================================
REM [EN] ==== Stopping services Confirmation ==================================
REM [JP] taskkillしたAijmLogServerのPIDが存在し続けるとエラーです。
REM [EN] PID of the taskkill AijmLogServer is the error continues to exist.
REM [JP] PIDが存在しなくなると、taskkillコマンドが失敗し、ERRORLEVELは0以外を戻します。
REM [EN] PID is no longer present, taskkill command fails, ERRORLEVEL returns nonzero.
            tasklist /fi "PID eq %%b" | findstr %%b > nul
            if not !ERRORLEVEL! == 0 (
                echo %DATE% %TIME% INFO :PID %%b is killed >> %LOGFILE%
                echo %DATE% %TIME% INFO :End stop command >> %LOGFILE%
                echo %DATE% %TIME% INFO :AijmLogServer Service StopCheck OK SleepTime %%i >> %LOGFILE%
                echo %DATE% %TIME% INFO :NREND AijmLogServer StopBatch >> %LOGFILE%
                echo -------------------------------------------------------------------------------- >> %LOGFILE%
REM [JP] ==== 戻り値"0"として処理終了 ===========================
REM [EN] ==== Process is completed as "0" return value ===========================
                exit /b 0
            )
        )
    )
)
REM [JP] ==== 停止処理が異常終了の場合 ==========================
REM [EN] ==== If exit warning is stop process ==============================================
echo %DATE% %TIME% INFO :AijmLogServer Service StopCheck NG %ADD_SERVER% >> %LOGFILE%
echo %DATE% %TIME% ERROR :Error occurred during AijmLogServer StopBatch >> %LOGFILE%
echo %DATE% %TIME% INFO :ABEND AijmLogServer StopBatch >> %LOGFILE%
echo -------------------------------------------------------------------------------- >> %LOGFILE%
REM [JP] ==== 戻り値"16"として処理終了 ==========================
REM [EN] ==== Process is completed as "16" return value ==========================
exit /b 16
