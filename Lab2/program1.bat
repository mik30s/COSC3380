echo off
set /p filename= <%1
set file=%filename%
set mypath=%cd%
C:\Users\mike168m\Documents\COSC3380\Lab2\prog1.exe %file%
C:\Users\mike168m\Documents\COSC3380\Lab2\prog2.exe
IF %ERRORLEVEL% EQU 0 (
	C:\Users\mike168m\Documents\COSC3380\Lab2\prog3.exe
) ELSE (
	echo "Ages are not between 0 and 120"
)
echo on
