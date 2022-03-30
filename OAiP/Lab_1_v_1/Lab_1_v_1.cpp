#include <iostream>

using namespace std;

double transfer_to_notation(int number, int notation);
int cycle(int number, int notation);

int main()
{
    int number;
    cout << "Entre a number: " ;
    cin >> number;

    int notation;
    cout << "Entre a value of new notation: ";
    cin >> notation;

    double result = transfer_to_notation(number, notation);
    cout << "Number in new notation: " << result << endl;

    cout << "Result with cycle: " << cycle(number, notation) << endl;
    system("pause");
    return 0;
    }

double transfer_to_notation(int number, int notation)
{
    int index = number % notation;
    number = number / notation;
    if (number == 0) return index;
    return index + transfer_to_notation(number,notation)*10;
}

int cycle(int number, int notation)
{
    int index;
    int cycle = 0;
    for (int i = 0; number > 0; i++)
    {
        index = number % notation;
        for (int k = 0; k <= i; k++)
        index = index *10;
        cycle = cycle + index;
        number = number / notation;
    }
    return cycle/10;
}