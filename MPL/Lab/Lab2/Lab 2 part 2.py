import pandas as pd

# создаем диапазон дат с 1 января 2020 года по 31 декабря 2022 года
date_range = pd.date_range(start='2020-01-01', end='2022-12-31', freq='D')

# выводим диапазон дат
print(date_range)

# создаем серию с датами
dates = pd.Series(['2020-01-01', '2020-02-01', '2020-03-01'])

# извлекаем месяц из даты
months = dates.dt.month

# выводим месяцы
print(months)

# создаем серию с отметками времени в секундах
timestamps = pd.Series([1609459200, 1609718400, 1609804800])

# преобразуем отметки времени в даты и время
dates = pd.to_datetime(timestamps, unit='s')

# выводим даты и время
print(dates)

# создаем DataFrame с данными
data = pd.DataFrame({
    'id': [1, 2, 3, 4, 5],
    'name': ['Alice', 'Bob', 'Charlie', 'David', 'Eva'],
    'age': [25, 32, 45, 28, 37],
    'gender': ['F', 'M', 'M', 'M', 'F']
})

# функция для применения условия IF
def age_classification(age):
    if age < 30:
        return 'Young'
    elif age < 40:
        return 'Middle-aged'
    else:
        return 'Elderly'

# применяем функцию к столбцу 'age' и создаем новый столбец 'age_class'
data['age_class'] = data['age'].apply(age_classification)

# создаем DataFrame соответствия имен и пола
name_gender = pd.DataFrame({
    'name': ['Alice', 'Bob', 'David'],
    'gender': ['F', 'M', 'M']
})

# объединяем DataFrame по столбцу 'name'
result = pd.merge(data, name_gender, on='name', how='left')

# функция для применения условия VLOOKUP
def gender_lookup(gender):
    if gender == 'M':
        return 'Male'
    elif gender == 'F':
        return 'Female'
    else:
        return 'Unknown'

# применяем функцию к столбцу 'gender' и создаем новый столбец 'gender_name'
result['gender_name'] = result['gender'].apply(gender_lookup)

# выводим результат
print(result)
