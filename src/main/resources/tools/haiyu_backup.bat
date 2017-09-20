rem *******************************Code Start*****************************
@echo off

set "Ymd=%date:~,4%%date:~5,2%%date:~8,2%"
set file_name=haiyu_t_bill_%Ymd%.sql
D:\mysql\bin\mysqldump --opt -u root --password=123456 lingzhu t_bill > D:\db_backup\%file_name%
rem *******************************DUMP OK*****************************
D:\tools\qiniu\qshell fput myblog %file_name% D:\\db_backup\\%file_name%
@echo on
rem *******************************Code End*****************************