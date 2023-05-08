import random

class Rational:
    def __init__(self, num, den):
        self.num = num
        self.den = den
    
    def mul(self, other):
        if isinstance(other, Rational):
            num = self.num * other.num
            den = self.den * other.den
            return Rational(num, den)
        elif isinstance(other, int):
            num = self.num * other
            return Rational(num, self.den)
        else:
            raise TypeError("Unsupported operand type(s) for *: '{}' and '{}'".format(type(self), type(other)))
    
    def truediv(self, other):
        if isinstance(other, Rational):
            num = self.num * other.den
            den = self.den * other.num
            return Rational(num, den)
        elif isinstance(other, int):
            den = self.den * other
            return Rational(self.num, den)
        else:
            raise TypeError("Unsupported operand type(s) for /: '{}' and '{}'".format(type(self), type(other)))
            
    @staticmethod
    def random_fraction(low, high):
        num = random.randint(low, high)
        den = random.randint(low, high)
        while den == 0:
            den = random.randint(low, high)
        return Rational(num, den)