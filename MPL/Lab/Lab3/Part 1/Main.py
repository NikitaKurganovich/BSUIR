#Main.py
from Rational import *
import PySimpleGUI as sg

class main:
    layout = [
    [sg.Text("First Numerator:"), sg.InputText(size=(10, 1), key="numerator"),
    sg.Text("Second Numerator:"), sg.InputText(size=(10, 1), key="numerator2")],
    [sg.Text("First Denominator:"), sg.InputText(size=(10, 1), key="denominator"),
    sg.Text("Second Denominator:"), sg.InputText(size=(10, 1), key="denominator2")],
    [sg.Button("Division"), sg.Button("Multiplication"), sg.Button("Random Rational Fraction")],
    [sg.Text("Result Numerator:"), sg.Text(size=(10, 1), key="resNumerator")],
    [sg.Text("Result Denominator:"), sg.Text(size=(10, 1), key="resDenominator")],
    [sg.Text(size = (50,1), key="output")]
    ]

    window = sg.Window("Rational Fractions", layout)
   

    while True:
        event, values = window.read()
        if event == sg.WINDOW_CLOSED:
            break
        if event == "Division":
            window['output'].update("")
            try:
                denominator = int(values["denominator"])
                numerator = int(values["numerator"])
                numerator2 = int(values["numerator2"])
                firstFracrion = Rational(numerator,denominator)

                try:
                    denominator2 = int(values["denominator2"])
                    if denominator2 == 0:
                        res = firstFracrion.truediv(numerator2) 
                        resNumerator = res.num
                        resDenominator = res.den
                        window['resNumerator'].update(resNumerator)
                        window['resDenominator'].update(resDenominator) 
                        window['output'].update("Second fraction will be interpreted as int.")
                        continue
                    else:  
                        secondFracrion = Rational(numerator2,denominator2)
                            
                        res = firstFracrion.truediv(secondFracrion)
                            
                        resNumerator = res.num
                        resDenominator = res.den
                            
                        window['resNumerator'].update(resNumerator)
                        window['resDenominator'].update(resDenominator)
                        continue
                except ValueError:
                    res = firstFracrion.truediv(numerator2) 
                    resNumerator = res.num
                    resDenominator = res.den
                    window['resNumerator'].update(resNumerator)
                    window['resDenominator'].update(resDenominator) 
                    window['output'].update("Second fraction will be interpreted as int.")
                    continue  
            except ValueError:
                window['output'].update("Please enter integer values.")
                continue  
            
        if event == "Multiplication":
            window['output'].update("")
            try:
                denominator = int(values["denominator"])
                numerator = int(values["numerator"])
                numerator2 = int(values["numerator2"])
                firstFracrion = Rational(numerator,denominator)

                try:
                    denominator2 = int(values["denominator2"])
                    if denominator2 == 0:
                        res = firstFracrion.mul(numerator2) 
                        resNumerator = res.num
                        resDenominator = res.den
                        window['resNumerator'].update(resNumerator)
                        window['resDenominator'].update(resDenominator) 
                        window['output'].update("Second fraction will be interpreted as int.")
                        continue
                    else:  
                        secondFracrion = Rational(numerator2,denominator2)
                            
                        res = firstFracrion.mul(secondFracrion)
                            
                        resNumerator = res.num
                        resDenominator = res.den
                            
                        window['resNumerator'].update(resNumerator)
                        window['resDenominator'].update(resDenominator)
                        continue
                except ValueError:
                    res = firstFracrion.mul(numerator2) 
                    resNumerator = res.num
                    resDenominator = res.den
                    window['resNumerator'].update(resNumerator)
                    window['resDenominator'].update(resDenominator) 
                    window['output'].update("Second fraction will be interpreted as int.")
                    continue      
            except ValueError:
                window['output'].update("Please enter integer values.")
                continue   
                    
        if event == "Random Rational Fraction":
            window['output'].update("")
            res = Rational.random_fraction(-20, 20)
            window["denominator"].update(res.den)
            window["numerator"].update(res.num)
            
    window.close()