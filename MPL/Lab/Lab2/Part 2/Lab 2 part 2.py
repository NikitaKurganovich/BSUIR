import pandas as pd
from datetime import datetime
import numpy as np

sales = pd.read_excel('https://github.com/datagy/mediumdata/raw/master/pythonexcel.xlsx', sheet_name = 'sales')
states = pd.read_excel('https://github.com/datagy/mediumdata/raw/master/pythonexcel.xlsx', sheet_name = 'states')

print("Original Table (+ months): ")
sales.insert(3,'Month',pd.DatetimeIndex(sales["Date"]).month) #extracting months from date
print(sales.head(10)) #printing dataframe
print("Replacing dates with a date range")

sales.drop(['Date'],axis = 1, inplace = True)
sales.drop(['Month'], axis = 1, inplace = True)

dates = pd.date_range( #creating a range of dates (Timestamps)
    start=pd.Timestamp('2021-01-01 00:00:00'),
    periods=50,
    freq='D'
)

sales.insert(2,"Date",dates) #inserting dates in the dataframe

print('Table with IF analog:')
sales['More Than 500'] = ['Yes' if x > 500 else 'No' for x in sales ['Sales']] #IF analog
print(sales.head(10))

print('\nMerged Table (VLOOKUP analog)')
sales['Date'] = sales['Date'].apply(lambda x: x.date()) #converting Timestamps to dates
sales = pd.merge(sales,states, how = 'left', on = 'City') #VLOOKUP analog
print(sales.head(10))

print('\nPivot Table:')
sales_pivot = sales.pivot_table(index='City', values = 'Sales', aggfunc = [np.sum])
print(sales_pivot.head(10))
