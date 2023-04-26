class RealString:
    def __init__(self, string):
        self.string = string
    
    def len(self):
        return len(self.string)
    
    def eq(self, other):
        if isinstance(other, str):
            return len(self.string) == len(other)
        elif isinstance(other, RealString):
            return len(self.string) == len(other.string)
        else:
            return False
        
# Создание двух экземпляров класса RealString и строки
rs1 = RealString("hello")
rs2 = RealString("hello world")
s = "world"

# Сравнение строки с экземпляром и двух экземпляров между собой
print(rs1.eq(rs1)) # True
print(rs1.eq(rs2)) # False
print(rs1.eq(s)) # False