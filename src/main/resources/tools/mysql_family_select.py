import mysql.connector
 
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="123456",
  database="lingzhu"
)
mycursor = mydb.cursor()
 
mycursor.execute("SELECT * FROM T_family where 1=1")
 
myresult = mycursor.fetchall()     # fetchall() 获取所有记录
 
for x in myresult:
  print(x)
