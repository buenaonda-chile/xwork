@echo off
REM ****************************************************************************
REM ** [JP]  ファイル名 : setenv.bat                                               **
REM ** [JP]  処理概要   : 環境変数設定バッチ                                       **
REM ** [JP]                                                                       **
REM ** [JP]    AI-JMで使用するバッチが共通で必要とする環境変数を設定します。       **
REM ** [JP]    指定したフォルダにあるjarファイルを全てクラスパスに追加します。     **
REM ** [JP]                                                                       **
REM ** [JP]    本バッチファイルをcallするバッチファイルは遅延環境変数の展開を      **
REM ** [JP]    有効にしてください。                                                **
REM ** [JP]                                                                      **
REM ** [JP]    setlocal enabledelayedexpansion                                     **
REM ** [JP]                                                                       **
REM ** [JP]                                                                       **
REM ** [JP]   【引数】                                                             **
REM ** [JP]      なし。                                                            **
REM ** [JP]                                                                       **
REM ** [JP]   【環境】                                                             **
REM ** [JP]      以下のパスにjarファイルがあることを前提としています。             **
REM ** [JP]          [AI-JMインストールディレクトリ]\module\lib                    **
REM **                                                                        **
REM ** [EN]  File name             : setenv.bat                                        **
REM ** [EN]  Outline of processing : Batch setting environment variables               **
REM ** [EN]                                                                           **
REM ** [EN]    I set the environment variables batch used in the AI-JM need in common. **
REM ** [EN]    I added to the classpath all jar files in the folder that you specify.  **
REM ** [EN]                                                                           **
REM ** [EN]    Batch file to call this batch file,                                     **
REM ** [EN]    please enable delayed environment variable expansion.                   **
REM ** [EN]                                                                           **
REM ** [EN]    setlocal enabledelayedexpansion                                         **
REM ** [EN]                                                                           **
REM ** [EN]                                                                           **
REM ** [EN]   【Argument】                                                                      **
REM ** [EN]      None.                                                                 **
REM ** [EN]                                                                           **
REM ** [EN]   【Environment】                                                                   **
REM ** [EN]      It is assumed that there is a jar file in the following path.         **
REM ** [EN]          [AI-JM installation directory]\module\lib                         **
REM **                                                                        **
REM ** ---------------------------------------------------------------------- **
REM ** [JP]  変更履歴   : 2011/09/18 新規作成(AIJB-0048)                           **
REM ** [JP]             : 2011/10/17 ログの出力先ディレクトリ環境変数追加(KN-0210) **
REM **                                                                        **
REM ** [EN]  Change history : 2011/09/18 Create new(AIJB-0048)                                                           **
REM ** [EN]                 : 2011/10/17 Add the environment variable in the destination directory for the log (KN-0210) **
REM **                                                                        **
REM **  $ setenv.bat 1495 2015-05-11 07:56:47Z 815372040074 $
REM **                                                                        **
REM ****************************************************************************

REM [JP] ==== 環境に応じて各自で設定してください ================
REM [EN] ==== Depending on your environment, please set your own ================
REM [JP] ==== パラメータ設定 ====================================
REM [EN] ==== Setting Parameters ====================================
REM --------------------------------------------------------
REM [JP]  AIJM_DIR       ： AI-JMをインストールしたディレクトリ
REM [JP]  LIB_DIR        ： AI-JMで使用するjarを配置したディレクトリ
REM [JP]  BATCH_LOG_DIR  ： AI-JMで使用するログ出力先ディレクトリ
REM [EN]  AIJM_DIR       ： Directory in which you installed the AI-JM
REM [EN]  LIB_DIR        ： Directory where you placed the jar for use with AI-JM
REM [EN]  BATCH_LOG_DIR  ： Destination directory of logging to be used by AI-JM
REM --------------------------------------------------------
set AIJM_DIR=D:\AIJM
set LIB_DIR=%AIJM_DIR%\module\lib
set BATCH_LOG_DIR=%AIJM_DIR%\logs\app_log

REM [JP] ==== クラスパスの設定 ==================================
REM [EN] ==== Setting the Classpath ==================================
set CLASSPATH=%AIJM_DIR%\module\config
set CLASSPATH=!CLASSPATH!;%AIJM_DIR%\module\config\library-config
for %%i in (%LIB_DIR%\*.jar) do set CLASSPATH=!CLASSPATH!;%%i

REM [JP] ==== ログファイル作成用の変数の設定 ====================
REM [EN] ==== Setting Variables for log file creation ====================
:retry
set D=%DATE%
set T=%TIME: =0%
if not "%D%" == "%DATE%" goto retry
set D=%D:/=%
set D=%D: =%
set T=%T::=%
set T=%T:.=%
set seq=%D%%T%


exit /b
