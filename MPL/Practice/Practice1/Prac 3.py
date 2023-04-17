
#номер 3
#инициализируем номер дня
day = 32 
try :
    #проверяем его номер
    if day > 31 :  
         #создаем ошибку
        raise ValueError( 'Invalid Day Number') 
except ValueError as msg :
    #и используем ее
    print( 'The Program found An' , msg )  
finally:
      #используем блок finally и если есть ошибка и если нет
    print('But Today Is Beautiful Anyway.' )

    