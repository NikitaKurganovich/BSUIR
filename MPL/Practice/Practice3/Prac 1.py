
#программа 1
def incrementer() :
    i = 1
    while True :
        yield i
        i += 1
inc = incrementer()
print( next( inc ) )
print( next( inc ) )
print( next( inc ) )
