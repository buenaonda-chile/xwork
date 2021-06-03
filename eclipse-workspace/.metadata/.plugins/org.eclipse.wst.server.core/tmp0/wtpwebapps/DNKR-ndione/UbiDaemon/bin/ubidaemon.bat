echo off
echo ########################################
echo              UbiDaemon
echo ########################################
echo.
set JAVA_DIR="C:\Program Files\Java\jdk1.8.0_20"
set UBIDAEMON_DIR=C:\Users\e150046\workspace\DNKR\WebContent\UbiDaemon
set PROPERTY_DIR=%UBIDAEMON_DIR%
set XMS=512M
set XMX=1024M
set CLASSPATH=%UBIDAEMON_DIR%\lib\UbiDaemon.jar;%UBIDAEMON_DIR%\lib\UbiViewerLib.jar;%UBIDAEMON_DIR%\lib\ubijdf.jar;%UBIDAEMON_DIR%\lib\ubixml.jar;%UBIDAEMON_DIR%\lib\ubixls.jar;%UBIDAEMON_DIR%\lib\ubipdf.jar;%UBIDAEMON_DIR%\lib\ubitext.jar;%UBIDAEMON_DIR%\lib\ubilog4j.jar
echo.
echo [디렉토리 정보]
echo JAVA      : %JAVA_DIR%
echo UBIDAEMON : %UBIDAEMON_DIR%
echo.
echo [데몬 시작]
%JAVA_DIR%\bin\java -Xms%XMS% -Xmx%XMX% -classpath %CLASSPATH%;. com.ubidcs.daemon.UbiDaemon %PROPERTY_DIR%
pause>nul

