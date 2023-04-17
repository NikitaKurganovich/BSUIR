import pickle


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