
#Программа номер 4
import random
n = int(input('Array size: '))
mas = []
for i in range(n):
    mas.append([])
    for j in range(n):
        mas[i].append(random.randint(1,100))
print ('Array with random numbers from 1 to 100:',mas)
m = mas[0][0]
for k in range(n):
    if m > mas[k][k]:
            m = mas[k][k]
print ('Smallest element: ',m)

