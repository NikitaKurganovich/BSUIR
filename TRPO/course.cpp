#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>
#include <cstring>
#include <vector>
#include <sha256.h>
#include <iomanip>
#include <ios>

using namespace std;

struct account
{
    string login, password, access, role;
};

struct member
{
    string surname, name, lastname, country, instrument;
    int birth_year, place;
};


const string USER_FILE = "Accounts.txt";
const string DEFAULT_USER_STRING = "admin 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 admin active";
const string MAIN_FILE = "Concert.txt";
const string DEFAULT_MAIN_FILE_STRING = "Ivanov Ivan Ivanovich 2001 Belarus piano 1";

void create_file(string FILE_NAME, string DEAFAULT_STRING);
void check_file(string FILE_NAME, string DEFAULT_STRING);

account searching_login(string login);
string string_encription(string text);
string string_decription(string text);
string input_password();

string input_password();


void main()
{
    string login, password, access, role, file_login, file_password, file_access, file_role;
    check_file();
    ifstream accounts("Accounts.txt");
    account user = login();



    _getch();
    return 0;
}

void menu(account user)
{
    switch (hash_value(user.role))
    {
    case ct_hash("admin"):
        admin_menu();
        return;
    case ct_hash("viewer"):
        viewer_menu();
        return;
    default:
        return;
    }
}

void registration()
{
    check_file(USER_FILE, DEFAULT_USER_STRING);
    ifstream file("Accounts.txt");
    account user;
    string login;
    while (true)
    {
    cout << "Entre a login: ";
    cin >> login;
    while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login ) 
            {
                system("CLS");
                cout << "This login is taken!" << endl;
            }
        }
    }
}

account authorization_and_authentication()
{ 
    check_file(USER_FILE, DEFAULT_USER_STRING);
    ifstream file("Accounts.txt");
    account user;
    string login, password;
    while(true)
    {
        cout << "Entre a login: ";
        cin >> login;
        cout << "Entre a password: ";
        password = input_password();
        file.seekg(0 ,ios_base::beg);
        while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login && user.password == password) 
            {
                system("CLS");
                cout << "You entred to system!" << endl;
                return user;
            }
        }
        system("CLS");
        cout << endl << "Incorrect login or password!" << endl;
    }
}

string input_password()
{
    string pass;
    char ch;
    while(true)
    {
        ch = _getch();
        if(ch == 13)
        {
            if (pass.length() > 4) break;
            else continue;
        }
        if(ch == 8) 
        {
            if(pass.length() > 0)
            {
            cout <<"\b \b";
            pass.erase(pass.end() - 1);
            }
        }
        else 
        {
            cout << '*';
            pass.push_back(ch);
        }
    }
    return sha256(pass);
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