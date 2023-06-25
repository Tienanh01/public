my_list=[-1.2, 18.9, 23, 12.4, 17.6, 23.5, 12.2,20.6, 11.5, 45.6]

i = int(input())

if i >  len(my_list) - 2 :
  print(str(i)+" list index out of range")
else :
  print("Phần tử thứ "+str(i)+" từ cuối lên của danh sách có giá trị là "+str(my_list[-1]) +".")