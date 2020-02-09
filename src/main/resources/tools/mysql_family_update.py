import mysql.connector
 
conn = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="123456",
  database="lingzhu"
)


cursor = conn.cursor()
try:
  cursor.execute('update T_family set birth="2013-2-9" where id=15')
  cursor.execute('select * from T_family')
  result = cursor.fetchall()
  conn.commit()
except Exception as e:
  conn.rollback()
  raise e
finally:
  cursor.close()
  conn.close()

 
for x in result:
  print(x)
