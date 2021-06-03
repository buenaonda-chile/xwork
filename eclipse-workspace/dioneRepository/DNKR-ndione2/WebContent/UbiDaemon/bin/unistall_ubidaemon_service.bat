echo off
echo ########################################
echo       UbiDaemon 서비스 해제 처리      
echo ########################################
echo.
set UBIDAEMON_DIR=D:\WAS\UbiDaemon
set JS_EXE=%UBIDAEMON_DIR%\bin\JavaService.exe
echo [디렉토리 정보]
echo UBIDAEMON : %UBIDAEMON_DIR%
echo.
echo [서비스 중지]
net stop UbiDaemon
echo.
echo [서비스 해제]
%JS_EXE% -uninstall UbiDaemon
echo ########################################
echo                  완 료
echo ########################################
pause>nul
