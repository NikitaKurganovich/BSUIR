#include <iostream>
#include <fstream>
#include <string>


using namespace std;

void create_file(ofstream accounts);
char decription(char symbol);
char encription(char symbol);

int main()
{
    ifstream accounts("Accounts.txt");
    if (!accounts.is_open())
    {
        cout << "File doesn't exist! File with standart admin account will be created! " << endl;
        ofstream accounts("Accounts.txt");
        create_file(accounts);
    }
    return 0;
}

void create_file(ofstream accounts)
{
    char temp;
    string passworld;
    temp = encription('a');
    passworld += temp;
    temp = encription('d');
    passworld += temp;
    temp = encription('m');
    passworld += temp;
    temp = encription('i');
    passworld += temp;
    temp = encription('n');
    passworld += temp;
    accounts << "admin" << " || " << passworld;
}

char encription(char symbol)
{
    int temp = (int)(symbol);
    return (char)(temp + 15);
}

char decription(char symbol)
{
    int temp = (int)(symbol);
    return (char)(temp - 15);
}