#задание 1

School = {"1A": ["Petrov", "Ivanov"],
          "1B": ["Okunev", "Iskrik", "Moroz"],
          "1C": ["Chunchik", "Loshkov", "Pushkin", "Mayakovskiy"],
          "1D": ["Lodirev"]}
print("Old list: ")
for key, value in School.items():
    print(key, ": ", value)
School["1E"] = ["Kupolov", "Storish", "Konsor", "Teterev"]
School["1F"] = ["Belov", "Popov", "Chernish", "Kisel", "Abobov"]
print("New list: ")
for key, value in School.items():
    print(key, ": ", value)

#задание 2

School_student_numbers = {}
for key, value in School.items():
    School_student_numbers[key] = len(value)
print("List of classes size: ")
for key, value in School_student_numbers.items():
    print(key, ": ", value)
