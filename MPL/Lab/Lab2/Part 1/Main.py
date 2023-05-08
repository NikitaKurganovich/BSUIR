from RealString import *

class Main:
    # Создание двух экземпляров класса RealString и строки
    rs1 = RealString(input("Input a first string (object of class): "))
    rs2 = RealString(input("Input a second string (object of class): "))
    s = str(input("Input a third string (usual str): "))
    print()
    # Сравнение строки с экземпляром и двух экземпляров между собой
    print("Comparing first string with itself")
    print("String: ",rs1.string)
    
    if(rs1.is_equel(rs1)):
        print("Strings have same length\n")
    else:
        print("Strings have different length\n")
        
    print("Comparing first string with second")
    print("First:", rs1.string)
    print("Second:", rs2.string)
    
    if(rs1.is_equel(rs2)):
        print("Strings have same length\n")
    else:
        print("Strings have different length\n")
        
    print("Comparing first string with third")
    print("First:", rs1.string)
    print("Third:", s)
    
    if(rs1.is_equel(s)):
        print("Strings have same length\n")
    else:
        print("Strings have different length\n")
    
    