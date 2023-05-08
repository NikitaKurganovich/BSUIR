class RealString:
    def __init__(self, string):
        self.string = string
    
    def len(self):
        return len(self.string)
    
    def is_equel(self, other):
        if isinstance(other, str):
            return len(self.string) == len(other)
        elif isinstance(other, RealString):
            return len(self.string) == len(other.string)
        else:
            return False
        
