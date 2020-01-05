import mysql.connector
from mysql.connector import errorcode

config = {
        'user':root,
        'password':123456,
        'host': 'localhost'
        }
		
# try〜except文でエラー対処
try:
    cnx = mysql.connector.connect(**config)

# ER_ACCESS_DENIED_ERRORは、DBへのアクセスが拒否された場合のエラーコード
except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print('Cannnot connect database.')
    else:
        print(err)
else:
    cnx.close()
