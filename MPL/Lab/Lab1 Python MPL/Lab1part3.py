import pickle

FILENAME = "data.data"
FILENAME2 = "sum.txt"

with open(FILENAME,"rb") as file:
    array = pickle.load(file)

print("Array: ", array)

with open(FILENAME2, "rb") as file:
    num = pickle.load(file)
    
print("Sum: ", num)