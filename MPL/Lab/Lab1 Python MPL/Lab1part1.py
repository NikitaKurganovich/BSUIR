from random import *
import pickle

array = []
for index in range(5):
    array.append(randint(-10,10))

FILENAME = "data.data"

with open(FILENAME,"wb") as file:
    pickle.dump(array, file)
