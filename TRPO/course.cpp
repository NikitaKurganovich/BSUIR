#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>

using namespace std;

void create_file();
char decription(char symbol);
char encription(char symbol);
bool searching_login(string login);

int main()
{
    string login, password, access, role, file_login, file_password, file_access, file_role;
    ifstream accounts("Accounts.txt");
    if (!accounts.is_open())
    {
        cout << "File doesn't exist! File with standart admin account will be created! " << endl;
        create_file();
    }
    
    cout << "Entre a login: ";
    cin >> login;
    if (searching_login(login) == false)
    {
        cout << "This account doesn't exist! " << endl;
    }

    _getch();
    return 0;
}

void create_file()
{
    ofstream accounts("Accounts.txt");
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
    accounts << "admin" << " " << passworld << " " << "admin" << " " << "active";
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

bool searching_login(string login)
{ 
    ifstream file("Accounts.txt");
    string file_login, file_password, file_access, file_role;
    while(!file.eof())
    {
        file_login = "";
        file >> file_login >> file_password >> file_role >> file_access;
        if (file_login == login) return true;
    }
    return false;
}