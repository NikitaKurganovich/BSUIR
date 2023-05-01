from random import *
import pickle

array = []
for index in range(5):
    array.append(randint(-10,10))

FILENAME = "data.data"

with open(FILENAME,"wb") as file:
    pickle.dump(array, file)

FILENAME = "data.data"
FILENAME2 = "sum.txt"
with open(FILENAME,"rb") as file:
    array = pickle.load(file)
sum = 0
for index in array:
    if(index >=0 or index <=10):
        sum = sum + index

with open(FILENAME2,"wb") as file:
    pickle.dump(sum,file)
    
    
with open(FILENAME,"rb") as file:
    array = pickle.load(file)

print("Array: ", array)

with open(FILENAME2, "rb") as file:
    num = pickle.load(file)
    
print("Sum: ", num)