rem *******************************Code Start*****************************
@echo off

set "Ymd=%date:~,4%%date:~5,2%%date:~8,2%"
D:\mysql\bin\mysqldump --opt -u root --password=123456 lingzhu t_bill > D:\db_backup\haiyu_t_bill_%Ymd%.sql
@echo on
rem *******************************Code End*****************************