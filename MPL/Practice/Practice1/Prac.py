
#Программа номер 1
number = int(input('Entre a natural number: '))
s = 1
#задаем значения переменным
x = 1 
for n in range(1, number + 1):
    x = ((-1) ** n) / (2 ** n)
# вычисление суммы ряда
s = x + s 
#выводим сумму и последний член
print('Element of series ', x,'sum of series ', s) 



