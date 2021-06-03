' ****************************************************************************
' ** [JP]  ファイル名      :sleep.vbs                                            **
' ** [JP]  処理概要        :一定時間処理を停止する                               **
' ** [JP]  作成日          :2010/08/18                                           **
' ** [JP]  引数            :[第1引数] 停止時間(ミリ秒)                           **
' ** [JP]                   引数の指定がない場合は60000ミリ秒(1分)とする         **
' ** [JP]  戻り値          :なし                                                 **
' ** [JP]  備考            :なし                                                 **
' **                                                                        **
' ** [EN]  File name             :sleep.vbs                                                         **
' ** [EN]  Outline of processing :Stop processing a certain period of time                          **
' ** [EN]  Creation date         :2010/08/18                                                        **
' ** [EN]  Argument              :[First argument] Stop time (In milliseconds)                      **
' **                         If you do not specify an argument, and 60000 milliseconds (1 min) **
' ** [EN]  Return value          :None                                                              **
' ** [EN]  Remarks               :None                                                              **
' **                                                                        **
' ** ---------------------------------------------------------------------- **
' ** [JP]  変更履歴        :2010/08/18 新規作成                                  **
' ** [JP]  変更履歴        :2012/02/14 バッチの構成をLinux版に合わせて変更に伴い **
' ** [JP]                              文字コードをUTF-8に変更(KN-0816)          **
' **                                                                        **
' ** [EN]  Change history :2010/08/18 Create new                                                        **
' ** [EN]  Change history :2012/02/14 Due to modified to suit Linux version of the batch configuration, **
' ** [EN]                             Modify the character encoding to UTF-8 (KN-0816)                  **
' **                                                                        **
' **  $ aijmSleep.vbs 1495 2015-05-11 07:56:47Z 815372040074 $
' **                                                                        **
' ****************************************************************************

' *******************************************************************************
' ** [JP]  変数の設定                                                               **
' ** [EN]  Setting Variables                                               **
' *******************************************************************************
Dim args
Set args = WSCript.Arguments

' *******************************************************************************
' ** [JP]  一定時間処理停止                                                         **
' ** [EN]  Stop processing a certain period of time                        **
' *******************************************************************************
If args.Count < 1 Then
    ' [JP] 引数の指定がない場合
    ' [EN] If no arguments are given
    WScript.Sleep(60000)   ' [JP] 単位はミリ秒 [EN] In milliseconds
Else
    ' [JP] 引数の指定がある場合
    ' [EN] If the argument is specified
    WScript.Sleep(args.item(0))
End If
