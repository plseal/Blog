rem *******************************Code Start*****************************
@echo off



title Echo date if format 'yyyy-MM-dd HH:mm:ss'
for /f "tokens=1 delims=/ " %%j in ("%date%") do set d1=%%j
for /f "tokens=2 delims=/ " %%j in ("%date%") do set d2=%%j
for /f "tokens=3 delims=/ " %%j in ("%date%") do set d3=%%j
for /f "tokens=4 delims=/ " %%j in ("%date%") do set d4=%%j
for /f "tokens=1 delims=: " %%j in ("%time%") do set t1=%%j
for /f "tokens=2 delims=: " %%j in ("%time%") do set t2=%%j
for /f "tokens=3 delims=:. " %%j in ("%time%") do set t3=%%j
echo Date Time1: %date%
echo Date Time2: %d4%-%d2%-%d3% %t1%:%t2%:%t3%


set Ymd=%d4%%d2%%d3%
set file_name=t_zhangzu_%Ymd%.sql


echo %file_name%


D:\mysql\bin\mysqldump --opt -u root --password=123456 lingzhu t_zhangzu > D:\db_backup\%file_name%
rem *******************************DUMP OK*****************************
set workpath=D:\tools\qiniu\qshell
D:\tools\qiniu\qshell fput myblog %file_name% D:\\db_backup\\%file_name%
@echo on
rem *******************************Code End*****************************