#!/bin/bash
# ****************************************************************************
# ** [JP]  ファイル名 : aijmMainControllerStart.sh                               **
# ** [JP]  処理概要   : AijmMainControllerの起動                                 **
# ** [JP]                                                                       **
# ** [JP]    AijmMainControllerの起動はバックグラウンドで実行します。            **
# ** [JP]                                                                       **
# ** [JP]  引数       : なし                                                     **
# ** [JP]  戻り値     : 0(正常終了)/16(異常終了)                                 **
# **                                                                        **
# ** [EN]  File name             : aijmMainControllerStart.sh                    **
# ** [EN]  Outline of processing : Start AijmMainController                      **
# ** [EN]                                                                       **
# ** [EN]    AijmMainController start to run in the background.                  **
# ** [EN]                                                                       **
# ** [EN]  Argument      : None                                                  **
# ** [EN]  Return value  : 0(Stopping services)/16(Exit Warning)                 **
# **                                                                        **
# ** ---------------------------------------------------------------------- **
# ** [JP]  変更履歴   : 2012/01/23 新規作成                                      **
# ** [JP]             : 2012/12/04 プロセス名短縮対応(チケット136)               **
# **                                                                        **
# ** [EN]  Change history : 2012/01/23 Create new                                        **
# ** [EN]                 : 2012/12/04 Process name corresponding reduction (Ticket 136) **
# **                                                                        **
# **  $ aijmMainControllerStart.sh 1495 2015-05-11 07:56:47Z 815372040074 $
# **                                                                        **
# ****************************************************************************

# [JP] ==== 環境に応じて各自で設定してください ====================================
# [EN] ==== Depending on your environment, please set your own ====================================
# [JP] ==== パラメータ設定 ========================================================
# [EN] ==== Setting Parameters ========================================================
# ----------------------------------------------------------------------------
# [JP]  JAVA_XMX       ： AijmMainControllerの最大ヒープサイズ(MB)
# [JP]  JAVA_XMS       ： AijmMainControllerの初期ヒープサイズ(MB)
# [EN]  JAVA_XMX       ： Maximum heap size of AijmMainController (MB)
# [EN]  JAVA_XMS       ： Initial heap size of AijmMainController (MB)
# ----------------------------------------------------------------------------
JAVA_XMX=256
JAVA_XMS=128

# [JP] ==== 起動クラスの設定 ======================================================
# [EN] ==== Setting the startup class ======================================================
EXECUTE_CLASS=com.globaldenso.ai.akatsuki.aijm.QueueExecuteProcMain

# [JP] ==== log4jの設定 ===========================================================
# [EN] ==== Setting the log4j ===========================================================
LOG_XML=log4j2-AMC.xml

# [JP] ==== 共通環境変数の設定 ====================================================
# [EN] ==== Setting common environment variables ====================================================
PRGDIR=`dirname $0`
. ${PRGDIR}/setenv.sh
if [ $? -ne 0 ]; then
# [JP] ==== 共通環境変数設定失敗 ログ出力 戻り値を16に設定 ========================
# [EN] ==== Failure of common environment variables  Log output  The return value is set to 16 ========================
    echo [boot] [`date "+%Y/%m/%d %T"`] [ERROR] setenv.sh Execute Failed >> ${PRGDIR}/aijmMainControllerStart.log
    exit 16
fi

# [JP] ==== ログ出力先設定 ========================================================
# [EN] ==== Log output destination setting ========================================================
LOGFILE=${AIJM_DIR}/logs/aijmMainControllerStart.log

# [JP] ==== 処理開始ログ出力 ======================================================
# [EN] ==== Log output process starts ======================================================
echo `date "+%Y/%m/%d %T"` INFO :START AijmMainController StartBatch >> $LOGFILE 2>&1

# [JP] ==== PSコマンドによるサービス起動確認 ======================================
# [EN] ==== Confirm start-up of services by PS command ======================================
echo `date "+%Y/%m/%d %T"` INFO :Start CheckProcess >> $LOGFILE 2>&1
PROCESS_CNT=`ps -ef | grep java | grep $EXECUTE_CLASS | grep start | grep -v grep | wc -l`
echo `date "+%Y/%m/%d %T"` INFO :End   CheckProcess >> $LOGFILE 2>&1

# [JP] ==== 既にサービスが起動している場合、ログに出力し処理終了 ==================
# [EN] ==== If the service is already running, the end of processing the log ==================
if [ $PROCESS_CNT -ne 0 ]; then
    echo `date "+%Y/%m/%d %T"` WARN :AijmMainController service was already started. >> $LOGFILE 2>&1
    echo `date "+%Y/%m/%d %T"` INFO :END AijmMainController StartBatch >> $LOGFILE 2>&1
    echo -------------------------------------------------------------------------------- >> $LOGFILE 2>&1
    exit 0
fi

# [JP] ==== 処理実行 ==============================================================
# [EN] ==== Process execution ==============================================================
echo `date "+%Y/%m/%d %T"` INFO :Start start command >> $LOGFILE 2>&1
export CLASSPATH
${JAVA_HOME}/bin/java -Xrs -Xmx${JAVA_XMX}m -Xms${JAVA_XMS}m -Dlog4j.configurationFile=${LOG_XML} ${EXECUTE_CLASS} start >> $LOGFILE 2>&1 &
echo `date "+%Y/%m/%d %T"` INFO :End   start command >> $LOGFILE 2>&1

# [JP] ==== 処理終了ログ出力 ======================================================
# [EN] ==== End of processing logging output ======================================================
echo `date "+%Y/%m/%d %T"` INFO :END AijmMainController StartBatch >> $LOGFILE 2>&1
echo -------------------------------------------------------------------------------- >> $LOGFILE 2>&1
exit
