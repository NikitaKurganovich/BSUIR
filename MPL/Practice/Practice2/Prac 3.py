#Программа номер 3
X = []
a = int(input('Entre lenght of array: '))
for i in range(a):
    b = int(input('Entre an element of array: '))
    X.append(b)
print('Your array: ',X)
X_2 = []
m = 0
for j in range(a):
    if X[j] > m:
        m = X[j]
    if X[j] > 0:
        X_2.append(X[j])
print('New array, with positive elements only:', X_2)
print ('Biggest array element:', m)
