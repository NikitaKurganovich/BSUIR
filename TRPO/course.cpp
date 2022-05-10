#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>
#include <cstring>

using namespace std;

struct account
{
    string login, password, access, role;
};


void create_file();
char decription(char symbol);
char encription(char symbol);
account searching_login(string login);
string string_encription(string text);
string string_decription(string text);
string input_password();

int main()
{
    string login, password, access, role, file_login, file_password, file_access, file_role;
    check_file();
    ifstream accounts("Accounts.txt");
    account user = login();



    _getch();
    return 0;
}

void create_file()
{
    ofstream accounts("Accounts.txt");
    string passworld = string_encription("admin");
    accounts << "admin" << " " << passworld << " " << "admin" << " " << "active";
}

char encription(char symbol)
{
    return (char)(int(symbol) + 15);
}

char decription(char symbol)
{
    return (char)(int(symbol) - 15);
}

account searching_login(string login)
{ 
    ifstream file("Accounts.txt");
    account user;
    while(!file.eof())
    {
        
        user.login = user.password = user.role = user.access = "";
        file >> user.login >> user.password >> user.role >> user.access;
        if (user.login == login) return user;
    }
    cout << "This account doesnt exist!" << endl;
    user.login = user.password = user.role = user.access = "";
    return user;
}

string string_encription(string text)
{
    for(int i = 0; i < text.length(); i++)
    {
        text[i] = encription(text[i]);
    }
    return text;
}

string string_decription(string text)
{
    for(int i = 0; i < text.length(); i++)
    {
        text[i] = decription(text[i]);
    }
    return text;
}

string input_password()
{
    string text;
	int i=0;
	while(true)
	{
		text[i]=_getch();
        if(text[i] == 13) break;
        if(text[i] == 8 && text.length() > 0)
        {
            cout << '\b' <<" "<< '\b';
        }
        else cout << "*";
        i++;
	}
    cout << endl;
	return text;
}

void check_file()
{
    ifstream accounts("Accounts.txt");
    if (!accounts.is_open())
    {
        cout << "File doesn't exist! File with standart admin account will be created! " << endl;
        create_file();
    }
}

account login()
{
    account user;
    return user;
}