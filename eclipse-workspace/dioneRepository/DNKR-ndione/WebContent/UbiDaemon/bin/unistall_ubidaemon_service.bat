echo off
echo ########################################
echo       UbiDaemon ���� ���� ó��      
echo ########################################
echo.
set UBIDAEMON_DIR=D:\WAS\UbiDaemon
set JS_EXE=%UBIDAEMON_DIR%\bin\JavaService.exe
echo [���丮 ����]
echo UBIDAEMON : %UBIDAEMON_DIR%
echo.
echo [���� ����]
net stop UbiDaemon
echo.
echo [���� ����]
%JS_EXE% -uninstall UbiDaemon
echo ########################################
echo                  �� ��
echo ########################################
pause>nul
