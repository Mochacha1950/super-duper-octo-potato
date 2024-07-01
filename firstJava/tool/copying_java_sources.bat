@echo off
set SOURCE_DIR="C:\eclipse-workspace\firstJava"
set DEST_DIR="C:\potahto\super-duper-octo-potato\firstJava"

xcopy %SOURCE_DIR% %DEST_DIR% /E /H /Y
